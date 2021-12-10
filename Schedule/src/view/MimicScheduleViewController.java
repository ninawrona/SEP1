package view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import model.list.*;

import java.util.ArrayList;

public class MimicScheduleViewController
{
    @FXML private Label errorLabel;
    @FXML private DatePicker datePicker;
    @FXML private ListView<Integer> holidayPicker;

    ArrayList<Integer> weekArray = new ArrayList<>();

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
        holidayPicker.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        reset();

    }

    public Region getRoot() {
        return root;
    }

    public void reset()
    {
        errorLabel.setText("");
        loadHolidayPicker();
    }

    public void loadHolidayPicker()
    {
        weekArray.remove(weekArray);
        for(int i=1; i<=52; i++)
        {
            weekArray.add(i);
        }
        if(weekArray.size()!=0)
        {
            holidayPicker.getItems().addAll(weekArray);
        }
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
