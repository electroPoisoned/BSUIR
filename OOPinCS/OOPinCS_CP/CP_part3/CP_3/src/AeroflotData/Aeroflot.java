package AeroflotData;

public class Aeroflot {
    private String destination;
    private String flightNumber;
    private PlaneType planeType;

    public Aeroflot(String destination, String flightNumber, PlaneType planeType) {
        this.destination = destination;
        this.flightNumber = flightNumber;
        this.planeType = planeType;
    }

    public String getDestination() {
        return destination;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public PlaneType getPlaneType() {
        return planeType;
    }

    @Override
    public String toString() {
        return "Destination: " + destination + ", Flight Number: " + flightNumber + ", Plane Type: " + planeType;
    }
}
