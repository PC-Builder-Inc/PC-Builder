package com.example.PCBuilder.controller;

import com.example.PCBuilder.model.dto.CaseDto;
import com.example.PCBuilder.model.dto.ProcessorDto;
import com.example.PCBuilder.model.dto.filter.CaseFilter;
import com.example.PCBuilder.model.dto.filter.ProcessorFilter;
import com.example.PCBuilder.service.CaseService;
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
@RequestMapping("/api/case")
public class CaseController {

    private final CaseService caseService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces =
            MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@Validated @RequestBody CaseDto dto) {
        return caseService.create(dto);
    }

    @GetMapping("/obtain-all")
    public List<ProcessorDto> obtainAll() {
        return caseService.obtainAll();
    }

    @GetMapping("/{processorId}")
    public ProcessorDto getById(@PathVariable String processorId) {
        return caseService.getById(processorId);
    }

    @PatchMapping("/{processorId}")
    public void update(@PathVariable String processorId, @RequestBody CaseDto dto) {
        caseService.update(processorId, dto);
    }

    @PostMapping("/search")
    public Page<ProcessorDto> getByFilter(
            @RequestBody(required = false) Optional<CaseFilter> filter,
            @RequestParam int offset) {
        return caseService.getByFilter(filter, offset);
    }

    @PostMapping("/sort-name-search")
    public Page<ProcessorDto> getByFilterWithSortByNameInc(
            @RequestBody(required = false) Optional<CaseFilter> filter,
            @RequestParam int offset) {
        return caseService.getByFilterWithSortByNameInc(filter, offset);
    }

    @PostMapping("/sort-price-search")
    public Page<ProcessorDto> getByFilterWithSortByPriceInc(
            @RequestBody(required = false) Optional<CaseFilter> filter,
            @RequestParam int offset) {
        return caseService.getByFilterWithSortByPriceInc(filter, offset);
    }

    @DeleteMapping("/{processorId}")
    public void delete(@PathVariable String processorId) {
        caseService.delete(processorId);
    }

    @GetMapping("/search-by-name")
    public List<ProcessorDto> searchByName(@RequestParam String name){
        return caseService.searchByName(name);
    }

}
