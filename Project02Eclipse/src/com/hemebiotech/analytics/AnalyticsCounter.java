package com.hemebiotech.analytics;


import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

import com.hemebiotech.analytics.toolsbox.ISymptomToolsBox;
import com.hemebiotech.analytics.toolsbox.SymptomToolsBox;

/**
 * The main class software with user interactions  
 *@author 0Nico
 *@version 1.5
 */
public class AnalyticsCounter {
	
	
	private static ISymptomToolsBox itoolsbox ;
	
	private static String filePath;
	
	private static String resultPath;
	
	
	public static void main(String args[]) throws Exception  {
		
		
		
		itoolsbox = new SymptomToolsBox();
		
	
		
		System.out.println("** Welcome to the Symptoms Analytics Counter Software v1.1 **");
		System.out.println("** Developped by HemeBioTech - 2020 . All right reserved. ** \n\n");
		System.out.println("Please enter the absolute location of your symptoms's files. One symptom per line, with no empty lines (means the end of the file). \n ");
		
		
		Scanner input = new Scanner(System.in);	    
	    filePath = input.next();
	    Map<String, Integer> fileSymptoms = itoolsbox.readSymptomsDataFromFile(filePath);
		
		
			
		System.out.println("Please enter the name of the result file (will overwrite if file already exist).\n");
		resultPath = input.next();
		itoolsbox.writeSymptomsCountAlphabetically(resultPath, fileSymptoms);
		
		
		input.close();
		System.out.println("Thank you for using HemeBioTech Software. See you soon. \n");
		
	}
}
