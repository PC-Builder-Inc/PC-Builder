package com.example.PCBuilder.model.mapper;

import com.example.PCBuilder.model.dto.VideoCardDto;
import com.example.PCBuilder.model.entity.VideoCard;
import org.mapstruct.MappingTarget;

public interface VideoCardMapper {
    VideoCardDto toDto(VideoCard processor);

    VideoCard toEntity(VideoCardDto processorDto);

    void merge(@MappingTarget VideoCard document, VideoCardDto dto);
}
