package view;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import model.basic.*;
import model.list.*;

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
        viewHandler.openView("schedule");
    }

    @FXML
    void cancelButton() {
        viewHandler.openView("schedule");
    }
}
