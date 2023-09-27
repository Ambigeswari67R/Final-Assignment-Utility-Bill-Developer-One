package com.finzly.bharatbijili;

import java.io.ByteArrayInputStream;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CSVService {
  @Autowired
  CsvFileRepository repository;

  public void save(MultipartFile file) {
    try {
  	  System.out.println("try inn");

      List<CsvFile> tutorials = CSVHelper.csvToTutorials(file.getInputStream());
	  System.out.println("try inn");

      repository.saveAll(tutorials);
    } catch (IOException e) {
      throw new RuntimeException("fail to store csv data: " + e.getMessage());
    }
  }

  public ByteArrayInputStream load() {
    List<CsvFile> tutorials = repository.findAll();

    ByteArrayInputStream in = CSVHelper.tutorialsToCSV(tutorials);
    return in;
  }

  public List<CsvFile> getAllTutorials() {
    return repository.findAll();
  }
}

