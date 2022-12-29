package com.example.PCBuilder.service.builder.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
//@Entity
//@FieldNameConstants(innerTypeName = "PcBuilderFields")
//@Table(name = "PC-BUILDERr")
//@Configuration
@Builder
public class PcBuilder {


    private Long id;
    private String processorId;
    private String motherboardId;
    private String powerSupplyUnitId;
    private String caseId;
    private String ramId;
    private String videoCardId;

    private int progressValue;

    public void incrementProgressValue() {
      progressValue++;
    }
}
