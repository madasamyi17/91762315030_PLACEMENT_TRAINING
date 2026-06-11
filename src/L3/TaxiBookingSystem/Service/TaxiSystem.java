package L3.TaxiBookingSystem.Service;

import L3.TaxiBookingSystem.enums.Location;
import L3.TaxiBookingSystem.Model.Booking;
import L3.TaxiBookingSystem.Model.Taxi;

import java.util.ArrayList;
import java.util.List;

public class TaxiSystem {
    private List<Taxi> taxis;

    public TaxiSystem() {
        taxis = new ArrayList<>();
    }

    public void createTaxis(int noOfTaxis){
        for(int i=0;i<noOfTaxis;i++){
            taxis.add(new Taxi());
        }
        System.out.println(noOfTaxis+" taxis Created");
    }

    public Taxi findTaxi(int pickUpTime, Location pickUpLocation){
//        System.out.println("Entering Find taxi method");
        List<Taxi> availableTaxis = findAvailableTaxis(pickUpTime,pickUpLocation);
        if(availableTaxis.isEmpty()){
            System.out.println("No taxis Available At the moment...");
            return null;
        }
        else{
            List<Taxi> closestTaxi = findClosestTaxi(availableTaxis,pickUpLocation);
            if(closestTaxi.size()==1)return closestTaxi.get(0);
            Taxi taxi = findTaxiwithMinEarnings(closestTaxi);
            return taxi;
        }
    }
    public List<Taxi> findClosestTaxi(List<Taxi> availableTaxis,Location pickUpLocation){
        int currMinDistance = Integer.MAX_VALUE;
        List<Taxi> closestTaxi = new ArrayList<>();
        for(Taxi taxi:availableTaxis){
            int distanceBetweenTaxiPickup = Math.abs(taxi.getNextAvailLocation().getChar()-pickUpLocation.getChar());
            if(distanceBetweenTaxiPickup<currMinDistance){
                currMinDistance=distanceBetweenTaxiPickup;
            }
        }
        for(Taxi taxi:availableTaxis){
            if(currMinDistance==Math.abs(taxi.getNextAvailLocation().getChar()-pickUpLocation.getChar())){
                closestTaxi.add(taxi);
            }
        }
        return closestTaxi;
    }
    public List<Taxi> findAvailableTaxis(int pickUpTime,Location pickUpLocation){
        int timeTakenToComeToPickUpPoint = 0;
        List<Taxi> availableTaxis = new ArrayList<>();
//        System.out.println("Entering Find Available taxis method");
//        System.out.println(taxis.size());
        for(Taxi taxi: taxis){
            timeTakenToComeToPickUpPoint = Math.abs(pickUpLocation.getChar() - taxi.getNextAvailLocation().getChar());
//            System.out.println("Time taken to Come to Pick Up point "+timeTakenToComeToPickUpPoint);
            if (taxi.getNextAvailTime() <= pickUpTime && pickUpTime>=(taxi.getNextAvailTime()+timeTakenToComeToPickUpPoint)) {
                availableTaxis.add(taxi);
//                System.out.println("hi");
            }
        }
        return availableTaxis;
    }

    public Taxi findTaxiwithMinEarnings(List<Taxi> taxis){
        int currMin = Integer.MAX_VALUE;
        Taxi minEarnTaxi = null;
        for(Taxi taxi:taxis){
            if(taxi.getEarnings()<currMin){
                currMin= taxi.getEarnings();
                minEarnTaxi=taxi;
            }
        }
        return minEarnTaxi;
    }
    public int calculateEarnings(Location pickUpLocation,Location dropLocation){
        int minFare = 100;
        int noOfKMs = Math.abs(pickUpLocation.getChar()- dropLocation.getChar())*15;
        return (noOfKMs-5)*10 + minFare;
    }
    public void confirmTaxi(Booking booking, Taxi taxi){
//        int timeTakenToComeToPickUpPoint = Math.abs(booking.getPickUpLocation().getChar() - taxi.getNextAvailLocation().getChar());
        int timeAfterRideCompleted = booking.getPickUpTime()+(Math.abs(booking.getPickUpLocation().getChar() - booking.getDropLocation().getChar()));
        int earningsForTheRide = calculateEarnings (booking.getPickUpLocation(),booking.getDropLocation());
        taxi.setNextAvailTime(timeAfterRideCompleted);
        taxi.setNextAvailLocation(booking.getDropLocation());
        taxi.setEarnings(earningsForTheRide);
        System.out.println("Taxi Booked... Details ...");
        showTaxiDetails(taxi);
        return;
    }

    public void showTaxiDetails() {
        for (Taxi taxi : taxis) {
            System.out.println("Taxi Id                      : " + taxi.getId());
            System.out.println("Taxi Earnings                : " + taxi.getEarnings());
            System.out.println("Taxi Current Location        : " + taxi.getNextAvailLocation());
            System.out.println("Taxi's Next Availability Time: " + taxi.getNextAvailTime());
            System.out.println();
        }
        System.out.println();
    }

    public void showTaxiDetails(Taxi taxi){
        System.out.println("Taxi Id                      : " + taxi.getId());
        System.out.println("Taxi Earnings                : " + taxi.getEarnings());
        System.out.println("Taxi Current Location        : " + taxi.getNextAvailLocation());
        System.out.println("Taxi's Next Availability Time: " + taxi.getNextAvailTime());
        System.out.println();
    }
}
