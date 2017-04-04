package apavlikovskyi.Airport.Class_entity;

/**
 * Created by Diana P on 04.04.2017.
 */
public class Ticket_entity {
    private int id;
    private String voyage_id;
    private String class_of_seat;
    private String passenger_id;
    private String seat_number;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVoyage_id() {
        return voyage_id;
    }

    public void setVoyage_id(String voyage_id) {
        this.voyage_id = voyage_id;
    }

    public String getClass_of_seat() {
        return class_of_seat;
    }

    public void setClass_of_seat(String class_of_seat) {
        this.class_of_seat = class_of_seat;
    }

    public String getPassenger_id() {
        return passenger_id;
    }

    public void setPassenger_id(String passenger_id) {
        this.passenger_id = passenger_id;
    }

    public String getSeat_number() {
        return seat_number;
    }

    public void setSeat_number(String seat_number) {
        this.seat_number = seat_number;
    }
}
