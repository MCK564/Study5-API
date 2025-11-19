package com.mck.study5.auth_service.models;

import jakarta.persistence.*;
import jakarta.ws.rs.DefaultValue;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serial;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Serial
    private static final long serialVersionUID = -863164858986274318L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String username;
    private String displayName;
    private String sub;
    private String role;
    private String loginType;


    @CreatedDate
    private LocalDateTime createdDate;


    @CreatedBy
    private String createdBy;


    @LastModifiedDate
    private LocalDateTime modifiedDate;


    @LastModifiedBy
    private String modifiedBy;

    @PrePersist
    protected void onCreate() {
        createdDate = LocalDateTime.now();
        modifiedDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        modifiedDate = LocalDateTime.now();
    }
}
