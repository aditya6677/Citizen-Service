package com.app.adi.repository;

import com.app.adi.Entity.CitizenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CitizenRepo extends JpaRepository<CitizenEntity, Long> {

    List<CitizenEntity> findByVid(int vid);
}
