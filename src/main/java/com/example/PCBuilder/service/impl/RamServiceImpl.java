package com.example.PCBuilder.service.impl;

import com.example.PCBuilder.model.dto.RamDto;
import com.example.PCBuilder.model.dto.filter.RamFilter;
import com.example.PCBuilder.model.entity.BaseData;
import com.example.PCBuilder.model.entity.RAM;
import com.example.PCBuilder.model.mapper.RamMapper;
import com.example.PCBuilder.repository.RamRepository;
import com.example.PCBuilder.repository.specification.RamSpecification;
import com.example.PCBuilder.service.MessageService;
import com.example.PCBuilder.service.RamService;
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
public class RamServiceImpl implements RamService {

    private final RamRepository ramRepository;
    private final RamMapper mapper;
    private final RamSpecification specification;
    private final MessageService messageService;

    @Override
    public String create(RamDto dto) {
        RAM ram = mapper.toEntity(dto);
        ramRepository.save(ram);
        return ram.getId();
    }

    @Override
    public void update(String id, RamDto dto) {
        RAM ram = getRAM(id);
        mapper.merge(ram, dto);
    }

    @Override
    public RamDto getById(String id) {
        return mapper.toDto(getRAM(id));
    }

    @Override
    public List<RamDto> obtainAll() {
        return ramRepository.findAll().stream().map(p -> mapper.toDto(p)).toList();
    }

    @Override
    public Page<RamDto> getByFilter(Optional<RamFilter> filter, int offset) {
        Pageable pageable = PageRequest.of(offset, PAGE_SIZE);
        return getPage(pageable, filter);
    }

    @Override
    public Page<RamDto> getByFilterWithSortByPriceInc(Optional<RamFilter> filter, int offset) {
        Pageable pageable = PageRequest.of(offset, PAGE_SIZE, Sort.by(BaseData.BaseDataFields.price));
        return getPage(pageable, filter);
    }

    @Override
    public Page<RamDto> getByFilterWithSortByNameInc(Optional<RamFilter> filter, int offset) {
        Pageable pageable = PageRequest.of(offset, PAGE_SIZE, Sort.by(BaseData.BaseDataFields.name));
        return getPage(pageable, filter);
    }

    public Page<RamDto> getPage(Pageable pageable, Optional<RamFilter> filter) {
        if (filter.isEmpty()) {
            return ramRepository.findAll(pageable).map(p -> mapper.toDto(p));
        } else {
            return ramRepository.findAll(specification.byFilter(filter.get()), pageable)
                    .map(p -> mapper.toDto(p));
        }
    }

    @Override
    public void delete(String id) {
        RAM toDelete = getRAM(id);
        ramRepository.delete(toDelete);
    }

    @Override
    public List<RamDto> searchByName(String name) {
        List<RamDto> dtos = obtainAll();
        return dtos.stream().filter(dto -> dto.getName().contains(name)).toList();
    }

    private RAM getRAM(String ramId) {
        return ramRepository.findById(ramId)
                .orElseThrow(() -> new EntityNotFoundException(
                        messageService.get("RAM.validation.does.not.found.by.id", ramId)
                ));
    }
}
