package com.mck.study5.user_service.controllers;

import com.mck.study5.user_service.constants.MessageKeys;
import com.mck.study5.user_service.dtos.requests.UserUpdateDTO;
import com.mck.study5.user_service.dtos.responses.ApiResponse;
import com.mck.study5.user_service.dtos.responses.users.UserDetailResponse;
import com.mck.study5.user_service.services.users.IUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final IUserService userService;

    @GetMapping("/ping")
    public String ping(){
        return "pong";
    }

    @GetMapping("/me")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<ApiResponse<UserDetailResponse>> me (
            @RequestHeader(value = "X-User-Id", required = true) String userId,
            @RequestHeader(value = "X-User-Role", required = true) String role
    ){
        if(userId == null || role == null){
            return ResponseEntity.ok(ApiResponse.failure(null, 401, MessageKeys.UNAUTHORIZED));
        }

        return ResponseEntity.ok(ApiResponse.success(userService.getUserDetail(Long.valueOf(userId)), 200, MessageKeys.SUCCESS));
    }


    @PostMapping(value = "/me", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<ApiResponse<UserDetailResponse>> mePost (
            @RequestHeader(value = "X-User-Id", required = true) Long userId,
            @Valid @ModelAttribute UserUpdateDTO userUpdateDTO
            ){
        return ResponseEntity.ok(ApiResponse.success(userService.updateUserDetail(userId, userUpdateDTO), 200, MessageKeys.SUCCESS));
    }

    @GetMapping("/admin/search")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiResponse<?>> adminSearchUser(
            @RequestParam(value = "keyword")String keyword,
            @RequestParam(value="page", defaultValue = "1")Integer page,
            @RequestParam(value="size", defaultValue = "20")Integer size
    ){
        return ResponseEntity.ok(ApiResponse.success(userService.adminSearchUsers(keyword, page, size), 200, MessageKeys.SUCCESS));
    }
}
