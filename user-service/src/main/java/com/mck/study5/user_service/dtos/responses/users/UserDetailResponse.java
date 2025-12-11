package com.mck.study5.user_service.dtos.responses.users;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mck.study5.user_service.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDetailResponse {
    private Long id;
    private String email;
    private String avatar;
    private String banner;
    private String name;
    private String address;
    private String phone;


    public static UserDetailResponse fromUser(User user) {
        return UserDetailResponse
                .builder()
                .id(user.getId())
                .email(user.getEmail())
                .avatar(user.getAvatar())
                .banner(user.getBanner())
                .name(user.getName())
                .address(user.getAddress())
                .phone(user.getPhone())
                .build();
    }
}
