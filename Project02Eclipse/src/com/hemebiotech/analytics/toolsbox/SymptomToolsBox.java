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

import com.hemebiotech.analytics.toolsbox.exceptions.CreateFileException;
import com.hemebiotech.analytics.toolsbox.exceptions.ReadFileException;
import com.hemebiotech.analytics.toolsbox.exceptions.ReadLinesException;
import com.hemebiotech.analytics.toolsbox.exceptions.WriteLineException;
import com.hemebiotech.analytics.toolsbox.options.OrderingOption;

/**
 * The essential object with all the methods needed by the main file. 
 *@author 0Nico
 *@version 1.5
 */
public class SymptomToolsBox implements ISymptomToolsBox {

	
	/**
	 * Read line by line to collect and count file's symptoms
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 * @return A map who contains symptoms extract and count from the file
	 * @throws ReadFileException 
	 * @throws ReadLinesException 
	 * @throws IOException 
	 */
	@Override
	public Map<String, Integer> readSymptomsDataFromFile (String filepath) throws  ReadFileException, ReadLinesException, IOException {
		try (BufferedReader reader = new BufferedReader (new FileReader(filepath))){
				
			Map<String, Integer> symptoms = new HashMap<>();	
			
			String line = reader.readLine();
			while (line != null) {
				symptoms.put(line, symptoms.getOrDefault(line, 0) + 1);
				
				try {
				line = reader.readLine();	
				} catch (RuntimeException e) {
					throw new ReadLinesException("Error while reading the line " + line + ". Please check format of the file.", e);
				}
			}
			return symptoms;
		}  catch (FileNotFoundException e){
			throw new ReadFileException("Problem to find the document. The current file path " + filepath + "\" doesn't match any file.", e);
		}
		
	}
	
	
	
	/**
	 *  Write in a result file the final analyze with specified order. 
	 *  
	 * @param resultPath  a full or partial path to a create a the file with result,  the ordering option
	 * @param symptoms  a map with counted symptoms
	 * @param option  the option to configure the symptoms sort 
	 * @throws WriteLineException 
	 * @throws CreateFileException 
	 * @throws IOException if the result path is incorrect & RuntimeException if the current line can't be written
	 */
	@Override
	public void writeSymptomsCount(String resultPath, Map<String, Integer> symptoms, OrderingOption option) throws WriteLineException, CreateFileException {
		try (FileWriter writer = new FileWriter (resultPath)){
		
			List<String> allSymptoms = orderListByOption(new ArrayList<String>(symptoms.keySet()), option);
			
			for (String symptom : allSymptoms) {
					try {
						writer.write(symptom + " : " + symptoms.get(symptom)+ "\n");
				} catch (RuntimeException e) {
					throw new WriteLineException ("Error while writing in file due to : " + symptom ,e);
				}
			}
		} catch (IOException e) {
			throw new CreateFileException ("Error to create the result File. Please retry with another extension file or name.", e);
		}
	
	}
	
	/**
	 * Method to sort the list of symptoms
	 * @param the list of the symptom's names
	 * @param the sort option
	 * @return the list of symptoms sorted
	 */
	private List<String> orderListByOption(List<String> symptoms, OrderingOption option){			
		switch(option) {
			case ASCENDING :
				Collections.sort(symptoms);
			case DESCENDING :
				Collections.sort(symptoms, Collections.reverseOrder());
		}
		return symptoms;		
	}
	

}
