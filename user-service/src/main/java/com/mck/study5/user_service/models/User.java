package com.mck.study5.user_service.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ToString
@Getter
@Setter
@Entity
@Data
@Table(name="users")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    private Long id;

    @OneToMany(mappedBy = "user", fetch=FetchType.LAZY)
    @JsonIgnore
    private List<Schedule> schedules = new ArrayList<>();

    @OneToMany(mappedBy = "user", fetch=FetchType.LAZY)
    @JsonIgnore
    private List<TrainingHistory> trainingHistories = new ArrayList<>();

    private List<Long> courses = new ArrayList<>();

    private String name;
    private String email;
    private String avatar;
    private Long avatarId;
    private Long bannerId;
    private String phone;
    private String fog;
    private String banner;
    private Boolean status;
    private String address;

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
