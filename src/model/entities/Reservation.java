package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exeption.DomainExeption;

public class Reservation {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Integer roomNumber;
	private Date checkin;
	private Date checkout;
	
	public Reservation() {
		
	}
	
	public Reservation(Integer roomNumber, Date checkin, Date checkout) throws DomainExeption {
		
		if (!checkout.after(checkin)) {
			throw new DomainExeption("Check-out date must be after check-in date: ");
		}
		
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}
	
	public Integer getRoomNumber() {
		return roomNumber;
	}
	
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	public Date getCheckIn() {
		return checkin;
	}
	
	public void setCheckIn(Date checkIn) {
		this.checkin = checkIn;
	}
	
	public Date getCheckOut() {
		return checkout;
	}
	
	public void setCheckOut(Date checkOut) {
		this.checkout = checkOut;
	}
	
	public Long duration() {
		Long diff = checkout.getTime() - checkin.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);		
	}
	
	public void updateDates(Date checkIn, Date checkOut) throws DomainExeption {
		
		Date date = new Date();
		
		if (!checkout.after(checkin)) {
			throw new DomainExeption(" Check-out date must be after check-in date ");
		}
		
		if (checkin.before(date) && checkout.before(date)) {
			throw new DomainExeption(" Reservation dates for update must be future dates");
		}		
	}
}
