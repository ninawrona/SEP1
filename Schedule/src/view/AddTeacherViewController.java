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
 *The AddTeacherViewController class handles the functionality of the window wherein the planner can add teachers to sessions.
 *
 * @author Christian Foyer, Kamil Fischbach, Martin Rosendahl, Nina Wrona, Robert Barta
 * @version 1 - 2 December 2021
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
   * Constructor for the AddTeacherViewController, called by the FXMLLoader
   */
  public AddTeacherViewController()
  {
    // Called by FXMLLoader
  }

  /**
   * Method for initializing all the variables
   * @param viewHandler A ViewHandler controlling what View we see. We are setting AddSessionViewController's viewHandler to this
   * @param model A ScheduleModel object that we set the AddSessionViewController model's to
   * @param root A Region root that we set AddSessionViewController's region to
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
   * method for getting the Root
   * @return Region root
   */
  public Region getRoot()
  {
    return root;
  }

  /**
   * Void Method for resetting everything. sets  the fields to empty.
   */
  public void reset()
  {
    errorLabel.setText("");
    teachersViaIdField.setText("");
  }

  /**
   * Boolean Method for whether the user confirms.
   * @return returns either true or false depending on what button picked.
   */
  private boolean confirmation() {
    teacherToBeAdded = new Teacher(teachersViaIdField.getText());
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Confirmation");
    alert.setHeaderText("Add a teacher: " + teacherToBeAdded);
    Optional<ButtonType> result = alert.showAndWait();
    return (result.isPresent()) && (result.get() == ButtonType.OK);
  }

  // @FXML methods here

  /**
   * Method for what to do when the confirmAddATeacherButton is pressed.
   * A teacher is made out of the teachers VIA ID field and it is then added to the model's session.
   * The teacher is also assigned to the course.
   * The viewHandler closes the view and then opens the view for "Schedule".
   */
  @FXML private void confirmAddATeacherButton()
  {
    try{
    teacherToBeAdded = new Teacher(teachersViaIdField.getText());
    boolean add = confirmation();
    if (add) {
      model.getChosenSession().getCourse().addTeacher(teacherToBeAdded);
      teacherToBeAdded.assignToCourseTaught(model.getChosenSession().getCourse());
    }
  } catch (Exception e) {
  errorLabel.setText("Item not found: " + e.getMessage());
}
    //
    System.out.println("Our teacher:" + teacherToBeAdded);
    System.out.println("Teachers for this course: " + model.getChosenSession().getCourse().getTeachers());
    viewHandler.closeView();
    viewHandler.openView("schedule");
  }

  /**
   * Method for the cancelAddATeacherButton.
   * ViewHandler closes the current view and opens the "courseDetails" view.
   */
  @FXML private void cancelAddATeacherButton()
  {
    viewHandler.closeView();
    viewHandler.openView("courseDetails");
  }
}
