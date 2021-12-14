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
    *The ClassSelectViewController class handles the functionality of the window wherein the planner can select a class.
    *
    * @author Christian Foyer, Kamil Fischbach, Martin Rosendahl, Nina Wrona, Robert Barta
    * @version 1 - 2 December 2021
    */
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

    /**
     * Constructor for ClassSelectViewController, called by FXMLLoader
     */
    public ClassSelectViewController()
    {
        // Called by FXMLLoader
    }

    /**
     * Method for initializing all the variables
     * @param viewHandler A ViewHandler controlling what View we see. We are setting ClassSelectViewController's viewHandler to this.
     * @param model A ScheduleModel object that we set the ClassSelectViewController model's to.
     * @param root A Region root that we set ClassSelectViewController's Region root to.
     */
    public void init(ViewHandler viewHandler, ScheduleModel model, Region root)
    {
        this.viewHandler = viewHandler;
        this.root = root;
        this.model = model;
        this.chosenClass = null;
        reset();
        loadAllCoursesArray();
    }

    /**
     * Method for getting the Region Root.
     * @return A Region root
     */
    public Region getRoot()
    {
        return root;
    }

    /**
     * Method for resetting. Sets the errorLabel to empty;
     */
    public void reset()
    {
        errorLabel.setText("");
    }

    //here we add our list of choices from an arrayList
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadAllCoursesArray();
    }

    /**
     * Method for loading all Classes. First it clears the AllClassesArray
     * And then it addes all the classes from the model into it. It then
     * loads the classes array int the classChoiceBox and sets the chosen class to the
     * selected choiceBoxClass.
     */
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
    /**
     * Method for the confirmInChooseClassButton. sets the chosenClass to the
     * classChoicebox value and then sets that to the models chosenClassGroup.
     * ViewHandler opens the "schedule" view.
     */
    @FXML
    private void confirmInChooseClassButton(){
        chosenClass = classChoiceBox.getSelectionModel().getSelectedItem();
        chosenClass = classChoiceBox.getValue();
        if(chosenClass!=null)
        {
            model.setChosenClassGroup(chosenClass);
            System.out.println(model.getChosenClassGroup() + "courses: " + model
                .getChosenClassGroup().getCourses());
            reset();
            viewHandler.openView("schedule");
        }
        else
        {
            errorLabel.setText("Would you kindly choose a class?");
        }
    }

    /**
     * method for the cancelInChooseClassButton.
     * calls the Reset() function and then ViewHandler changes the view to "schedule".
     */
    @FXML
    private void cancelInChooseClassButton(){
        reset();
        viewHandler.openView("schedule");
    }
}
