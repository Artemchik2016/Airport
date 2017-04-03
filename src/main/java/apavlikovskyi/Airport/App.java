package apavlikovskyi.Airport;

import org.flywaydb.core.Flyway;

/**
 * Created by Diana P on 17.03.2017.
 */

public class App {
   static final private String url="jdbc:mysql://localhost:3306/airport?createDatabaseIfNotExist=true";
   static final private String user="root";
   static final private String password="admin";

    public static void main(String[] args) {
        Flyway flyway = new Flyway();
        flyway.setDataSource(url, user, password);
        flyway.migrate();
    }
}
