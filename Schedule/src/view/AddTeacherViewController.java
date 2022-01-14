package view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.basic.Teacher;
import model.list.ScheduleModel;

import java.util.Optional;

/**
 * A class handling the functionality of the window wherein the user can add teachers to sessions.
 *
 * @author Christian Foyer, Kamil Fischbach, Martin Rosendahl, Nina Wrona, Robert Barta
 * @version 3-10 December 2021
 */
public class AddTeacherViewController
{
  //@FXML private methods here
  @FXML private TextField teachersViaIdField;
  @FXML private Label errorLabel;
  private Region root;
  private ViewHandler viewHandler;
  private ScheduleModel model;
  private Teacher teacherToBeAdded;

  /**
   * A zero-argument constructor called by FXML Loader.
   */
  public AddTeacherViewController()
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
  public void init(ViewHandler viewHandler, Region root, ScheduleModel model)
  {
    this.viewHandler = viewHandler;
    this.root = root;
    this.model = model;
    reset();
    errorLabel.setText("");
    teachersViaIdField.setText("");
    this.teacherToBeAdded = null;
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
   * A void method setting the error label to empty String and teacher's VIA ID to empty String.
   */
  public void reset()
  {
    errorLabel.setText("");
    teachersViaIdField.setText("");
  }

  /**
   * A boolean method asking the user to confirm.
   *
   * @return "True" when "OK" button pressed, "False" when it is not pressed.
   */
  private boolean confirmation()
  {
    teacherToBeAdded = new Teacher(teachersViaIdField.getText());
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Confirmation");
    alert.setHeaderText("Add a teacher: " + teacherToBeAdded);
    Optional<ButtonType> result = alert.showAndWait();
    return (result.isPresent()) && (result.get() == ButtonType.OK);
  }

  // @FXML methods here

  /**
   * A void FXML method that adds the teacher to the chosen course
   * and assign this course to the teacher's courses.
   * Afterwards it opens a schedule view.
   */
  @FXML private void confirmAddATeacherButton()
  {
    try
    {
      teacherToBeAdded = new Teacher(teachersViaIdField.getText());
      boolean add = confirmation();
      if (add)
      {
        model.getChosenSession().getCourse().addTeacher(teacherToBeAdded);
        teacherToBeAdded.assignToCourseTaught(
            model.getChosenSession().getCourse());
        System.out.println(teacherToBeAdded + " to a course: " + teacherToBeAdded.getCoursesTaught());
      }
    }
    catch (Exception e)
    {
      errorLabel.setText("Item not found: " + e.getMessage());
    }
    //
    viewHandler.closeView();
    viewHandler.openView("schedule");
  }

  /**
   * A void FXML method closing the current view and opening schedule view.
   */
  @FXML private void cancelAddATeacherButton()
  {
    viewHandler.closeView();
    viewHandler.openView("courseDetails");
  }
}
