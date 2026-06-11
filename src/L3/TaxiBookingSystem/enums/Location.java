package L3.TaxiBookingSystem.enums;

public enum Location {
    A,B,C,D,E,F;

    public char getChar(){
        return name().charAt(0);
    }
}
