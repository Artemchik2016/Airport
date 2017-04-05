package apavlikovskyi.Airport;

import apavlikovskyi.Airport.DAO.DAOUtil.DataBaseConnection;

public class App {

    public static void main(String[] args) {
        DataBaseConnection.migrate();

    }
}
