package com.mck.study5.upload_service.controllers;

import com.mck.study5.upload_service.services.download.IDownloadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/downloads")
@RequiredArgsConstructor
public class DownloadController
{
    private final IDownloadService downloadService;
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<?> downloadFile(@PathVariable Long id){
        return ResponseEntity.ok().build();
    }

}
