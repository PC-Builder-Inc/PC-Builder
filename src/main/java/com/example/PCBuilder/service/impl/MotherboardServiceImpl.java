package com.example.PCBuilder.service.impl;

import com.example.PCBuilder.model.dto.MotherboardDto;
import com.example.PCBuilder.model.dto.filter.MotherboardFilter;
import com.example.PCBuilder.service.MotherboardService;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public class MotherboardServiceImpl implements MotherboardService {
    @Override
    public String create(MotherboardDto dto) {
        return null;
    }

    @Override
    public void update(String id, MotherboardDto dto) {

    }

    @Override
    public MotherboardDto getById(String id) {
        return null;
    }

    @Override
    public List<MotherboardDto> obtainAll() {
        return null;
    }

    @Override
    public Page<MotherboardDto> getByFilter(Optional<MotherboardFilter> filter, int offset) {
        return null;
    }

    @Override
    public Page<MotherboardDto> getByFilterWithSortByPriceInc(Optional<MotherboardFilter> filter, int offset) {
        return null;
    }

    @Override
    public Page<MotherboardDto> getByFilterWithSortByNameInc(Optional<MotherboardFilter> filter, int offset) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public List<MotherboardDto> searchByName(String name) {
        return null;
    }
}
