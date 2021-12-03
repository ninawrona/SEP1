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
    }


    public void update(){
        list.clear();
        for(int i = 0; i<model.getSessionsByClassGroup(model.getChosenClassGroup()).size(); i++){
            list.add(new SessionViewModel(model.getSessionsByClassGroup(model.getChosenClassGroup()).get(i)));
        }

        System.out.println("Update in ScheduleViewModel" + model.getSessionsByClassGroup(model.getChosenClassGroup()));
    }

    public ObservableList<SessionViewModel> getList(){
        return list;
    }

    public void addSession(Session session){
        list.add(new SessionViewModel(session));
    }


}
