package com.mck.study5.upload_service.models;

import com.mck.study5.upload_service.kafka.events.MediaKind;
import com.mck.study5.upload_service.kafka.events.MediaOwnerType;
import com.mck.study5.upload_service.kafka.events.MediaUsage;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name="audios")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Audio extends BaseEntity{
    private String name;
    private String quality;
    private Long size;
    private String url;
    private String description;
    private String belongToObject;
    private Long belongToId;
    private String mediaKind;
    private String mediaUsage;
    private String mediaOwnerType;
}
