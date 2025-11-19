package com.mck.study5.upload_service.dtos.upload;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mck.study5.upload_service.image.ImageFile;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UploadDTO {
    private Long id;
    private String name;
    private String quality;
    private Byte size;
    private String url;
    private String description;
    private String mediaOwnerType;
    private String mediaUsage;

    @ImageFile
    private MultipartFile file;

    @NotNull
    private Long belongToId;

    @NotNull
    private String belongToObject; // avatar, thumbnail
}
