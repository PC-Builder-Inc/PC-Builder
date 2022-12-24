package com.example.PCBuilder.model.entity;

import com.example.PCBuilder.model.enums.FrequencyRAM;
import com.example.PCBuilder.model.enums.MemoryTechnology;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "RAM")
public class RAM extends BaseData {

 @Column(name = "RAMTECHNOLOGY")
 private MemoryTechnology ramTechnology;

 @Column(name = "FREQUENCYRAM")
 private FrequencyRAM frequencyRAM;
}
