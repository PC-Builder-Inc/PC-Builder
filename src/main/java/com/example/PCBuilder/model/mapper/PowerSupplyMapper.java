package com.example.PCBuilder.model.mapper;

import com.example.PCBuilder.model.dto.PowerSupplyDto;
import com.example.PCBuilder.model.entity.PowerSupplyUnit;
import org.mapstruct.MappingTarget;

public interface PowerSupplyMapper {
    PowerSupplyDto toDto(PowerSupplyUnit processor);

    PowerSupplyUnit toEntity(PowerSupplyDto processorDto);

    void merge(@MappingTarget PowerSupplyUnit document, PowerSupplyDto dto);
}
