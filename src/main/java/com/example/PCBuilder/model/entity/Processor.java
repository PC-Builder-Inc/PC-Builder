package com.example.PCBuilder.model.entity;

import com.example.PCBuilder.model.enums.Socket;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name = "processor")
public class Processor extends BaseData {
    @Column(name = "socket", nullable = false)
    private Socket socket;

    @Column(name = "family", nullable = false)
    private String family;

    @Column(name = "number_of_cores", nullable = false)
    private int numberOfCores;

    @Column(name = "integrated_graphic_core_name")
    private String integratedGraphicCoreName;

    @Column(name = "release_year")
    private int releaseYear;

    @Column(name = "base_frequency")
    private int baseFrequency;

    @Column(name = "tdp", nullable = false)
    private int tdp;

    @Column(name = "technical_process")
    private int technicalProcess;
}
