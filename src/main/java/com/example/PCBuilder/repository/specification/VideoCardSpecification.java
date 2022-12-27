package com.example.PCBuilder.repository.specification;

import com.example.PCBuilder.model.dto.filter.VideoCardFilter;
import com.example.PCBuilder.model.entity.BaseData;
import com.example.PCBuilder.model.entity.VideoCard;
import com.example.PCBuilder.model.enums.MemoryTechnology;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.Set;

import static java.util.Objects.isNull;

@Component
@RequiredArgsConstructor
public class VideoCardSpecification {

    public Specification<VideoCard> byFilter(@Nullable VideoCardFilter filter) {
        return isNull(filter) ? null : Specification
                .where(byIds(filter.getIds()))
                .and(byTdpValues(filter.getTdpValues()))
                .and(byVRamValues(filter.getVRamValues()))
                .and(byVRamType(filter.getVRamTypes()));
    }

    private static Specification<VideoCard> byTdpValues(Set<Integer> tdpValues) {
        return CommonSpecification.searchIn(VideoCard.VideoCardFields.tdp, tdpValues);
    }

    private static Specification<VideoCard> byIds(Set<String> ids) {
        return CommonSpecification.searchIn(BaseData.BaseDataFields.id, ids);
    }

    private static Specification<VideoCard> byVRamValues(Set<Integer> vRamValues) {
        return CommonSpecification.searchIn(VideoCard.VideoCardFields.vRam, vRamValues);
    }

    private static Specification<VideoCard> byVRamType(Set<MemoryTechnology> vRamTypes) {
        return CommonSpecification.searchIn(VideoCard.VideoCardFields.vRamType, vRamTypes);
    }

}
