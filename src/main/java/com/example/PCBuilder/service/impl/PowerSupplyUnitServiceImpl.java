package com.example.PCBuilder.service.impl;

import com.example.PCBuilder.model.dto.PowerSupplyUnitDto;
import com.example.PCBuilder.model.dto.filter.PowerSupplyUnitFilter;
import com.example.PCBuilder.model.entity.BaseData;
import com.example.PCBuilder.model.entity.PowerSupplyUnit;
import com.example.PCBuilder.model.mapper.PowerSupplyUnitMapper;
import com.example.PCBuilder.repository.PowerSupplyUnitRepository;
import com.example.PCBuilder.repository.specification.PowerSupplyUnitSpecification;
import com.example.PCBuilder.service.MessageService;
import com.example.PCBuilder.service.PowerSupplyUnitService;
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
public class PowerSupplyUnitServiceImpl implements PowerSupplyUnitService {

    private final PowerSupplyUnitRepository powerSupplyUnitRepository;
    private final PowerSupplyUnitMapper mapper;
    private final PowerSupplyUnitSpecification specification;
    private final MessageService messageService;

    @Override
    public String create(PowerSupplyUnitDto dto) {
        PowerSupplyUnit powerSupplyUnit = mapper.toEntity(dto);
        powerSupplyUnitRepository.save(powerSupplyUnit);
        return powerSupplyUnit.getId();
    }

    @Override
    public void update(String id, PowerSupplyUnitDto dto) {
        PowerSupplyUnit powerSupplyUnit = getPowerSupplyUnit(id);
        mapper.merge(powerSupplyUnit, dto);
    }

    @Override
    public PowerSupplyUnitDto getById(String id) {
        return mapper.toDto(getPowerSupplyUnit(id));
    }

    @Override
    public List<PowerSupplyUnitDto> obtainAll() {
        return powerSupplyUnitRepository.findAll().stream().map(p -> mapper.toDto(p)).toList();
    }

    @Override
    public Page<PowerSupplyUnitDto> getByFilter(Optional<PowerSupplyUnitFilter> filter, int offset) {
        Pageable pageable = PageRequest.of(offset, PAGE_SIZE);
        return getPage(pageable, filter);
    }

    @Override
    public Page<PowerSupplyUnitDto> getByFilterWithSortByPriceInc(Optional<PowerSupplyUnitFilter> filter, int offset) {
        Pageable pageable = PageRequest.of(offset, PAGE_SIZE, Sort.by(BaseData.BaseDataFields.price));
        return getPage(pageable, filter);
    }

    @Override
    public Page<PowerSupplyUnitDto> getByFilterWithSortByNameInc(Optional<PowerSupplyUnitFilter> filter, int offset) {
        Pageable pageable = PageRequest.of(offset, PAGE_SIZE, Sort.by(BaseData.BaseDataFields.name));
        return getPage(pageable, filter);
    }

    public Page<PowerSupplyUnitDto> getPage(Pageable pageable, Optional<PowerSupplyUnitFilter> filter) {
        if (filter.isEmpty()) {
            return powerSupplyUnitRepository.findAll(pageable).map(p -> mapper.toDto(p));
        } else {
            return powerSupplyUnitRepository.findAll(specification.byFilter(filter.get()), pageable)
                    .map(p -> mapper.toDto(p));
        }
    }

    @Override
    public void delete(String id) {
        PowerSupplyUnit toDelete = getPowerSupplyUnit(id);
        powerSupplyUnitRepository.delete(toDelete);
    }

    @Override
    public List<PowerSupplyUnitDto> searchByName(String name) {
        List<PowerSupplyUnitDto> dtos = obtainAll();
        return dtos.stream().filter(dto -> dto.getName().contains(name)).toList();
    }

    private PowerSupplyUnit getPowerSupplyUnit(String powerSupplyUnitId) {
        return powerSupplyUnitRepository.findById(powerSupplyUnitId)
                .orElseThrow(() -> new EntityNotFoundException(
                        messageService.get("PowerSupplyUnit.validation.does.not.found.by.id", powerSupplyUnitId)
                ));
    }
}
