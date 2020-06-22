package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The essential object with all the methods needed by the main file. 
 *@author 0Nico
 *@version 1.4
 */
public class SymptomToolsBox {

	/**
	 * Key collection who contains the symptoms file counted data
	 */
	private Map<String, Integer> symptoms;	
	

	/**
	 * Reading method, come in first order to execute correctly the full software.
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 * @throws IOException if the file path is incorrect
	 */
	public void readSymptomsDataFromFile (String filepath) throws IOException {
		BufferedReader reader = new BufferedReader (new FileReader(filepath));
		String line = reader.readLine();

		this.symptoms = new HashMap<>();	
		
		while (line != null) {
			if(symptoms.containsKey(line)) {
				symptoms.replace(line, symptoms.get(line) + 1);
				System.out.println("symptom from file: " + line);
			}
			else {
				symptoms.put(line, 1);
			}
			
			line = reader.readLine();	// get another symptom
		}
		reader.close(); 
	}
	
	/**
	 *  Second time method, to write in a result file the final analyze. 
	 *  
	 * @see readSymptomsDataFromFile needed before using this method.
	 * @param resultPath a full or partial path to a create a the file with the software result
	 * @throws IOException if the result path is incorrect
	 */
	public void writeSymptomsCountOnFile(String resultPath) throws IOException {
		
		if(symptoms == null) {
			System.err.println("Error, no symptoms are loaded. Please only use this methods after reading symptoms file.");
		} else {
			FileWriter writer = new FileWriter (resultPath);
			symptoms.forEach((symptom, frequency)  ->{
				try {
					writer.write(symptom + " : " + frequency + "\n");
				} catch (IOException e) {
					System.err.println("Error while writing in result File. Please retry with a correct extension file.");
					e.printStackTrace();
				}
			});
			writer.close();
		}
	}
	
	/**
	 *  Second time method, to write in a result file the final analyze with a alphabetical order. 
	 *  
	 * @see readSymptomsDataFromFile needed before using this method.
	 * @param resultPath a full or partial path to a create a the file with the software result
	 * @throws IOException if the result path is incorrect
	 */
	public void writeSymptomsCountAlphabetically(String resultPath) throws IOException {
		
		if(symptoms == null) {
			System.err.println("Error, no symptoms are loaded. Please only use this methods after reading symptoms file.");
		} else {
			List<String> allSymptoms = new ArrayList<String>(symptoms.keySet());
			Collections.sort(allSymptoms);
			
			FileWriter writer = new FileWriter (resultPath);
			allSymptoms.stream().forEach(symptom  ->{
				try {
					writer.write(symptom + " : " + symptoms.get(symptom)+ "\n");
				} catch (IOException e) {
					System.err.println("Error while writing in result File. Please retry with a correct extension file.");
					e.printStackTrace();
				}
			});	
			writer.close();
		}
	}
	

}
