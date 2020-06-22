package com.hemebiotech.analytics;


import java.io.IOException;
import java.util.Scanner;

public class AnalyticsCounter {
	
	public static void main(String args[]) {
		
		SymptomToolsBox toolsbox = new SymptomToolsBox();
		String filePath;
		String resultPath;
		
		System.out.println("** Welcome to the Symptoms Analytics Counter Software v1.1 **");
		System.out.println("** Developped by HemeBioTech - 2020 . All right reserved. ** \n\n");
		System.out.println("Please enter the absolute location of your symptoms's files. One symptom per line, with no empty lines (means the end of the file). \n ");
		
		Scanner input = new Scanner(System.in);	    
	    filePath = input.next();
		try {
			toolsbox.readSymptomsDataFromFile(filePath);
		} catch (IOException e) {
			System.err.println("Error to read symptoms file, please enter correct and existing file path.");
			e.printStackTrace();
		}
		
		
		System.out.println("Please enter the name of the result file (will overwrite if file already exist).\n");
		resultPath = input.next();
		try {
			toolsbox.writeSymptomsCountAlphabetically(resultPath);
		} catch (IOException e) {
			System.err.println("Error to create result file. Please enter a valid result filepath.  ");
			e.printStackTrace();
		}
		
		input.close();
		System.out.println("Thank you for using HemeBioTech Software. See you soon. \n");
		
	}
}
