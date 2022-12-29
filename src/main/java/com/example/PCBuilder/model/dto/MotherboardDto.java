package com.example.PCBuilder.model.dto;

import com.example.PCBuilder.model.enums.FrequencyRAM;
import com.example.PCBuilder.model.enums.Manufacturer;
import com.example.PCBuilder.model.enums.MemoryTechnology;
import com.example.PCBuilder.model.enums.Socket;
import lombok.Data;

@Data
public class MotherboardDto {
    private String id;
    private Socket socket;
    private MemoryTechnology ramTechnology;
    private String chipsetType;
    private int maxRam;
    private FrequencyRAM frequencyRAM;
    private String name;
    private Manufacturer manufacturer;
    private int price;
}
