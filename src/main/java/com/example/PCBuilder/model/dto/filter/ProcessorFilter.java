package com.example.PCBuilder.model.dto.filter;

import com.example.PCBuilder.model.dto.PcDto;
import com.example.PCBuilder.model.enums.Manufacturer;
import com.example.PCBuilder.model.enums.Socket;
import lombok.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProcessorFilter {

    private Set<String> ids;

    private Set<Socket> sockets;

    private Set<String> families;

    private Set<Integer> numberOfCores;

    private Set<Integer> tdpValues;

    private Set<Manufacturer> manufacturers;

    private PcDto pcDto;
}
