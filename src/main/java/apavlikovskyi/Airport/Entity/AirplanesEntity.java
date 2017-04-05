package apavlikovskyi.Airport.Entity;

/**
 * Created by Diana P on 04.04.2017.
 */
public class AirplanesEntity {

    private String voyage_id;
    private  String name;
    private int seats_capacity;

    public String getVoyage_id() {
        return voyage_id;
    }

    public void setVoyage_id(String voyage_id) {
        this.voyage_id = voyage_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeats_capacity() {
        return seats_capacity;
    }

    public void setSeats_capacity(int seats_capacity) {
        this.seats_capacity = seats_capacity;
    }
}
