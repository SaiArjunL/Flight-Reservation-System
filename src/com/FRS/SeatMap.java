package com.FRS;

public class SeatMap {
    private int[] row;
    private String[] column;
    private int totalNumberOfSeats;
    private int availableSeats;
    private String seatNumber;

    public SeatMap(int totalNumberOfSeats) {
        this.row = new int[]{1, 2, 3, 4, 5};
        this.column = new String[]{"A", "B", "C", "D"};
        this.totalNumberOfSeats = totalNumberOfSeats;
    }

    public int getAvailableSeats() {
        return this.availableSeats;
    }

    public int getTotalNumberOfSeats(){
        return this.totalNumberOfSeats;
    }

}
