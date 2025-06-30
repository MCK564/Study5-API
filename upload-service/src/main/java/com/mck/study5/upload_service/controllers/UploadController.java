package com.mck.study5.upload_service.controllers;


import com.mck.study5.upload_service.services.download.IDownloadService;
import com.mck.study5.upload_service.services.upload.IUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class UploadController {
    private final IUploadService uploadService;
    private final IDownloadService downloadService;


}
