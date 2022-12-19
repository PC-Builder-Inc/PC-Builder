package com.example.PCBuilder.model.entity;

import com.example.PCBuilder.model.enums.MemoryTechnology;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "VIDEO_CARD")
public class VideoCard extends BaseData {

 @Column(name = "GPUBASECLOCK")
 private int gpuBaseClock;

 @Column(name = "GPUBOOSTCLOCK")
 private int gpuBoostClock;

 @Column(name = "VRAM")
 private int vRam;

 @Column(name = "VRAMTYPE")
 private MemoryTechnology vRamType;

 @Column(name = "TDP")
 private int tdp;
}
