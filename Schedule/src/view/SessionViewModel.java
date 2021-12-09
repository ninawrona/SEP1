package view;

import javafx.beans.property.*;
import model.basic.*;
import model.list.*;

import java.time.LocalDate;

public class SessionViewModel
{

  private StringProperty courseProperty;
  private IntegerProperty dayOfWeekProperty;
  private StringProperty startTimeProperty;
  private IntegerProperty startTimeIntProperty;
  private IntegerProperty numberOfLessonsProperty;
  private StringProperty fullStringProperty;
  private int timeHolder;

  public SessionViewModel(Session session)
  {
    courseProperty = new SimpleStringProperty(session.shortString());

    LocalDate localDate = LocalDate.of(session.getDate().getYear(),
        session.getDate().getMonth(), session.getDate().getDay());
    // Set day of week as an int. 1 is Monday, 7 is Sunday
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
        System.out.println("Could not find time for timeholder (SessionViewModel)");
        break;
    }
    startTimeIntProperty = new SimpleIntegerProperty(timeHolder);
  }

  public StringProperty getCourseProperty()
  {
    return courseProperty;
  }

  public IntegerProperty getDayOfWeekProperty()
  {
    return dayOfWeekProperty;
  }

  public StringProperty getStartTimeProperty()
  {
    return startTimeProperty;
  }

  public int getStartTimeIntProperty() {
    return startTimeIntProperty.get();
  }

  public IntegerProperty getNumberOfLessonsProperty()
  {
    return numberOfLessonsProperty;
  }
}
