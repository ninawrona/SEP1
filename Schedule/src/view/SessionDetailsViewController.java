package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.list.ScheduleModel;

public class SessionDetailsViewController
{
    //@FXML private methods here
    @FXML private Label errorLabel;
    @FXML private TextField courseDetailsField;
    @FXML private TextField classDetailsField;
    @FXML private TextField teachersDetailsField;
    @FXML private TextField studentsDetailsField;
    @FXML private TextField startTimeField;
    @FXML private TextField roomDetailsField;
    private Region root;
    private ViewHandler viewHandler;
    private ScheduleModel model;

    public SessionDetailsViewController()
    {
        // Called by FXMLLoader
    }

    public void init(ViewHandler viewHandler,  ScheduleModel model, Region root) // add model when made
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

