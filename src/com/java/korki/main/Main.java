package com.java.korki.main;

import com.java.korki.datamodel.Packages;
import com.korki.java.CSV.CSVActions;

public class Main {

	public static void main(String[] args) {
		//Packages pack = new Packages();
		CSVActions CSVact = new CSVActions();
		CSVact.CSVReader();
		CSVact.CSVChangingReceived("Konieczkowa");
		System.out.println("");
		CSVact.CSVReader();
		System.out.println("");
		CSVact.CSVDeleting("Miloszow");
		CSVact.CSVReader();
	}

}
