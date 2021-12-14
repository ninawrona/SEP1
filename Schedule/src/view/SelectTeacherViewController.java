package view;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import model.basic.ClassGroup;
import model.basic.Teacher;
import model.list.ScheduleModel;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SelectTeacherViewController
{
    //@FXML private methods here
    @FXML private Label errorLabel;
    @FXML private ChoiceBox<Teacher> teacherChoiceBox;
    private Region root;
    private ViewHandler viewHandler;
    private ScheduleModel model;
    private Teacher chosenTeacher;

    ArrayList<Teacher> allTeachersArray = new ArrayList<>();

    public SelectTeacherViewController()
    {
      // Called by FXMLLoader
    }

    public void init(ViewHandler viewHandler, ScheduleModel model, Region root)
    {
      this.viewHandler = viewHandler;
      this.root = root;
      this.model = model;
      this.chosenTeacher = null;
      reset();
      loadAllTeachersArray();
    }

    public Region getRoot()
    {
      return root;
    }

    public void reset()
    {
      errorLabel.setText("");
      //loadAllTeachersArray();
        allTeachersArray.removeAll(allTeachersArray);
        teacherChoiceBox.getItems().remove(allTeachersArray);

    }


    //here we add our list of choices from an arrayList
    public void initialize(URL url, ResourceBundle resourceBundle) {
      loadAllTeachersArray();
    }


    private void loadAllTeachersArray(){
      allTeachersArray.removeAll(allTeachersArray);
      teacherChoiceBox.getItems().remove(allTeachersArray);
      // Made a simple array to add
      for (int i = 0; i < model.getAllTeachers().size(); i++) {
        allTeachersArray.add(model.getAllTeachers().get(i));
      }
      System.out.println("My teachers array" + allTeachersArray);
      teacherChoiceBox.getItems().addAll(allTeachersArray);
      chosenTeacher = teacherChoiceBox.getSelectionModel().getSelectedItem();

    }

    // @FXML methods here
    @FXML
    private void confirmInSelectTeacherButton(){
      chosenTeacher = teacherChoiceBox.getSelectionModel().getSelectedItem();
      chosenTeacher = teacherChoiceBox.getValue();
      if(chosenTeacher!=null)
      {
        model.setChosenTeacher(chosenTeacher);
        //System.out.println(model.getChosenTeacher() + " courses: " + model.getCoursesByTeacher(chosenTeacher));
        reset();
      }
      viewHandler.openView("schedule");
    }

    @FXML
    private void cancelInSelectTeacherButton(){
      reset();
      viewHandler.openView("schedule");
    }
  }
