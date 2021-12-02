package view;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.basic.ClassGroup;
import model.basic.Course;
import model.list.ScheduleModel;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ClassSelectViewController
{
    //@FXML private methods here
    @FXML private Label errorLabel;
    @FXML private ChoiceBox<ClassGroup> classChoiceBox;
    private Region root;
    private ViewHandler viewHandler;
    private ScheduleModel model;

    ArrayList<ClassGroup> allClassesArray = new ArrayList<>();

    public ClassSelectViewController()
    {
        // Called by FXMLLoader
    }

    public void init(ViewHandler viewHandler, ScheduleModel model, Region root)
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


    //here we add our list of choices from an arrayList
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadAllCoursesArray();
    }

    private void loadAllCoursesArray(){
        allClassesArray.removeAll(allClassesArray);
        // Made a simple array to add
        for (int i = 0; i < model.getAllClasses().size(); i++) {
            allClassesArray.add(model.getAllClasses().get(i));
        }
        classChoiceBox.getItems().addAll(allClassesArray);
    }

    // @FXML methods here
}
