package org.generation.italy.eventi;

import java.time.LocalDate;
import java.util.Scanner;

public class Event {
	
	private String title;
	private LocalDate date;
	Scanner sc=new Scanner(System.in);
	private int numberOfSeatsBooked;
	private int totalNumberOfSeates;
	
	//---------------------------------------------------------------------------------------
	//CONSTRUCTOR----------------------------------------------------------------------------
	//---------------------------------------------------------------------------------------
	
	public Event(String title, LocalDate date, int totalNumberOfSeates) throws Exception {
		super();
		setTitle(title);
		setDate(date);
		setNumberOfSeatsBooked(0);
		setTotalNumberOfSeates(totalNumberOfSeates);
	}
	
	//---------------------------------------------------------------------------------------
	//GETTER AND SETTERS---------------------------------------------------------------------
	//---------------------------------------------------------------------------------------

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public void setDate(LocalDate date) throws Exception {
		if(!isValidDate(date))
		{
			throw new Exception("Invalid Value of Date: Date after today is required"); 
		}
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
	
	public void setTotalNumberOfSeates(int totalNumberOfSeates) throws Exception {
		if(!isValidNumberOfSeats(totalNumberOfSeates))
		{
			throw new Exception("Invalid Value of totalNumberOfSeates: totalNumberOfSeates is required"); 
		}
		this.totalNumberOfSeates = totalNumberOfSeates;
	}
	

	//---------------------------------------------------------------------------------------
	//VALIDATORS-----------------------------------------------------------------------------
	//---------------------------------------------------------------------------------------
	
	private boolean isValidDate(LocalDate date) {
		return date.isAfter(LocalDate.now());
	}
	private boolean isValidNumberOfSeats(int totalNumberOfSeates) {
		return totalNumberOfSeates>0;
	}
	
	//---------------------------------------------------------------------------------------
	//PUBLIC METHODS-------------------------------------------------------------------------
	//---------------------------------------------------------------------------------------
	
	public void Booking (int reservationAttempt) throws Exception
	{
		if(isEventPassed())
		{
			throw new Exception("You can't book to this event anymore: this event is passed"); 
		}
		if(isEventFull(reservationAttempt))
		{
			throw new Exception("You can't book the amount of seats: there is no availability of the requested amount of seats"); 
		}
			this.numberOfSeatsBooked+=reservationAttempt;
	}
	
	public void CancelReservation(int cancellationOfSeatsAttempt) throws Exception {
		if(isEventPassed())
		{
			throw new Exception("You can't cancel your reservation to this event anymore: this event is passed"); 
		}
		if(isEventEmpty(cancellationOfSeatsAttempt))
		{
			throw new Exception("You can't cancel your reservation to this event: seats booked < cancellation requested"); 
		}
			this.numberOfSeatsBooked-=cancellationOfSeatsAttempt;
	}
	
	private boolean isEventPassed() {
		return date.isBefore(LocalDate.now());
	}
	
	private boolean isEventFull(int reservationAttempt) {
		return this.numberOfSeatsBooked+reservationAttempt>this.totalNumberOfSeates;
	}
	
	private boolean isEventEmpty(int cancellationOfSeatsAttempt) {
		return this.numberOfSeatsBooked-cancellationOfSeatsAttempt<0;
	}
	
	//---------------------------------------------------------------------------------------
	//TOSTRING METHOD------------------------------------------------------------------------
	//---------------------------------------------------------------------------------------
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Event:"+getTitle()
				+"\ndate:"+getDate()
				+"\nnumberOfseatsBooked:"+getNumberOfSeatsBooked()
				+"\ntotalNumberOfSeats:"+getTotalNumberOfSeates();
	}
}
