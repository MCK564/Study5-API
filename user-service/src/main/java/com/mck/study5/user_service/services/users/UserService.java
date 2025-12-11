package com.mck.study5.user_service.services.users;


import com.mck.study5.user_service.dtos.requests.UserUpdateDTO;
import com.mck.study5.user_service.dtos.responses.users.CourseResponse;
import com.mck.study5.user_service.dtos.responses.users.UserDetailListResponse;
import com.mck.study5.user_service.dtos.responses.users.UserDetailResponse;
import com.mck.study5.user_service.exceptions.DataNotFoundException;
import com.mck.study5.user_service.models.User;
import com.mck.study5.user_service.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService{
    private final UserRepository userRepository;

    private void updateUser(User user, UserUpdateDTO dto){
        user.setName(dto.getName());
        user.setAddress(dto.getAddress());
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());
        //check if there is attached image file.
//        kafka publish upload message and get the new image link
    }

    @Override
    @Cacheable(value = "redisUser", key = "#userId")
    public UserDetailResponse getUserDetail(Long userId) {
        User existedUser = userRepository.findById(userId)
                .orElseThrow(()->new DataNotFoundException("User not found"));

        return UserDetailResponse.fromUser(existedUser);
    }

    @Override
    @Caching(
            evict = {
                    @CacheEvict(value = {"redisUser","redisUsers"}, allEntries = true)
            },
            put = {
                    @CachePut(value = "redisUser", key = "#userId", condition = "#result != null")
            }
    )
    public UserDetailResponse updateUserDetail(Long userId, UserUpdateDTO dto) {
        User existedUser = userRepository.findById(userId)
                .orElseThrow(()->new DataNotFoundException("User not found"));
        updateUser(existedUser, dto);
        User updatedUser = userRepository.save(existedUser);
        return UserDetailResponse.fromUser(updatedUser);
    }

    @Override
    public CourseResponse getCourse(Long userId) {
        if(userRepository.existsById(userId)){
            User existedUser = userRepository.findById(userId)
                    .orElseThrow(()->new DataNotFoundException("User not found"));
            return CourseResponse.builder()
                    .courses(existedUser.getCourses())
                    .build();
        }
        return null;
    }

    @Override
    @Cacheable(value = "redisUsers", key = "#keyword+'_'+#page+'_'+#size" )
    public UserDetailListResponse adminSearchUsers(String keyword, Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page-1, size);
        Page<User> pages = userRepository.findAll(keyword, pageRequest);
        List<UserDetailResponse> userDetailResponses = pages.getContent()
                .stream()
                .map(UserDetailResponse::fromUser)
                .toList();
        return UserDetailListResponse.builder()
                .currentPage(page)
                .totalPages(pages.getTotalPages())
                .users(userDetailResponses)
                .build();

    }
}
