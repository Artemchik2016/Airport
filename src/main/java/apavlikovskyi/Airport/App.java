package apavlikovskyi.Airport;

import apavlikovskyi.Airport.DAO.DataBaseConnection;

public class App {

    public static void main(String[] args) {
        DataBaseConnection.migrate();

    }
}
