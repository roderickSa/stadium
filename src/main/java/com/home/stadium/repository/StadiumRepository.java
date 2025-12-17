package com.home.stadium.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.home.stadium.domain.model.Stadium;

public interface StadiumRepository extends JpaRepository<Stadium, UUID> {
}
