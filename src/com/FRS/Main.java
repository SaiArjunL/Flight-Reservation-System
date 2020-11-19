package com.FRS;

public class Main {

    public static void main(String[] args) {

        String[] touristLocations = {"Australia", "New Zealand", "Andaman and Nicobar Islands",
                "Singapore", "Switzerland"};

        Flight flight = new Flight();

        PassengerRegistration passenger = new PassengerRegistration("Periyar Street",
                "Chennai","Tamil Nadu",
                "Ladeela Sai Arjun", "8639953455", "lsaarjun@gmail.com");

        RegularTicket regularTicket = new RegularTicket(flight, passenger, true, true, true);


        TouristTicket touristTicket = new TouristTicket(flight, passenger, touristLocations, "Country street, Country");

        printTicketDetails(regularTicket);

        printTicketDetails(touristTicket);

    }

    public static void printTicketDetails(BookingTicket ticket){

        System.out.println(ticket.getPNRNumber());

    }
}
