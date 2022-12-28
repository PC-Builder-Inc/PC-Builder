package com.example.PCBuilder.model.mapper;

import com.example.PCBuilder.model.dto.CaseDto;
import com.example.PCBuilder.model.entity.Case;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BuilderMapper {
    CaseDto toDto(Case aCase);

    Case toEntity(CaseDto caseDto);

}
