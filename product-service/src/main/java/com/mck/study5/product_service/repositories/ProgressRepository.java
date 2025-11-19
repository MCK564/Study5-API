package com.mck.study5.product_service.repositories;

import com.mck.study5.product_service.models.Progress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgressRepository extends JpaRepository<Progress,Long> {

}
