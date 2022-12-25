package com.example.PCBuilder.repository;

import com.example.PCBuilder.model.entity.Case;
import com.example.PCBuilder.model.entity.VideoCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VideoCardRepository extends JpaRepository<VideoCard, String>, JpaSpecificationExecutor<VideoCard> {
}
