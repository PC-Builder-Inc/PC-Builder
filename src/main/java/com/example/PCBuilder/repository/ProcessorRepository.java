package com.example.PCBuilder.repository;

import com.example.PCBuilder.model.entity.Processor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProcessorRepository extends JpaRepository<Processor, String>, JpaSpecificationExecutor<Processor> {

}
