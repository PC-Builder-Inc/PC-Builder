package com.example.PCBuilder.controller;

import com.example.PCBuilder.model.dto.VideoCardDto;
import com.example.PCBuilder.model.dto.filter.VideoCardFilter;
import com.example.PCBuilder.service.VideoCardService;
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
@RequestMapping("/api/video-card")
public class VideoCardController {

    private final VideoCardService videoCardService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces =
            MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@Validated @RequestBody VideoCardDto dto) {
        return videoCardService.create(dto);
    }

    @GetMapping("/obtain-all")
    public List<VideoCardDto> obtainAll() {
        return videoCardService.obtainAll();
    }

    @GetMapping("/{videoCardDtoId}")
    public VideoCardDto getById(@PathVariable String videoCardDtoId) {
        return videoCardService.getById(videoCardDtoId);
    }

    @PatchMapping("/{videoCardDtoId}")
    public void update(@PathVariable String videoCardDtoId, @RequestBody VideoCardDto dto) {
        videoCardService.update(videoCardDtoId, dto);
    }

    @PostMapping("/search")
    public Page<VideoCardDto> getByFilter(
            @RequestBody(required = false) Optional<VideoCardFilter> filter,
            @RequestParam int offset) {
        return videoCardService.getByFilter(filter, offset);
    }

    @PostMapping("/sort-name-search")
    public Page<VideoCardDto> getByFilterWithSortByNameInc(
            @RequestBody(required = false) Optional<VideoCardFilter> filter,
            @RequestParam int offset) {
        return videoCardService.getByFilterWithSortByNameInc(filter, offset);
    }

    @PostMapping("/sort-price-search")
    public Page<VideoCardDto> getByFilterWithSortByPriceInc(
            @RequestBody(required = false) Optional<VideoCardFilter> filter,
            @RequestParam int offset) {
        return videoCardService.getByFilterWithSortByPriceInc(filter, offset);
    }

    @DeleteMapping("/{videoCardDtoId}")
    public void delete(@PathVariable String videoCardDtoId) {
        videoCardService.delete(videoCardDtoId);
    }

    @GetMapping("/search-by-name")
    public List<VideoCardDto> searchByName(@RequestParam String name){
        return videoCardService.searchByName(name);
    }

}
