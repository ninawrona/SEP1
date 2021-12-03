package view;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.basic.Session;
import model.list.ScheduleModel;

import javax.lang.model.util.ElementScanner6;

public class ScheduleViewModel {

    private ObservableList<SessionViewModel> list;
    private ScheduleModel model;


    public ScheduleViewModel(ScheduleModel model){
        this.model = model;
        this.list = FXCollections.observableArrayList();
        update();


        /*timeProperty = new SimpleStringProperty(session.getStartTimeString());
        try {
            switch (session.getDate().getWeekday()){
                case "MONDAY":
                    mondayProperty = new SimpleStringProperty(session.toString());
                case "TUESDAY":
                    tuesdayProperty = new SimpleStringProperty(session.toString());
                case "WEDNESDAY":
                    wednesdayProperty = new SimpleStringProperty(session.toString());
                case "THURSDAY":
                    thursdayProperty = new SimpleStringProperty(session.toString());
                case "FRIDAY":
                    fridayProperty = new SimpleStringProperty(session.toString());
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }*/
    }

   /* public StringProperty getTimeProperty(){
        return timeProperty;
    }

    public StringProperty getMondayProperty(){
        return mondayProperty;
    }

    public StringProperty getTuesdayProperty(){
        return tuesdayProperty;
    }

    public StringProperty getWednesdayProperty(){
        return wednesdayProperty;
    }

    public StringProperty getThursdayProperty(){
        return thursdayProperty;
    }

    public StringProperty getFridayProperty(){
        return fridayProperty;
    }
*/

    public void update(){
        list.clear();
        for(int i = 0; i<model.getSessionsByClassGroup(model.getChosenClassGroup()).size(); i++){
            list.add(new SessionViewModel(model.getSessionsByClassGroup(model.getChosenClassGroup()).get(i)));
        }
    }

    public ObservableList<SessionViewModel> getList(){
        return list;
    }

    public void addSession(Session session){
        list.add(new SessionViewModel(session));
    }


}
