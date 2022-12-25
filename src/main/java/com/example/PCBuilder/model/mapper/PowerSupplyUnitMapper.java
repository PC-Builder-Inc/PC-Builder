package com.example.PCBuilder.model.mapper;

import com.example.PCBuilder.model.dto.PowerSupplyUnitDto;
import com.example.PCBuilder.model.entity.PowerSupplyUnit;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PowerSupplyUnitMapper {
    PowerSupplyUnitDto toDto(PowerSupplyUnit processor);

    PowerSupplyUnit toEntity(PowerSupplyUnitDto processorDto);

    void merge(@MappingTarget PowerSupplyUnit document, PowerSupplyUnitDto dto);
}
