package com.example.PCBuilder.service;

import com.example.PCBuilder.model.dto.RamDto;
import com.example.PCBuilder.model.dto.filter.RamFilter;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface RamService {
    String create(RamDto dto);

    void update(String id, RamDto dto);

    RamDto getById(String id);

    List<RamDto> obtainAll();

    Page<RamDto> getByFilter(Optional<RamFilter> filter, int offset);

    Page<RamDto> getByFilterWithSortByPriceInc(Optional<RamFilter> filter, int offset);

    Page<RamDto> getByFilterWithSortByNameInc(Optional<RamFilter> filter, int offset);

    void delete(String id);

    List<RamDto> searchByName(String name);
}
