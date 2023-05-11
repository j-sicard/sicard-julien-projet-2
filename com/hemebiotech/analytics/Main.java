package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        // Create an object to read symptoms from the symptoms.txt file
        ISymptomReader symptomReader = new ReadSymptomDataFromFile("symptoms.txt");

        // Create an object to write symptoms to the result.out file
        ISymptomWriter symptomWriter = new WriteSymptomDataToFile("result.out");

        // Create an AnalyticsCounter object that counts and sorts symptoms
        AnalyticsCounter counter = new AnalyticsCounter(symptomReader, symptomWriter);

        // Get a list of all symptoms
        List<String> symptoms = counter.getSymptoms();

        // Count the number of occurrences of each symptom
        Map<String, Integer> countedSymptoms = counter.countSymptoms(symptoms);

        // Sort the symptoms in alphabetical order
        Map<String, Integer> sortedSymptoms = counter.sortSymptoms(countedSymptoms);

        // Write the sorted results to the result.out file
        counter.writeSymptoms(sortedSymptoms);
    }
}