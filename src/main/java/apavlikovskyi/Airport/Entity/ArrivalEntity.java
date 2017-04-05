package apavlikovskyi.Airport.Entity;

/**
 * Created by Diana P on 04.04.2017.
 */
public class ArrivalEntity {
    private String voyage_id;
    private String date;
    private String time;
    private String terminal;
    private String flight_status;

    public String getVoyage_id() {
        return voyage_id;
    }

    public void setVoyage_id(String voyage_id) {
        this.voyage_id = voyage_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public String getFlight_status() {
        return flight_status;
    }

    public void setFlight_status(String flight_status) {
        this.flight_status = flight_status;
    }

    public String getGate() {
        return gate;
    }

    public void setGate(String gate) {
        this.gate = gate;
    }

    private String gate;
}
