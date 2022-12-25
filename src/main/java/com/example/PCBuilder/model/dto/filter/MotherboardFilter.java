package com.example.PCBuilder.model.dto.filter;

import com.example.PCBuilder.model.enums.FrequencyRAM;
import com.example.PCBuilder.model.enums.MemoryTechnology;
import com.example.PCBuilder.model.enums.Socket;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MotherboardFilter {

    private Set<String> ids;

    private Set<Socket> sockets;

    private Set<MemoryTechnology> ramTechnologies;

    private Set<FrequencyRAM> frequenciesRAM;

}
