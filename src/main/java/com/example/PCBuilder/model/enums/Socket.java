package com.example.PCBuilder.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
@Getter
public enum Socket {
    LGA_1700("LGA 1700"),
    LGA_1200("LGA 1200"),
    AM4("AM4"),
    AM5("AM5");

    final String name;

    public static Socket getByName(String name){
        return Arrays.stream(Socket.values())
                .filter(l -> l.getName().equalsIgnoreCase(name))
                .findFirst().orElse(null);
    }
}
