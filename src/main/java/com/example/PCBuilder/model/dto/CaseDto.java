package com.example.PCBuilder.model.dto;

import com.example.PCBuilder.model.enums.Color;
import com.example.PCBuilder.model.enums.Manufacturer;
import lombok.Data;

@Data
public class CaseDto {
    private String id;
    private Color color;
    private String name;
    private Manufacturer manufacturer;
    private int price;
}
