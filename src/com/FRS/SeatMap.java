package com.FRS;
import java.util.ArrayList;
import java.util.Random;

public class SeatMap {

    private ArrayList<String> allSeats = new ArrayList<>();
    private final int totalNumberOfSeats;
    private int availableSeats;
    private String seatNumber;

    public SeatMap(int totalNumberOfSeats) {
        this.totalNumberOfSeats = totalNumberOfSeats;
        this.availableSeats = totalNumberOfSeats;
    }

    public int getAvailableSeats() {
        return this.availableSeats;
    }

    public int getTotalNumberOfSeats(){
        return this.totalNumberOfSeats;
    }

    public void generateSeatNumber(){

        String temp1 = Integer.toString(getRandomRow( this.totalNumberOfSeats / (this.totalNumberOfSeats / 10)));

        String temp2 = String.valueOf(getRandomColumn(totalNumberOfSeats / 10));

        this.seatNumber = temp1 + temp2;

        while(allSeats.contains(seatNumber)){
            temp1 = Integer.toString(getRandomRow( this.totalNumberOfSeats / (this.totalNumberOfSeats / 10)));

            temp2 = String.valueOf(getRandomColumn(totalNumberOfSeats / 10));
            this.seatNumber = temp1 + temp2;
        }

        allSeats.add(this.seatNumber);
        System.out.println("Seat Number: " + this.seatNumber);

        this.availableSeats--;
    }

    private int getRandomRow(int numberOfRows) {
        return (int) ((Math.random() * (numberOfRows - 1)) + 1);
    }

    private char getRandomColumn(int numberOfColumns){
        Random rnd = new Random();
        return (char) ('A' + rnd.nextInt(numberOfColumns));
    }

}
