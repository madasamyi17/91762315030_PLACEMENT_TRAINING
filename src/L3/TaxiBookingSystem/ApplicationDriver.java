package L3.TaxiBookingSystem;

import L3.TaxiBookingSystem.Service.BookingSystem;
import L3.TaxiBookingSystem.Service.TaxiSystem;

import java.util.Scanner;

public class ApplicationDriver {
    public static void main(String[] args) {
        TaxiSystem taxiSystem = new TaxiSystem();
        BookingSystem bookingSystem = new BookingSystem(taxiSystem);
        taxiSystem.createTaxis(3);
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Taxi Booking System\nOptions : \n1.Book Taxi \n2.Display Bookings\n3.Display Taxi Details\n4.Close Application ");
            int option = sc.nextInt();
            switch (option){
                case 1:
                    bookingSystem.createBooking();
                    break;
                case 2:
                    bookingSystem.showBookings();
                    break;
                case 3:
                    taxiSystem.showTaxiDetails();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Option");
            }
        }
    }
}
