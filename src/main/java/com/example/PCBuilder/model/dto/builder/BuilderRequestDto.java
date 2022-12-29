package com.example.PCBuilder.model.dto.builder;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class BuilderRequestDto {
    private String processorId;
    private String motherboardId;
    private String ramId;
    private String powerSupplyUnitId;
    private String caseId;
    private String videoCardId;
}
