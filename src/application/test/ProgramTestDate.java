package application.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exeption.DomainExeption;

public class ProgramTestDate {
	
	public static void main(String[]args) throws ParseException {
		
		try {
		Scanner scanner = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Date checkin = sdf.parse(scanner.next());
		Date checkout = sdf.parse(scanner.next());
		
		Reservation res = new Reservation(2, checkin, checkout);
		
		System.out.println(res.duration());
		
		scanner.close();
		} catch (DomainExeption d) {
			System.out.println("error: " + d.getMessage());
		}
	}

}
