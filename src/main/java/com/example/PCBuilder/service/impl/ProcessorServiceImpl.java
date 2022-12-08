package com.example.PCBuilder.service.impl;

import com.example.PCBuilder.model.dto.ProcessorDto;
import com.example.PCBuilder.model.entity.Processor;
import com.example.PCBuilder.model.mapper.ProcessorMapper;
import com.example.PCBuilder.repository.ProcessorRepository;
import com.example.PCBuilder.service.ProcessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProcessorServiceImpl implements ProcessorService {

    private final ProcessorRepository processorRepository;
    private final ProcessorMapper mapper;

    @Override
    public String create(ProcessorDto dto) {
        Processor processor = mapper.toEntity(dto);
        processorRepository.save(processor);
        return processor.getId();
    }
}
