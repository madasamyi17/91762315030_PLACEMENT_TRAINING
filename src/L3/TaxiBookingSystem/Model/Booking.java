package L3.TaxiBookingSystem.Model;

import L3.TaxiBookingSystem.enums.BookingStatus;
import L3.TaxiBookingSystem.enums.Location;

public class Booking {
    private static int bookingIdCounter=1;
    private int bookingId;
    private Location pickUpLocation;
    private Location dropLocation;
    private int pickUpTime;
    private BookingStatus status;
    private Taxi taxi;

    public BookingStatus getStatus() {
        return status;
    }

    public Taxi getTaxi() {
        return taxi;
    }

    public void setTaxi(Taxi taxi) {
        this.taxi = taxi;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public Booking(Location pickUpLocation, Location dropLocation,int pickUpTime) {
        this.bookingId = bookingIdCounter++;
//        this.taxi = null;
        this.pickUpLocation = Location.valueOf(String.valueOf(pickUpLocation));
        this.dropLocation = Location.valueOf(String.valueOf(dropLocation));
        this.pickUpTime=pickUpTime;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public Location getPickUpLocation() {
        return pickUpLocation;
    }

    public void setPickUpLocation(Location pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    public int getPickUpTime(){
        return pickUpTime;
    }

    public void setPickUpTime(int pickUpTime){
        this.pickUpTime=pickUpTime;
    }
    public Location getDropLocation() {
        return dropLocation;
    }

    public void setDropLocation(Location dropLocation) {
        this.dropLocation = dropLocation;
    }
}
