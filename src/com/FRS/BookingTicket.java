package com.FRS;
import java.text.DecimalFormat;

public class BookingTicket {

    private long PNRNumber;
    private String departureLocation;
    private String destinationLocation;
    private float ticketPrice;

    private Flight flightDetails;
    private PassengerRegistration passengerDetails;
    private SeatMap seatNumber;

    enum TicketStatus{
        PENDING,
        CONFIRMED,
        CANCELLED;
    }

    TicketStatus ticketStatus = TicketStatus.PENDING;


    public BookingTicket(Flight flightDetails, PassengerRegistration passengerDetails, String origin, String destination){
        this.flightDetails = flightDetails;
        this.passengerDetails = passengerDetails;
        this.ticketPrice = flightDetails.getTicketPrice();
        this.departureLocation = origin;
        this.destinationLocation = destination;
        validateOriginAndDestination();
    }

    public long generatePNRNumber(){
        return  (int) ((Math.random() * (999999 - 100000)) + 100000);
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

    public TicketStatus getStatus() {
        return this.ticketStatus;
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

    public void updatePassengerCredit() {

        if(this.passengerDetails.checkDue() <= 0.0f){
            this.ticketStatus = TicketStatus.CANCELLED;
        }
        else{
            this.ticketStatus = TicketStatus.CONFIRMED;

            float temp = this.passengerDetails.checkDue()
                    - flightDetails.getTicketPrice() * passengerDetails.getPassengerCount();

            this.passengerDetails.setCredit(temp);
        }
    }

    public void validateOriginAndDestination(){
        boolean flag1 = false, flag2 = false;
        for(int i = 0; i < flightDetails.getOrigin().length; i++){
            if(this.departureLocation.equals(flightDetails.getOrigin()[i]))
                    flag1 = true;
        }

        for(int i = 0; i < flightDetails.getDestination().length; i++){
            if(this.destinationLocation.equals((flightDetails.getDestination()[i])))
                flag2 = true;
        }

        if(flag1 && flag2){
            this.PNRNumber = generatePNRNumber();
            updatePassengerCredit();
        }
        else{
            System.out.println("Please check the available locations..");
        }
    }

}
