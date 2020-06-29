package com.hemebiotech.analytics.toolsbox;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
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
 *@version 1.5
 */
public class SymptomToolsBox implements ISymptomToolsBox {

	
	/**
	 * Reading method, come in first order to execute correctly the full software.
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 * @throws FileNotFoundException if the file path is incorrect & RuntimeException if the lines aren't readable
	 * @return A map who contains symptoms extract and count from the file
	 */
	@Override
	public Map<String, Integer> readSymptomsDataFromFile (String filepath) throws Exception {
		try (BufferedReader reader = new BufferedReader (new FileReader(filepath))){
				
			Map<String, Integer> symptoms = new HashMap<>();	
			
			String line = reader.readLine();
			while (line != null) {
				if(symptoms.containsKey(line)) {
					symptoms.replace(line, symptoms.get(line) + 1);
					System.out.println("symptom from file: " + line);
				} else {
					symptoms.put(line, 1);
				}
				try {
				line = reader.readLine();	
				} catch (RuntimeException e) {
					throw new Exception("Error while reading the line " + line + ". Please check format of the file.", e);
				}
			}
			return symptoms;
		}  catch (FileNotFoundException e){
			throw new Exception("Problem to find the document. The current file path " + filepath + "\" doesn't match any file.", e);
		}
		
	}
	
	
	
	/**
	 *  Write in a result file the final analyze with a alphabetical order. 
	 *  
	 * @param resultPath a full or partial path to a create a the file with the software result and symptoms who contains the symptoms
	 * @throws IOException if the result path is incorrect
	 */
	@Override
	public void writeSymptomsCountAlphabetically(String resultPath, Map<String, Integer> symptoms) throws Exception {
		try (FileWriter writer = new FileWriter (resultPath)){
		
			List<String> allSymptoms = new ArrayList<String>(symptoms.keySet());
			Collections.sort(allSymptoms);
			
			for (String symptom : allSymptoms) {
					try {
						writer.write(symptom + " : " + symptoms.get(symptom)+ "\n");
				} catch (RuntimeException e) {
					throw new Exception ("Error while writing in file due to : " + symptom ,e);
				}
			}
		} catch (IOException e) {
			throw new Exception ("Error to create the result File. Please retry with another extension file or name.", e);
		}
	
	}
	

}
