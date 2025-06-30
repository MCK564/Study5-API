package com.mck.study5.upload_service.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name="audios")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Audio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String quality;
    private Byte size;
    private String url;
    private String description;

    @Column(name = "belong_to_id")
    private Long belongToId;
}
