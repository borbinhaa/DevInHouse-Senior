package com.DevInHouse.SpringSecurity.repository;

import com.DevInHouse.SpringSecurity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}

