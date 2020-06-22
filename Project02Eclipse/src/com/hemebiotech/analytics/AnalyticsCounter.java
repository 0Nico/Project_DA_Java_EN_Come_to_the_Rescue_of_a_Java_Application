package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AnalyticsCounter {
	
	public static void main(String args[]) throws Exception {
		// first get input
		System.out.println(new File(".").getAbsolutePath());
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();

		Map<String, Integer> symptomes = new HashMap<>();	
		
		while (line != null) {
			if(symptomes.containsKey(line)) {
				symptomes.replace(line, symptomes.get(line) + 1);
				System.out.println("symptom from file: " + line);
				
			}
			else {
				symptomes.put(line, 1);
			}
			
			line = reader.readLine();	// get another symptom
		}
		
		// next generate output
		reader.close();
		FileWriter writer = new FileWriter ("result.out");
		symptomes.forEach((symptom, frequency)  ->{
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
