package org.generation.italy.eventi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.generation.italy.eventi.EventPlanning.DateComparator;

public class UniqueEventsPlanner {
	


	private String title;
	private Set<Event> uniqueEvents;
	Scanner sc=new Scanner(System.in);
	
	
	//---------------------------------------------------------------------------------------
	//CONSTRUCTOR----------------------------------------------------------------------------
	//---------------------------------------------------------------------------------------
	
	public UniqueEventsPlanner(String title) {

		setTitle(title);
		setUniqueEvents(new HashSet<Event>());
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

	public Set<Event> getUniqueEvents() {
		return uniqueEvents;
	}

	public void setUniqueEvents(Set<Event> uniqueEvents) {
		this.uniqueEvents = uniqueEvents;
	}
	
	
	//---------------------------------------------------------------------------------------
	//VALIDATOR-------------------------------------------------------------------------
	//---------------------------------------------------------------------------------------
	
	public boolean isEventUnique(Event event) {
		
		for (Event e : getUniqueEvents())
		{
			if(event.equals(e))
			{
				return false;
			}
		}
		return true;
	}
	
	
	//---------------------------------------------------------------------------------------
	//PUBLIC METHODS-------------------------------------------------------------------------
	//---------------------------------------------------------------------------------------

	

	
	
	public void addEventToList(Event event) throws Exception {
		
		if(!isEventUnique(event))
		{
			throw new Exception("Invalid Value of totalNumberOfSeates: totalNumberOfSeates is required"); 
		}
		getUniqueEvents().add(event);
	}
	
	
	
	public List<Event> getEventListInADate ( LocalDate date) {
		
		List <Event> listOfEventInASpecificDate = new ArrayList<Event>();
		
		for (Event e : getUniqueEvents())
		{
			if(date.equals(e.getDate()))
			{
				listOfEventInASpecificDate.add(e);
			}
		}
		

		return listOfEventInASpecificDate;
	}
	
	public int getEventsNumber ( ) {
		return getUniqueEvents().size();
	}
	
	public void clearListFromEvents () {
		getUniqueEvents().clear();
	}
	
	public Event getEventWithMaxNumberSeats() {
		int maxNumberSeats= Integer.MIN_VALUE;
		Event eventWithMaxNumberSeats = null;
		
		for(Event e : getUniqueEvents())
		{
			if(e.getTotalNumberOfSeates()>=maxNumberSeats)
			{
				maxNumberSeats=e.getTotalNumberOfSeates();
				eventWithMaxNumberSeats=e;
			}
		}
		return eventWithMaxNumberSeats;
	}
	
	public Event getEventWithMinNumberSeats() {
		int minNumberSeats= Integer.MAX_VALUE;
		Event eventWithMinNumberSeats = null;
		
		for(Event e : getUniqueEvents())
		{
			if(e.getTotalNumberOfSeates()<=minNumberSeats)
			{
				minNumberSeats=e.getTotalNumberOfSeates();
				eventWithMinNumberSeats=e;
			}
		}
		return eventWithMinNumberSeats;
	}
	
	public List<Event> orderedPrint() {
		
		List <Event> orderedList = new ArrayList<>(getUniqueEvents());
		
		orderedList.sort(new TitleComparator());

		return orderedList;
	}
	
	public static class TitleComparator implements Comparator<Event> {
		@Override
		public int compare(Event o1, Event o2) {
			// TODO Auto-generated method stub
			if (o1.getTitle().length()>o2.getTitle().length())
				return 1;
			if (o1.getTitle().length()<o2.getTitle().length())
				return -1;
			return 0;
		}
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
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "\ntitle: "+getTitle()+
				"\nSet:"+getUniqueEvents();
	}

}
