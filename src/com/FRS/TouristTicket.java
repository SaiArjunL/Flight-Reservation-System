package com.FRS;

public class TouristTicket extends BookingTicket {

    private String hotelAddress;

    private static class TouristLocations{

        String[] locationArray = new String[5];

        public TouristLocations(String[] locationArray){
            this.locationArray = locationArray;
        }

    }

    private TouristLocations touristLocations;

    public TouristTicket(Flight flightDetails, PassengerRegistration passengerDetails,
                         String[] touristLocations, String hotelAddress){

        super(flightDetails, passengerDetails, 987654321);
        this.touristLocations = new TouristLocations(touristLocations);
        this.hotelAddress = hotelAddress;

    }

    public void addTouristLocation(){

    }

    public void removeTouristLocations(){

    }

}
