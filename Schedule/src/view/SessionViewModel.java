package view;

import javafx.beans.property.*;
import model.basic.*;
import model.list.*;

import java.time.LocalDate;

/**
 * A class creating a view for a given session.
 *
 * @author Christian Foyer, Kamil Fischbach, Martin Rosendahl, Nina Wrona, Robert Barta
 * @version 3-10 December 2021
 */
public class SessionViewModel
{

  private StringProperty courseProperty;
  private StringProperty teacherProperty;
  private IntegerProperty dayOfWeekProperty;
  private StringProperty startTimeProperty;
  private IntegerProperty startTimeIntProperty;
  private IntegerProperty numberOfLessonsProperty;
  private StringProperty fullStringProperty;
  private int timeHolder;

  /**
   * A one-argument constructor intializing all the instance variable using the given parameter.
   *
   * @param session A Session object which is used for the variables.
   */
  public SessionViewModel(Session session)
  {
    courseProperty = new SimpleStringProperty(session.shortString());

    LocalDate localDate = LocalDate
        .of(session.getDate().getYear(), session.getDate().getMonth(),
            session.getDate().getDay());

    // Set day of week as an int. 1 is Monday, 7 is Sunday
    teacherProperty = new SimpleStringProperty(
        session.getTeachers().toString());
    dayOfWeekProperty = new SimpleIntegerProperty(
        localDate.getDayOfWeek().getValue());
    startTimeProperty = new SimpleStringProperty(session.getStartTimeString());
    numberOfLessonsProperty = new SimpleIntegerProperty(
        session.getNumberOfLessons());
    fullStringProperty = new SimpleStringProperty(session.toString());
    switch (session.getStartTimeString())
    {
      case ("08:20"):
        timeHolder = 2;
        break;
      case ("09:15"):
        timeHolder = 3;
        break;
      case ("10:10"):
        timeHolder = 4;
        break;
      case ("11:05"):
        timeHolder = 5;
        break;
      case ("12:00"):
        timeHolder = 6;
        break;
      case ("12:45"):
        timeHolder = 7;
        break;
      case ("13:40"):
        timeHolder = 8;
        break;
      case ("14:35"):
        timeHolder = 9;
        break;
      case ("15:30"):
        timeHolder = 10;
        break;
      case ("16:25"):
        timeHolder = 11;
        break;
      case ("17:20"):
        timeHolder = 12;
        break;
      default:
        timeHolder = 2;
        System.out
            .println("Could not find time for timeholder (SessionViewModel)");
        break;
    }
    startTimeIntProperty = new SimpleIntegerProperty(timeHolder);
  }

  /**
   * A getter method for variable "courseProperty".
   *
   * @return A StringProperty object.
   */
  public StringProperty getCourseProperty()
  {
    return courseProperty;
  }

  /**
   * A getter method for variable "dayOfTheWeekProperty".
   *
   * @return A IntegerProperty object.
   */
  public IntegerProperty getDayOfWeekProperty()
  {
    return dayOfWeekProperty;
  }

  /**
   * A getter method for variable "startTimeProperty".
   *
   * @return An int representation of "startTimeProperty".
   */
  public int getStartTimeIntProperty()
  {
    return startTimeIntProperty.get();
  }

  /**
   * A getter method for variable "teacherProperty".
   *
   * @return A String object representation of "teacherProperty".
   */
  public String getTeacher()
  {
    return teacherProperty.toString();
  }

  /**
   * A getter method for variable "numberOfLessonsProperty".
   *
   * @return A IntegerProperty object.
   */
  public IntegerProperty getNumberOfLessonsProperty()
  {
    return numberOfLessonsProperty;
  }
}
