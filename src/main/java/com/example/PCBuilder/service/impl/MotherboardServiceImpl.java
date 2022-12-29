package com.example.PCBuilder.service.impl;

import com.example.PCBuilder.model.dto.MotherboardDto;
import com.example.PCBuilder.model.dto.filter.MotherboardFilter;
import com.example.PCBuilder.model.entity.BaseData;
import com.example.PCBuilder.model.entity.Motherboard;
import com.example.PCBuilder.model.mapper.MotherboardMapper;
import com.example.PCBuilder.repository.MotherboardRepository;
import com.example.PCBuilder.repository.specification.MotherboardSpecification;
import com.example.PCBuilder.service.MessageService;
import com.example.PCBuilder.service.MotherboardService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.PCBuilder.config.ConfigConstants.PAGE_SIZE;

@Service
@RequiredArgsConstructor
public class MotherboardServiceImpl implements MotherboardService {

    private final MotherboardRepository motherboardRepository;
    private final MotherboardMapper mapper;
    private final MotherboardSpecification specification;
    private final MessageService messageService;

    @Override
    public String create(MotherboardDto dto) {
        Motherboard motherboard = mapper.toEntity(dto);
        motherboardRepository.save(motherboard);
        return motherboard.getId();
    }

    @Override
    public void update(String id, MotherboardDto dto) {
        Motherboard motherboard = getMotherboard(id);
        mapper.merge(motherboard, dto);
    }

    @Override
    public MotherboardDto getById(String id) {
        return mapper.toDto(getMotherboard(id));
    }

    @Override
    public List<MotherboardDto> obtainAll() {
        return motherboardRepository.findAll().stream().map(p -> mapper.toDto(p)).toList();
    }

    @Override
    public Page<MotherboardDto> getByFilter(Optional<MotherboardFilter> filter, int offset) {
        Pageable pageable = PageRequest.of(offset, PAGE_SIZE);
        return getPage(pageable, filter);
    }

    @Override
    public Page<MotherboardDto> getByFilterWithSortByPriceInc(Optional<MotherboardFilter> filter, int offset) {
        Pageable pageable = PageRequest.of(offset, PAGE_SIZE, Sort.by(BaseData.BaseDataFields.price));
        return getPage(pageable, filter);
    }

    @Override
    public Page<MotherboardDto> getByFilterWithSortByNameInc(Optional<MotherboardFilter> filter, int offset) {
        Pageable pageable = PageRequest.of(offset, PAGE_SIZE, Sort.by(BaseData.BaseDataFields.name));
        return getPage(pageable, filter);
    }

    public Page<MotherboardDto> getPage(Pageable pageable, Optional<MotherboardFilter> filter) {
        if (filter.isEmpty()) {
            return motherboardRepository.findAll(pageable).map(p -> mapper.toDto(p));
        } else {
            return motherboardRepository.findAll(specification.byFilter(filter.get()), pageable)
                    .map(p -> mapper.toDto(p));
        }
    }

    @Override
    public void delete(String id) {
        Motherboard toDelete = getMotherboard(id);
        motherboardRepository.delete(toDelete);
    }

    @Override
    public List<MotherboardDto> searchByName(String name) {
        List<MotherboardDto> dtos = obtainAll();
        return dtos.stream().filter(dto -> dto.getName().contains(name)).toList();
    }

    private Motherboard getMotherboard(String motherboardId) {
        return motherboardRepository.findById(motherboardId)
                .orElseThrow(() -> new EntityNotFoundException(
                        messageService.get("Motherboard.validation.does.not.found.by.id", motherboardId)
                ));
    }
}
