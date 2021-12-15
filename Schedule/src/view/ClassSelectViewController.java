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

/**
 * A class handling the functionality of the window wherein the user can select a class.
 *
 * @author Christian Foyer, Kamil Fischbach, Martin Rosendahl, Nina Wrona, Robert Barta
 * @version 1 - 2 December 2021
 */
public class ClassSelectViewController {
    //@FXML private methods here
    @FXML
    private Label errorLabel;
    @FXML
    private ChoiceBox<ClassGroup> classChoiceBox;
    @FXML
    private ChoiceBox<Teacher> teacherChoiceBox;
    private Region root;
    private ViewHandler viewHandler;
    private ScheduleModel model;
    private ClassGroup chosenClass;

    ArrayList<ClassGroup> allClassesArray = new ArrayList<>();
    ArrayList<Teacher> allTeachersArray = new ArrayList<>();

    /**
     * A zero-argument constructor called by FXML Loader.
     */
    public ClassSelectViewController() {
        // Called by FXMLLoader
    }

    /**
     * A void method initializing all the non-FXML variables.
     *
     * @param viewHandler A ViewHandler object which will be used to set this class 'viewHandler' variable.
     * @param model       A ScheduleModel object which will be used to set this class 'model' variable.
     * @param root        A Region object which will be used to set this class 'root' variable.
     */
    public void init(ViewHandler viewHandler, ScheduleModel model, Region root) {
        this.viewHandler = viewHandler;
        this.root = root;
        this.model = model;
        this.chosenClass = null;
        reset();
        loadAllCoursesArray();
    }

    /**
     * A getter method of Region object.
     *
     * @return A Region object - 'root'.
     */
    public Region getRoot() {
        return root;
    }

    /**
     * A void method setting the error label to empty String.
     */
    public void reset() {
        errorLabel.setText("");
    }

    /**
     * A void method loading the course list into the teachers choice box.
     */
    private void loadAllCoursesArray() {
        allClassesArray.removeAll(allClassesArray);

        for (int i = 0; i < model.getAllClasses().size(); i++) {
            allClassesArray.add(model.getAllClasses().get(i));
        }
        classChoiceBox.getItems().addAll(allClassesArray);
        chosenClass = classChoiceBox.getSelectionModel().getSelectedItem();

    }

    // @FXML methods here

    /**
     * A void FXML method which sets the chosen class inside the model and opens the schedule view.
     */
    @FXML
    private void confirmInChooseClassButton() {
        chosenClass = classChoiceBox.getSelectionModel().getSelectedItem();
        chosenClass = classChoiceBox.getValue();
        if (chosenClass != null) {
            model.setChosenClassGroup(chosenClass);
            System.out.println(model.getChosenClassGroup() + "courses: " + model
                    .getChosenClassGroup().getCourses());
            reset();
            viewHandler.openView("schedule");
        } else {
            errorLabel.setText("Would you kindly choose a class?");
        }
    }

    /**
     * A void FXML method closing the current view and opening schedule view.
     */
    @FXML
    private void cancelInChooseClassButton() {
        reset();
        viewHandler.openView("schedule");
    }
}
