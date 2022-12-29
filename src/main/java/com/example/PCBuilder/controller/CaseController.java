package com.example.PCBuilder.controller;

import com.example.PCBuilder.model.dto.CaseDto;
import com.example.PCBuilder.model.dto.ProcessorDto;
import com.example.PCBuilder.model.dto.builder.BuilderDto;
import com.example.PCBuilder.model.dto.builder.BuilderRequestDto;
import com.example.PCBuilder.model.dto.filter.CaseFilter;
import com.example.PCBuilder.model.dto.filter.ProcessorFilter;
import com.example.PCBuilder.service.CaseService;
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
@RequestMapping("/api/case")
public class CaseController {

    private final CaseService caseService;
    @Autowired
    private final BuilderService builderService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces =
            MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@Validated @RequestBody CaseDto dto) {
        return caseService.create(dto);
    }

    @GetMapping("/obtain-all")
    public List<CaseDto> obtainAll() {
        return caseService.obtainAll();
    }

    @GetMapping("/{caseId}")
    public CaseDto getById(@PathVariable String caseId) {
        return caseService.getById(caseId);
    }

    @PatchMapping("/{caseId}")
    public void update(@PathVariable String caseId, @RequestBody CaseDto dto) {
        caseService.update(caseId, dto);
    }

    @PostMapping("/search")
    public Page<CaseDto> getByFilter(
            @RequestBody(required = false) Optional<CaseFilter> filter,
            @RequestParam int offset) {
        return caseService.getByFilter(filter, offset);
    }

    @PostMapping("/sort-name-search")
    public Page<CaseDto> getByFilterWithSortByNameInc(
            @RequestBody(required = false) Optional<CaseFilter> filter,
            @RequestParam int offset) {
        return caseService.getByFilterWithSortByNameInc(filter, offset);
    }

    @PostMapping("/sort-price-search")
    public Page<CaseDto> getByFilterWithSortByPriceInc(
            @RequestBody(required = false) Optional<CaseFilter> filter,
            @RequestParam int offset) {
        return caseService.getByFilterWithSortByPriceInc(filter, offset);
    }

    @DeleteMapping("/{caseId}")
    public void delete(@PathVariable String processorId) {
        caseService.delete(processorId);
    }

    @GetMapping("/search-by-name")
    public List<CaseDto> searchByName(@RequestParam String name){
        return caseService.searchByName(name);
    }

    @PostMapping("/build")
    public BuilderDto buildCase(@RequestBody(required = true) BuilderRequestDto builderRequestDto) {
        return builderService.pcBuilder(builderRequestDto);
    }

}
