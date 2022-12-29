package com.example.PCBuilder.model.dto;

import com.example.PCBuilder.model.enums.Manufacturer;
import lombok.Data;

@Data
public class PowerSupplyUnitDto {
    private String id;
    private int power;
    private String name;
    private Manufacturer manufacturer;
    private int price;
}
