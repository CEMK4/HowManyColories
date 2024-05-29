package com.HowManyColories.HowManyColories.repositories;

import com.HowManyColories.HowManyColories.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}