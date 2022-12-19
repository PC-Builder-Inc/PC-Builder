package com.example.PCBuilder.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "POWER_SUPPLY_UNIT")
public class PowerSupplyUnit extends BaseData {

 @Column(name = "POWER")
 private int power;
}
