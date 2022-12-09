package com.example.PCBuilder.service.impl;

import com.example.PCBuilder.model.dto.ProcessorDto;
import com.example.PCBuilder.model.dto.filter.ProcessorFilter;
import com.example.PCBuilder.model.entity.BaseData;
import com.example.PCBuilder.model.entity.Processor;
import com.example.PCBuilder.model.mapper.ProcessorMapper;
import com.example.PCBuilder.repository.ProcessorRepository;
import com.example.PCBuilder.repository.specification.ProcessorSpecification;
import com.example.PCBuilder.service.MessageService;
import com.example.PCBuilder.service.ProcessorService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.aspectj.bridge.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProcessorServiceImpl implements ProcessorService {

    private final ProcessorRepository processorRepository;
    private final ProcessorMapper mapper;
    private final ProcessorSpecification specification;
    private final MessageService messageService;
    private static final int PAGE_SIZE = 10;

    @Override
    @Transactional
    public String create(ProcessorDto dto) {
        Processor processor = mapper.toEntity(dto);
        processorRepository.save(processor);
        return processor.getId();
    }

    @Override
    @Transactional
    public void update(String id, ProcessorDto dto) {
        Processor processor = getProcessor(id);
        mapper.merge(processor, dto);
    }

    @Override
    public List<ProcessorDto> obtainAll() {
        return processorRepository.findAll().stream().map(p -> mapper.toDto(p)).toList();
    }

    @Override
    public Page<ProcessorDto> getByFilter(Optional<ProcessorFilter> filter, int offset) {
        Pageable pageable = PageRequest.of(offset, PAGE_SIZE);
        return getPage(pageable, filter);
    }

    @Override
    public ProcessorDto getById(String id) {
        return mapper.toDto(getProcessor(id));
    }

    @Override
    public Page<ProcessorDto> getByFilterWithSortByPriceInc(Optional<ProcessorFilter> filter, int offset) {
        Pageable pageable = PageRequest.of(offset, PAGE_SIZE, Sort.by(BaseData.BaseDataFields.price));
        return getPage(pageable, filter);
    }

    @Override
    public Page<ProcessorDto> getByFilterWithSortByNameInc(Optional<ProcessorFilter> filter, int offset) {
        Pageable pageable = PageRequest.of(offset, PAGE_SIZE, Sort.by(BaseData.BaseDataFields.name));
        return getPage(pageable, filter);
    }

    public Page<ProcessorDto> getPage(Pageable pageable, Optional<ProcessorFilter> filter) {
        if (filter.isEmpty()) {
            return processorRepository.findAll(pageable).map(p -> mapper.toDto(p));
        }
        else {
            return processorRepository.findAll(specification.byFilter(filter.get()), pageable)
                    .map(p -> mapper.toDto(p));
        }
    }

    private Processor getProcessor(String processorId) {
        return processorRepository.findById(processorId)
                .orElseThrow(() -> new EntityNotFoundException(
                        messageService.get("processor.validation.does.not.found.by.id", processorId)
                ));
    }

    @Override
    @Transactional
    public void delete(String id) {
        Processor toDelete = getProcessor(id);
        processorRepository.delete(toDelete);
    }

}
