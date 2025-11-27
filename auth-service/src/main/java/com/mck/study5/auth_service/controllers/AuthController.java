package com.mck.study5.auth_service.controllers;


import com.mck.study5.auth_service.constants.MessageKeys;
import com.mck.study5.auth_service.dto.LoginRequestDTO;
import com.mck.study5.auth_service.dto.RegisterRequestDTO;
import com.mck.study5.auth_service.models.User;
import com.mck.study5.auth_service.response.ApiResponse;
import com.mck.study5.auth_service.response.AuthUrlResponse;
import com.mck.study5.auth_service.response.UserLoginResponse;
import com.mck.study5.auth_service.services.ExternalOAuthService;
import com.mck.study5.auth_service.services.IJwtService;
import com.mck.study5.auth_service.services.IUserService;
import com.mck.study5.auth_service.services.OAuthAuthorizeService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.web.access.AuthorizationManagerWebInvocationPrivilegeEvaluator;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@RestController()
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final IUserService userService;
    private final IJwtService jwtService;
    private final OAuthAuthorizeService oAuthAuthorizeService;
    private final ExternalOAuthService externalOAuthService;

    @Value(value = "${redirect-after")
    private String redirectAfter;

    @PostMapping("/oauth2/success")
    public ResponseEntity<ApiResponse<UserLoginResponse>> oauth2Success(
            @RequestBody Map<String,Object> userInfo
            ){
        String email = (String) userInfo.get("email");
        String name = (String) userInfo.get("name");
        String provider = (String) userInfo.get("provider");
        User user = userService.findOrCreateUser(email,name,provider);

        String accessToken = jwtService.generateToken(user);
        String refreshToken = jwtService.generateRefreshToken(user);

        UserLoginResponse userLoginResponse = UserLoginResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
        return ResponseEntity.ok(ApiResponse.success(userLoginResponse, 200, MessageKeys.SUCCESS));
    }

    @PostMapping("/refresh")
    public ResponseEntity<ApiResponse<UserLoginResponse>> refresh(){
        return ResponseEntity.ok(null);
    }


    @GetMapping("/oauth2/google/authorize")
    public ResponseEntity<ApiResponse<?>> googleUrl(
            @RequestParam(value = "redirect_after", required = false) String redirectAfter){
        return ResponseEntity.ok(ApiResponse.success(oAuthAuthorizeService.buildGoogleAuthorizationUrl(redirectAfter),200, MessageKeys.SUCCESS));
    }


    @GetMapping("/oauth2/callback/google")
    public RedirectView callbackGoogle(
            @RequestParam String code,
            @RequestParam String state){
        UserLoginResponse userLoginResponse = externalOAuthService.exchangeGoogleCode(code);
        StringBuilder strb = new StringBuilder("http://localhost:5173");
        strb.append("?login=").append(MessageKeys.SUCCESS);
        strb.append("&access_token=").append(userLoginResponse.getAccessToken());
        strb.append("&refresh_token=").append(userLoginResponse.getRefreshToken());

       return new RedirectView(strb.toString());
    }

    @GetMapping("/oauth2/callback/facebook/{provider}")
    public ResponseEntity<?> callbackFacebook(@RequestParam String code,
                                      @RequestParam String state,
                                      @PathVariable String provider){
        return ResponseEntity.ok(null);
    }

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

    private String extractTokenFromHeader(HttpServletRequest request){
        String authHeader = request.getHeader("Authorization");
        if(authHeader != null || !authHeader.startsWith("Bearer ")){
            return authHeader.substring(7);
        }
        throw new RuntimeException("Missing or invalid Authorization header in request");
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<UserLoginResponse>> login(@RequestBody LoginRequestDTO loginRequest){
       return ResponseEntity.ok(ApiResponse.success(userService.login(loginRequest), HttpStatus.OK.value(), MessageKeys.LOGIN_SUCCESS));
    }


    @PostMapping("/register")
    public ResponseEntity<ApiResponse<?>> register(@RequestBody RegisterRequestDTO registerRequest){
        return ResponseEntity.ok(ApiResponse.success(userService.createUser(registerRequest), HttpStatus.CREATED.value(), MessageKeys.SUCCESS));
    }




}
