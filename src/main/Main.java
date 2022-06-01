package main;

import com.mysql.cj.result.LocalTimeValueFactory;
import controller.MainScreenController;
import database.DBCountries;
import database.JDBC;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Country;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * This class creates an appointment management application that interfaces with a MySQL database.
 * The class contains the program's main() method and is not intended to be instantiated.
 * FUTURE ENHANCEMENTS:
 * @author Greg Farrell
 * @version 1.0
 */
public class Main extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/MainScreen.fxml"));
        if(MainScreenController.getUserLocale().getLanguage().equals("fr")) { stage.setTitle("Écran Principal"); }
        else { stage.setTitle("Main Screen"); }
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    public static void main(String[] args) {
        JDBC.openConnection();
        /* ZonedDateTime localTime0 = ZonedDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        String b = dtf.format(localTime0);
        System.out.println(b);
        System.out.println(localTime0);
        System.out.println(localTime0.toInstant()); */

        launch(args);
        JDBC.closeConnection();
    }
}
