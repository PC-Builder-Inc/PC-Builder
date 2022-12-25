package com.example.PCBuilder.repository.specification;

import com.example.PCBuilder.model.dto.filter.PowerSupplyUnitFilter;
import com.example.PCBuilder.model.entity.BaseData;
import com.example.PCBuilder.model.entity.PowerSupplyUnit;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.Set;

import static java.util.Objects.isNull;

@Component
@RequiredArgsConstructor
public class PowerSupplyUnitSpecification {
    public Specification<PowerSupplyUnit> byFilter(@Nullable PowerSupplyUnitFilter filter) {
        return isNull(filter) ? null : Specification
                .where(byIds(filter.getIds()))
                .and(byPowers(filter.getPower()));
    }

    private static Specification<PowerSupplyUnit> byPowers(Set<Integer> powers) {
        return CommonSpecification.searchIn(PowerSupplyUnit.PowerSupplyUnitFields.power, powers);
    }

    private static Specification<PowerSupplyUnit> byIds(Set<String> ids) {
        return CommonSpecification.searchIn(BaseData.BaseDataFields.id, ids);
    }
}
