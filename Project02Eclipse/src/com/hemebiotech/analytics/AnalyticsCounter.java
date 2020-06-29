package com.hemebiotech.analytics;


import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

import com.hemebiotech.analytics.toolsbox.ISymptomToolsBox;
import com.hemebiotech.analytics.toolsbox.SymptomToolsBox;
import com.hemebiotech.analytics.toolsbox.options.OrderingOption;

/**
 * The main class software with user interactions  
 *@author 0Nico
 *@version 1.5
 */
public class AnalyticsCounter {
	
	
	private static ISymptomToolsBox itoolsbox ;
	
	private static String filePath;
	private static String resultPath;
	private static String orderingOption = "";
	
	
	public static void main(String args[]) throws Exception  {
		
		
		
		itoolsbox = new SymptomToolsBox();
		
	
		
		System.out.println("** Welcome to the Symptoms Analytics Counter Software v1.5 **");
		System.out.println("** Developped by HemeBioTech - 2020 . All right reserved. ** \n\n");
		System.out.println("Please enter the absolute location of your symptoms's files. One symptom per line, with no empty lines (means the end of the file). \n ");
		
		
		Scanner input = new Scanner(System.in);	    
	    filePath = input.next();
	    Map<String, Integer> fileSymptoms = itoolsbox.readSymptomsDataFromFile(filePath);
		
		
			
		System.out.println("Please enter the name of the result file (will overwrite if file already exist).\n");
		resultPath = input.next();
		
		while (!(orderingOption.equals("ASCENDING") || orderingOption.equals("DESCENDING"))) {
			System.out.println("Choose a way to order the file (please enter the full word uppercase):\n 1. ASCENDING \n 2. DESCENDING");
			orderingOption = input.next();
		}
		itoolsbox.writeSymptomsCount(resultPath, fileSymptoms, OrderingOption.valueOf(orderingOption));
		
		
		input.close();
		System.out.println("The file has been created. Thank you for using HemeBioTech Software. See you soon. \n");
		
	}
}
