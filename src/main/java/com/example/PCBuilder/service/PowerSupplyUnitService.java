package com.example.PCBuilder.service;

import com.example.PCBuilder.model.dto.PowerSupplyUnitDto;
import com.example.PCBuilder.model.dto.filter.PowerSupplyUnitFilter;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface PowerSupplyUnitService {
    String create(PowerSupplyUnitDto dto);

    void update(String id, PowerSupplyUnitDto dto);

    PowerSupplyUnitDto getById(String id);

    List<PowerSupplyUnitDto> obtainAll();

    Page<PowerSupplyUnitDto> getByFilter(Optional<PowerSupplyUnitFilter> filter, int offset);

    Page<PowerSupplyUnitDto> getByFilterWithSortByPriceInc(Optional<PowerSupplyUnitFilter> filter, int offset);

    Page<PowerSupplyUnitDto> getByFilterWithSortByNameInc(Optional<PowerSupplyUnitFilter> filter, int offset);

    void delete(String id);

    List<PowerSupplyUnitDto> searchByName(String name);
}
