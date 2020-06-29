package com.hemebiotech.analytics.toolsbox;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

public interface ISymptomToolsBox {

	
	/**
	 * Reading method, come in first order to execute correctly the full software.
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 * @throws FileNotFoundException if the file path is incorrect & RuntimeException if the lines aren't readable
	 * @return A map who contains symptoms extract and count from the file
	 */
	public Map<String, Integer> readSymptomsDataFromFile (String filepath) throws Exception;
	
	
	/**
	 *  Write in a result file the final analyze with a alphabetical order. 
	 *  
	 * @param resultPath a full or partial path to a create a the file with the software result and symptoms who contains the symptoms
	 * @throws IOException if the result path is incorrect
	 */
	public void writeSymptomsCountAlphabetically(String resultPath, Map<String, Integer> symptoms) throws Exception ;
		
	
}
