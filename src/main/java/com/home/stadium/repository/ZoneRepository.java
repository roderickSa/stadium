package com.home.stadium.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.home.stadium.domain.model.Zone;

public interface ZoneRepository extends JpaRepository<Zone, UUID>  {
    List<Zone> findByStadiumId(UUID stadiumId);
}
