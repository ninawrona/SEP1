package view;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import model.basic.*;
import model.list.*;

import java.net.URL;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

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
    reset();
    /*
    errorLabel.setText("");
    titleLabel.setText("");
    loadAllCourseArray();
    datePicker.showWeekNumbersProperty();
    loadTimeArray();
    loadNumberOfLessonsArray();
     */
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
    titleLabel.setText(
        "Add a Session to " + model.getChosenClassGroup().toString());
    session = null;
    model.setChosenClassGroup(model.getChosenClassGroup());
    this.classGroup = model.getChosenClassGroup();
    System.out.println(
        model.getChosenClassGroup() + "courses: " + model.getChosenClassGroup()
            .getCourses());
    System.out.println("I just reset the add session window!");
    courseChoiceBoxInAddSession.setValue(null);
    startTimeChoiceBox.setValue(null);
    // datePicker.getEditor().clear();
    numberOfLessonsChoiceBox.setValue(null);
    roomsChoiceBox.setValue(null);
    loadAllCourseArray();
    loadTimeArray();
    loadNumberOfLessonsArray();
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
    errorLabel.setText("");
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
    catch (IllegalArgumentException a){
      errorLabel.setText("The last lesson has to end before 18:00.");
    }
    catch (Exception e)
    {
      errorLabel.setText(e.getMessage());
    }


  }

  private boolean confirmation() {
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Confirmation");
    alert.setHeaderText("Are you sure you want to book: " + session.getRoom() + " for less than 45 students?");
    Optional<ButtonType> result = alert.showAndWait();
    return (result.isPresent()) && (result.get() == ButtonType.OK);
  }

  @FXML private void addSessionButton()
  {
    try
    {
      session.bookRoom(roomsChoiceBox.getValue());
      model.addSession(session, roomsChoiceBox.getValue());
      if (session.getRoom() == null)
      {
        System.out.println("Hey! The room for this session is null!");
      }
      if (session.getRoom().getCapacity()>100&&session.getCourse().getStudents().size()<45){
        boolean book = confirmation();
        if(book){
          scheduleViewModel.addSession(session);
          reset();
        }
        else{
          session.bookRoom(null);
        }
        //errorLabel.setText("Are you sure you want to book the auditorium for less than 45 students?");
      }
      else
      {
        System.out.println("I put that session in room " + session.getRoom());
      }
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
