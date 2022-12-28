package com.example.PCBuilder.controller;

import com.example.PCBuilder.model.dto.MotherboardDto;
import com.example.PCBuilder.model.dto.filter.MotherboardFilter;
import com.example.PCBuilder.service.MotherboardService;
import com.example.PCBuilder.service.builder.api.BuilderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/motherboard")
public class MotherboardController {

    private final MotherboardService motherboardService;
    @Autowired
    private final BuilderService builderService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces =
            MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@Validated @RequestBody MotherboardDto dto) {
        return motherboardService.create(dto);
    }

    @GetMapping("/obtain-all")
    public List<MotherboardDto> obtainAll() {
        return motherboardService.obtainAll();
    }

    @GetMapping("/{motherboardId}")
    public MotherboardDto getById(@PathVariable String motherboardId) {
        return motherboardService.getById(motherboardId);
    }

    @PatchMapping("/{motherboardId}")
    public void update(@PathVariable String motherboardId, @RequestBody MotherboardDto dto) {
        motherboardService.update(motherboardId, dto);
    }

    @PostMapping("/search")
    public Page<MotherboardDto> getByFilter(
            @RequestBody(required = false) Optional<MotherboardFilter> filter,
            @RequestParam int offset) {
        return motherboardService.getByFilter(filter, offset);
    }

    @PostMapping("/sort-name-search")
    public Page<MotherboardDto> getByFilterWithSortByNameInc(
            @RequestBody(required = false) Optional<MotherboardFilter> filter,
            @RequestParam int offset) {
        return motherboardService.getByFilterWithSortByNameInc(filter, offset);
    }

    @PostMapping("/sort-price-search")
    public Page<MotherboardDto> getByFilterWithSortByPriceInc(
            @RequestBody(required = false) Optional<MotherboardFilter> filter,
            @RequestParam int offset) {
        return motherboardService.getByFilterWithSortByPriceInc(filter, offset);
    }

    @DeleteMapping("/{motherboardId}")
    public void delete(@PathVariable String motherboardId) {
        motherboardService.delete(motherboardId);
    }

    @GetMapping("/search-by-name")
    public List<MotherboardDto> searchByName(@RequestParam String name) {
        return motherboardService.searchByName(name);
    }

}
