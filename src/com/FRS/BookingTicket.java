package com.FRS;

public class BookingTicket {

    private long PNRNumber;
    private String departureLocation;
    private String destinationLocation;
    private float ticketPrice;

    private Flight flightDetails;
    private PassengerRegistration passengerDetails;
    private String typeOfTicket;
    private SeatMap seatNumber;

    enum TicketStatus{
        PENDING,
        CONFIRMED,
        REJECTED
    }

    TicketStatus status;


    public BookingTicket(Flight flightDetails, PassengerRegistration passengerDetails, long PNRNumber){
        this.flightDetails = flightDetails;
        this.passengerDetails = passengerDetails;
        this.PNRNumber = PNRNumber;
    }

    public long getPNRNumber() {
        return PNRNumber;
    }

    public String getDepartureLocation() {
        return departureLocation;
    }

    public String getDestinationLocation() {
        return destinationLocation;
    }

    public float getTicketPrice() {
        return ticketPrice;
    }

    public String getTypeOfTicket() {
        return typeOfTicket;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setPNRNumber(long PNRNumber) {
        this.PNRNumber = PNRNumber;
    }

    public void setDepartureLocation(String departureLocation) {
        this.departureLocation = departureLocation;
    }

    public void setDestinationLocation(String destinationLocation) {
        this.destinationLocation = destinationLocation;
    }

    public void setTicketPrice(float ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public void setTypeOfTicket(String typeOfTicket) {
        this.typeOfTicket = typeOfTicket;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }
}
