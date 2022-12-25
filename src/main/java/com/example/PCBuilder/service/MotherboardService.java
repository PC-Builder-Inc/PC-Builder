package com.example.PCBuilder.service;

import com.example.PCBuilder.model.dto.MotherboardDto;
import com.example.PCBuilder.model.dto.filter.MotherboardFilter;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface MotherboardService {
    String create(MotherboardDto dto);

    void update(String id, MotherboardDto dto);

    MotherboardDto getById(String id);

    List<MotherboardDto> obtainAll();

    Page<MotherboardDto> getByFilter(Optional<MotherboardFilter> filter, int offset);

    Page<MotherboardDto> getByFilterWithSortByPriceInc(Optional<MotherboardFilter> filter, int offset);

    Page<MotherboardDto> getByFilterWithSortByNameInc(Optional<MotherboardFilter> filter, int offset);

    void delete(String id);

    List<MotherboardDto> searchByName(String name);
}
