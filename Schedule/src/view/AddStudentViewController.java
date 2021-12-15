package view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.basic.Student;
import model.basic.Teacher;
import model.list.ScheduleModel;

import java.util.Optional;

import static java.lang.Integer.parseInt;

/**
 * A class handling the functionality of the window wherein the user can add students to courses.
 *
 * @author Christian Foyer, Kamil Fischbach, Martin Rosendahl, Nina Wrona, Robert Barta
 * @version 3-10 December 2021
 */
public class AddStudentViewController
{

  //@FXML private methods here
  @FXML private Label errorLabel;
  @FXML private TextField studentsNameField;
  @FXML private TextField studentsViaIdField;
  @FXML private TextField classField;
  private Region root;
  private ViewHandler viewHandler;
  private ScheduleModel model;
  private String name;
  private int viaId;
  private String className;

  // TODO Kamil review

  /**
   * A zero-argument constructor called by FXML Loader.
   */
  public AddStudentViewController()
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
    this.name=null;
    this.viaId=0;
    this.className=null;
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
   * A void method setting the error label, students name, VIA ID and class to empty String objects.
   */
  public void reset()
  {
    errorLabel.setText("");
    studentsNameField.setText("");
    studentsViaIdField.setText("");
    classField.setText("");
  }

  /**
   * Boolean Method for whether the user confirms.
   *
   * @return returns either true or false depending on what button picked.
   */
  private boolean confirmation()
  {
    Student student = new Student(studentsNameField.getText(),
        parseInt(studentsViaIdField.getText()));
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Confirmation");
    alert.setHeaderText(
        "Add a student: " + student + "to a course: " + model.getChosenSession()
            .getCourse());
    Optional<ButtonType> result = alert.showAndWait();
    return (result.isPresent()) && (result.get() == ButtonType.OK);
  }

  // @FXML methods here

  /**
   * Method for what to do when the confirmAddAStudentButton is pressed.
   * A Student is made out of the Students VIA ID field, studentsNameField, and model's chosenClassGroup and it is then added to the model's course.
   * The viewHandler closes the view and then opens the view for "courseDetails".
   */
  @FXML private void confirmAddAStudentButton()
  {
    try
    {
      boolean add = confirmation();
      name = studentsNameField.getText();
      viaId = parseInt(studentsViaIdField.getText());
      Student student = new Student(model.getChosenClassGroup().getSemester(),
          name, viaId);
      if (name != null && !name.equals("") && viaId != 0 && className != null
          && className.length() == 2)
      {
        if (add)
        {
          model.getChosenSession().getCourse().addStudent(student);
        }
      }
    }
    catch (Exception e)
    {
      errorLabel.setText(e.getMessage());
    }
    viewHandler.closeView();
    viewHandler.openView("courseDetails");

  }

  /**
   * Method for the cancelAddAStudentButton. calls the Reset() method
   * ViewHandler closes the view and then opens the view for "courseDetails"
   */
  @FXML private void cancelAddAStudentButton()
  {
    reset();
    viewHandler.closeView();
    viewHandler.openView("courseDetails");
  }

}
