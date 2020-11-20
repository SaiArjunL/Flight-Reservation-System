package com.FRS;

public class RegularTicket extends BookingTicket {

    private String departureLocation;
    private String destinationLocation;


    private static class SpecialServiceRequest{

        boolean isFoodRequested, isWaterRequested, areSnacksRequested;

        public SpecialServiceRequest(boolean isFoodRequested, boolean isWaterRequested, boolean areSnacksRequested) {
            this.isFoodRequested = isFoodRequested;
            this.isWaterRequested = isWaterRequested;
            this.areSnacksRequested = areSnacksRequested;
        }
    }

    private SpecialServiceRequest specialServices;

    public RegularTicket(Flight flightDetails, PassengerRegistration passengerDetails, String departureLocation, String destinationLocation,
                         boolean food, boolean water, boolean snacks) {
        super(flightDetails, passengerDetails, departureLocation, destinationLocation);
        this.departureLocation = departureLocation;
        this.destinationLocation = destinationLocation;
        this.specialServices = new SpecialServiceRequest(food, water, snacks);
    }



}
