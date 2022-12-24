package com.example.PCBuilder.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MemoryTechnology {

 //For RAM
 DDR3("DDR3"),

 DDR4("DDR4"),

 DDR5("DDR5"),

 //For Video cards
 GDDR3 ("GDDR3 "),

 GDDR4 ("GDDR4 "),

 GDDR5("GDDR5"),

 GDDR5X("GDDR5X"),

 GDDR6("GDDR6");

 private final String code;

 public static MemoryTechnology getByCode(String code) throws IllegalAccessException {
  for (MemoryTechnology enumValue : MemoryTechnology.values()) {
   if (enumValue.getCode().equals(code)) return enumValue;
  }
  throw new IllegalAccessException("There is no RAMTechnology enum value with code " + code);
 }

 @Override
 public String toString() {
  return super.toString() + "(" + code + ")";
 }
}
