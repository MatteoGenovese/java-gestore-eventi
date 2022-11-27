package org.generation.italy.eventi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class EventPlanning {
	
	private String title;
	private List<Event> events;
	Scanner sc=new Scanner(System.in);
	
	//---------------------------------------------------------------------------------------
	//CONSTRUCTOR----------------------------------------------------------------------------
	//---------------------------------------------------------------------------------------
	
	public EventPlanning(String title) {
		
		setTitle(title);
		setEvents(new ArrayList<Event>());
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

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}
	
	//---------------------------------------------------------------------------------------
	//PUBLIC METHODS-------------------------------------------------------------------------
	//---------------------------------------------------------------------------------------

	public void addEventToList(Event event) {
		getEvents().add(event);
	}
	
	public List<Event> getEventListInADate ( LocalDate date) {
		
		List <Event> listOfEventInASpecificDate = new ArrayList<Event>();
		for (int i=0;i<getEvents().size();i++)
		{
			if(date.equals(getEvents().get(i).getDate()))
			{
				listOfEventInASpecificDate.add(getEvents().get(i));
			}
		}
		return listOfEventInASpecificDate;
	}
	
	public int getEventsNumber ( ) {
		return getEvents().size();
	}
	
	public void clearListFromEvents () {
		getEvents().clear();
	}
	
	public void getSortedPlanning () {
		getEvents().sort(new DateComparator());
	}
	
	public static class DateComparator implements Comparator<Event> {
		@Override
		public int compare(Event o1, Event o2) {
			// TODO Auto-generated method stub
			if (o1.getDate().isAfter(o2.getDate()))
				return -1;
			if (o1.getDate().isBefore(o2.getDate()))
				return 1;
			return 0;
		}
	}
		
	public void bookingReservation(int Index, int reservationAttempt) throws Exception {
		getEvents().get(Index).Booking(reservationAttempt);
	}
	
	public void cancelReservation(int Index, int cancellationOfSeatsAttempt) throws Exception {
		getEvents().get(Index).CancelReservation(cancellationOfSeatsAttempt);
	}
	
	public void getList() {
		for(int i=0; i<events.size();i++)
		{
			System.out.println(getEvents().get(i));
		}
	}
		

		
	public String printEvent(int index) {
		return getEvents().get(index).toString();
	}
}
