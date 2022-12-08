package com.example.PCBuilder.controller;

import com.example.PCBuilder.model.dto.ProcessorDto;
import com.example.PCBuilder.service.ProcessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/processor")
public class ProcessorController {

    private final ProcessorService processorService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces =
            MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@Validated @RequestBody ProcessorDto dto) {
        return processorService.create(dto);
    }

//    @PutMapping("/{processor-id}")
//    public void update(
//            @PathVariable("processor-id") String processorId,
//            @RequestBody ProcessorDto dto) {
//        processorService.update(processorId, dto);
//    }
}
