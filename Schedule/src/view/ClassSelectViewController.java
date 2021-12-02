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
    //@FXML private ChoiceBox<> classChoiceBox;
    private Region root;
    private ViewHandler viewHandler;
    private ScheduleModel model;

    ArrayList<ClassGroup> allClassesArray = new ArrayList<>();

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadAllClassesArray();
    }

    private void loadAllClassesArray() {
        // Clear the current arrayList
        allClassesArray.removeAll(allClassesArray);

        for (int i = 0; i < ScheduleViewModel.getClassGroup().size(); i++) {
            allCoursesArray.add(model.getCourseListByClassGroup(classGroup).get(i));
        }
        courseChoiceBoxInAddSession.getItems().addAll(allCoursesArray);
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
