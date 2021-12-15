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

/**
 * A class allowing to choose a teacher from the given list.
 *
 * @author Christian Foyer, Kamil Fischbach, Martin Rosendahl, Nina Wrona, Robert Barta
 * @version 3-10 December 2021
 */

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

  /**
   * A zero-argument constructor called by FXML Loader.
   */
  public SelectTeacherViewController()
  {
    // Called by FXMLLoader
  }

  /**
   * A void method initializing all the non-FXML variables.
   *
   * @param viewHandler A ViewHandler object which will be used to set this class 'viewHandler' variable.
   * @param model       A ScheduleModel object which will be used to set this class 'model' variable.
   * @param root        A Region object which will be used to set this class 'root' variable.
   */
  public void init(ViewHandler viewHandler, ScheduleModel model, Region root)
  {
    this.viewHandler = viewHandler;
    this.root = root;
    this.model = model;
    this.chosenTeacher = null;
    reset();
  }

  /**
   * A getter method of Region object.
   *
   * @return A Region object - 'root'.
   */
  public Region getRoot()
  {
    return root;
  }

  /**
   * A void method setting the error label to empty String,
   * clearing both the list of teachers and the teacher choice box.
   */
  public void reset()
  {
    errorLabel.setText("");
    allTeachersArray.removeAll(allTeachersArray);
    teacherChoiceBox.getItems().remove(allTeachersArray);
    loadAllTeachersArray();
  }

  /**
   * A void method loading the teachers list into the teachers choice box.
   */
  private void loadAllTeachersArray()
  {
    allTeachersArray.removeAll(allTeachersArray);
    teacherChoiceBox.getItems().remove(allTeachersArray);

    for (int i = 0; i < model.getAllTeachers().size(); i++)
    {
      allTeachersArray.add(model.getAllTeachers().get(i));
    }
    System.out.println("My teachers array" + allTeachersArray);
    teacherChoiceBox.getItems().addAll(allTeachersArray);
    chosenTeacher = teacherChoiceBox.getSelectionModel().getSelectedItem();

  }

  // @FXML methods here

  /**
   * A void FXML method setting the chosen teacher inside the model and opening the schedule view.
   */
  @FXML private void confirmInSelectTeacherButton()
  {
    chosenTeacher = teacherChoiceBox.getSelectionModel().getSelectedItem();
    chosenTeacher = teacherChoiceBox.getValue();
    if (chosenTeacher != null)
    {
      model.setChosenTeacher(chosenTeacher);
      reset();
    }
    viewHandler.openView("schedule");
  }

  /**
   * A void FXML method closing the current view and opening schedule view.
   */
  @FXML private void cancelInSelectTeacherButton()
  {
    reset();
    viewHandler.openView("schedule");
  }
}
