package com.example.PCBuilder.model.dto;

import com.example.PCBuilder.model.enums.Manufacturer;
import com.example.PCBuilder.model.enums.MemoryTechnology;
import lombok.Data;

@Data
public class VideoCardDto {
    private String id;
    private int gpuBaseClock;
    private int gpuBoostClock;
    private int vRam;
    private MemoryTechnology vRamType;
    private int tdp;
    private String name;
    private Manufacturer manufacturer;
    private int price;
}
