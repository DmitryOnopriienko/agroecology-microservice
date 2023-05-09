package com.agroecology.microservice.service;

import com.agroecology.microservice.entity.Field;

import java.util.List;

public interface FieldsService {
  Field getData(String name);

  List<Field> getAllData();
}
