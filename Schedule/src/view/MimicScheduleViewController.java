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

  public MimicScheduleViewController()
  {
    // Called by FXMLLoader
  }

    public void init(ViewHandler viewHandler, ScheduleModel model, Region root)
    {
        this.viewHandler = viewHandler;
        this.model = model;
        this.root = root;
        holidayPicker.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        reset();

    }

  public Region getRoot()
  {
    return root;
  }

    public void reset()
    {
        errorLabel.setText("");
        loadHolidayPicker();
    }

    public void loadHolidayPicker()
    {
        weekArray.remove(weekArray);
        for(int i=1; i<=52; i++)
        {
            weekArray.add(i);
        }
        if(weekArray.size()!=0)
        {
            holidayPicker.getItems().addAll(weekArray);
        }
    }

  @FXML void confirmButton()
  {
    // Do the holidays here
    for(int i=0; i<holidayPicker.getSelectionModel().getSelectedIndices().size(); i++)
    {
      weekHoliday.add(Integer.parseInt(holidayPicker.getSelectionModel().getSelectedIndices().get(i).toString())+1);
    }
    System.out.println(weekHoliday);



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
        SessionList sessionListForDay = model
            .getSessionsByDateAndClassGroup(dateHolder, model.getChosenClassGroup());
        for (int i = 0; i < sessionListForDay.size(); i++)
        {
          Session sessionCopy = sessionListForDay.get(i).copySessionToDate(startMonday);
          model.addSession(sessionCopy, sessionCopy.getRoom());
          System.out.println("Session added to model: " + sessionCopy);
        }
        System.out.println("Moving origin date");
        System.out.println(
            "Old origin: " + dateHolder + ", weekday : " + dateHolder.getWeekday());
        dateHolder.stepForwardOneDay();
        System.out.println(
            "New origin: " + dateHolder + ", weekday : " + dateHolder.getWeekday());
        System.out.println("Moving target date");
        System.out.println(
            "Old target: " + startMonday + ", weekday : " + startMonday.getWeekday());
        startMonday.stepForwardOneDay();
        System.out.println(
            "New target: " + startMonday + ", weekday : " + startMonday.getWeekday());

        if (startMonday.getWeekday().equals("SATURDAY"))
        {
          System.out.println(
              "I got to Saturday! Moving origin back to Monday and target forward to Monday");
          dateHolder = model.getChosenMonday().copy();
          startMonday.stepForward(2);
          System.out.println(
              "New origin: " + dateHolder + ", weekday : " + dateHolder.getWeekday());
          System.out.println(
              "New target: " + startMonday + ", weekday : " + startMonday.getWeekday());

        }
      }
    }

    //Then we are closing the view and openingView
    viewHandler.openView("schedule");
  }

  @FXML void cancelButton()
  {
    viewHandler.openView("schedule");
  }
}
