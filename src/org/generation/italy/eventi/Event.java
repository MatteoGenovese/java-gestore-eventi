package org.generation.italy.eventi;

import java.time.LocalDate;
import java.util.Scanner;

public class Event {
	
	private String title;
	private LocalDate date;
	Scanner sc=new Scanner(System.in);

	
	private int numberOfSeatsBooked;
	private int totalNumberOfSeates;

	public Event(String title, LocalDate date, int totalNumberOfSeates) {
		super();
		setTitle(title);
		setDate(date);
		setNumberOfSeatsBooked(0);
		setTotalNumberOfSeates(totalNumberOfSeates);

	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		
		this.title = title;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public int getNumberOfSeatsBooked() {
		return numberOfSeatsBooked;
	}
	public void setNumberOfSeatsBooked(int numberOfSeatsBooked) {
		this.numberOfSeatsBooked = numberOfSeatsBooked;
	}
	public int getTotalNumberOfSeates() {
		return totalNumberOfSeates;
	}
	public void setTotalNumberOfSeates(int totalNumberOfSeates) {
		
		while(true)
		{
			if(totalNumberOfSeates>0)
			{
				this.totalNumberOfSeates = totalNumberOfSeates;
				break;
			}
			else
			{
				System.out.println("number of seates has to be positive, insert a new number");
				totalNumberOfSeates=Integer.parseInt(sc.nextLine());
			}
		}
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "\n Event:"+getTitle()
				+"\n date:"+getDate()
				+"\n numberOfseatsBooked:"+getNumberOfSeatsBooked()
				+"\n totalNumberOfSeats:"+getTotalNumberOfSeates();
	}



	
}
