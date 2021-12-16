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
import java.util.concurrent.TimeUnit;

import static java.lang.Integer.parseInt;

/**
 * A class handling the functionality of the window wherein the user can add individual sessions.
 *
 * @author Christian Foyer, Kamil Fischbach, Martin Rosendahl, Nina Wrona, Robert Barta
 * @version 3-10 December 2021
 */
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

  // TODO Kamil review

  /**
   * A zero-argument constructor called by the FXML Loader.
   */
  public AddSessionViewController()
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
    this.scheduleViewModel = new ScheduleViewModel(model);
    this.classGroup = model.getChosenClassGroup();
    reset();
  }

  /**
   * A getter method returning a Region object.
   *
   * @return A Region object - 'root'.
   */
  public Region getRoot()
  {
    return root;
  }

  /**
   * A void method setting labels to empty String objects and loading the lists.
   */
  public void reset()
  {
    // Clear old drop-downs
    courseChoiceBoxInAddSession.getItems().removeAll(allCoursesArray);
    startTimeChoiceBox.getItems().removeAll(timeArray);
    numberOfLessonsChoiceBox.getItems().removeAll(numberOfLessonsArray);
    roomsChoiceBox.getItems().removeAll(roomsArray);
    // set text to ""
    errorLabel.setText("");
    titleLabel
        .setText("Add a Session to " + model.getChosenClassGroup().toString());
    session = null;
    model.setChosenClassGroup(model.getChosenClassGroup());
    this.classGroup = model.getChosenClassGroup();
    courseChoiceBoxInAddSession.setValue(null);
    startTimeChoiceBox.setValue(null);
    numberOfLessonsChoiceBox.setValue(null);
    roomsChoiceBox.setValue(null);
    loadAllCourseArray();
    loadTimeArray();
    loadNumberOfLessonsArray();
  }

  /**
   * A void method that is loading all the courses into the course choice box.
   */
  private void loadAllCourseArray()
  {
    allCoursesArray.removeAll(allCoursesArray);
    // Only load the courses relevant to the selected class group
    try
    {
      ClassGroup classGroupx = classGroup;
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

  /**
   * A void method that first clears the list of Time objects
   * and then adds the legal start Time object.
   */
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

  /**
   * A void method that first clears the list of number of lessons
   * and then adds the number of lessons to the list.
   */
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

  /**
   * A void method that first clears the list of room objects
   * and then adds the list of room objects.
   */
  private void loadRoomArray()
  {
    roomsArray.removeAll(roomsArray);
    for (int i = 0; i < model.suggestRooms(session).size(); i++)
    {
      roomsArray.add(model.suggestRooms(session).get(i));
    }
    roomsArray.add(new Room());
    roomsChoiceBox.getItems().addAll(roomsArray);
  }

  /**
   * A getter method returning the value of the picked date.
   *
   * @return returns the date as a localDate.
   */
  public Date getDateFromDatePicker()
  {
    LocalDate localDate = datePicker.getValue();
    return new Date(localDate.getDayOfMonth(), localDate.getMonthValue(),
        localDate.getYear());
  }

  // @FXML methods here

  /**
   * A void FXML method that creates a Session object and finds a room for this session.
   * Afterwards it loads found rooms inside the room choice box.
   */
  @FXML private void findRoomsButton()
  {
    // Create a session using the information above, then load rooms
    errorLabel.setText("");
    roomsChoiceBox.getItems().removeAll(roomsArray);
    boolean isHolidayWeek = false;
    if (model.getHolidayWeeks() != null)
    {
      if (model.getHolidayWeeks().size() != 0)
      {

        for (int k = 0; k < model.getHolidayWeeks().size(); k++)
        {
          if (model.getHolidayWeeks().get(k) == getDateFromDatePicker()
              .getWeekNumber())
          {
            isHolidayWeek = true;
            errorLabel.setText("Chosen date is during holidays.");
          }
        }

      }
    }
    if (!isHolidayWeek)
    {
      try
      {

        session = new Session(courseChoiceBoxInAddSession.getValue(),
            getDateFromDatePicker(), startTimeChoiceBox.getValue(),
            numberOfLessonsChoiceBox.getValue());
        if (!(model.getSessionsByClassGroup(model.getChosenClassGroup())
            .isClassGroupAvailable(model.getChosenClassGroup(), session)))
        {
          errorLabel.setText("The session would overlap.");
        }
        else
        {
          //GAP checker:

          SessionList sortedSessions = model
              .getSessionsByDateAndClassGroup(getDateFromDatePicker(),
                  model.getChosenClassGroup());
          if (sortedSessions.size() > 1)
          {

            for (int i = 0; i < sortedSessions.size(); i++)
            {
              int difference =
                  sortedSessions.get(i + 1).getStartTime().getTimeInSeconds()
                      - sortedSessions.get(i).getEndTime().getTimeInSeconds();

              if (difference > 10)
              {
                if (sortedSessions.get(i).getEndTimeString().equals("11:50")
                    && difference == 55)
                {
                  loadRoomArray();
                }
                boolean gap = gapConfirmation();
                if (gapConfirmation())
                {
                  loadRoomArray();
                }
                else
                {
                  reset();
                }
              }
            }
          }
        }

        loadRoomArray();
      }
      catch (IllegalArgumentException a)
      {
        errorLabel.setText("The last lesson has to end before 18:00.");
      }
      catch (Exception e)
      {
        errorLabel.setText(e.getMessage());
      }
    }
  }

  /**
   * A boolean method asking the user to confirm.
   * It also verifies if the user wants to book a room for a session with less than 45 students.
   *
   * @return "True" when "OK" button pressed, "False" when it is not pressed.
   */
  private boolean confirmation()
  {
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Confirmation");
    alert.setHeaderText("Are you sure you want to book: " + session.getRoom()
        + " for less than 45 students?");
    Optional<ButtonType> result = alert.showAndWait();
    return (result.isPresent()) && (result.get() == ButtonType.OK);
  }

  /**
   * A void method that throws an alert warning about gaps between sessions.
   *
   * @return "True" when "OK" button pressed, "False" when it is not pressed.
   */
  private boolean gapConfirmation()
  {
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Confirmation");
    alert.setHeaderText(
        "You have a gap between the sessions. Do you want to continue?");
    Optional<ButtonType> result = alert.showAndWait();
    return (result.isPresent()) && (result.get() == ButtonType.OK);
  }

  /**
   * A void FXML method that adds a Session object to the model
   * for the chosen class if all the properties are legal.
   */
  @FXML private void addSessionButton()
  {
    if (model.isTeacherAvailable(session))
    {
      try
      {
        session.bookRoom(roomsChoiceBox.getValue());
        //model.addSession(session, roomsChoiceBox.getValue());
        if (session.getRoom() == null)
        {
          System.out.println("Hey! The room for this session is null!");
        }
        if (session.getRoom().getCapacity() > 100
            && session.getCourse().getStudents().size() < 45)
        {
          boolean book = confirmation();
          if (book)
          {
            scheduleViewModel.addSession(session);
            reset();
          }
          else
          {
            session.bookRoom(null);
          }
        }
        else
        {
          System.out.println("I put that session in room " + session.getRoom());
        }

        model.addSession(session, session.getRoom());

        //warning for an auditorium
        if (session.getRoom().getCapacity() > 100
            && session.getCourse().getStudents().size() < 45)
        {
          boolean book = confirmation();
          if (book)
          {
            scheduleViewModel.addSession(session);
          }
          else
          {
            reset();
          }
        }

        {
          scheduleViewModel.addSession(session);
        }

        SessionList sortedSessions = model
            .getSessionsByDateAndClassGroup(getDateFromDatePicker(),
                model.getChosenClassGroup());
        if (sortedSessions.size() > 1)
        {
          //SORTING BASED ON START TIME
          for (int i = 0; i < sortedSessions.size() - 1; i++)
          {
            int difference =
                sortedSessions.get(i + 1).getStartTime().getTimeInSeconds()
                    - sortedSessions.get(i).getEndTime().getTimeInSeconds();

            if (difference > 600)
            {
              if (!(sortedSessions.get(i).getEndTimeString().equals("11:50"))
                  && !(difference == 3300))
              {
                gapConfirmation();
              }
            }
          }
        }

        reset();
        viewHandler.openView("schedule");
      }
      catch (Exception e)
      {
        errorLabel.setText(e.getMessage());
        try
        {
          Thread.sleep(5000);
        }
        catch (InterruptedException interruptedException)
        {
          interruptedException.printStackTrace();
        }
        reset();
      }
    }
    else
    {
      errorLabel.setText("The teacher is not available!");
      try
      {
        Thread.sleep(5000);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
      reset();
    }
  }

  /**
   * A void FXML method closing the current view and opening schedule view.
   */
  @FXML private void cancelInAddSessionButton()
  {
    reset();
    viewHandler.closeView();
    viewHandler.openView("schedule");
  }
}
