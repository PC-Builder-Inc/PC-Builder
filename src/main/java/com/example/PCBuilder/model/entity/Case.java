package com.example.PCBuilder.model.entity;

import com.example.PCBuilder.model.enums.Color;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

@Getter
@Setter
@Entity
@FieldNameConstants(innerTypeName = "CaseFields")
@Table(name = "CASE_PC")
public class Case extends BaseData {

 @Column(name = "COLOR")
 private Color color;
}
