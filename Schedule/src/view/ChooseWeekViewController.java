package view;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import model.basic.*;
import model.list.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.Locale;

public class ChooseWeekViewController {
    //FXML instance variable here
    @FXML
    DatePicker datePicker;
    @FXML
    Label errorLabel;

    private ScheduleModel model;
    private int chosenWeekNumber;
    private ViewHandler viewHandler;
    private Region root;

    public ChooseWeekViewController() {
        // Called by FXMLLoader
    }

    public void init(ViewHandler viewHandler, ScheduleModel model, Region root) {
        this.viewHandler = viewHandler;
        this.model = model;
        this.root = root;
        this.chosenWeekNumber = model.getChosenWeekNumber();
        reset();
    }

    public Region getRoot() {
        return root;
    }

    public void reset() {
        errorLabel.setText("");
    }

    @FXML
    void confirmButton() {
        LocalDate date = datePicker.getValue();
        chosenWeekNumber = date.get(ChronoField.ALIGNED_WEEK_OF_YEAR);
        model.setChosenWeekNumber(chosenWeekNumber);
        System.out.println("I just set the week to " + model.getChosenWeekNumber());
        // Holder
        System.out.println("I'm finding the monday");
        LocalDate mondayHolder = date;
            while (mondayHolder.getDayOfWeek().getValue() != 1) {
                System.out.println(mondayHolder);
                mondayHolder = mondayHolder.minusDays(1);
                System.out.println("I just moved back one day");
                System.out.println("Holder is now " + mondayHolder);
            }
        Date monday = new Date(mondayHolder.getDayOfMonth(), mondayHolder.getMonthValue(), mondayHolder.getYear());
        model.setChosenMonday(monday);
        System.out.println("I just set the Monday to " + monday);

        viewHandler.openView("schedule");
    }

    @FXML
    void cancelButton() {
        viewHandler.openView("schedule");
    }
}
