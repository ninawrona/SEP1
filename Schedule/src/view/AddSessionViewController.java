package view;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import model.basic.*;
import model.list.*;

import java.net.URL;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AddSessionViewController
{
  //@FXML private methods here
  @FXML private Label errorLabel;
  @FXML private Label titleLabel;
  @FXML private ChoiceBox<Course> courseChoiceBoxInAddSession;
  @FXML private DatePicker datePicker;
  @FXML private ChoiceBox<Time> startTimeChoiceBox;
  @FXML private ChoiceBox<Integer> numberOfLessonsChoiceBox;
  @FXML private ChoiceBox<Room> roomsChoiceBox;

  private Region root;
  private ViewHandler viewHandler;
  private ScheduleModel model;
  private ScheduleViewModel scheduleViewModel;
  private ClassGroup classGroup;
  private Session session;

  ArrayList<Course> allCoursesArray = new ArrayList<>();
  ArrayList<Time> timeArray = new ArrayList<>();
  ArrayList<Integer> numberOfLessonsArray = new ArrayList<>();
  ArrayList<Room> roomsArray = new ArrayList<>();

    /*ArrayList<Integer> allCoursesArray = new ArrayList<>();
    ArrayList<Time> timeArray = new ArrayList<>();
    ArrayList<Integer> numberOfLessonsArray = new ArrayList<>();
    ArrayList<Integer> roomsArray = new ArrayList<>();*/

  public AddSessionViewController()
  {
    // Called by FXMLLoader
  }

  public void init(ViewHandler viewHandler, ScheduleModel model, Region root)
  {
    this.viewHandler = viewHandler;
    this.root = root;
    this.model = model;
    this.scheduleViewModel = new ScheduleViewModel(model);
    this.classGroup = model.getChosenClassGroup();
    errorLabel.setText("");
    titleLabel.setText("");
    loadAllCourseArray();
    datePicker.showWeekNumbersProperty();
    loadTimeArray();
    loadNumberOfLessonsArray();
  }

  public Region getRoot()
  {
    return root;
  }

  public void reset()
  {
    // Clear old drop-downs
    courseChoiceBoxInAddSession.getItems().removeAll(allCoursesArray);
    startTimeChoiceBox.getItems().removeAll(timeArray);
    numberOfLessonsChoiceBox.getItems().removeAll(numberOfLessonsArray);
    roomsChoiceBox.getItems().removeAll(roomsArray);
    // set text to ""
    errorLabel.setText("");
    if (model.getChosenClassGroup() != null)
    {
      titleLabel.setText(
          "Add a Session to " + model.getChosenClassGroup().toString());
      session = null;
      model.setChosenClassGroup(model.getChosenClassGroup());
      this.classGroup = model.getChosenClassGroup();
      System.out.println(model.getChosenClassGroup() + "courses: " + model.getChosenClassGroup().getCourses());
      System.out.println("I did a reset");//What does it mean?
      courseChoiceBoxInAddSession.setValue(null);
      startTimeChoiceBox.setValue(null);
      datePicker.getEditor().clear();
      numberOfLessonsChoiceBox.setValue(null);
      roomsChoiceBox.setValue(null);
      loadAllCourseArray();
      loadTimeArray();
      loadNumberOfLessonsArray();
    }
    else
    {
      errorLabel.setText("You have to choose class first!");
    }
  }

  // Load the courses into the arrayList
  // ? How will this look on the list? Will it use the toString method?
  private void loadAllCourseArray()
  {
    // Clear the current arrayList
    allCoursesArray.removeAll(allCoursesArray);

    // Only load the courses relevant to the selected class group
    try
    {
      ClassGroup classGroupx = classGroup;
      System.out.println(classGroup);
      CourseList courseListx = new CourseList();
      for (int i = 0; i < classGroupx.getCourses().size(); i++)
      {
        courseListx.addCourse(classGroupx.getCourses().get(i));
      }
      for (int i = 0; i < courseListx.size(); i++)
      {
        Course coursex = courseListx.get(i);
        allCoursesArray.add(coursex);
      }
      courseChoiceBoxInAddSession.getItems().addAll(allCoursesArray);
    }
    catch (NullPointerException e)
    {
      errorLabel.setText("Class not selected!");
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  private void loadTimeArray()
  {
    timeArray.removeAll(timeArray);
    timeArray.add(new Time(8, 20));
    timeArray.add(new Time(9, 15));
    timeArray.add(new Time(10, 10));
    timeArray.add(new Time(11, 5));
    timeArray.add(new Time(12, 0));
    timeArray.add(new Time(12, 45));
    timeArray.add(new Time(13, 40));
    timeArray.add(new Time(14, 35));
    timeArray.add(new Time(15, 30));
    timeArray.add(new Time(16, 25));
    timeArray.add(new Time(17, 20));
    startTimeChoiceBox.getItems().addAll(timeArray);

  }

  private void loadNumberOfLessonsArray()
  {
    numberOfLessonsArray.removeAll(numberOfLessonsArray);
    // Made a simple array to add
    int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
    for (int i = 0; i < numbers.length; i++)
    {
      numberOfLessonsArray.add(numbers[i]);
    }
    numberOfLessonsChoiceBox.getItems().addAll(numberOfLessonsArray);
  }

  // Load rooms based on the session above
  private void loadRoomArray()
  {
    roomsArray.removeAll(roomsArray);
    for (int i = 0; i < model.suggestRooms(session).size(); i++)
    {
      roomsArray.add(model.suggestRooms(session).get(i));
    }
    roomsChoiceBox.getItems().addAll(roomsArray);
    System.out.println("Those are the rooms displayed:" + "\n" + roomsArray);
    System.out.println("Here are the rooms!");
  }

  // Convert the date picker into our date class
  public Date getDateFromDatePicker()
  {
    LocalDate localDate = datePicker.getValue();
    return new Date(localDate.getDayOfMonth(), localDate.getMonthValue(),
        localDate.getYear());
  }

  // @FXML methods here
  // Create a session using the information above, then load rooms
  @FXML private void findRoomsButton()
  {
    roomsChoiceBox.getItems().removeAll(roomsArray);
    try
    {
      session = new Session(courseChoiceBoxInAddSession.getValue(),
          getDateFromDatePicker(), startTimeChoiceBox.getValue(),
          numberOfLessonsChoiceBox.getValue());
      System.out.println("I just created the following session:\n");
      System.out.println(session);
      loadRoomArray();
    }
    catch(Exception e)
    {
      errorLabel.setText(e.getMessage());
    }

  }

  @FXML private void addSessionButton()
  {
    try
    {
      model.addSession(session, roomsChoiceBox.getValue());
      scheduleViewModel.addSession(session);
      reset();
    }
    catch (Exception e)
    {
      errorLabel.setText(e.getMessage());
    }
    System.out.println("I just added the following session: \n" + session);
    viewHandler.openView("schedule");
  }

  @FXML private void cancelInAddSessionButton()
  {
    reset();
    viewHandler.closeView();
    viewHandler.openView("schedule");
  }
}
