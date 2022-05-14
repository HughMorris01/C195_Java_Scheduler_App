package model;

import database.DBCountries;
import database.DBFirst_Level_Divisions;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDateTime;

public class Customer {
    private int customerId;
    private String customerName;
    private String address;
    private String postalCode;
    private String phone;
    private Division division;
    private int divisionId;
    private Country country;
    private ObservableList<Appointment> customerAppointments = FXCollections.observableArrayList();

    //Constructor
    public Customer(int customerId, String customerName, String address, String postalCode, String phone, int divisionId) {
        setCustomerId(customerId);
        setCustomerName(customerName);
        setAddress(address);
        setPostalCode(postalCode);
        setPhone(phone);
        setDivisionId(divisionId);
        DBFirst_Level_Divisions.getAllDivisions();
        for (Division d : DBFirst_Level_Divisions.getAllDivisions()) {
            if (divisionId == d.getDivisionId()) {
                setDivision(d);
                return;
            }
        }
    }

    public Customer(String customerName, String address, String postalCode, String phone, int divisionId) {
        setCustomerName(customerName);
        setAddress(address);
        setPostalCode(postalCode);
        setPhone(phone);
        setDivisionId(divisionId);
        for (Division d : DBFirst_Level_Divisions.getAllDivisions()) {
            if (divisionId == d.getDivisionId()) {
                setDivision(d);
                return;
            }
        }
    }

    //Setter Functions
    public void setCustomerId(int customerId) { this.customerId = customerId; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public void setAddress(String address) { this.address = address; }
    public void setPostalCode(String postalCode) { this.postalCode = postalCode; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setDivisionId(int divisionId) { this.divisionId = divisionId; }
    public void setDivision(Division division) { this.division = division; }

    //Getter Functions
    public int getCustomerId() { return customerId; }
    public String getCustomerName() { return customerName; }
    public String getAddress() { return address; }
    public String getPostalCode() { return postalCode; }
    public String getPhone() { return phone; }
    public int getDivisionId() { return divisionId; }
    public Division getDivision() { return division; }
    public ObservableList<Appointment> getCustomerAppointments() { return customerAppointments;}

    @Override
    public String toString() {
        String customerToString = "id #" + getCustomerId() + ": " + getCustomerName();
        return customerToString;
    }
}