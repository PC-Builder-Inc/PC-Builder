package com.example.PCBuilder.service;

import com.example.PCBuilder.model.dto.ProcessorDto;
import com.example.PCBuilder.model.dto.filter.ProcessorFilter;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ProcessorService {
    String create(ProcessorDto dto);
    void update(String id, ProcessorDto dto);
    ProcessorDto getById(String id);
    List<ProcessorDto> obtainAll();
    Page<ProcessorDto> getByFilter(Optional<ProcessorFilter> filter, int offset);
    Page<ProcessorDto> getByFilterWithSortByPriceInc(Optional<ProcessorFilter> filter, int offset);
    Page<ProcessorDto> getByFilterWithSortByNameInc(Optional<ProcessorFilter> filter, int offset);
    void delete(String id);
}
