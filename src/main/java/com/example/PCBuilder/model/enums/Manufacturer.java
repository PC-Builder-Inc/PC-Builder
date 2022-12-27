package com.example.PCBuilder.model.enums;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
@Getter
public enum Manufacturer {
    //PowerSupplyUnit
    COUGAR("Cougar"),
    //Motherboard
    GIGABYTE("GIGABYTE"),
    //RAM
    KINGSTON("Kingston"),
    //Case
    AEROCOOL("AeroCool"),
    //Processor
    INTEL("Intel"),
    AMD("AMD"),
    MSI("MSI");

    final String name;

    public static Manufacturer getByName(String name) {
        return Arrays.stream(Manufacturer.values())
                .filter(l -> l.getName().equalsIgnoreCase(name))
                .findFirst().orElse(null);
    }

}
