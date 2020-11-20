package com.FRS;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        String[] touristLocations = {"Australia", "New Zealand", "Andaman and Nicobar Islands",
                "Singapore", "Switzerland"};

        int[] flightNumbers = {1001, 1002};

        String[] originLocations = {"HYD", "MUM"};
        String[] destinationLocations = {"MUM", "HYD"};

        Flight flight = new Flight(2, flightNumbers, originLocations, destinationLocations);


        SeatMap seatMap = new SeatMap(50);



        PassengerRegistration passenger = new PassengerRegistration("Periyar Street",
                "Chennai","Tamil Nadu",
                "Ladeela Sai Arjun", "8639953455", "lsaarjun@gmail.com", 10000);

        System.out.println("\nYour Contact Details: " + passenger.getContactDetails() + "\n");
        System.out.println("Your Address Details: " + passenger.getAddressDetails() + "\n");
        System.out.println("Number of Passengers: " + passenger.getPassengerCount() + "\n");
        System.out.println("Your Wallet Amount: ₹" + passenger.checkDue() + "\n");

        BookingTicket ticket = new RegularTicket(flight, passenger,"HYD", "MUM",
                true, true, true);

        System.out.print("Your Ticket from " + ticket.getDepartureLocation());
        System.out.println(" to " + ticket.getDestinationLocation() + " is " + ticket.getStatus());
        System.out.println("PNR Number: " + ticket.getPNRNumber());
        seatMap.generateSeatNumber();
        System.out.println("Ticket Status: " + ticket.getStatus());
        System.out.println("Ticket Price: ₹" + ticket.getTicketPrice());
        System.out.println("Your Remaining Wallet Amount: ₹" + passenger.checkDue());
        System.out.println("\n**********HAPPY JOURNEY**********");

//
//        RegularTicket regularTicket = new RegularTicket(flight, passenger, true, true, true);
//
//
//        TouristTicket touristTicket = new TouristTicket(flight, passenger, touristLocations, "Country street, Country");
//
//        printTicketDetails(regularTicket);
//
//        printTicketDetails(touristTicket);

    }

    public static void printTicketDetails(BookingTicket ticket){

        System.out.println(ticket.getPNRNumber());

    }
}
