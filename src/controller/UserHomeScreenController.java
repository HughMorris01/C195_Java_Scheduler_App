package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class UserHomeScreenController implements Initializable {

    public Label loginTimeTextField;
    public Label userName;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        LocalDateTime loginSuccess = MainScreenController.getLoginTime();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        String loginTimeString = dtf.format(loginSuccess);
        loginTimeTextField.setText(loginTimeString);
        userName.setText(MainScreenController.getUser().getUserName());

    }
    /** This method is an event handler on the Customer.
     * When clicked, the button loads and redirects the program to the Customer Screen FXML document.
     * @param actionEvent Passed from the On Action event listener in the User Home Screen FXML document
     * @throws IOException Exception gets thrown if load() cannot locate the FXML file
     * */
    public void toCustomerScreen(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/CustomerScreen.fxml"));
        Stage stage = (Stage) ((Node) (actionEvent.getSource())).getScene().getWindow();
        Scene scene = new Scene(root, 600, 450);
        stage.setScene(scene);
        stage.setTitle("Customer Screen");
        stage.show();
    }

    public void toAppointmentScreen(ActionEvent actionEvent) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("/view/AppointmentScreen.fxml"));
            Stage stage = (Stage) ((Node) (actionEvent.getSource())).getScene().getWindow();
            Scene scene = new Scene(root, 1050, 450);
            stage.setScene(scene);
            stage.setTitle("Appointment Screen");
            stage.show();
    }
}
