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

  ArrayList<Student> studentList = new ArrayList<>();
  ArrayList<Teacher> teacherList = new ArrayList<>();

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
    System.out.println("Ects: "+model.getChosenSession().getCourse().getECTS());
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

    studentChoice.getItems().removeAll(studentList);
    teacherChoice.getItems().removeAll(teacherList);
    studentChoice.setValue(null);
    teacherChoice.setValue(null);

    loadStudentArray();
    loadTeacherArray();

  }

  public void loadStudentArray(){
    studentList.removeAll(studentList);

    try{
      for(int i = 0; i<model.getChosenSession().getCourse().getStudents().size(); i++){
        studentList.add(model.getChosenSession().getCourse().getStudents().get(i));
      }
      studentChoice.getItems().addAll(studentList);
    }
    catch (Exception e){
      e.printStackTrace();
    }
  }


  public void loadTeacherArray(){
    teacherList.removeAll(teacherList);

    try{
      for(int i = 0; i<model.getChosenSession().getTeachers().size();i++){
        teacherList.add(model.getChosenSession().getTeachers().get(i));
      }
      teacherChoice.getItems().addAll(teacherList);
    }
    catch (Exception e){
      e.printStackTrace();
    }

  }
  // @FXML methods here

  @FXML private void addTeacherButton()
  {
    viewHandler.closeView();
    viewHandler.openView("addTeacher");
  }

  @FXML private void removeTeacherButton()
  {
    try{
      model.getChosenSession().getTeachers().removeTeacher(teacherChoice.getValue());
      reset();
    }
    catch (IllegalArgumentException e)
    {
      errorLabel.setText(e.getMessage());
    }
  }

  @FXML private void addStudentButton()
  {
    viewHandler.closeView();
    viewHandler.openView("addStudent");
  }

  @FXML private void removeStudentButton()
  {
    try{
      model.getChosenSession().getCourse().removeStudent(studentChoice.getValue());
      reset();
    }
    catch (IllegalArgumentException e)
    {
      errorLabel.setText(e.getMessage());
    }
    System.out.println("List of current students");
    System.out.println(model.getChosenSession().getCourse().getStudents().toString());
  }

  @FXML private void cancelButton()
  {
    viewHandler.closeView();
    viewHandler.openView("schedule");
  }



}

