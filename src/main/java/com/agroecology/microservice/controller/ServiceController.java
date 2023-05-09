package com.agroecology.microservice.controller;

import com.agroecology.microservice.entity.Field;
import com.agroecology.microservice.service.FieldsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {

  private final FieldsService fieldsService;

  @Autowired
  public ServiceController(FieldsService fieldsService) {
    this.fieldsService = fieldsService;
  }

  @GetMapping("/data/{name}")
  public Field getDataAboutField(@PathVariable("name") String name) {
    System.out.println("Log: Request for " + name + " field");
    return fieldsService.getData(name);
  }
}
