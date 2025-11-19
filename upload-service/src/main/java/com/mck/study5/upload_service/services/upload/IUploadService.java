package com.mck.study5.upload_service.services.upload;

import com.mck.study5.upload_service.dtos.upload.AudioDTO;
import com.mck.study5.upload_service.dtos.upload.UploadDTO;
import com.mck.study5.upload_service.models.Audio;
import com.mck.study5.upload_service.models.Image;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


public interface IUploadService {
    Image uploadImage(UploadDTO dto);
    Image getImageById(Long id);
    String deleteImageById(Long id);
    Audio uploadAudio(AudioDTO dto);
    Audio getAudioById(Long id);
    String deleteAudioById(Long id);
}
