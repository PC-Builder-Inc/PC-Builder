package com.example.PCBuilder.controller;

import com.example.PCBuilder.model.dto.MotherboardDto;
import com.example.PCBuilder.model.dto.ProcessorDto;
import com.example.PCBuilder.model.dto.filter.MotherboardFilter;
import com.example.PCBuilder.service.MotherboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/motherboard")
public class MotherboardController {

    private final MotherboardService motherboardService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces =
            MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@Validated @RequestBody MotherboardDto dto) {
        return motherboardService.create(dto);
    }

    @GetMapping("/obtain-all")
    public List<ProcessorDto> obtainAll() {
        return motherboardService.obtainAll();
    }

    @GetMapping("/{processorId}")
    public ProcessorDto getById(@PathVariable String processorId) {
        return motherboardService.getById(processorId);
    }

    @PatchMapping("/{processorId}")
    public void update(@PathVariable String processorId, @RequestBody MotherboardDto dto) {
        motherboardService.update(processorId, dto);
    }

    @PostMapping("/search")
    public Page<ProcessorDto> getByFilter(
            @RequestBody(required = false) Optional<MotherboardFilter> filter,
            @RequestParam int offset) {
        return motherboardService.getByFilter(filter, offset);
    }

    @PostMapping("/sort-name-search")
    public Page<ProcessorDto> getByFilterWithSortByNameInc(
            @RequestBody(required = false) Optional<MotherboardFilter> filter,
            @RequestParam int offset) {
        return motherboardService.getByFilterWithSortByNameInc(filter, offset);
    }

    @PostMapping("/sort-price-search")
    public Page<ProcessorDto> getByFilterWithSortByPriceInc(
            @RequestBody(required = false) Optional<MotherboardFilter> filter,
            @RequestParam int offset) {
        return motherboardService.getByFilterWithSortByPriceInc(filter, offset);
    }

    @DeleteMapping("/{processorId}")
    public void delete(@PathVariable String processorId) {
        motherboardService.delete(processorId);
    }

    @GetMapping("/search-by-name")
    public List<ProcessorDto> searchByName(@RequestParam String name) {
        return motherboardService.searchByName(name);
    }

}
