package com.example.PCBuilder.model.mapper;

import com.example.PCBuilder.model.dto.VideoCardDto;
import com.example.PCBuilder.model.entity.VideoCard;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface VideoCardMapper {
    VideoCardDto toDto(VideoCard processor);

    VideoCard toEntity(VideoCardDto processorDto);

    void merge(@MappingTarget VideoCard document, VideoCardDto dto);
}
