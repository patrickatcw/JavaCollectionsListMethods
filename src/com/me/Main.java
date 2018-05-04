package com.me;

import java.util.List;

//initial code from JavaCollectionsAndBinarySearch
//https://docs.oracle.com/javase/tutorial/collections/interfaces/index.html
public class Main {

    public static void main(String[] args) {

        //starting steps for collectionslistmethods
        //step 35 to theater class, class seat

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
