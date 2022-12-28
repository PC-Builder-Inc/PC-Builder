package com.example.PCBuilder.controller;

import com.example.PCBuilder.model.dto.ProcessorDto;
import com.example.PCBuilder.model.dto.filter.ProcessorFilter;
import com.example.PCBuilder.model.entity.Processor;
import com.example.PCBuilder.service.ProcessorService;
import com.example.PCBuilder.service.builder.api.BuilderService;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/processor")
public class ProcessorController {

    private final ProcessorService processorService;
    @Autowired
    private final BuilderService builderService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces =
            MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@Validated @RequestBody ProcessorDto dto) {
        return processorService.create(dto);
    }

    @GetMapping("/obtain-all")
    public List<ProcessorDto> obtainAll() {
        return processorService.obtainAll();
    }

    @GetMapping("/{processorId}")
    public ProcessorDto getById(@PathVariable String processorId) {
        return processorService.getById(processorId);
    }

    @PatchMapping("/{processorId}")
    public void update(@PathVariable String processorId, @RequestBody ProcessorDto dto) {
        processorService.update(processorId, dto);
    }

    @PostMapping("/search")
    public Page<ProcessorDto> getByFilter(
            @RequestBody(required = false) Optional<ProcessorFilter> filter,
            @RequestParam int offset) {
        return processorService.getByFilter(filter, offset);
    }

    @PostMapping("/sort-name-search")
    public Page<ProcessorDto> getByFilterWithSortByNameInc(
            @RequestBody(required = false) Optional<ProcessorFilter> filter,
            @RequestParam int offset) {
        return processorService.getByFilterWithSortByNameInc(filter, offset);
    }

    @PostMapping("/sort-price-search")
    public Page<ProcessorDto> getByFilterWithSortByPriceInc(
            @RequestBody(required = false) Optional<ProcessorFilter> filter,
            @RequestParam int offset) {
        return processorService.getByFilterWithSortByPriceInc(filter, offset);
    }

    @DeleteMapping("/{processorId}")
    public void delete(@PathVariable String processorId) {
        processorService.delete(processorId);
    }

}
