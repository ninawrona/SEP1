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
import model.list.StudentList;

import java.util.ArrayList;

/**
 * A class handling the functionality of the window wherein the user can see and make changes to the participant of a course.
 *
 * @author Christian Foyer, Kamil Fischbach, Martin Rosendahl, Nina Wrona, Robert Barta
 * @version 3-10 December 2021
 */
public class CourseDetailsViewController
{
  ArrayList<Student> studentList = new ArrayList<>();
  ArrayList<Teacher> teacherList = new ArrayList<>();
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

  /**
   * A zero-argument constructor called by FXML Loader.
   */
  public CourseDetailsViewController()
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

    courseNameField.setText(
        "" + model.getChosenSession().getCourse().getFullName());
    semesterField.setText("" + model.getChosenClassGroup().getSemester());
    ectsPointsField.setText(
        "" + model.getChosenSession().getCourse().getECTS());
    reset();
  }

  /**
   * A getter method returning the Region object.
   *
   * @return A Region object - 'root'.
   */
  public Region getRoot()
  {
    return root;
  }

  /**
   * A void method setting the error label to empty String and loading the list of students and teachers.
   */
  public void reset()
  {
    errorLabel.setText("");
    //set the areas to the chosen class and course.

    studentChoice.getItems().removeAll(studentList);
    teacherChoice.getItems().removeAll(teacherList);
    studentChoice.setValue(null);
    teacherChoice.setValue(null);
    courseNameField.setText(
        "" + model.getChosenSession().getCourse().getFullName());
    loadStudentArray();
    loadTeacherArray();

  }

  /**
   * Method for loading students array.
   * Empties the studentList and then adds the model's students to the student
   * list and loads them into the studentChoiceBox.
   */
  public void loadStudentArray()
  {
    studentList.removeAll(studentList);

    try
    {
      for (int i = 0;
           i < model.getChosenSession().getCourse().getStudents().size(); i++)
      {
        studentList.add(
            model.getChosenSession().getCourse().getStudents().get(i));
      }
      studentChoice.getItems().addAll(studentList);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  /**
   * Method for loading the Teachers.
   * First it empties the teacher list and then it gets the model's teachers
   * and adds them to the teacher list. Then it loads it into the TeacherChoiceBox.
   */
  public void loadTeacherArray()
  {
    teacherList.removeAll(teacherList);

    try
    {
      for (int i = 0; i < model.getChosenSession().getTeachers().size(); i++)
      {
        teacherList.add(model.getChosenSession().getTeachers().get(i));
      }
      teacherChoice.getItems().addAll(teacherList);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }

  }
  // @FXML methods here

  /**
   * A void FXML method which opens a the view for adding a teacher.
   */
  @FXML private void addTeacherButton()
  {
    viewHandler.closeView();
    viewHandler.openView("addTeacher");
  }

  /**
   * A void FXML method which removes a chosen teacher from the list.
   */
  @FXML private void removeTeacherButton()
  {
    try
    {
      model.getChosenSession().getTeachers()
          .removeTeacher(teacherChoice.getValue());
      reset();
    }
    catch (IllegalArgumentException e)
    {
      errorLabel.setText(e.getMessage());
    }
  }

  /**
   * A void FXML method which opens a the view for adding a student.
   */
  @FXML private void addStudentButton()
  {
    viewHandler.closeView();
    viewHandler.openView("addStudent");
  }

  /**
   * A void FXML method which removes a chosen student from the list.
   */
  @FXML private void removeStudentButton()
  {
    try
    {
      model.getChosenSession().getCourse()
          .removeStudent(studentChoice.getValue());
      reset();
    }
    catch (IllegalArgumentException e)
    {
      errorLabel.setText(e.getMessage());
    }
  }

  /**
   * A void FXML method closing the current view and opening schedule view.
   */
  @FXML private void cancelButton()
  {
    viewHandler.closeView();
    viewHandler.openView("schedule");
  }
}

