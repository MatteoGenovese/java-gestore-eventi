package org.generation.italy.eventi;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class Concert extends Event{
	
	LocalTime concertStartingHour;
	BigDecimal price;
	
	public Concert(String title, LocalDate date, int totalNumberOfSeates, LocalTime concertStartingHour, BigDecimal price) throws Exception {
		super(title, date, totalNumberOfSeates);
		setConcertStartingHour(concertStartingHour);
		setPrice(price);
	}

	public LocalTime getConcertStartingHour() {
		return concertStartingHour;
	}

	public void setConcertStartingHour(LocalTime concertStartingHour) {
		this.concertStartingHour = concertStartingHour;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()
				+"\nStarting Hour: "+getConcertStartingHour()
				+"\nPrice: "+getPrice();
	}

}
