package com.example.PCBuilder.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

@Getter
@Setter
@Entity
@FieldNameConstants(innerTypeName = "PowerSupplyUnitFields")
@Table(name = "POWER_SUPPLY_UNIT")
public class PowerSupplyUnit extends BaseData {

 @Column(name = "POWER")
 private int power;
}
