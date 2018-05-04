package com.me;

import java.util.ArrayList;
import java.util.List;

//initial code from JavaCollectionsAndBinarySearch
//https://docs.oracle.com/javase/tutorial/collections/interfaces/index.html
public class Main {

    public static void main(String[] args) {

        //starting steps for collectionslistmethods
        //step 35 to theater class, class seat

        //instance to create object (from original program)
        Theater theater = new Theater("Severance Hall", 8, 12);
        //step 38 instance for list
        List<Theater.Seat> seatCopy = new ArrayList<>(theater.seats);

        printList(seatCopy);
        //then run, printed seats horizontally A01 to H12

        //step 39 reserve a seat
        seatCopy.get(1).reserve(); //using copy of arraylist to reserve seat
        if (theater.reserveSeat("A02")) {
            System.out.println("Please pay for A02");
        } else {
            System.out.println("Seat is already reserves");
            //run, showing that 2 separate arraylists sharing the same data, seat object
            /*Seat A02 is reserved
            .......Seat is already reserves*/
        }

    }

    //step 37 method that prints out the list
    public static void printList(List<Theater.Seat> list) {
        for (Theater.Seat seat : list) {
            System.out.print(" " + seat.getSeatNumber());

        }
        System.out.println();
        System.out.println("-----------------------------");

    }


}
