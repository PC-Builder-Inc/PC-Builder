package com.example.PCBuilder.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public enum FrequencyRAM {

 FREQUENCY_1600 (1600),

 FREQUENCY_1800 (1800),

 FREQUENCY_2000 (2000),

 FREQUENCY_2133 (2133),

 FREQUENCY_2200 (2200),

 FREQUENCY_2400  (2400),

 FREQUENCY_2666  (2666),

 FREQUENCY_2800  (2800),

 FREQUENCY_3000  (3000),

 FREQUENCY_3200  (3200),

 FREQUENCY_3333  (3333),

 FREQUENCY_4800  (4800),

 FREQUENCY_5200  (5200),

 FREQUENCY_5600  (5600);

 private final int code;

 public static FrequencyRAM getByCode(int code) throws IllegalAccessException {
  for (FrequencyRAM enumValue : FrequencyRAM.values()) {
      if (enumValue.getCode() == code) return enumValue;
  }
  throw new IllegalAccessException("There is no FrequencyRAM enum value with code " + code);
 }

 @Override
 public String toString() {
  return super.toString() + "(" + code + ")";
 }
}

