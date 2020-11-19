package com.FRS;
import java.util.Date;

public class Flight {

    private int flightNumber;
    private int availableFlights;
    private Date dateAndTimeOfdeparture;
    private Date dateAndTimeOfarrivalDate;




    private SeatMap seatMap;

    public Flight(){
        this.seatMap = new SeatMap(20);
        this.availableFlights = 1;
        this.dateAndTimeOfdeparture = new Date();
        this.dateAndTimeOfarrivalDate = new Date();
        this.flightNumber = 1234;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public int getAvailableFlights() {
        return availableFlights;
    }

    public Date getDateAndTimeOfdeparture() {
        return dateAndTimeOfdeparture;
    }

    public Date getDateAndTimeOfarrivalDate() {
        return dateAndTimeOfarrivalDate;
    }

    public SeatMap getSeatMap() {
        return seatMap;
    }
}