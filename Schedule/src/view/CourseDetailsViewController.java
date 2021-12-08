package view;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.basic.Student;
import model.basic.Teacher;
import model.list.ScheduleModel;

public class CourseDetailsViewController
{
  //@FXML private methods here
  @FXML private Label errorLabel;
  @FXML private TextArea courseNameField;
  @FXML private TextArea semesterField;
  @FXML private TextArea ectsPointsField;
  @FXML private ChoiceBox<Teacher> teacherChoice;
  @FXML private ChoiceBox<Student> studentChoice;
  private Region root;
  private ViewHandler viewHandler;
  private ScheduleModel model;

  public CourseDetailsViewController()
  {
    // Called by FXMLLoader
  }

  public void init(ViewHandler viewHandler, ScheduleModel model, Region root)
  {
    this.viewHandler = viewHandler;
    this.root = root;
    this.model = model;
    reset();
    courseNameField.setText("" + model.getChosenSession().getCourse());
    semesterField.setText("" + model.getChosenClassGroup().getSemester());
    ectsPointsField.setText("" + model.getChosenSession().getCourse().getECTS());
  }

  public Region getRoot()
  {
    return root;
  }

  public void reset()
  {
    errorLabel.setText("");
    //set the areas to the chosen class and course.
  }

  // @FXML methods here

  @FXML private void addTeacherButton()
  {
    viewHandler.closeView();
    viewHandler.openView("addTeacher");
  }

  @FXML private void removeTeacherButton()
  {
    teacherChoice.getValue().removeFromCoursesTaught(model.getChosenSession().getCourse());
  }

  @FXML private void addStudentButton()
  {
    viewHandler.closeView();
    viewHandler.openView("addStudent");
  }

  @FXML private void removeStudentButton()
  {
    model.removeStudentFromCourse(studentChoice.getValue(), model.getChosenSession().getCourse());
  }

  @FXML private void cancelButton()
  {
    viewHandler.closeView();
    viewHandler.openView("schedule");
  }



}

