package com.DevInHouse.SpringSecurity.repository;

import com.DevInHouse.SpringSecurity.model.AutoridadeUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoridadeRepository extends JpaRepository<AutoridadeUser, String> {

}
