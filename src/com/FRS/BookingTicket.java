package com.FRS;
import java.time.Duration;

public abstract class BookingTicket {

    private long PNRNumber;
    protected String departureLocation;
    protected String destinationLocation;
    private float ticketPrice;
    protected final String dateAndTimeOfDeparture;
    protected String dateAndTimeOfArrival;
    private String seatNumber;
    protected int flightNumber;
    protected String typeOfTicket;

    protected final Flight flightDetails;
    private final PassengerRegistration passengerDetails;
    private final SeatMap seatMap;


    enum TicketStatus{
        PENDING,
        CONFIRMED,
        CANCELLED;
    }

    TicketStatus ticketStatus = TicketStatus.PENDING;


    public BookingTicket(Flight flightDetails, PassengerRegistration passengerDetails, SeatMap seatMap){
        this.flightDetails = flightDetails;
        this.passengerDetails = passengerDetails;
        this.seatMap = seatMap;
        setTicketPrice(flightDetails.getTicketPrice());
        this.dateAndTimeOfDeparture = flightDetails.getDateAndTimeOfDeparture();
        this.dateAndTimeOfArrival = flightDetails.getDateAndTimeOfArrival();
        setSeatNumber();
    }

    public long generatePNRNumber(){
        return  (int) ((Math.random() * (999999 - 100000)) + 100000);
    }

    public abstract String getDepartureLocation();

    public abstract String getDestinationLocation();

    public abstract String getTypeOfTicket();

    public long getPNRNumber() {
        return PNRNumber;
    }

    private void setSeatNumber(){
        this.seatNumber = seatMap.getSeatNumber();
    }

    public void setTicketPrice(float ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public float getTicketPrice() {
        return ticketPrice;
    }

    public TicketStatus getStatus() {
        return this.ticketStatus;
    }

    public void updateStatus(TicketStatus status){
        this.ticketStatus = status;
    }

    public void setDepartureLocation(String departureLocation) {
        this.departureLocation = departureLocation;
    }

    public void setDestinationLocation(String destinationLocation) {
        this.destinationLocation = destinationLocation;
    }

    public void debitPassengerWallet() {

        if(this.passengerDetails.checkDue() <= 0.0f){
            updateStatus(TicketStatus.CANCELLED);
        }
        else{
            updateStatus(TicketStatus.CONFIRMED);

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
            debitPassengerWallet();
        }
        else{
            System.out.println("Please check the available locations..");
        }
    }

    public String getDuration(){
        Duration duration = Duration.between(flightDetails.dateAndTimeOfDeparture,
                flightDetails.dateAndTimeOfArrival);
        return "" + Math.abs(duration.toHoursPart()) + " Hours and " +  Math.abs(duration.toMinutesPart()) + " Minutes";
    }

    public void cancelTicket(){
        this.ticketStatus = TicketStatus.CANCELLED;
        this.seatMap.updateAvailableSeats();
       passengerDetails.addCredit(flightDetails.getTicketPrice());
    }

    public String getDateAndTimeOfDeparture(){
        return this.dateAndTimeOfDeparture;
    }

    public String getDateAndTimeOfArrival(){
        return this.dateAndTimeOfArrival;
    }

    public String getSeatNumber(){
        return this.seatNumber;
    }

    public int getFlightNumber(){
        return this.flightNumber;
    }

}
