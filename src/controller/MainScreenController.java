package controller;

import database.DBCountries;
import database.DBCustomers;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import model.Country;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MainScreenController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println(2);
        try {
            DBCustomers.selectCustomers();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public void showCountries() {
        // List variable to populate
        ObservableList<Country> countryList;

        // Return the list of countries from the database
        countryList = DBCountries.getAllCountries();

        // Display all countries in console
        for (Country c : countryList) {
            System.out.println("Country ID: " + c.getId() + " Country Name: " + c.getName());
        }
    }
}
