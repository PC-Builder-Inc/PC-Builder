package com.example.PCBuilder.model.dto.filter;

import com.example.PCBuilder.model.enums.Socket;
import lombok.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProcessorFilter {

    private Set<String> ids;

    private Set<String> externalIds;

    private Set<Socket> sockets;

    private Set<String> families;

    private Set<Integer> numberOfCores;

    private Set<Integer> tdpValues;

}
