package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Region;

public class ConfirmationViewController
{
    //@FXML private methods here
    @FXML Label errorLabel;
    @FXML TextArea detailsTextArea;
    private Region root;
    private ViewHandler viewHandler;
    //private ScheduleModel model;

    public ConfirmationViewController()
    {
        // Called by FXMLLoader
    }

    public void init(ViewHandler viewHandler, Region root) // add model when made
    {
        this.viewHandler = viewHandler;
        this.root = root;
        // this.model = model;
        reset();
    }

    public Region getRoot()
    {
        return root;
    }

    public void reset()
    {
        // set text to ""
    }

    // @FXML methods here
}

