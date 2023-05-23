package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter { 
  private ISymptomReader reader;
  private ISymptomWriter writer;
  private static final String DATA_SOURCE_FILE = "symptoms.txt";
  private static final String RECEIPT_FILE = "result.out";
      

  public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {       
    this.reader = reader;
    this.writer = writer;
  }  
  /**
   * Retrieves the list of symptoms.
   * @return A list of symptoms.
   */

  public List<String> getSymptoms() {      
    ArrayList<String> result = new ArrayList<String>();

    try {
      BufferedReader reader = new BufferedReader(new FileReader(DATA_SOURCE_FILE));
      String line = reader.readLine();

      while (line != null) {
        result.add(line);
        line = reader.readLine();
      }
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }      

    return result;
  }

  /**
   * Counts the occurrences of each symptom in the list.
   * @param symptoms A list of symptoms.
   * @return A map containing the symptoms and their occurrence count.
   */
  public Map<String, Integer> countSymptoms(List<String> symptoms) {        
    Map<String, Integer> symptomCount = new HashMap<>();

    for (String symptom : symptoms) {
      int count = symptomCount.getOrDefault(symptom, 0);
      symptomCount.put(symptom, count + 1);
    }

    return symptomCount;
  }

  /**
   * Sorts the symptoms in alphabetical order.
   * @param symptoms A map containing the symptoms and their occurrence count.
   * @return A sorted map of symptoms.
   */
  public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
    Map<String, Integer> sortedSymptoms = new TreeMap<>(symptoms);

    return sortedSymptoms;
  }

  /**
   * Writes the symptoms and their occurrence count to a file.
   * @param symptoms A map containing the symptoms and their occurrence count.
   */
  public void writeSymptoms(Map<String, Integer> symptoms) {
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter(RECEIPT_FILE));

      for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
        writer.write(entry.getKey() + " : " + entry.getValue() + "\n");
      }
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}