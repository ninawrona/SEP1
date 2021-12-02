package view;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.list.ScheduleModel;

public class ClassSelectViewController
{
    //@FXML private methods here
    @FXML private Label errorLabel;
    //@FXML private ChoiceBox<> classChoiceBox;
    private Region root;
    private ViewHandler viewHandler;
    private ScheduleModel model;

    public ClassSelectViewController()
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
