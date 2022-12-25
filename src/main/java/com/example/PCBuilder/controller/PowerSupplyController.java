package com.example.PCBuilder.controller;

import com.example.PCBuilder.model.dto.PowerSupplyDto;
import com.example.PCBuilder.model.dto.ProcessorDto;
import com.example.PCBuilder.model.dto.filter.PowerSupplyFilter;
import com.example.PCBuilder.model.dto.filter.ProcessorFilter;
import com.example.PCBuilder.service.PowerSupplyService;
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
@RequestMapping("/api/power-supply")
public class PowerSupplyController {

    private final PowerSupplyService powerSupplyService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces =
            MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@Validated @RequestBody PowerSupplyDto dto) {
        return powerSupplyService.create(dto);
    }

    @GetMapping("/obtain-all")
    public List<ProcessorDto> obtainAll() {
        return powerSupplyService.obtainAll();
    }

    @GetMapping("/{processorId}")
    public ProcessorDto getById(@PathVariable String processorId) {
        return powerSupplyService.getById(processorId);
    }

    @PatchMapping("/{processorId}")
    public void update(@PathVariable String processorId, @RequestBody PowerSupplyDto dto) {
        powerSupplyService.update(processorId, dto);
    }

    @PostMapping("/search")
    public Page<ProcessorDto> getByFilter(
            @RequestBody(required = false) Optional<PowerSupplyFilter> filter,
            @RequestParam int offset) {
        return powerSupplyService.getByFilter(filter, offset);
    }

    @PostMapping("/sort-name-search")
    public Page<ProcessorDto> getByFilterWithSortByNameInc(
            @RequestBody(required = false) Optional<PowerSupplyFilter> filter,
            @RequestParam int offset) {
        return powerSupplyService.getByFilterWithSortByNameInc(filter, offset);
    }

    @PostMapping("/sort-price-search")
    public Page<ProcessorDto> getByFilterWithSortByPriceInc(
            @RequestBody(required = false) Optional<PowerSupplyFilter> filter,
            @RequestParam int offset) {
        return powerSupplyService.getByFilterWithSortByPriceInc(filter, offset);
    }

    @DeleteMapping("/{processorId}")
    public void delete(@PathVariable String processorId) {
        powerSupplyService.delete(processorId);
    }

    @GetMapping("/search-by-name")
    public List<ProcessorDto> searchByName(@RequestParam String name){
        return powerSupplyService.searchByName(name);
    }

}
