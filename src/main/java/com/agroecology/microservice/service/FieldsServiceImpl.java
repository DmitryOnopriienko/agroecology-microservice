package com.agroecology.microservice.service;

import com.agroecology.microservice.entity.Field;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.util.Arrays;

@Service
public class FieldsServiceImpl implements FieldsService {
  @Override
  public Field getData(String name) {
    System.out.println("Log: Request for " + name + " field in service");
    try (CSVReader reader =
                 new CSVReaderBuilder(new FileReader("./src/main/resources/fields.csv"))
                         .withSkipLines(1)
                         .withCSVParser(new CSVParserBuilder()
                                 .withSeparator(';')
                                 .build())
                         .build()) {
      System.out.println("Log: file opened");
      String[] nextLine;
      while ((nextLine = reader.readNext()) != null) {
        System.out.println("Log: line:" + Arrays.toString(nextLine));
        if (nextLine[0].equals(name)) {
          System.out.println("Log: needed line:" + Arrays.toString(nextLine));
          return mapToField(nextLine);
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  private static Field mapToField(String[] line) {
    return new Field(
            line[0],
            line[1],
            Integer.parseInt(line[2]),
            line[3],
            line[4],
            Integer.parseInt(line[5]),
            Integer.parseInt(line[6]),
            line[7],
            Integer.parseInt(line[8]),
            line[9],
            line[10],
            line[11],
            line[12],
            line[13],
            line[14]
    );
  }
}
