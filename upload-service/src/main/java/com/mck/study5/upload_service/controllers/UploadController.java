package com.mck.study5.upload_service.controllers;


import com.mck.study5.upload_service.constants.MessageKeys;
import com.mck.study5.upload_service.dtos.upload.UploadDTO;
import com.mck.study5.upload_service.models.Image;
import com.mck.study5.upload_service.response.ApiResponse;
import com.mck.study5.upload_service.services.upload.IUploadService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/uploads")
@RequiredArgsConstructor
public class UploadController {
    private final IUploadService uploadService;

    @GetMapping("/ping")
    public String ping(){
        return "pong";
    }

    @PostMapping(
            value = "/images",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<ApiResponse<?>> uploadImage(
            @Valid @ModelAttribute UploadDTO dto
            ){
        if(dto.getBelongToId()==null){
            return ResponseEntity.ok(ApiResponse.failure("no_belong_to_id",400,MessageKeys.DATA_NOT_FOUND));
        }
        Image image = uploadService.uploadImage(dto);
        ApiResponse<Image> response = ApiResponse.success(image, 200, MessageKeys.SUCCESS);
        return ResponseEntity.ok(response);
    }


}
