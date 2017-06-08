package com.java.korki.actions;

import java.util.Scanner;

import com.java.korki.datamodel.Director;
import com.java.korki.datamodel.Packages;
import com.korki.java.CSV.CSVActions;
import com.korki.java.interfaces.Users;

public class UsersActions implements Users {

	Director user1 = new Director();
	Packages pack = new Packages();

	public void Operations() {
		System.out.println("podaj login i password");
		Scanner in = new Scanner(System.in);
		String login = in.nextLine();
		String password = in.nextLine();
		if (user1.SignIn(login, password)) {
			Menu();
		} else {
			System.out.println("nie poprawny login, badz haslo");
		}
	}

	private void Menu() {
		String addressDel ="";
		String addressRec ="";
		CSVActions CSVact = new CSVActions();
		Scanner in = new Scanner(System.in);
		int switchActions = 0;
		while(switchActions != 5){
		System.out.println(" 1 - stwórz now¹ przesy³kê \n 2 - Sprawdz przesy³ki \n 3 - zmien stan dostarczenia"
				+ "\n 4 - usun przesylke \n 5 - wyjscie");

		switchActions = in.nextInt();
		in.nextLine();
		if (switchActions == 1) {
			pack.csvHandler();
		} else if (switchActions == 2) {
			CSVact.CSVReader();
		} else if (switchActions == 3) {
			System.out.println("Podaj adres przesy³ki do zmiany stanu dostarczenia");
			addressRec = in.nextLine();
			CSVact.CSVChangingReceived(addressRec);
		} else if (switchActions == 4) {
			System.out.println("Podaj adres przesy³ki do usuniêcia");
			addressDel = in.nextLine();
			CSVact.CSVDeleting(addressDel);
		} else if (switchActions == 2) {
			System.out.println("Exit");
		}
		}
	}

	@Override
	public boolean SignIn(String login, String password) {
		return false;

	}

	@Override
	public void SignOut() {
		// TODO Auto-generated method stub

	}
}
