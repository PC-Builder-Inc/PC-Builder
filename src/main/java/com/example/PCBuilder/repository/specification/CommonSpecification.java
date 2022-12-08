package com.example.PCBuilder.repository.specification;

import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;

import java.util.Collection;

import static org.springframework.util.CollectionUtils.isEmpty;

@UtilityClass
public final class CommonSpecification {

    public <T, R> Specification<T> searchIn(String fieldName, Collection<R> values) {
        return isEmpty(values) ? null
                : (root, query, criteriaBuilder) -> root.get(fieldName).in(values);
    }

}

