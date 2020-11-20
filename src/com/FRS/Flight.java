package com.FRS;
import jdk.swing.interop.SwingInterOpUtils;

import java.util.*;

public class Flight {

    private final int[] flightNumbers;
    private final int numberOfFlights;
    private final Date dateAndTimeOfdeparture;
    private final Date dateAndTimeOfarrivalDate;
    private float ticketPrice;
    private String[] origin;
    private String[] destination;
    private String[] flightRoutes;

    public Flight(int numberOfFlights, int[] flightNumbers, String[] origin, String[] destination){
        this.numberOfFlights = numberOfFlights;
        this.dateAndTimeOfdeparture = new Date();
        this.dateAndTimeOfarrivalDate = new Date();
        this.flightNumbers = flightNumbers;
        this.ticketPrice = (float) (Math.random() * (5000 - 2000)) + 2000;;
        this.origin = origin;
        this.destination = destination;
    }

    public int[] getFlightNumber() {
        return flightNumbers;
    }

    public int getNumberOfFlights() {
        return numberOfFlights;
    }

    public Date getDateAndTimeOfdeparture() {
        return dateAndTimeOfdeparture;
    }

    public Date getDateAndTimeOfarrivalDate() {
        return dateAndTimeOfarrivalDate;
    }

//    public void setFlightRoutes(){
//        Scanner sc = new Scanner(System.in);
//        for(int i = 0; i < numberOfFlights; i++) {
//            System.out.println("Enter Flight Route - " + (i + 1));
//            this.origin[i] = sc.nextLine();
//            this.dest[i] = sc.nextLine();
//
//        }
//        System.out.println(Arrays.toString(this.origin));
//        System.out.println(Arrays.toString(this.dest));
//    }

    public void getSeatDetails(SeatMap seatDetails) {
        System.out.println("Total Number of seats: " + seatDetails.getTotalNumberOfSeats());
        seatDetails.generateSeatNumber();
        System.out.println("Remaining Available Seats: " + seatDetails.getAvailableSeats() + "\n");
    }

    public float getTicketPrice(){
        return (float)Math.floor((this.ticketPrice * 100) / 100);
    }

    public String[] getOrigin(){
        return this.origin;
    }

    public String[] getDestination(){
        return this.destination;
    }


}