package com.mck.study5.user_service.services.users;

import com.mck.study5.user_service.dtos.requests.UserUpdateDTO;
import com.mck.study5.user_service.dtos.responses.users.CourseResponse;
import com.mck.study5.user_service.dtos.responses.users.UserDetailResponse;
import org.springframework.stereotype.Service;


public interface IUserService {
    UserDetailResponse getUserDetail(Long userId);
    UserDetailResponse updateUserDetail(Long userId, UserUpdateDTO dto);
    CourseResponse getCourse(Long userId);
}
