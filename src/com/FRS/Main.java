package com.FRS;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {

        LocalDateTime departureDateAndTime = LocalDateTime.of(2021, 1, 12, 10, 35);

        LocalDateTime arrivalDateAndTime = LocalDateTime.of(2021, 1, 12, 12, 50);


        String[] locations = {"India", "Australia", "New Zealand", "Andaman and Nicobar Islands", "Singapore", "Switzerland"};

        int[] flightNumbers = {1001, 1002};


        Flight flight = new Flight(2, flightNumbers, locations, departureDateAndTime, locations, arrivalDateAndTime);

        SeatMap seatMap = new SeatMap(50);


        PassengerRegistration passenger = new PassengerRegistration("Periyar Street", "Chennai",
                "Tamil Nadu", "Ladeela Sai Arjun", "8639953455",
                "lsaarjun@gmail.com", 10000);

        printPassengerDetails(passenger);
        printWalletAmount(passenger);

        RegularTicket bookingTicket1 = bookRegularTicket(flight, passenger, seatMap);
        printRegularTicketDetails(bookingTicket1);
//        printTicketDetails(bookingTicket1);
        printWalletAmount(passenger);
        System.out.println();
        TouristTicket bookingTicket2 = bookTouristTicket(flight, passenger, seatMap);
        printTouristTicketDetails(bookingTicket2);
//        printTicketDetails(bookingTicket2);
        printWalletAmount(passenger);
        cancelTicket(bookingTicket1);
        printWalletAmount(passenger);

    }

    public static void printTicketDetails(BookingTicket ticket){
        System.out.println("PNR Number is: " + ticket.getPNRNumber());
    }

    public static void printPassengerDetails(PassengerRegistration passenger){

        System.out.println("\nYour Contact Details: " + passenger.getContactDetails() + "\n");
        System.out.println("Your Address Details: " + passenger.getAddressDetails() + "\n");
        System.out.println("Number of Passengers: " + passenger.getPassengerCount() + "\n");

    }

    public static void printWalletAmount(PassengerRegistration passenger){
        System.out.println("Your Wallet Amount: ₹ " + passenger.checkDue());
    }

    public static void printRegularTicketDetails(RegularTicket ticket){

        if(ticket.getClass().getSimpleName().equals("RegularTicket")){
            System.out.print("Your Ticket from " + ticket.getDepartureLocation());
            System.out.println(" to " + ticket.getDestinationLocation() + " is " + ticket.getStatus() + "\n");
            System.out.println("Ticket Type: " + ticket.getTypeOfTicket() + "\n");
            System.out.println("Flight Number: " + ticket.getFlightNumber());
            System.out.print("Departure Date & Time: " + ticket.getDateAndTimeOfDeparture());
            System.out.println("\t\tArrival Date & Time: " + ticket.getDateAndTimeOfArrival());
            System.out.println("Duration of Journey: " + ticket.getDuration() + "\n");
            System.out.println("PNR Number: " + ticket.getPNRNumber());
            System.out.println("Your Seat: " + ticket.getSeatNumber());
            System.out.println("Ticket Status: " + ticket.getStatus());
            System.out.println("Ticket Price: ₹ " + ticket.getTicketPrice());
            System.out.println("\n**********HAPPY JOURNEY**********\n");
        }

    }

    public static void printTouristTicketDetails(TouristTicket ticket){

        if(ticket.getClass().getSimpleName().equals("TouristTicket")){
            System.out.println("Your Tourist Ticket from " + ticket.getDestinationLocation() + " is " + ticket.getStatus());
            System.out.println("Ticket Type: " + ticket.getTypeOfTicket() + "\n");
            System.out.println("Flight Number: " + ticket.getFlightNumber());
            System.out.print("Departure Date & Time: " + ticket.getDateAndTimeOfDeparture());
            System.out.println("\nYour Selected Locations are: ");
            for(String location:ticket.getSelectedLocations())
                System.out.println(location);
            System.out.println("\nHotel Address: " + ticket.getHotelAddress());
            System.out.println("\nPNR Number: " + ticket.getPNRNumber());
            System.out.println("Your Seat Number is: " + ticket.getSeatNumber());
            System.out.println("Ticket Status: " + ticket.getStatus());
            System.out.println("Ticket Price: ₹ " + ticket.getTicketPrice());
            System.out.println("\n**********HAPPY JOURNEY**********");
        }
    }

    public static RegularTicket bookRegularTicket(Flight flight, PassengerRegistration passenger, SeatMap seatMap){

        return new RegularTicket(flight, passenger, seatMap,"Australia", "New Zealand",
                true, true, true);
    }

    public static TouristTicket bookTouristTicket(Flight flight, PassengerRegistration passenger, SeatMap seatMap){

        return new TouristTicket(flight, passenger, seatMap, "Australia", "Thailand", "Andaman and Nicobar Islands",
                "Singapore", "Switzerland", "India", "Country street, Country");
    }

    public static void cancelTicket(BookingTicket ticket){
        ticket.cancelTicket();
        System.out.println("YOUR " + ticket.getTypeOfTicket().toUpperCase() + " HAS BEEN "+ ticket.getStatus() +"!!!!");
    }
}
