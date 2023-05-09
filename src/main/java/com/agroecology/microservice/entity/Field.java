package com.agroecology.microservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Field {
  private String name;
  private String aria;
  private int bal;
  private String ph;
  private String gumus;
  private int azot;
  private int phosfor;
  private String kaliy;
  private int param1;
  private String param2;
  private String param3;
  private String param4;
  private String param5;
  private String param6;
  private String param7;
}
