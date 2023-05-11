package com.hemebiotech.analytics;

import java.util.Map;
import java.util.List;

public class Main{

  public static void main(String[] args) {
    
    ISymptomReader symptomReader = new ReadSymptomDataFromFile("symptoms.txt");
    
    ISymptomWriter symptomWriter = new WriteSymptomDataToFile("result.out");
  
    AnalyticsCounter counter = new AnalyticsCounter(symptomReader, symptomWriter);
  
    List<String> symptoms = counter.getSymptoms();

    Map<String, Integer> countedSymptoms = counter.countSymptoms(symptoms);

    Map<String, Integer> sortedSymptoms = counter.sortSymptoms(countedSymptoms);
  
    }
}