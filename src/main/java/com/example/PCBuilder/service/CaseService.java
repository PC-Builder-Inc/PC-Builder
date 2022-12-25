package com.example.PCBuilder.service;

import com.example.PCBuilder.model.dto.CaseDto;
import com.example.PCBuilder.model.dto.ProcessorDto;
import com.example.PCBuilder.model.dto.filter.CaseFilter;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface CaseService {
    String create(CaseDto dto);

    void update(String id, CaseDto dto);

    ProcessorDto getById(String id);

    List<CaseDto> obtainAll();

    Page<CaseDto> getByFilter(Optional<CaseFilter> filter, int offset);

    Page<CaseDto> getByFilterWithSortByPriceInc(Optional<CaseFilter> filter, int offset);

    Page<CaseDto> getByFilterWithSortByNameInc(Optional<CaseFilter> filter, int offset);

    void delete(String id);

    List<CaseDto> searchByName(String name);
}
