package com.example.PCBuilder.model.mapper;

import com.example.PCBuilder.model.dto.ProcessorDto;
import com.example.PCBuilder.model.entity.Processor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProcessorMapper {

    ProcessorDto toDto(Processor processor);

    Processor toEntity(ProcessorDto processorDto);
}
