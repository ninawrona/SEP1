package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.basic.ClassGroup;
import model.basic.Course;
import model.basic.Teacher;
import model.list.ScheduleModel;
import model.list.TeacherList;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ClassSelectViewController
{
    //@FXML private methods here
    @FXML private Label errorLabel;
    @FXML private ChoiceBox<ClassGroup> classChoiceBox;
    @FXML private ChoiceBox<Teacher> teacherChoiceBox;
    private Region root;
    private ViewHandler viewHandler;
    private ScheduleModel model;
    private ClassGroup chosenClass;

    ArrayList<ClassGroup> allClassesArray = new ArrayList<>();
    ArrayList<Teacher> allTeachersArray = new ArrayList<>();

    public ClassSelectViewController()
    {
        // Called by FXMLLoader
    }

    public void init(ViewHandler viewHandler, ScheduleModel model, Region root)
    {
        this.viewHandler = viewHandler;
        this.root = root;
        this.model = model;
        this.chosenClass = null;
        reset();
        loadAllCoursesArray();
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
        chosenClass = classChoiceBox.getSelectionModel().getSelectedItem();

    }

    // @FXML methods here
    @FXML
    private void confirmInChooseClassButton(){
        chosenClass = classChoiceBox.getSelectionModel().getSelectedItem();
        chosenClass = classChoiceBox.getValue();
        model.setChosenClassGroup(chosenClass);
        System.out.println(model.getChosenClassGroup() + "courses: " + model.getChosenClassGroup().getCourses());
        reset();
        viewHandler.openView("schedule");
    }

    @FXML
    private void cancelInChooseClassButton(){
        reset();
        viewHandler.openView("schedule");
    }
}
