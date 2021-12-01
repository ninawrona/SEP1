package view;

import javafx.scene.layout.Region;

public class AddTeacherViewController {
    //@FXML private methods here
    private Region root;
    private ViewHandler viewHandler;
    //private ScheduleModel model;

    public AddTeacherViewController()
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
