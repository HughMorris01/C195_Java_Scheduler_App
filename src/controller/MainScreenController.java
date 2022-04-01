package controller;

import database.DBContacts;
import database.DBCountries;
import database.DBCustomers;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
            /*int rowsAffected1 = DBCustomers.insertCustomer("Bobby", "2357 Newberry Street", 103);
            int rowsAffected2 = DBCustomers.updateCustomer(9, "Badrinath");
            System.out.println("Inserted Rows: " + rowsAffected1);
            System.out.println("Updated Rows: " + rowsAffected2);
            int rowsAffected3 = DBCustomers.deleteCustomer(9);
            System.out.println("Deleted Rows: " + rowsAffected3); */
            DBCustomers.selectCustomers();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
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
