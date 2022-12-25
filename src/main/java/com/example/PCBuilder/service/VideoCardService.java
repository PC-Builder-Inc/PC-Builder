package com.example.PCBuilder.service;

import com.example.PCBuilder.model.dto.VideoCardDto;
import com.example.PCBuilder.model.dto.filter.VideoCardFilter;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface VideoCardService {
    String create(VideoCardDto dto);

    void update(String id, VideoCardDto dto);

    VideoCardDto getById(String id);

    List<VideoCardDto> obtainAll();

    Page<VideoCardDto> getByFilter(Optional<VideoCardFilter> filter, int offset);

    Page<VideoCardDto> getByFilterWithSortByPriceInc(Optional<VideoCardFilter> filter, int offset);

    Page<VideoCardDto> getByFilterWithSortByNameInc(Optional<VideoCardFilter> filter, int offset);

    void delete(String id);

    List<VideoCardDto> searchByName(String name);
}
