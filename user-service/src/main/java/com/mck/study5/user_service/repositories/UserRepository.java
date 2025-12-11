package com.mck.study5.user_service.repositories;

import com.mck.study5.user_service.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>  {

    @Query("SELECT u FROM User u WHERE 1=1 AND (" +
            "lower(u.name) LIKE lower(concat('%', :keyword, '%')) OR " +
            ":keyword=u.email OR :keyword=u.phone )")
    Page<User> findAll(@Param("keyword")String keyword, Pageable pageable);
}
