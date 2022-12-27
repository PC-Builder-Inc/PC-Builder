package com.example.PCBuilder.model.dto;

import com.example.PCBuilder.model.enums.FrequencyRAM;
import com.example.PCBuilder.model.enums.Manufacturer;
import com.example.PCBuilder.model.enums.MemoryTechnology;
import lombok.Data;

@Data
public class RamDto {
    private MemoryTechnology ramTechnology;
    private FrequencyRAM frequencyRAM;
    private String name;
    private Manufacturer manufacturer;
    private int price;
    private String id;
}
