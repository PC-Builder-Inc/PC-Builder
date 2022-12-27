package com.example.PCBuilder.model.dto.filter;

import com.example.PCBuilder.model.enums.MemoryTechnology;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VideoCardFilter {

    private Set<String> ids;

    private Set<Integer> vRamValues;

    private Set<MemoryTechnology> vRamTypes;

    private Set<Integer> tdpValues;
}
