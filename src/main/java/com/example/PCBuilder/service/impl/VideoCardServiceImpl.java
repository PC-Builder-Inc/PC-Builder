package com.example.PCBuilder.service.impl;

import com.example.PCBuilder.model.dto.VideoCardDto;
import com.example.PCBuilder.model.dto.filter.VideoCardFilter;
import com.example.PCBuilder.model.entity.VideoCard;
import com.example.PCBuilder.model.mapper.VideoCardMapper;
import com.example.PCBuilder.repository.VideoCardRepository;
import com.example.PCBuilder.repository.specification.VideoCardSpecification;
import com.example.PCBuilder.service.MessageService;
import com.example.PCBuilder.service.VideoCardService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VideoCardServiceImpl implements VideoCardService {

    private final VideoCardRepository videoCardRepository;
    private final VideoCardMapper mapper;
    private final VideoCardSpecification specification;
    private final MessageService messageService;

    @Override
    public String create(VideoCardDto dto) {
        VideoCard videoCard = mapper.toEntity(dto);
        videoCardRepository.save(videoCard);
        return videoCard.getId();
    }

    @Override
    public void update(String id, VideoCardDto dto) {
        VideoCard videoCard = getVideoCard(id);
        mapper.merge(videoCard, dto);
    }

    @Override
    public VideoCardDto getById(String id) {
        return mapper.toDto(getVideoCard(id));
    }

    @Override
    public List<VideoCardDto> obtainAll() {
        return videoCardRepository.findAll().stream().map(p -> mapper.toDto(p)).toList();
    }

    @Override
    public Page<VideoCardDto> getByFilter(Optional<VideoCardFilter> filter, int offset) {
        return null;
    }

    @Override
    public Page<VideoCardDto> getByFilterWithSortByPriceInc(Optional<VideoCardFilter> filter, int offset) {
        return null;
    }

    @Override
    public Page<VideoCardDto> getByFilterWithSortByNameInc(Optional<VideoCardFilter> filter, int offset) {
        return null;
    }

    @Override
    public void delete(String id) {
        VideoCard toDelete = getVideoCard(id);
        videoCardRepository.delete(toDelete);
    }

    @Override
    public List<VideoCardDto> searchByName(String name) {
        List<VideoCardDto> dtos = obtainAll();
        return dtos.stream().filter(dto -> dto.getName().contains(name)).toList();
    }

    private VideoCard getVideoCard(String ramId) {
        return videoCardRepository.findById(ramId)
                .orElseThrow(() -> new EntityNotFoundException(
                        messageService.get("VideoCard.validation.does.not.found.by.id", ramId)
                ));
    }
}
