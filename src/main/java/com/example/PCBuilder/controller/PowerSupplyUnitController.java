package com.example.PCBuilder.controller;

import com.example.PCBuilder.model.dto.PowerSupplyUnitDto;
import com.example.PCBuilder.model.dto.filter.PowerSupplyUnitFilter;
import com.example.PCBuilder.service.PowerSupplyUnitService;
import lombok.RequiredArgsConstructor;
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
@RequestMapping("/api/power-supply")
public class PowerSupplyUnitController {

    private final PowerSupplyUnitService powerSupplyUnitService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces =
            MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@Validated @RequestBody PowerSupplyUnitDto dto) {
        return powerSupplyUnitService.create(dto);
    }

    @GetMapping("/obtain-all")
    public List<PowerSupplyUnitDto> obtainAll() {
        return powerSupplyUnitService.obtainAll();
    }

    @GetMapping("/{powerSupplyUnitId}")
    public PowerSupplyUnitDto getById(@PathVariable String powerSupplyUnitId) {
        return powerSupplyUnitService.getById(powerSupplyUnitId);
    }

    @PatchMapping("/{powerSupplyUnitId}")
    public void update(@PathVariable String powerSupplyUnitId, @RequestBody PowerSupplyUnitDto dto) {
        powerSupplyUnitService.update(powerSupplyUnitId, dto);
    }

    @PostMapping("/search")
    public Page<PowerSupplyUnitDto> getByFilter(
            @RequestBody(required = false) Optional<PowerSupplyUnitFilter> filter,
            @RequestParam int offset) {
        return powerSupplyUnitService.getByFilter(filter, offset);
    }

    @PostMapping("/sort-name-search")
    public Page<PowerSupplyUnitDto> getByFilterWithSortByNameInc(
            @RequestBody(required = false) Optional<PowerSupplyUnitFilter> filter,
            @RequestParam int offset) {
        return powerSupplyUnitService.getByFilterWithSortByNameInc(filter, offset);
    }

    @PostMapping("/sort-price-search")
    public Page<PowerSupplyUnitDto> getByFilterWithSortByPriceInc(
            @RequestBody(required = false) Optional<PowerSupplyUnitFilter> filter,
            @RequestParam int offset) {
        return powerSupplyUnitService.getByFilterWithSortByPriceInc(filter, offset);
    }

    @DeleteMapping("/{powerSupplyUnitId}")
    public void delete(@PathVariable String powerSupplyUnitId) {
        powerSupplyUnitService.delete(powerSupplyUnitId);
    }

    @GetMapping("/search-by-name")
    public List<PowerSupplyUnitDto> searchByName(@RequestParam String name){
        return powerSupplyUnitService.searchByName(name);
    }

}
