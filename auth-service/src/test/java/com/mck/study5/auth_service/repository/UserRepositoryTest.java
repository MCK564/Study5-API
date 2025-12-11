package com.mck.study5.auth_service.repository;


import com.mck.study5.auth_service.models.User;
import com.mck.study5.auth_service.repositories.UserRepository;
import org.apache.kafka.common.protocol.types.Field;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    private User buildUser(String username, String email){
        return User.builder()
                .username(username)
                .email(email)
                .password("encoded-password")
                .role("USER")
                .build();
    }

    @Test
    void findByEmail_shouldReturnUser_whenEmailExists(){
//        given
        User user = buildUser("test", "test@gmail.com");
        userRepository.save(user);

        Optional<User> result = userRepository.findByEmail("test@gmail.com");

        assertThat(result).isPresent();
        assertThat(result.get().getUsername()).isEqualTo("test");
        assertThat(result.get().getEmail()).isEqualTo("test@gmail.com");
    }


    @Test
    void findByEmail_shouldReturnEmpty_whenEmailNotExists(){
        Optional<User> result = userRepository.findByEmail("notfound@example.com");
        assertThat(result).isNotPresent();
    }

    @Test
    void findByUsername_shouldReturnUser_whenUsernameExists(){
        User user = buildUser("john_doe", "john@gmail.com");
        userRepository.save(user);

        Optional<User> result = userRepository.findByUsername("john_doe");

        assertThat(result).isPresent();
        assertThat(result.get().getEmail()).isEqualTo("john@gmail.com");
    }


    @Test
    void findByUsername_shouldReturnEmpty_whenUsernameNotExist(){
        Optional<User> result = userRepository.findByUsername("notfound");

        assertThat(result).isNotPresent();
    }

    @Test
    void existsByEmailOrUsername_shouldReturnTrue_whenEmailExists(){
        User user = buildUser("user1","user1@gmail.com");
        userRepository.save(user);

        Boolean exists = userRepository.existsByEmailOrUsername("user1@gmail.com","any");
        assertThat(exists).isTrue();
    }

    @Test
    void existsByEmailOrUsername_shouldReturnTrue_whenUserExists(){
        User user  = buildUser("user2","user2@gmail.com");
        userRepository.save(user);

        Boolean exists = userRepository.existsByEmailOrUsername("any","user2");

        assertThat(exists).isTrue();
    }

    @Test
    void existsByEmailOrUsername_shouldReturnFalse_whenUserNotExist(){
        Boolean exists = userRepository.existsByEmailOrUsername("any","any");
        assertThat(exists).isFalse();
    }

}
