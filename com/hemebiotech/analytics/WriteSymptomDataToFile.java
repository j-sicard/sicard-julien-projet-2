package com.hemebiotech.analytics;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {  

    
    private String fileName;

    public WriteSymptomDataToFile() {
        this.fileName = "result.out";
    }

    public WriteSymptomDataToFile(String fileName) {
        this.fileName = fileName;
    }

    @Override
	public void writeSymptoms(Map<String, Integer> symptoms) {
        	
        try {
            BufferedWriter writer = new BufferedWriter (new FileWriter(fileName));
            for(Map.Entry<String, Integer> symptom:symptoms.entrySet()){
                writer.write(symptom.getKey() + " : " + symptom.getValue() + "\n");
            }	  
        writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }	
	}
}

