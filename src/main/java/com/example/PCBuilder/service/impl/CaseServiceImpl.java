package com.example.PCBuilder.service.impl;

import com.example.PCBuilder.model.dto.CaseDto;
import com.example.PCBuilder.model.dto.filter.CaseFilter;
import com.example.PCBuilder.model.entity.Case;
import com.example.PCBuilder.model.mapper.CaseMapper;
import com.example.PCBuilder.repository.CaseRepository;
import com.example.PCBuilder.repository.specification.CaseSpecification;
import com.example.PCBuilder.service.CaseService;
import com.example.PCBuilder.service.MessageService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CaseServiceImpl implements CaseService {

    private final CaseRepository caseRepository;
    private final CaseMapper mapper;
    private final CaseSpecification specification;
    private final MessageService messageService;


    @Override
    @Transactional
    public String create(CaseDto dto) {
        Case aCase = mapper.toEntity(dto);
        caseRepository.save(aCase);
        return aCase.getId();
    }

    @Override
    @Transactional
    public void update(String id, CaseDto dto) {
        Case aCase = getCase(id);
        mapper.merge(aCase, dto);
    }

    @Override
    public CaseDto getById(String id) {
        return mapper.toDto(getCase(id));    }

    @Override
    public List<CaseDto> obtainAll() {
        return caseRepository.findAll().stream().map(p -> mapper.toDto(p)).toList();
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
    @Transactional
    public void delete(String id) {
        Case toDelete = getCase(id);
        caseRepository.delete(toDelete);
    }

    @Override
    public List<CaseDto> searchByName(String name) {
        List<CaseDto> dtos = obtainAll();
        return dtos.stream().filter(dto -> dto.getName().contains(name)).toList();
    }

    private Case getCase(String caseId) {
        return caseRepository.findById(caseId)
                .orElseThrow(() -> new EntityNotFoundException(
                        messageService.get("case.validation.does.not.found.by.id", caseId)
                ));
    }
}
