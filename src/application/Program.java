package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;
import model.exeption.DomainExeption;

public class Program {
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
		System.out.print("Room number: ");
		Integer roomNumber = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		Reservation res = new Reservation(roomNumber, checkIn, checkOut);		
		System.out.println("Reservation: " + res);
		
		System.out.println();
		
		System.out.println("Enter data to update the reservation: ");
		System.out.print("Check-in date (dd/MM/yyyy): ");
		checkIn = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		checkOut = sdf.parse(sc.next());
		res.updateDates(checkIn, checkOut);
		System.out.println("Reservation: " + res);
		
		
		
		} catch (ParseException e) {
			System.out.println("invalid format");
		} catch (DomainExeption e) {
			System.out.println("Error in reservation: " + e.getMessage());
		} catch (IllegalArgumentException e) {
			System.out.println("Unexpected error");
		}		
		
		sc.close();
	}

}
