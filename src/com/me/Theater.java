package com.me;

import java.util.ArrayList;
import java.util.List;

//step 1 class
public class Theater {

    //step 2 fields or variables
    private final String theaterName;
    //private List<Seat> seats = new ArrayList<>();
    //step 18 change above to linkedlist
    //private List<Seat> seats = new LinkedList<>();
    //step 19 to main to run it again, everything still works same

    //step 20 change list to collection, still works fine
    //private Collection<Seat> seats = new LinkedList<>();

    //step 21 change linkedlist to hashset, still work fine,
    //but changes order of seats if we uncomment theater.getSeats();
    //private Collection<Seat> seats = new HashSet<>();

    //step 22 change hashset to linked hashset, order of seats back to normal
    //private Collection<Seat> seats = new LinkedHashSet<>();

    //cant use treeset

    //step 24 change back to list and arraylist
    //private List<Seat> seats = new ArrayList<>();

    //step 36 make this public, then to main for step 37
    public List<Seat> seats = new ArrayList<>();
    //step 25 back to main to run

    //step 3 constructor
    public Theater(String theaterName, int numRows, int seatsPerRow) {
        this.theaterName = theaterName;

        int lastRow = 'A' + (numRows - 1);
        for (char row = 'A'; row <= lastRow; row++) {
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                Seat seat = new Seat(row + String.format("%02d", seatNum));
                seats.add(seat);
            }
        }

    }

    //step 4 getter for theaterName
    public String getTheaterName() {
        return theaterName;
    }

    //step 5 method to reserve seat
    //step 33 comment out method and add this source code from java binary search
    public boolean reserveSeat(String seatNumber) {
        int low = 0;
        int high = seats.size() - 1;

        while (low <= high) {
            System.out.print(".");
            int mid = (low + high) / 2;
            Seat midVal = seats.get(mid);
            int cmp = midVal.getSeatNumber().compareTo(seatNumber);

            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0){
                    high = mid - 1;
                }else{
                    return seats.get(mid).reserve();
                }
            }

            System.out.println("There is no seat " + seatNumber);
            return false;

            //then back to main step 34 to run
        }


    /*public boolean reserveSeat(String seatNumber) {
        //Seat requestedSeat = null;
        //step 28 null to....
        Seat requestedSeat = new Seat(seatNumber);
        //step 29 add this variable
        int foundSeat = Collections.binarySearch(seats, requestedSeat, null);
        //step 30 add if statement
        if(foundSeat >=  0) {
            return seats.get(foundSeat).reserve();
        }else{
            System.out.println("There is no seat " + seatNumber);
            return false;
        }

        //step 31 comment below out because it is replaced with collections binary search
        *//*for(Seat seat : seats) {
            //step 23
            System.out.print(".");
            if (seat.getSeatNumber().equals(seatNumber)) {
                requestedSeat = seat;
                break;
            }
        }
        if (requestedSeat==null) {
            System.out.println("There is no seat " + seatNumber);
            return false;
        }
        return requestedSeat.reserve();*//*
    }*/

    //step 32 back to main to run and check that is works

    //step 6 method for testing
    public void getSeats() {
        for (Seat seat : seats) {

            System.out.println(seat.getSeatNumber());
        }
    }

    //step 7 set up private class
    //private class Seat {
    //step 26 change form above to implements comparable and then add
    //comparable code in step 27, an override
    //private class Seat implements Comparable<Seat> {
      //step 35 change this to public and seat field above, for step 36
    public class Seat implements Comparable<Seat> {

        //step 8 variables or fields
        private final String seatNumber;
        private boolean reserved = false;

        //step 9 constructor for just seatnumber
        public Seat(String seatNumber) {
            this.seatNumber = seatNumber;
        }

        //step 27 comparable code, an override
        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }

        //step 10 method for reserve
        public boolean reserve() {
            if (!this.reserved) {
                this.reserved = true;
                System.out.println("Seat " + seatNumber + " is reserved");
                return true;
            } else {
                return false;
            }
        }

        //step 11 cancel function
        public boolean cancel() {
            if (this.reserved) {
                this.reserved = false;
                System.out.println("Reservation of seat " + seatNumber + " cancelled");
                return true;
            } else {
                return false;
            }

        }

        //step 12 getter for seatnumber
        public String getSeatNumber() {
            return seatNumber;

            //step 13 to main
        }
    }

}
