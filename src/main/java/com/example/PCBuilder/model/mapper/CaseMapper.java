package com.example.PCBuilder.model.mapper;

import com.example.PCBuilder.model.dto.CaseDto;
import com.example.PCBuilder.model.entity.Case;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CaseMapper {
    CaseDto toDto(Case aCase);

    Case toEntity(CaseDto caseDto);

    void merge(@MappingTarget Case document, CaseDto dto);
}
