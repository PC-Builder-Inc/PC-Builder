package com.example.PCBuilder.service.impl;

import com.example.PCBuilder.model.dto.RamDto;
import com.example.PCBuilder.model.dto.filter.RamFilter;
import com.example.PCBuilder.service.RamService;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public class RamServiceImpl implements RamService {
    @Override
    public String create(RamDto dto) {
        return null;
    }

    @Override
    public void update(String id, RamDto dto) {

    }

    @Override
    public RamDto getById(String id) {
        return null;
    }

    @Override
    public List<RamDto> obtainAll() {
        return null;
    }

    @Override
    public Page<RamDto> getByFilter(Optional<RamFilter> filter, int offset) {
        return null;
    }

    @Override
    public Page<RamDto> getByFilterWithSortByPriceInc(Optional<RamFilter> filter, int offset) {
        return null;
    }

    @Override
    public Page<RamDto> getByFilterWithSortByNameInc(Optional<RamFilter> filter, int offset) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public List<RamDto> searchByName(String name) {
        return null;
    }
}
