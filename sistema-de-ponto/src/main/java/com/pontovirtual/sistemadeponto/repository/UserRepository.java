package com.pontovirtual.sistemadeponto.repository;

import com.pontovirtual.sistemadeponto.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
