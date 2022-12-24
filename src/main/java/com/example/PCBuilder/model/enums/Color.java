package com.example.PCBuilder.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Color {

 YELLOW ("Желтый"),

 RED ("Красный"),

 GREEN ("Зеленый"),

 ORANGE ("Оранжевый"),

 BLUE ("Синий"),

 PINK ("Розовый"),

 BROWN ("Коричневый"),

 PURPLE ("Фиолетовый"),

 WHITE ("Белый"),

 BLACK ("Черный");

 private final String code;

 public static Color getByCode(String code) throws IllegalAccessException {
  for (Color enumValue : Color.values()) {
    if (enumValue.getCode().equals(code)) return enumValue;
  }
  throw new IllegalAccessException("There is no Color enum value with code " + code);
 }

 @Override
 public String toString() {
  return super.toString() + "(" + code + ")";
 }
}
