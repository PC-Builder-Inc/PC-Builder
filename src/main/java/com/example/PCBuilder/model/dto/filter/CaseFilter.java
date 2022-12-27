package com.example.PCBuilder.model.dto.filter;

import com.example.PCBuilder.model.enums.Color;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CaseFilter {

    private Set<String> ids;

    private Set<Color> colors;

}
