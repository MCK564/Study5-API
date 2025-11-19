package com.mck.study5.upload_service.dtos.upload;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.mck.study5.upload_service.audio.AudioFile;
import com.mck.study5.upload_service.image.ImageFile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AudioDTO {
    private Long id;
    private String name;
    private String quality;
    private Byte size;
    private String url;
    private String description;

    @AudioFile
    private MultipartFile file;
    private Long belongToId;
    private String belongToObject;
}
