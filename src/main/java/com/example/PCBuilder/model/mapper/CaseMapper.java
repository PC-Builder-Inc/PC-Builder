package com.example.PCBuilder.model.mapper;

import com.example.PCBuilder.model.dto.CaseDto;
import com.example.PCBuilder.model.entity.Case;
import org.mapstruct.MappingTarget;

public interface CaseMapper {
    CaseDto toDto(Case processor);

    Case toEntity(CaseDto processorDto);

    void merge(@MappingTarget Case document, CaseDto dto);
}
