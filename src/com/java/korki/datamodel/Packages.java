package com.java.korki.datamodel;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.korki.java.interfaces.CSVHandler;

public class Packages implements CSVHandler {

	private String senderAddress;
	private String senderName;
	private String senderSurname;
	
	private String receiverAddress;
	private String receiverName;
	private String receiverSurname;
	
	public Packages() {
		csvHandler();
	}
	
	public void CreatingPackages() {
		Scanner in = new Scanner(System.in);
		System.out.println("podaj adres nadawcy: ");
		senderAddress = in.nextLine();
		System.out.println("podaj imie nadawcy: ");
		senderName = in.nextLine();
		System.out.println("podaj nazwisko nadawcy: ");
		senderSurname = in.nextLine();
		System.out.println("podaj adres odbiorcy: ");
		receiverAddress = in.nextLine();
		System.out.println("podaj imie odbiorcy: ");
		receiverName = in.nextLine();
		System.out.println("podaj nazwisko odbiorcy: ");
		receiverSurname = in.nextLine();
	}
	
	@Override
	public void csvHandler() {
		CreatingPackages();
		
		String fileName = "MailPackages.txt";
		
		try{
			FileWriter fileWriter = new FileWriter(fileName);
			
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			
			bufferedWriter.write(senderAddress + ";" + senderName + ";" + senderSurname + ";" +
					receiverAddress + ";" + receiverName + ";" + receiverSurname);
			
			bufferedWriter.close();
		} catch(IOException e) {
			System.out.println("Error writing file: " + fileName);
		}
	}

}
