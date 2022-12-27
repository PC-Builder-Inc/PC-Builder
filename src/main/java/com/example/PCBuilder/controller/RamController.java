package com.example.PCBuilder.controller;

import com.example.PCBuilder.model.dto.RamDto;
import com.example.PCBuilder.model.dto.filter.RamFilter;
import com.example.PCBuilder.service.RamService;
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
@RequestMapping("/api/ram")
public class RamController {

    private final RamService ramService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces =
            MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@Validated @RequestBody RamDto dto) {
        return ramService.create(dto);
    }

    @GetMapping("/obtain-all")
    public List<RamDto> obtainAll() {
        return ramService.obtainAll();
    }

    @GetMapping("/{ramId}")
    public RamDto getById(@PathVariable String ramId) {
        return ramService.getById(ramId);
    }

    @PatchMapping("/{ramId}")
    public void update(@PathVariable String ramId, @RequestBody RamDto dto) {
        ramService.update(ramId, dto);
    }

    @PostMapping("/search")
    public Page<RamDto> getByFilter(
            @RequestBody(required = false) Optional<RamFilter> filter,
            @RequestParam int offset) {
        return ramService.getByFilter(filter, offset);
    }

    @PostMapping("/sort-name-search")
    public Page<RamDto> getByFilterWithSortByNameInc(
            @RequestBody(required = false) Optional<RamFilter> filter,
            @RequestParam int offset) {
        return ramService.getByFilterWithSortByNameInc(filter, offset);
    }

    @PostMapping("/sort-price-search")
    public Page<RamDto> getByFilterWithSortByPriceInc(
            @RequestBody(required = false) Optional<RamFilter> filter,
            @RequestParam int offset) {
        return ramService.getByFilterWithSortByPriceInc(filter, offset);
    }

    @DeleteMapping("/{ramId}")
    public void delete(@PathVariable String ramId) {
        ramService.delete(ramId);
    }

    @GetMapping("/search-by-name")
    public List<RamDto> searchByName(@RequestParam String name){
        return ramService.searchByName(name);
    }

}
