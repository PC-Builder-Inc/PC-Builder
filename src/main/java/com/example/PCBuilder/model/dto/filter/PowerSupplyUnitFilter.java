package com.example.PCBuilder.model.dto.filter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PowerSupplyUnitFilter {

    private Set<String> ids;

    private Set<Integer> power;
}
