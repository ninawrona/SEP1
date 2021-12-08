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
  private String name = null;
  private int viaId = 0;
  private String className = null;

  public AddStudentViewController()
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

  public Region getRoot()
  {
    return root;
  }

  public void reset()
  {
    errorLabel.setText("");
    studentsNameField.setText("");
    studentsViaIdField.setText("");
    classField.setText("");
  }

  private boolean confirmation() {
    Student student = new Student(studentsNameField.getText(), parseInt(studentsViaIdField.getText()));
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Confirmation");
    alert.setHeaderText("Add a student: " + student + "to a course: " + model.getChosenSession().getCourse());
    Optional<ButtonType> result = alert.showAndWait();
    return (result.isPresent()) && (result.get() == ButtonType.OK);
  }

  // @FXML methods here

  @FXML private void confirmAddAStudentButton()
  {
    try
    {
      boolean add = confirmation();
      name = studentsNameField.getText();
      viaId = parseInt(studentsViaIdField.getText());
      //className = classField.getText();
      Student student = new Student(model.getChosenClassGroup().getSemester(), name, viaId);
      if (name != null && !name.equals("") && viaId != 0 && className != null
          && className.length() == 2)
      {
        if (add) {
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

  @FXML private void cancelAddAStudentButton()
  {
    reset();
    viewHandler.closeView();
    viewHandler.openView("courseDetails");
  }

}
