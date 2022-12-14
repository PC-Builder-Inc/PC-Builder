package com.example.PCBuilder.model.mapper;

import com.example.PCBuilder.model.dto.RamDto;
import com.example.PCBuilder.model.entity.RAM;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface RamMapper {
    RamDto toDto(RAM processor);

    RAM toEntity(RamDto processorDto);

    void merge(@MappingTarget RAM document, RamDto dto);
}
