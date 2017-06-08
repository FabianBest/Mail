package com.korki.java.CSV;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVActions {

	List<String> csvArray = new ArrayList<>();

	String fileName = "MailPackages.txt";

	public void CSVReader() {

		String line = null;

		try {
			FileReader fileReader = new FileReader(fileName);

			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}
			bufferedReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException e) {
			System.out.println("Error reading file '" + fileName + "'");
		}

	}

	public int CSVSearch(String name) {
		int CSVFound = -1;

		String line = null;

		try {
			FileReader fileReader = new FileReader(fileName);

			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {
				csvArray.add(line);
			}
			bufferedReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException e) {
			System.out.println("Error reading file '" + fileName + "'");
		}

		for (int i = 0; i < csvArray.size(); i++) {
			if (csvArray.get(i).startsWith(name)) {
				CSVFound = i;
			}
		}
		return CSVFound;
	}

	public void CSVChangingReceived(String name) {
		int csvFound = CSVSearch(name);
			String csvConverted = csvArray.get(csvFound).toString();
			String[] csvString = csvConverted.split(";");
			// System.out.println(csvString[7]);
			if (csvString[7].equals("true")) {
				csvString[7] = "false";
			} else {
				csvString[7] = "true";
			}
			// System.out.println(csvString[7]);
			csvArray.set(csvFound, csvString[0] + ";" + csvString[1] + ";" + csvString[2] + ";" + csvString[3] + ";"
					+ csvString[4] + ";" + csvString[5] + ";" + csvString[6] + ";" + csvString[7]);
			// System.out.println(csvArray.get(csvFound));

			//////////////////////////////////////

			try {
				FileReader fileReader = new FileReader(fileName);

				FileWriter fileWriter = new FileWriter(fileName);

				BufferedReader bufferedReader = new BufferedReader(fileReader);

				BufferedWriter bufferedWritter = new BufferedWriter(fileWriter);

				for (int i = 0; i < csvArray.size(); i++) {
					bufferedWritter.write(csvArray.get(i) + "\n");
				}
				bufferedReader.close();
				bufferedWritter.close();
			} catch (FileNotFoundException e) {
				System.out.println("Unable to open file '" + fileName + "'");
			} catch (IOException e) {
				System.out.println("Error reading file '" + fileName + "'");
			}
		
		csvArray.clear();

	}

	public void CSVDeleting(String name) {
		int csvFound = CSVSearch(name);
			csvArray.remove(csvFound);

			try {
				FileReader fileReader = new FileReader(fileName);

				FileWriter fileWriter = new FileWriter(fileName, false);

				BufferedReader bufferedReader = new BufferedReader(fileReader);

				BufferedWriter bufferedWritter = new BufferedWriter(fileWriter);

				for (int i = 0; i < csvArray.size(); i++) {
					bufferedWritter.write(csvArray.get(i) + "\n");
				}
				bufferedReader.close();
				bufferedWritter.close();
			} catch (FileNotFoundException e) {
				System.out.println("Unable to open file '" + fileName + "'");
			} catch (IOException e) {
				System.out.println("Error reading file '" + fileName + "'");
			}
		csvArray.clear();
	}

}
