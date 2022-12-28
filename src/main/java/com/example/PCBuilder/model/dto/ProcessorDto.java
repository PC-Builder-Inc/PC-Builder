package com.example.PCBuilder.model.dto;

import com.example.PCBuilder.model.enums.Manufacturer;
import com.example.PCBuilder.model.enums.Socket;
import lombok.Data;

@Data
public class ProcessorDto {
    private Socket socket;

    private String family;

    private int numberOfCores;

    private String integratedGraphicCoreName;

    private int releaseYear;

    private int baseFrequency;

    private int tdp;

    private int technicalProcess;

    private int price;

    private String name;

    private Manufacturer manufacturer;

    private String id;
}
