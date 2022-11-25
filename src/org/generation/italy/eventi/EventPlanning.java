package org.generation.italy.eventi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;



public class EventPlanning {
	
	private String title;
	private List<Event> events;
	Scanner sc=new Scanner(System.in);
	
	public EventPlanning(String title) {
		super();
		this.title = title;
		this.events = new ArrayList<>();
	}
	
	
	public void addEventToList(Event event) {
		this.events.add(event);
	}
	
	public void getList() {
		
		for(int i=0; i<events.size();i++)
		{
			System.out.println(this.events.get(i));

		}
	}
	
	public List<Event> getEventListInADate ( List <Event> eventList, LocalDate date) {
		
		List <Event> listOfEventInASpecificDate = new ArrayList<Event>();
		for (int i=0;i<eventList.size();i++)
		{
			if(date.equals(eventList.get(i).getDate()))
			{
				listOfEventInASpecificDate.add(eventList.get(i));
			}
		}
		return listOfEventInASpecificDate;
	}
	
	public int getEventNumer ( List <Event> eventList) {
		return events.size();
	}
	
	public void clearListFromEvents () {
		this.events.clear();
	}
	
	public void getPlanning () {

		events.sort(new DateComparator());
	
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
	
	
	
	
	

}
