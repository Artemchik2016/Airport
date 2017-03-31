package apavlikovskyi.Airport;

import org.flywaydb.core.Flyway;

/**
 * Created by Diana P on 17.03.2017.
 */

public class App {
   static final private String url="jdbc:mysql://127.0.0.1:3307/airport";
   static final private String user="airport";
   static final private String password="admin";

    public static void main(String[] args) {
        Flyway flyway = new Flyway();
        flyway.setDataSource(url, user, password);
        flyway.migrate();
    }
}
