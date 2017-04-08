package apavlikovskyi.airport.entity;

/**
 * Created by Артем on 08.04.2017.
 */
public class VoyageEntity {
    private String id;
    private String flightNumber;
    private String arrivalPort;
    private String departurePort;

    public VoyageEntity(){}

    public VoyageEntity(String id, String flightNumber, String arrivalPort, String departurePort) {
        this.id = id;
        this.flightNumber = flightNumber;
        this.arrivalPort = arrivalPort;
        this.departurePort = departurePort;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getArrivalPort() {
        return arrivalPort;
    }

    public void setArrivalPort(String arrivalPort) {
        this.arrivalPort = arrivalPort;
    }

    public String getDeparturePort() {
        return departurePort;
    }

    public void setDeparturePort(String departurePort) {
        this.departurePort = departurePort;
    }
}
