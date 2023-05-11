package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.TreeMap;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class AnalyticsCounter { 
    private ISymptomReader reader;
    private ISymptomWriter writer;
    private String filepath;

    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) { 
        this.reader = reader;
        this.writer = writer;
    }

    public List<String> getSymptoms() {
        ArrayList<String> result = new ArrayList<String>();

        if (filepath != null) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(filepath));
                String line = reader.readLine();

                while (line != null) {
                    result.add(line);
                    line = reader.readLine();
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    public Map<String, Integer> countSymptoms(List<String> symptoms) {        
        Map<String, Integer> symptomCount = new HashMap<>();

        for (String symptom : symptoms) {
            int count = symptomCount.getOrDefault(symptom, 0);
            symptomCount.put(symptom, count + 1);
        }

        return symptomCount;
    } 

    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
        Map<String, Integer> sortedSymptoms = new TreeMap<>(symptoms);

        return sortedSymptoms;
    }

    public void writeSymptoms(Map<String, Integer> symptoms) {	
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("result.out"));
            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                writer.write(entry.getKey() + " : " + entry.getValue() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }	
    }
}