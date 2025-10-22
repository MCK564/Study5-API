package com.mck.study5.auth_service.controllers;


import com.mck.study5.auth_service.models.User;
import com.mck.study5.auth_service.services.IJwtService;
import com.mck.study5.auth_service.services.IUserService;
import constants.MessageKeys;
import dtos.response.user.UserDetailResponse;
import dtos.response.user.UserLoginResponse;
import feign.Response;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.web.access.AuthorizationManagerWebInvocationPrivilegeEvaluator;
import org.springframework.web.bind.annotation.*;
import response.ApiResponse;

import java.util.Map;

@RestController()
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final IUserService userService;
    private final IJwtService jwtService;


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
    @GetMapping("/me")
    public ResponseEntity<ApiResponse<UserDetailResponse>> me(
        HttpServletRequest request
    ){
        String token = extractTokenFromHeader(request);
        String email =
        return ResponseEntity.ok(null);
    }


    @PostMapping("/refresh")
    public ResponseEntity<ApiResponse<UserLoginResponse>> refresh(){
        return ResponseEntity.ok(null);
    }

    @GetMapping("/oauth2/callback/google/{provider}")
    public ResponseEntity<?> callbackGoogle(@RequestParam String code,
                                      @RequestParam String state,
                                      @PathVariable String provider){
        return ResponseEntity.ok(null);
    }

    @GetMapping("/oauth2/callback/facebook/{provider}")
    public ResponseEntity<?> callbackFacebook(@RequestParam String code,
                                      @RequestParam String state,
                                      @PathVariable String provider){
        return ResponseEntity.ok(null);
    }

    private String extractTokenFromHeader(HttpServletRequest request){
        String authHeader = request.getHeader("Authorization");
        if(authHeader != null || !authHeader.startsWith("Bearer ")){
            return authHeader.substring(7);
        }
        throw new RuntimeException("Missing or invalid Authorization header in request");
    }
}
