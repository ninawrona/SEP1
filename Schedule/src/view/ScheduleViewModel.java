package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.basic.Session;
import model.basic.Time;
import model.list.ScheduleModel;

public class ScheduleViewModel {

    private ObservableList<SessionViewModel> list;
    private ScheduleModel model;



    public ScheduleViewModel(ScheduleModel model){
        this.model = model;
        this.list = FXCollections.observableArrayList();
        update();
    }


    public void update(){
        list.clear();
        try
        {
          for (int i = 0; i < model.getSessionsByClassGroup(model.getChosenClassGroup())
              .size(); i++)
          {
            list.add(new SessionViewModel(
                model.getSessionsByClassGroup(model.getChosenClassGroup()).get(i)));
            System.out.println(
                "I just added a session to the list in scheduleViewModel!");
            System.out.println("Update in ScheduleViewModel" + model.getSessionsByClassGroup(model.getChosenClassGroup()));
          }
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

    public ObservableList<SessionViewModel> getList(){
        return list;
    }

    public void addSession(Session session){
        list.add(new SessionViewModel(session));
    }
}
