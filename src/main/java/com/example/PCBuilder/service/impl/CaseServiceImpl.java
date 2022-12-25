package com.example.PCBuilder.service.impl;

import com.example.PCBuilder.model.dto.CaseDto;
import com.example.PCBuilder.model.dto.ProcessorDto;
import com.example.PCBuilder.model.dto.filter.CaseFilter;
import com.example.PCBuilder.model.entity.Case;
import com.example.PCBuilder.model.entity.Processor;
import com.example.PCBuilder.service.CaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CaseServiceImpl implements CaseService {

    private final CaseRepository caseRepository;

    @Override
    public String create(CaseDto dto) {
        Case processor = mapper.toEntity(dto);
        caseRepository.save(processor);
        return processor.getId();
    }

    @Override
    public void update(String id, CaseDto dto) {

    }

    @Override
    public ProcessorDto getById(String id) {
        return null;
    }

    @Override
    public List<CaseDto> obtainAll() {
        return null;
    }

    @Override
    public Page<CaseDto> getByFilter(Optional<CaseFilter> filter, int offset) {
        return null;
    }

    @Override
    public Page<CaseDto> getByFilterWithSortByPriceInc(Optional<CaseFilter> filter, int offset) {
        return null;
    }

    @Override
    public Page<CaseDto> getByFilterWithSortByNameInc(Optional<CaseFilter> filter, int offset) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public List<CaseDto> searchByName(String name) {
        List<CaseDto> dtos = obtainAll();
        return dtos.stream().filter(dto -> dto.getName().contains(name)).toList();
    }
}
