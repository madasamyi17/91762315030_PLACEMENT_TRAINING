package L3.TaxiBookingSystem.Model;

import L3.TaxiBookingSystem.enums.Location;

public class Taxi {
    private static int idCounter = 1;
    private int id;
    private int earnings;
    private int nextAvailTime;
    private Location nextAvailLocation;

    public Location getNextAvailLocation() {
        return nextAvailLocation;
    }

    public void setNextAvailLocation(Location nextAvailLocation) {
        this.nextAvailLocation = nextAvailLocation;
    }


    public Taxi() {
        this.id = idCounter++;
        this.earnings = 0;
        this.nextAvailTime = 0;
        this.nextAvailLocation = Location.A;
    }

    public int getEarnings() {
        return earnings;
    }

    public void setEarnings(int earnings) {
        this.earnings += earnings;
    }

    public int getNextAvailTime() {
        return nextAvailTime;
    }

    public void setNextAvailTime(int nextAvailTime) {
        this.nextAvailTime = nextAvailTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
