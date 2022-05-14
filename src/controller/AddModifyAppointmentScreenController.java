package controller;

import database.DBContacts;
import database.DBCustomers;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Contact;
import model.Country;
import model.Customer;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddModifyAppointmentScreenController implements Initializable {
    public Label screenLabel;
    public Button submitButton;
    public static boolean isNewAppointment = false;
    public ComboBox<Contact> contactComboBox;
    public ComboBox<Customer> customerComboBox;
    public TextField contactId;
    public TextField appointmentIdTextField;
    public ObservableList<Contact> localContactList;
    public ObservableList<Customer> localCustomerList;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (isNewAppointment) { screenLabel.setText("Enter New Appointment");
        submitButton.setText("Confirm Appointment");}
        else {screenLabel.setText("Update Existing Appointment");
        submitButton.setText("Save Changes");}

        localContactList = DBContacts.getAllContacts();
        contactComboBox.setItems(localContactList);

        localCustomerList = DBCustomers.getAllCustomers();
        customerComboBox.setItems(localCustomerList);
    }

    public void toAppointmentScreen(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/AppointmentScreen.fxml"));
        Stage stage = (Stage) ((Node) (actionEvent.getSource())).getScene().getWindow();
        Scene scene = new Scene(root, 1050, 450);
        stage.setScene(scene);
        stage.setTitle("Appointment Screen");
    }


    public void onSubmit(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/AppointmentScreen.fxml"));
        Stage stage = (Stage) ((Node) (actionEvent.getSource())).getScene().getWindow();
        Scene scene = new Scene(root, 1050, 450);
        stage.setScene(scene);
        stage.setTitle("Appointment Screen");
    }

    public void onContactSelect(ActionEvent actionEvent) {
        Contact selectedContact = contactComboBox.getSelectionModel().getSelectedItem();
        int selectedId = selectedContact.getId();
        contactId.setText(String.valueOf(selectedId));
    }

    public void onCustomerSelect(ActionEvent actionEvent) {
    }
}
