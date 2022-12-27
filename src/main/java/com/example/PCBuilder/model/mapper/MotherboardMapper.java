package com.example.PCBuilder.model.mapper;

import com.example.PCBuilder.model.dto.MotherboardDto;
import com.example.PCBuilder.model.entity.Motherboard;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MotherboardMapper {
    MotherboardDto toDto(Motherboard processor);

    Motherboard toEntity(MotherboardDto processorDto);

    void merge(@MappingTarget Motherboard document, MotherboardDto dto);
}
