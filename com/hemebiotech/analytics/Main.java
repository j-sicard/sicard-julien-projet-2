package com.hemebiotech.analytics;

import java.util.Map;
import java.util.List;


// WRITE YOUR CODE HERE
public class Main{

  public static void main(String[] args) {

    // Instanciation d'un objet ISymptomReader
    ISymptomReader symptomReader = new ReadSymptomDataFromFile("symptoms.txt");

    // Instanciation d'un objet ISymptomWriter
    ISymptomWriter symptomWriter = new WriteSymptomDataToFile("result.out");

    // Instanciation d'un objet AnalyticsCounter
    AnalyticsCounter counter = new AnalyticsCounter(symptomReader, symptomWriter);

    // Obtention de la liste des symptômes
    List<String> symptoms = counter.getSymptoms();

    // Comptage des symptômes
    Map<String, Integer> countedSymptoms = counter.countSymptoms(symptoms);

    // Tri des symptômes par ordre alphabétique
    Map<String, Integer> sortedSymptoms = counter.sortSymptoms(countedSymptoms);

    // Écriture des symptômes triés dans le fichier de sortie
    counter.writeSymptoms(sortedSymptoms);
}
}