package com.example.PCBuilder.service.impl;

import com.example.PCBuilder.model.dto.VideoCardDto;
import com.example.PCBuilder.model.dto.filter.VideoCardFilter;
import com.example.PCBuilder.service.VideoCardService;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public class VideoCardServiceImpl implements VideoCardService {
    @Override
    public String create(VideoCardDto dto) {
        return null;
    }

    @Override
    public void update(String id, VideoCardDto dto) {

    }

    @Override
    public VideoCardDto getById(String id) {
        return null;
    }

    @Override
    public List<VideoCardDto> obtainAll() {
        return null;
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

    }

    @Override
    public List<VideoCardDto> searchByName(String name) {
        return null;
    }
}
