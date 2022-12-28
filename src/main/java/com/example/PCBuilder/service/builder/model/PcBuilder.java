package com.example.PCBuilder.service.builder.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Entity
@FieldNameConstants(innerTypeName = "PcBuilderFields")
@Table(name = "PC-BUILDERr")
@Configuration
public class PcBuilder {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "processor_id", nullable = false)
    private String processorId;
    @Column(name = "motherboard_id", nullable = false)
    private String motherboardId;
    @Column(name = "power_id", nullable = false)
    private String powerSupplyUnitId;
    @Column(name = "case_id", nullable = false)
    private String caseId;
    @Column(name = "ram_id", nullable = false)
    private String ramId;
    @Column(name = "videocard_id", nullable = false)
    private String videoCardId;

    private int progressValue;

    public void incrementProgressValue() {
      progressValue++;
    }
}
