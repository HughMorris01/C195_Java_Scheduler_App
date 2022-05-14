package main;

import database.DBCountries;
import database.JDBC;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Timestamp;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
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
        stage.setTitle("Main Screen");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    public static void main(String[] args) {

        JDBC.openConnection();
        DBCountries.checkDateTimeConversion();

        //Locale.setDefault(new Locale("fr"));
        LocalDateTime a = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm");
        String b = dtf.format(a);
        ZonedDateTime testing = ZonedDateTime.of(a, ZoneId.of("US/Arizona"));
        System.out.println(b + " \n" + testing);
        testing = testing.plusHours(3);
        System.out.println("\n" +testing);
        System.out.println(ZonedDateTime.of(2024, 4, 8, 13, 35, 56, 0, ZoneId.of("US/Central")));

        launch(args);

        JDBC.closeConnection();
    }
}
