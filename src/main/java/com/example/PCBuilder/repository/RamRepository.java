package com.example.PCBuilder.repository;

import com.example.PCBuilder.model.entity.RAM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RamRepository extends JpaRepository<RAM, String>, JpaSpecificationExecutor<RAM> {
}
