package com.example.PCBuilder.repository;

import com.example.PCBuilder.model.entity.PowerSupplyUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PowerSupplyUnitRepository extends JpaRepository<PowerSupplyUnit, String>, JpaSpecificationExecutor<PowerSupplyUnit> {
}
