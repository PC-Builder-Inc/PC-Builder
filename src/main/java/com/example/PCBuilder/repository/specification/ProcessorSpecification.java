package com.example.PCBuilder.repository.specification;

import com.example.PCBuilder.model.dto.filter.ProcessorFilter;
import com.example.PCBuilder.model.entity.BaseData;
import com.example.PCBuilder.model.entity.Processor;
import com.example.PCBuilder.model.enums.Socket;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.Set;

import static java.util.Objects.isNull;

@Component
@RequiredArgsConstructor
public class ProcessorSpecification {

    public Specification<Processor> byFilter(@Nullable ProcessorFilter filter) {
        return isNull(filter) ? null : Specification
                .where(byIds(filter.getIds()))
                .and(bySockets(filter.getSockets()))
                .and(byNumberOfCores(filter.getNumberOfCores()))
                .and(byTdp(filter.getTdpValues()));
    }

    private static Specification<Processor> bySockets(Set<Socket> sockets) {
        return CommonSpecification.searchIn(Processor.ProcessorFields.socket, sockets);
    }

    private static Specification<Processor> byIds(Set<String> ids) {
        return CommonSpecification.searchIn(BaseData.BaseDataFields.id, ids);
    }

    private static Specification<Processor> byNumberOfCores(Set<Integer> cores) {
        return CommonSpecification.searchIn(Processor.ProcessorFields.numberOfCores, cores);
    }

    private static Specification<Processor> byTdp(Set<Integer> tdp) {
        return CommonSpecification.searchIn(Processor.ProcessorFields.tdp, tdp);
    }

}
