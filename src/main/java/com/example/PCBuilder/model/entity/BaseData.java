package com.example.PCBuilder.model.entity;

import com.example.PCBuilder.model.enums.Manufacturer;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Data
@MappedSuperclass
public abstract class BaseData {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(name = "name", nullable = false)
    protected String name;

    @Column(name = "price", nullable = false)
    protected int price;

    @Column(name = "manufacturer", nullable = false)
    protected Manufacturer manufacturer;
}
