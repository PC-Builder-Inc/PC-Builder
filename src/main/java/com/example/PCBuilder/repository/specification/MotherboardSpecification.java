package com.example.PCBuilder.repository.specification;

import com.example.PCBuilder.model.dto.filter.MotherboardFilter;
import com.example.PCBuilder.model.entity.BaseData;
import com.example.PCBuilder.model.entity.Motherboard;
import com.example.PCBuilder.model.enums.FrequencyRAM;
import com.example.PCBuilder.model.enums.MemoryTechnology;
import com.example.PCBuilder.model.enums.Socket;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.Set;

import static java.util.Objects.isNull;

@Component
@RequiredArgsConstructor
public class MotherboardSpecification {
    public Specification<Motherboard> byFilter(@Nullable MotherboardFilter filter) {
        return isNull(filter) ? null : Specification
                .where(byIds(filter.getIds()))
                .and(bySockets(filter.getSockets()))
                .and(byFrequenciesRAM(filter.getFrequenciesRAM()))
                .and(byRamTechnologies(filter.getRamTechnologies()));
    }

    private static Specification<Motherboard> bySockets(Set<Socket> sockets) {
        return CommonSpecification.searchIn(Motherboard.MotherboardFields.socket, sockets);
    }

    private static Specification<Motherboard> byIds(Set<String> ids) {
        return CommonSpecification.searchIn(BaseData.BaseDataFields.id, ids);
    }

    private static Specification<Motherboard> byFrequenciesRAM(Set<FrequencyRAM> frequenciesRAM) {
        return CommonSpecification.searchIn(Motherboard.MotherboardFields.frequencyRAM, frequenciesRAM);
    }

    private static Specification<Motherboard> byRamTechnologies(Set<MemoryTechnology> memoryTechnologies) {
        return CommonSpecification.searchIn(Motherboard.MotherboardFields.ramTechnology, memoryTechnologies);
    }
}
