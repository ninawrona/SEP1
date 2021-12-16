package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.basic.Date;
import model.basic.Session;
import model.basic.Time;
import model.list.ScheduleModel;
import model.list.SessionList;

/**
 * A class supporting the display of the schedule.
 *
 * @author Christian Foyer, Kamil Fischbach, Martin Rosendahl, Nina Wrona, Robert Barta
 * @version 3-10 December 2021
 */
public class ScheduleViewModel
{

  private ObservableList<SessionViewModel> list;
  private ScheduleModel model;

  /**
   * A one-argument constructor intializing all the instance variables.
   *
   * @param model A ScheduleModel object which is used to set this class "model"  variable.
   */
  public ScheduleViewModel(ScheduleModel model)
  {
    this.model = model;
    this.list = FXCollections.observableArrayList();
    update();
  }

  /**
   * A method which gets all the sessions from Monday until Friday for the chosen class from the model.
   *
   * @return An ObservableList<SessionViewModel> object containing all the sessions by this date and ClassGroup.
   */
  public ObservableList<SessionViewModel> getListByDateAndClassGroup()
  {
    // The goal is to find all sessions from monday to Friday for a given class
    ObservableList<SessionViewModel> holder = FXCollections
        .observableArrayList();
    Date dateHolder = model.getChosenMonday().copy();
    // Advance the day from Monday
    for (int i = 0; i < 5; i++)
    {
      // Loop through list by date and classGroup
      if (model.getSessionsByDateAndClassGroup(dateHolder,
          model.getChosenClassGroup()) != null)
      {
        for (int j = 0; j < model.getSessionsByDateAndClassGroup(dateHolder,
            model.getChosenClassGroup()).size(); j++)
        {
          holder.add(new SessionViewModel(model
              .getSessionsByDateAndClassGroup(dateHolder,
                  model.getChosenClassGroup()).get(j)));
        }
      }
      dateHolder.stepForward(1);
    }
    return holder;
  }

  /**
   * A method which gets all the sessions from Monday until Friday for the chosen teacher from the model.
   * @return an ObservableList<SessionViewModel> object containing all the sessions by this teacher.
   */
  public ObservableList<SessionViewModel> getListByTeacher()
  {
    // The goal is to find all sessions from monday to Friday for a given teacher
    ObservableList<SessionViewModel> holder = FXCollections
        .observableArrayList();
    Date dateHolder = model.getChosenMonday().copy();
    // Advance the day from Monday
    for (int i = 0; i < 5; i++)
    {
      // Loop through list by date and teacher
      if (model.getSessionsByDateAndTeacher(dateHolder,
          model.getChosenTeacher()) != null)
      {
        for (int j = 0; j < model.getSessionsByDateAndTeacher(dateHolder,
            model.getChosenTeacher()).size(); j++)
        {
          holder.add(new SessionViewModel(model
              .getSessionsByDateAndTeacher(dateHolder,
                  model.getChosenTeacher()).get(j)));
        }
      }
      dateHolder.stepForward(1);
    }
    return holder;
  }

  /**
   * A void method clearing and updating the list.
   */
  public void update()
  {
    list.clear();

    try
    {
      list.addAll(getListByDateAndClassGroup());
    }
    catch (IllegalArgumentException e)
    {
      System.out.println("The class is not set yet, or sessions don't exist");
    }
    catch (NullPointerException e)
    {
      System.out.println("That class does not have sessions yet");
    }

  }

  /**
   * A getter method for the list.
   *
   * @return An ObservableList<SessionViewModel> object.
   */
  public ObservableList<SessionViewModel> getList()
  {
    return list;
  }

  /**
   * A void method adding a session to the list.
   *
   * @param session A Session object which is added to the list.
   */
  public void addSession(Session session)
  {
    list.add(new SessionViewModel(session));
  }
}
