package com.example.PCBuilder.model.entity;

import com.example.PCBuilder.model.enums.FrequencyRAM;
import com.example.PCBuilder.model.enums.MemoryTechnology;
import com.example.PCBuilder.model.enums.Socket;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

@Getter
@Setter
@Entity
@FieldNameConstants(innerTypeName = "MotherboardFields")
@Table(name = "MOTHERBOARD")
public class Motherboard extends BaseData {

 @Column(name = "SOCKET")
 private Socket socket;

 @Column(name = "RAMTECHNOLOGY")
 private MemoryTechnology ramTechnology;

 @Column(name = "CHIPSETTYPE")
 private String chipsetType;

 @Column(name = "MAXRAM")
 private int maxRam;

 @Column(name = "FREQUENCYRAM")
 private FrequencyRAM frequencyRAM;
}
