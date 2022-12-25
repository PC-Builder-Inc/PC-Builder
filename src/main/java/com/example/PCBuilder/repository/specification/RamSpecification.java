package com.example.PCBuilder.repository.specification;

import com.example.PCBuilder.model.dto.filter.RamFilter;
import com.example.PCBuilder.model.entity.BaseData;
import com.example.PCBuilder.model.entity.RAM;
import com.example.PCBuilder.model.enums.FrequencyRAM;
import com.example.PCBuilder.model.enums.MemoryTechnology;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.Set;

import static java.util.Objects.isNull;

@Component
@RequiredArgsConstructor
public class RamSpecification {
    public Specification<RAM> byFilter(@Nullable RamFilter filter) {
        return isNull(filter) ? null : Specification
                .where(byIds(filter.getIds()))
                .and(byFrequenciesRAM(filter.getFrequenciesRAM()))
                .and(byRamTechnologies(filter.getRamTechnologies()));
    }


    private static Specification<RAM> byIds(Set<String> ids) {
        return CommonSpecification.searchIn(BaseData.BaseDataFields.id, ids);
    }

    private static Specification<RAM> byFrequenciesRAM(Set<FrequencyRAM> frequenciesRAM) {
        return CommonSpecification.searchIn(RAM.RamFields.frequencyRAM, frequenciesRAM);
    }

    private static Specification<RAM> byRamTechnologies(Set<MemoryTechnology> memoryTechnologies) {
        return CommonSpecification.searchIn(RAM.RamFields.ramTechnology, memoryTechnologies);
    }
}
