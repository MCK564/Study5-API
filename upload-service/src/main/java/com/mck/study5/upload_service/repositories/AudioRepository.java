package com.mck.study5.upload_service.repositories;

import com.mck.study5.upload_service.models.Audio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AudioRepository extends JpaRepository<Audio,Long> {
}
