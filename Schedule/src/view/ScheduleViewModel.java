package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.basic.Date;
import model.basic.Session;
import model.basic.Time;
import model.list.ScheduleModel;
import model.list.SessionList;

public class ScheduleViewModel
{

  private ObservableList<SessionViewModel> list;
  private ScheduleModel model;

  public ScheduleViewModel(ScheduleModel model)
  {
    this.model = model;
    this.list = FXCollections.observableArrayList();
    update();
  }

  public ObservableList<SessionViewModel> getListByClassGroup()
  {
    ObservableList<SessionViewModel> holder = FXCollections
        .observableArrayList();
    for (int i = 0;
         i < model.getSessionsByClassGroup(model.getChosenClassGroup())
             .size(); i++)
    {
      holder.add(new SessionViewModel(
          model.getSessionsByClassGroup(model.getChosenClassGroup()).get(i)));
    }
    return holder;
  }

  // The goal is to find all sessions from monday to Friday for a given class
  public ObservableList<SessionViewModel> getListByDateAndClassGroup()
  {
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

  public ObservableList<SessionViewModel> getList()
  {
    return list;
  }

  public void addSession(Session session)
  {
    list.add(new SessionViewModel(session));
  }
}
