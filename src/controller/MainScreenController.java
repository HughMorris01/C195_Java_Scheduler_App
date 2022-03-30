package controller;

import database.DBCountries;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import model.Country;

import java.net.URL;
import java.util.ResourceBundle;

public class MainScreenController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println(2);
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
