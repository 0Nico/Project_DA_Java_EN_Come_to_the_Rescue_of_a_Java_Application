package com.hemebiotech.analytics.toolsbox;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import com.hemebiotech.analytics.toolsbox.exceptions.CreateFileException;
import com.hemebiotech.analytics.toolsbox.exceptions.ReadFileException;
import com.hemebiotech.analytics.toolsbox.exceptions.ReadLinesException;
import com.hemebiotech.analytics.toolsbox.exceptions.WriteLineException;
import com.hemebiotech.analytics.toolsbox.options.OrderingOption;

public interface ISymptomToolsBox {

	
	/**
	 * Read line by line to collect and count file's symptoms
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 * @return A map who contains symptoms extract and count from the file
	 * @throws ReadFileException 
	 * @throws ReadLinesException 
	 * @throws IOException 
	 */
	public Map<String, Integer> readSymptomsDataFromFile (String filepath) throws Exception;
	
	

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
	public void writeSymptomsCount(String resultPath, Map<String, Integer> symptoms, OrderingOption option) throws Exception ;
		
	
}
