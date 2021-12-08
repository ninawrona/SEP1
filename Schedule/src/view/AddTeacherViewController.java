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

public class AddTeacherViewController
{
  //@FXML private methods here
  @FXML private TextField teachersViaIdField;
  @FXML private Label errorLabel;
  private Region root;
  private ViewHandler viewHandler;
  private ScheduleModel model;
  private Teacher teacherToBeAdded;

  public AddTeacherViewController()
  {
    // Called by FXMLLoader
  }

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

  public Region getRoot()
  {
    return root;
  }

  public void reset()
  {
    errorLabel.setText("");
    teachersViaIdField.setText("");
  }
  private boolean confirmation() {
    teacherToBeAdded = new Teacher(teachersViaIdField.getText());
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Confirmation");
    alert.setHeaderText("Add a teacher: " + teacherToBeAdded);
    Optional<ButtonType> result = alert.showAndWait();
    return (result.isPresent()) && (result.get() == ButtonType.OK);
  }

  // @FXML methods here
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

  @FXML private void cancelAddATeacherButton()
  {
    viewHandler.closeView();
    viewHandler.openView("courseDetails");
  }
}
