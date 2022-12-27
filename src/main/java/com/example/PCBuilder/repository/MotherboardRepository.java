package com.example.PCBuilder.repository;

import com.example.PCBuilder.model.entity.Motherboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MotherboardRepository extends JpaRepository<Motherboard, String>, JpaSpecificationExecutor<Motherboard> {
}