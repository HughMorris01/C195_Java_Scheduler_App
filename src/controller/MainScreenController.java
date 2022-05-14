package controller;

import com.sun.javafx.stage.StageHelper;
import database.DBCountries;
import database.DBCustomers;
import database.DBUsers;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import main.Main;
import model.User;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;

/** This is the controller class for the MainScreen.fxml document and not meant to be instantiated.
 *
 * @author Greg Farrell
 * @version 1.0
 * */
public class MainScreenController implements Initializable {
    public TextField userIdTextField;
    public TextField passwordTextField;
    public Label passwordLabel;
    public Label userIdLabel;
    public Button loginButton;
    public Label userLocaleLabel;
    public Label userLocaleData;
    private static Locale userLocale;
    private static LocalDateTime loginTime;
    private static User user;
    private static String userName;
    private static int userId;
    private static String errorMessage1 = "The username and password do not match our records, please try again.";
    private static String blankField = "Blank Field";
    private static String invalidLogin = "Invalid Login Attempt";
    private static String blankAlert1 = "A username must be entered.";
    private static String blankAlert2 = "A password must be entered.";




    @Override
    public void initialize(URL url, ResourceBundle rb) {

        checkLocale();


        /* LocalDateTime a = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm");
        String b = dtf.format(a);
        ZonedDateTime testing = ZonedDateTime.of(a, ZoneId.of("US/Arizona"));
        System.out.println(b + " \n" + testing);
        testing = testing.plusHours(3);
        System.out.println("\n" +testing);
        System.out.println(ZonedDateTime.of(2024, 4, 8, 13, 35, 56, 0, ZoneId.of("US/Central"))); */
    }

    public void checkLocale() {
        userLocale = Locale.getDefault();
        if (userLocale.getLanguage().equals("fr")) {
            ResourceBundle rb = ResourceBundle.getBundle("main/LocaleBundle", userLocale);
            passwordLabel.setText(rb.getString("password"));
            userIdLabel.setText(rb.getString("userId"));
            loginButton.setText(rb.getString("login"));
            loginButton.setPrefWidth(110);
            userLocaleLabel.setText(rb.getString("locale"));
            userLocaleData.setText(rb.getString("france"));
            errorMessage1 = rb.getString("errorMessage1");
            blankField = rb.getString("blankField");
            invalidLogin = rb.getString("invalidLogin");
            blankAlert1 = rb.getString("blankAlert1");
            blankAlert2 = rb.getString("blankAlert2");
        }
        else { userLocaleData.setText(userLocale.getDisplayCountry()); }
    }

    public void loginValidation(ActionEvent actionEvent) {
        try {
            ObservableList<User> allUsers = DBUsers.getAllUsers();
            String tempText = userIdTextField.getText();
            if (tempText.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle(blankField);
                alert.setContentText(blankAlert1);
                alert.show();
                return;
            }
            String tempText1 = passwordTextField.getText();
            if (tempText1.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle(blankField);
                alert.setContentText(blankAlert2);
                alert.show();
                return;
            }
            String enteredName = userIdTextField.getText();
            String enteredPassword = passwordTextField.getText();

            for(User u : allUsers) {
                System.out.println(u);
                if(u.getUserName().equals(enteredName) && u.getUserPassword().equals(enteredPassword)) {
                    loginTime = LocalDateTime.now();
                    user = u;
                    Parent root = FXMLLoader.load(getClass().getResource("/view/UserHomeScreen.fxml"));
                    Stage stage = (Stage) ((Node) (actionEvent.getSource())).getScene().getWindow();
                    Scene scene = new Scene(root, 500, 500);
                    stage.setScene(scene);
                    stage.setTitle("User Home Screen");
                    return;
                }
            }
             {  Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle(invalidLogin);
                alert.setContentText(errorMessage1);
                alert.show();
                userIdTextField.clear();
                passwordTextField.clear();
            }
        }
        catch (Exception exception) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please enter valid values in the input fields");
            alert.setTitle("Invalid Input Type");
            alert.setContentText(exception.getLocalizedMessage());
            alert.show();
        }
    }
    public static Locale getUserLocale() { return userLocale;}
    public static LocalDateTime getLoginTime() { return loginTime; }
    public static User getUser() { return user; }
}
