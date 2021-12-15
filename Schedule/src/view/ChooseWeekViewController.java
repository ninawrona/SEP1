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

/**
 * A class handling the choosing of a week
 * that we are looking at in the displayed Schedule.
 * @author Christian Foyer, Kamil Fischbach, Martin Rosendahl, Nina Wrona, Robert Barta
 * @version 3-10 December 2021
 */
public class ChooseWeekViewController {
    //FXML instance variable here
    @FXML
    private DatePicker datePicker;
    @FXML
    private Label errorLabel;

    private ScheduleModel model;
    private int chosenWeekNumber;
    private ViewHandler viewHandler;
    private Region root;

    /**
     * A zero-argument constructor called by FXML Loader.
     */
    public ChooseWeekViewController() {
        // Called by FXMLLoader
    }

    /**
     * A void method initializing all the non-FXML variables.
     *
     * @param viewHandler A ViewHandler object which will be used to set this class 'viewHandler' variable.
     * @param model       A ScheduleModel object which will be used to set this class 'model' variable.
     * @param root        A Region object which will be used to set this class 'root' variable.
     */
    public void init(ViewHandler viewHandler, ScheduleModel model, Region root) {
        this.viewHandler = viewHandler;
        this.model = model;
        this.root = root;
        this.chosenWeekNumber = model.getChosenWeekNumber();
        reset();
    }

    /**
     * A getter method of Region object.
     *
     * @return A Region object - 'root'.
     */
    public Region getRoot() {
        return root;
    }

    /**
     * A void method setting the error label to empty String.
     */
    public void reset() {
        errorLabel.setText("");
    }

    /**
     * A void FXML method getting the value of the picked date
     * and setting the week of the schedule being displayed
     * to the week of the chosen date.
     */
    @FXML
    void confirmButton() {
        LocalDate date = datePicker.getValue();
        chosenWeekNumber = date.get(ChronoField.ALIGNED_WEEK_OF_YEAR);
        model.setChosenWeekNumber(chosenWeekNumber);
        // Holder

        LocalDate mondayHolder = date;
        while (mondayHolder.getDayOfWeek().getValue() != 1) {
            mondayHolder = mondayHolder.minusDays(1);

        }
        Date monday = new Date(mondayHolder.getDayOfMonth(),
                mondayHolder.getMonthValue(), mondayHolder.getYear());
        model.setChosenMonday(monday);
        

        viewHandler.openView("schedule");
    }

    /**
     * A void method closing this view and opening the schedule view.
     */
    @FXML
    void cancelButton() {
        viewHandler.openView("schedule");
    }
}
