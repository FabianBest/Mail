package com.java.korki.datamodel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
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
	
	private String mailMan;
	
	private boolean received;
	
	public Packages() {
		
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
		System.out.println("Przypisz listonosza");
		System.out.println("1 - Zdzis³aw Stonoga");
		System.out.println("2 - W³adimir Putin");
		int caser = in.nextInt();
		switch(caser) {
		case 1: mailMan = "Zdzis³aw Stonoga";
		break;
		case 2: mailMan = "W³adimir Putin";
		break;
		}
		received = false;
		
	}
	
	@Override
	public void csvHandler() {
		CreatingPackages();
		
		String fileName = "MailPackages.txt";
		
		File file = new File(fileName);
		
		try{
			FileWriter fileWriter = new FileWriter(fileName, true);

			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			
			bufferedWriter.write(senderAddress + ";" + senderName + ";" + senderSurname + ";" +
					receiverAddress + ";" + receiverName + ";" + receiverSurname + ";" +
					mailMan + ";" + received);	
			
			bufferedWriter.newLine();
		
		bufferedWriter.close();
	} catch(FileNotFoundException e) {
			System.out.println("Error writing file: " + fileName);
		} catch(IOException e) {
			System.out.println("Error writing file: " + fileName);
		}
	}

}
