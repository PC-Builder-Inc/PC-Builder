package com.example.PCBuilder.model.entity;

import com.example.PCBuilder.model.enums.Color;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "CASE")
public class Case extends BaseData {

 @Column(name = "COLOR")
 private Color color;
}
