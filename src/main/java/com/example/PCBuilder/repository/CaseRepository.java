package com.example.PCBuilder.repository;

import com.example.PCBuilder.model.entity.Case;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CaseRepository extends JpaRepository<Case, String>, JpaSpecificationExecutor<Case> {
}
