package com.mck.study5.user_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mck.study5.user_service.constants.MessageKeys;
import com.mck.study5.user_service.controllers.UserController;
import com.mck.study5.user_service.dtos.requests.UserUpdateDTO;
import com.mck.study5.user_service.dtos.responses.users.UserDetailListResponse;
import com.mck.study5.user_service.dtos.responses.users.UserDetailResponse;
import com.mck.study5.user_service.services.users.IUserService;
import jakarta.persistence.EntityManagerFactory;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(
        controllers = UserController.class,
        excludeAutoConfiguration = {
                DataSourceAutoConfiguration.class,
                HibernateJpaAutoConfiguration.class,
                JpaRepositoriesAutoConfiguration.class
        }
)
@AutoConfigureMockMvc(addFilters = false)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private IUserService userService;

    @MockBean
    private EntityManagerFactory entityManagerFactory;

    @Test
    void ping_shouldReturnPong() throws Exception {
        mockMvc.perform(get("/users/ping"))
                .andExpect(status().isOk())
                .andExpect(content().string("pong"));
    }

    @Test
    void me_shouldReturnUserDetail() throws Exception {
        UserDetailResponse detail = UserDetailResponse.builder()
                .id(1L)
                .email("test@example.com")
                .name("Test User")
                .address("123 Street")
                .phone("0123456789")
                .avatar("avatar.png")
                .banner("banner.png")
                .build();

        when(userService.getUserDetail(1L)).thenReturn(detail);

        mockMvc.perform(get("/users/me")
                        .header("X-User-Id", "1")
                        .header("X-User-Role", "USER"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.message").value(MessageKeys.SUCCESS))
                .andExpect(jsonPath("$.data.id").value(1))
                .andExpect(jsonPath("$.data.email").value("test@example.com"))
                .andExpect(jsonPath("$.data.name").value("Test User"));

        verify(userService).getUserDetail(1L);
    }

    @Test
    void mePost_shouldUpdateUserDetail() throws Exception {
        UserDetailResponse updated = UserDetailResponse.builder()
                .id(1L)
                .email("updated@example.com")
                .name("Updated Name")
                .address("456 Avenue")
                .phone("0999999999")
                .avatar("new-avatar.png")
                .banner("banner.png")
                .build();

        when(userService.updateUserDetail(eq(1L), any(UserUpdateDTO.class))).thenReturn(updated);

        mockMvc.perform(multipart("/users/me")
                        .header("X-User-Id", "1")
                        .param("name", "Updated Name")
                        .param("email", "updated@example.com")
                        .param("phone", "0999999999")
                        .param("address", "456 Avenue"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andExpect(jsonPath("$.message").value(MessageKeys.SUCCESS))
                .andExpect(jsonPath("$.data.email").value("updated@example.com"))
                .andExpect(jsonPath("$.data.name").value("Updated Name"));

        ArgumentCaptor<UserUpdateDTO> captor = ArgumentCaptor.forClass(UserUpdateDTO.class);
        verify(userService).updateUserDetail(eq(1L), captor.capture());

        UserUpdateDTO dto = captor.getValue();
        assertThat(dto.getName()).isEqualTo("Updated Name");
        assertThat(dto.getEmail()).isEqualTo("updated@example.com");
        assertThat(dto.getPhone()).isEqualTo("0999999999");
        assertThat(dto.getAddress()).isEqualTo("456 Avenue");
    }

    @Test
    void adminSearchUser_shouldReturnPagedUsers() throws Exception {
        UserDetailResponse firstUser = UserDetailResponse.builder()
                .id(10L)
                .email("john@example.com")
                .name("John Doe")
                .build();
        UserDetailListResponse response = UserDetailListResponse.builder()
                .users(List.of(firstUser))
                .totalPages(5)
                .currentPage(1)
                .quantity(1)
                .build();

        when(userService.adminSearchUsers("john", 1, 10)).thenReturn(response);

        mockMvc.perform(get("/users/admin/search")
                        .param("keyword", "john")
                        .param("page", "1")
                        .param("size", "10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andExpect(jsonPath("$.message").value(MessageKeys.SUCCESS))
                .andExpect(jsonPath("$.data.total_pages").value(5))
                .andExpect(jsonPath("$.data.currentPage").value(1))
                .andExpect(jsonPath("$.data.quantity").value(1))
                .andExpect(jsonPath("$.data.users[0].email").value("john@example.com"));

        verify(userService).adminSearchUsers("john", 1, 10);
    }
}
