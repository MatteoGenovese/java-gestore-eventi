package org.generation.italy.eventi;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Scanner sc=new Scanner(System.in);
		LocalDate date;
		int year;
		int day;
		int month;
		String eventName;
		int eventSeatsNumber;
		int reservationAttempt;
		int whatDoYouWantToDo=0;
		String doYouWantToBook;
		String doYouWantToCancelYourReservation;
		Event event=null;
		
		
		ArrayList <Event> events = new ArrayList <Event> ();
		
		EventPlanning eventPlanner = new EventPlanning("New List");

		while(true)
		{
			System.out.println("What do you want to do:"
					+"\n1-Insert a new event"
					+"\n2-Book some seats"
					+"\n3-cancel your reservation"
					+"\n4-Print all the events"
					+"\n5-Print the total events number"
					+"\n6-Clear all the events list");
			whatDoYouWantToDo=Integer.parseInt(sc.nextLine());
			
			if(whatDoYouWantToDo==1)
			{
				
				
				
				System.out.println("Event name:");
				eventName=sc.nextLine();
				
				System.out.println("year:");
				year=Integer.parseInt(sc.nextLine());
				System.out.println("month:");
				month=Integer.parseInt(sc.nextLine());
				System.out.println("day:");
				day=Integer.parseInt(sc.nextLine());
				date=LocalDate.of(year,month, day);
				
				
				System.out.println("Place number of seats:");
				eventSeatsNumber=Integer.parseInt(sc.nextLine());
				
				try {

					
					eventPlanner.addEventToList(new Event(eventName, date, eventSeatsNumber));
				}
				catch (Exception e) {

					System.err.println(e.getMessage());
				}
				finally {


				}
			}
			
			if(whatDoYouWantToDo==2)
			{
				
				System.out.println("Do you want to book in some events?(y to confirm)");
				doYouWantToBook=sc.nextLine();
				
				if(doYouWantToBook.equals("y"))
				{
					System.out.println("How many reservation do you want to attempt?:");
					reservationAttempt=Integer.parseInt(sc.nextLine());
					
					System.out.println("for what event?: (type the index at the end of the list)");
					
					try {
						for(int i=0;i<events.size();i++)
						{						
							System.out.println("\nindex "+i+"[");
							System.out.print(events.get(i));
							System.out.println("]\n");
						}
						
						int eventIndex=Integer.parseInt(sc.nextLine());
						events.get(eventIndex).Booking(reservationAttempt);

						
						System.out.println("\nindex "+eventIndex+"[");
						System.out.print(events.get(eventIndex));
						System.out.println("]\n");

					}
					catch (Exception e) {

						System.err.println(e.getMessage());
					}
					finally {
						

					}
				}

			}
			
			if(whatDoYouWantToDo==3)
			{
				System.out.println("Do you want to cancel your reservation in some events?(y to confirm)");
				doYouWantToCancelYourReservation=sc.nextLine();
				
				if(doYouWantToCancelYourReservation.equals("y"))
				{
					System.out.println("How many reservation do you want to cancel?:");
					reservationAttempt=Integer.parseInt(sc.nextLine());
					
					System.out.println("for what event?: (type the index at the end of the list)");
					
					try {
						for(int i=0;i<events.size();i++)
						{						
							System.out.println("\nindex "+i+"[");
							System.out.print(events.get(i));
							System.out.println("]\n");
						}
						
						int eventIndex=Integer.parseInt(sc.nextLine());
						events.get(eventIndex).CancelReservation(reservationAttempt);

						
						System.out.println("\nindex "+eventIndex+"[");
						System.out.print(events.get(eventIndex));
						System.out.println("]\n");

					}
					catch (Exception e) {

						System.err.println(e.getMessage());
					}
					finally {
						

					}
				}
			}
			
			if(whatDoYouWantToDo==4)
			{

				
				try {
					for(int i=0;i<events.size();i++)
					{						
						System.out.println("\nindex "+i+"[");
						System.out.print(events.get(i));
						System.out.println("]\n");
						
					}
				}
				catch (Exception e) {

					System.err.println(e.getMessage());
				}
				finally {


				}
			}
			if(whatDoYouWantToDo==5)
			{
				System.out.println("totalNumberOfEvent: "+ events.size());
			}
			if(whatDoYouWantToDo==6)
			{
				System.out.println("all events was be deleted");
				events.clear();
			}
						
		}

	}

}
