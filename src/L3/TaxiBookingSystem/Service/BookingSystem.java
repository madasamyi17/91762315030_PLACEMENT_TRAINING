package L3.TaxiBookingSystem.Service;

import L3.TaxiBookingSystem.enums.BookingStatus;
import L3.TaxiBookingSystem.enums.Location;
import L3.TaxiBookingSystem.Model.Booking;
import L3.TaxiBookingSystem.Model.Taxi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookingSystem {
    List<Booking> bookings;
    TaxiSystem taxiSystem;
    public BookingSystem(TaxiSystem taxiSystem) {
        bookings = new ArrayList<>();
        this.taxiSystem=taxiSystem;
    }

    public void createBooking(){
        Booking booking = getBookingInput();
        Taxi availableTaxi = taxiSystem.findTaxi(booking.getPickUpTime(),booking.getPickUpLocation());
        if(availableTaxi==null){
            booking.setStatus(BookingStatus.FAILED);
            bookings.add(booking);
            return;
        }
        else{
            booking.setStatus(BookingStatus.SUCCESS);
            taxiSystem.confirmTaxi(booking,availableTaxi);
            booking.setTaxi(availableTaxi);
            bookings.add(booking);
        }
    }

    public Booking getBookingInput(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Customer ID : ");
        int customerId = sc.nextInt();
        System.out.print("Enter PickUp Point (A,B,C,D,E,F) ");
        Location pickUpLocation = Location.valueOf(sc.next());
        System.out.print("Enter Drop Point (A,B,C,D,E,F) ");
        Location dropLocation = Location.valueOf(sc.next());
        while(pickUpLocation.equals(dropLocation)){
            System.out.print("PickUp point and Drop Point cannot be same....");
            System.out.print("Enter a Valid Drop Point(A,B,C,D,E,F) ");
            dropLocation = Location.valueOf(sc.next());
        }
        System.out.print("Enter the pickUp Time ");
        int pickUpTime = sc.nextInt();
        return new Booking(pickUpLocation,dropLocation,pickUpTime);
    }

    public void showBookings(){
        for(Booking booking :bookings){
            System.out.println("Booking Id       : "+booking.getBookingId());
            System.out.println("Pickup Location  : "+booking.getPickUpLocation());
            System.out.println("Drop Location    : "+booking.getDropLocation());
            System.out.println("PickUp Time      : "+booking.getPickUpTime());
            System.out.println("Booking Status   : "+booking.getStatus());
            if(booking.getStatus()==BookingStatus.SUCCESS){
                System.out.println("Taxi Allocated   : "+booking.getTaxi().getId());
            }
            System.out.println();
        }
        System.out.println();
    }


}
