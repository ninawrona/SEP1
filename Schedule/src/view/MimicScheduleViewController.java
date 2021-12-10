package view;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import model.basic.*;
import model.list.*;

public class MimicScheduleViewController
{
    @FXML private Label errorLabel;
    @FXML private DatePicker datePicker;
    @FXML private ComboBox holidayPicker;


    private ScheduleModel model;
    private ViewHandler viewHandler;
    private Region root;

    public MimicScheduleViewController()
    {
        // Called by FXMLLoader
    }

    public void init(ViewHandler viewHandler, ScheduleModel model, Region root)
    {
        this.viewHandler = viewHandler;
        this.model = model;
        this.root = root;
        reset();
    }

    public Region getRoot() {
        return root;
    }

    public void reset()
    {
        errorLabel.setText("");
    }

    public void loadHolidayPicker()
    {

    }


    @FXML void confirmButton()
    {
        // Do the mimicking here

    }

    @FXML void cancelButton()
    {
        viewHandler.openView("schedule");
    }
}
