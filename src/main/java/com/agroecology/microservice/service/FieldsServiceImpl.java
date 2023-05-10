package com.agroecology.microservice.service;

import com.agroecology.microservice.entity.Field;
import com.agroecology.microservice.exception.NotFoundException;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class FieldsServiceImpl implements FieldsService {
  @Override
  public Field getData(String name) {
    try (InputStreamReader inputStreamReader =
                 new InputStreamReader(getClass().getResourceAsStream("/fields.csv"));
            CSVReader reader =
                 new CSVReaderBuilder(new BufferedReader(inputStreamReader))
                         .withSkipLines(1)
                         .withCSVParser(new CSVParserBuilder().withSeparator(';').build())
                         .build()) {
      String[] nextLine;
      while ((nextLine = reader.readNext()) != null) {
        if (nextLine[0].equals(name)) {
          return mapToField(nextLine);
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    throw new NotFoundException("Field with name " + name + " not found");
  }

  @Override
  public List<Field> getAllData() {
    List<Field> fields = new ArrayList<>();
    try (InputStreamReader inputStreamReader =
                 new InputStreamReader(getClass().getResourceAsStream("/fields.csv"));
         CSVReader reader =
                 new CSVReaderBuilder(new BufferedReader(inputStreamReader))
                         .withSkipLines(1)
                         .withCSVParser(new CSVParserBuilder().withSeparator(';').build())
                         .build()) {
      String [] nextLine;
      while ((nextLine = reader.readNext()) != null) {
        fields.add(mapToField(nextLine));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return fields;
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
