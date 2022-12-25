package com.example.PCBuilder.service;

import com.example.PCBuilder.model.dto.PowerSupplyDto;
import com.example.PCBuilder.model.dto.filter.PowerSupplyFilter;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface PowerSupplyService {
    String create(PowerSupplyDto dto);

    void update(String id, PowerSupplyDto dto);

    PowerSupplyDto getById(String id);

    List<PowerSupplyDto> obtainAll();

    Page<PowerSupplyDto> getByFilter(Optional<PowerSupplyFilter> filter, int offset);

    Page<PowerSupplyDto> getByFilterWithSortByPriceInc(Optional<PowerSupplyFilter> filter, int offset);

    Page<PowerSupplyDto> getByFilterWithSortByNameInc(Optional<PowerSupplyFilter> filter, int offset);

    void delete(String id);

    List<PowerSupplyDto> searchByName(String name);
}
