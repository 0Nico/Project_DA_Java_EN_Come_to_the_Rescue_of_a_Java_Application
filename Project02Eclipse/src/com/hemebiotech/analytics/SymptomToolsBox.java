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
 * Simple brute force implementation
 *
 */
public class SymptomToolsBox {

	
	private Map<String, Integer> symptoms;	
	
	

	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 * @throws IOException 
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
	
	public void writeSymptomsCountOnFile(String resultPath) throws IOException {
		
		FileWriter writer = new FileWriter (resultPath);
		symptoms.forEach((symptom, frequency)  ->{
			try {
				writer.write(symptom + " : " + frequency + "\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
			
		
		writer.close();
	}
	
	

}
