package view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import model.basic.Date;
import model.basic.Session;
import model.list.*;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.ArrayList;

/**
 * A class allowing the user to pick a date to mimic up to.
 * It also allows to pick which weeks will be holidays.
 *
 * @author Christian Foyer, Kamil Fischbach, Martin Rosendahl, Nina Wrona, Robert Barta
 * @version 3-10 December 2021
 */
public class MimicScheduleViewController
{
  @FXML private Label errorLabel;
  @FXML private DatePicker datePicker;
  @FXML private ListView holidayPicker;

  private int chosenWeekNumber;
  ArrayList<Integer> weekArray = new ArrayList<>();
  ArrayList<Integer> weekHoliday = new ArrayList<>();

  private ScheduleModel model;
  private ViewHandler viewHandler;
  private Region root;

  /**
   * A zero-argument constructor called by FXML Loader.
   */
  public MimicScheduleViewController()
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
    this.model = model;
    this.root = root;
    holidayPicker.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    this.chosenWeekNumber = 0;
    reset();

  }

  /**
   * A getter method of Region object.
   *
   * @return A Region object - 'root'.
   */
  public Region getRoot()
  {
    return root;
  }

  /**
   * A void method setting the error label to empty String and loading the holiday picker.
   */
  public void reset()
  {
    errorLabel.setText("");
    loadHolidayPicker();
  }

  /**
   * A void method loading number from 1 to 52 into the holiday picker.
   */
  public void loadHolidayPicker()
  {
    weekArray.remove(weekArray);
    for (int i = 1; i <= 52; i++)
    {
      weekArray.add(i);
    }
    if (weekArray.size() != 0)
    {
      holidayPicker.getItems().addAll(weekArray);
    }
  }

  /**
   * A void FXML method confirming the choices, setting the holidays and mimicking the schedule.
   */
  @FXML private void confirmButton()
  {
    // Do the holidays here
    for (int i = 0;
         i < holidayPicker.getSelectionModel().getSelectedIndices().size(); i++)
    {
      weekHoliday.add(Integer.parseInt(
          holidayPicker.getSelectionModel().getSelectedIndices().get(i)
              .toString()) + 1);
    }
    System.out.println(weekHoliday);
    model.setHolidayWeeks(weekHoliday);

    // Do the mimicking here
    LocalDate date = datePicker.getValue();
    chosenWeekNumber = date.get(ChronoField.ALIGNED_WEEK_OF_YEAR);
    LocalDate mondayHolder = date;
    while (mondayHolder.getDayOfWeek().getValue() != 1)
    {
      System.out.println(mondayHolder);
      mondayHolder = mondayHolder.minusDays(1);
      System.out.println("I just moved back one day");
      System.out.println("Holder is now " + mondayHolder);
    }
    // Monday Holder is now the monday of the week that is targeted to end the mimic
    Date monday = new Date(mondayHolder.getDayOfMonth(),
        mondayHolder.getMonthValue(), mondayHolder.getYear());
    System.out.println("I just set the Monday to " + monday);
    Date endMonday = monday.copy();
    endMonday.stepForward(7);
    Date startMonday = model.getChosenMonday().copy();
    startMonday.stepForward(7);
    Date dateHolder = model.getChosenMonday().copy();

    while (!startMonday.equals(endMonday))
    {
      boolean isHoliday = false;
      if (startMonday.getWeekday().equals("MONDAY"))
      {
        for (int j = 0; j < weekHoliday.size(); j++)
        {
          if (startMonday.getWeekNumber() == weekHoliday.get(j))
          {
            startMonday.stepForward(7);
            isHoliday = true;
            break;
          }
        }
      }
      if (!isHoliday)
      {
        SessionList sessionListForDay = model.getSessionsByDateAndClassGroup(
            dateHolder, model.getChosenClassGroup());
        for (int i = 0; i < sessionListForDay.size(); i++)
        {
          Session sessionCopy = sessionListForDay.get(i)
              .copySessionToDate(startMonday);
          model.addSession(sessionCopy, sessionCopy.getRoom());
          System.out.println("Session added to model: " + sessionCopy);
        }
        System.out.println("Moving origin date");
        System.out.println("Old origin: " + dateHolder + ", weekday : "
            + dateHolder.getWeekday());
        dateHolder.stepForwardOneDay();
        System.out.println("New origin: " + dateHolder + ", weekday : "
            + dateHolder.getWeekday());
        System.out.println("Moving target date");
        System.out.println("Old target: " + startMonday + ", weekday : "
            + startMonday.getWeekday());
        startMonday.stepForwardOneDay();
        System.out.println("New target: " + startMonday + ", weekday : "
            + startMonday.getWeekday());

        if (startMonday.getWeekday().equals("SATURDAY"))
        {
          System.out.println(
              "I got to Saturday! Moving origin back to Monday and target forward to Monday");
          dateHolder = model.getChosenMonday().copy();
          startMonday.stepForward(2);
          System.out.println("New origin: " + dateHolder + ", weekday : "
              + dateHolder.getWeekday());
          System.out.println("New target: " + startMonday + ", weekday : "
              + startMonday.getWeekday());

        }
      }
    }

    //Then we are closing the view and openingView
    viewHandler.openView("schedule");
  }

  /**
   * A void FXML method closing the current view and opening schedule view.
   */
  @FXML private void cancelButton()
  {
    viewHandler.openView("schedule");
  }
}
