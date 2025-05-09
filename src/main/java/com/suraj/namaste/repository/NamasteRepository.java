package com.suraj.namaste.repository;

import com.suraj.namaste.entity.NamasteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NamasteRepository extends JpaRepository<NamasteEntity, Long> {
}