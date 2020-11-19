package com.FRS;

public class RegularTicket extends BookingTicket {



    private static class SpecialServiceRequest{

        boolean isFoodRequested, isWaterRequested, areSnacksRequested;

        public SpecialServiceRequest(boolean isFoodRequested, boolean isWaterRequested, boolean areSnacksRequested) {
            this.isFoodRequested = isFoodRequested;
            this.isWaterRequested = isWaterRequested;
            this.areSnacksRequested = areSnacksRequested;
        }
    }

    private SpecialServiceRequest specialServices;

    public RegularTicket(Flight flightDetails, PassengerRegistration passengerDetails,
                         boolean food, boolean water, boolean snacks) {
        super(flightDetails, passengerDetails, 123456789);
        this.specialServices = new SpecialServiceRequest(food, water, snacks);
    }



}
