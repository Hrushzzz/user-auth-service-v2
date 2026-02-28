package com.hrushikesh.user_auth_service_v2.repositories;

import com.hrushikesh.user_auth_service_v2.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SessionRepo extends JpaRepository<Session, Long> {
    Optional<Session> findByToken(String token);
}
