package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.list.ScheduleModel;

public class CourseDetailsViewController
{
    //@FXML private methods here
    @FXML private Label errorLabel;
    @FXML private TextField courseNameField;
    @FXML private TextField semesterField;
    @FXML private TextField teachersField;
    @FXML private TextField studentsField;
    @FXML private TextField ectsPointsField;
    private Region root;
    private ViewHandler viewHandler;
    private ScheduleModel model;

    public CourseDetailsViewController()
    {
        // Called by FXMLLoader
    }

    public void init(ViewHandler viewHandler, Region root, ScheduleModel model)
    {
        this.viewHandler = viewHandler;
        this.root = root;
        this.model = model;
        reset();
    }

    public Region getRoot()
    {
        return root;
    }

    public void reset()
    {
        errorLabel.setText("");
    }

    // @FXML methods here
}

