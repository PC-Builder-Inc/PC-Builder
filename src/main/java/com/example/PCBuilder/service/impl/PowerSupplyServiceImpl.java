package com.example.PCBuilder.service.impl;

import com.example.PCBuilder.model.dto.PowerSupplyDto;
import com.example.PCBuilder.model.dto.filter.PowerSupplyFilter;
import com.example.PCBuilder.service.PowerSupplyService;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public class PowerSupplyServiceImpl implements PowerSupplyService {
    @Override
    public String create(PowerSupplyDto dto) {
        return null;
    }

    @Override
    public void update(String id, PowerSupplyDto dto) {

    }

    @Override
    public PowerSupplyDto getById(String id) {
        return null;
    }

    @Override
    public List<PowerSupplyDto> obtainAll() {
        return null;
    }

    @Override
    public Page<PowerSupplyDto> getByFilter(Optional<PowerSupplyFilter> filter, int offset) {
        return null;
    }

    @Override
    public Page<PowerSupplyDto> getByFilterWithSortByPriceInc(Optional<PowerSupplyFilter> filter, int offset) {
        return null;
    }

    @Override
    public Page<PowerSupplyDto> getByFilterWithSortByNameInc(Optional<PowerSupplyFilter> filter, int offset) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public List<PowerSupplyDto> searchByName(String name) {
        return null;
    }
}
