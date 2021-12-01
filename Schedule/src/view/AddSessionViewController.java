package view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import model.basic.*;
import model.basic.Course;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AddSessionViewController implements Initializable
{
  //@FXML private methods here
  @FXML private Label errorLabel;
  @FXML private ChoiceBox<Course> courseChoiceBoxInAddSession;
  @FXML private ChoiceBox<Time> startTimeChoiceBox;
  @FXML private ChoiceBox<Integer> numberOfLessonsChoiceBox;
  @FXML private ChoiceBox<Room> roomsChoiceBox;
  private Region root;
  private ViewHandler viewHandler;
  //private ScheduleModel model;

  ArrayList<Course> allCoursesArray = new ArrayList<>();
  ArrayList<Time> timeArray = new ArrayList<>();
  ArrayList<Integer> numberOfLessonsArray = new ArrayList<>();
  ArrayList<Room> roomsArray = new ArrayList<>();
  Session session;

  public AddSessionViewController()
  {
    // Called by FXMLLoader
  }

  public void init(ViewHandler viewHandler, Region root) // add model when made
  {
    this.viewHandler = viewHandler;
    this.root = root;
    // this.model = model;
    reset();
  }

  public Region getRoot()
  {
    return root;
  }

  public void reset()
  {
    // set text to ""
  }

  //here we add our list of choices from an arrayList
  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    loadAllCourseArray();
    loadTimeArray();
    loadNumberOfLessonsArray();
    // Rooms should load after the time is set
    // roomsChoiceBox.getItems().addAll(roomsArray); //rooms that are currently available, we have to change
                                                  // the array after clicking find rooms
  }

  // Load the courses into the arrayList
  // ? How will this look on the list? Will it use the toString method?
  private void loadAllCourseArray()
  {
    // Clear the current arrayList
    allCoursesArray.removeAll(allCoursesArray);
    /* waiting for model
    for (int i = 0; i < model.getCourseList().size(); i++)
    {
      allCoursesArray.add(model.getCourseList().get(i);
    }
     */
    courseChoiceBoxInAddSession.getItems().addAll(allCoursesArray);
  }

  private void loadTimeArray()
  {
    timeArray.removeAll(timeArray);
    timeArray.add(new Time(8, 20));
    timeArray.add(new Time(9, 15));
    timeArray.add(new Time(10, 10));
    timeArray.add(new Time (11, 5));
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
    int[] numbers = {1,2,3,4,5,6,7,8,9,10,11};
    for (int i = 0; i < numbers.length; i++)
    {
      numberOfLessonsArray.add(numbers[i]);
    }
    numberOfLessonsChoiceBox.getItems().addAll(numberOfLessonsArray);
  }

  private void loadRoomArray()
  {
    roomsArray.removeAll(roomsArray);
    /* waiting for model
    for (int i = 0; i < model.suggestRooms().size(); i++)
    {
      roomsArray.add(model.suggestRooms().get(i));
    }
     */
    roomsChoiceBox.getItems().addAll(roomsArray);
  }
  
  // @FXML methods here
}
