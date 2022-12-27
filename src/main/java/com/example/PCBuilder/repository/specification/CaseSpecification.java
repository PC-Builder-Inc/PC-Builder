package com.example.PCBuilder.repository.specification;

import com.example.PCBuilder.model.dto.filter.CaseFilter;
import com.example.PCBuilder.model.entity.BaseData;
import com.example.PCBuilder.model.entity.Case;
import com.example.PCBuilder.model.enums.Color;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.Set;

import static java.util.Objects.isNull;

@Component
@RequiredArgsConstructor
public class CaseSpecification {

    public Specification<Case> byFilter(@Nullable CaseFilter filter) {
        return isNull(filter) ? null : Specification
                .where(byIds(filter.getIds()))
                .and(byColors(filter.getColors()));
    }

    private static Specification<Case> byColors(Set<Color> colors) {
        return CommonSpecification.searchIn(Case.CaseFields.color, colors);
    }

    private static Specification<Case> byIds(Set<String> ids) {
        return CommonSpecification.searchIn(BaseData.BaseDataFields.id, ids);
    }
}
