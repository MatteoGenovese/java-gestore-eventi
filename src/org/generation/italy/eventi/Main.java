package org.generation.italy.eventi;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		LocalDate date;
		int year;
		int day;
		int month;
		String eventName;
		int eventSeatsNumber;
		
		System.out.println("Event name:");
		eventName=sc.nextLine();
		
		//insert date

		System.out.println("year:");
		year=Integer.parseInt(sc.nextLine());
		System.out.println("month:");
		month=Integer.parseInt(sc.nextLine());
		System.out.println("day:");
		day=Integer.parseInt(sc.nextLine());
		date=LocalDate.of(year,month, day);
		
		
		System.out.println("Place number of seats:");
		eventSeatsNumber=Integer.parseInt(sc.nextLine());
		
		Event e = new Event(eventName, date, eventSeatsNumber);
		
		
		
		System.out.println(e);
	}

}
