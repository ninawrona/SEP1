
package view;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.basic.Session;
import model.list.ScheduleModel;

public class ScheduleListViewModel {
    private ObservableList<ScheduleModel> list;
    private ScheduleModel model;

    public ScheduleListViewModel(ScheduleModel model) {
        this.model = model;
        this.list = FXCollections.observableArrayList();
        update();
    }

    public ObservableList<ScheduleModel> getList() {
        return list;
    }

    public void update() {
        list.clear();
        for (int i = 0; i < model.sessionListSize(); i++) {
            list.add(new ScheduleViewModel(model.getSession));
        }
    }

    public void add(Session session) {
        list.add(new ScheduleModel(session));
    }

    public void remove(Session session) {
        for (int i = 0; i < list.size(); i++) {
            switch (session.getDate().getWeekday()) {
                case "MONDAY":
                    if (list.get(i).getTimeProperty.get().equals(session.getStartTime())
                            && list.get(i).getMondayProperty.get().equals(session.getDate().getWeekday())) {
                        list.remove(i);
                        break;
                    }
                case "TUESDAY":
                    if (list.get(i).getTimeProperty.get().equals(session.getStartTime())
                            && list.get(i).getTuesdayProperty.get().equals(session.getDate().getWeekday())) {
                        list.remove(i);
                        break;
                    }
                case "WEDNESDAY":
                    if (list.get(i).getTimeProperty.get().equals(session.getStartTime())
                            && list.get(i).getWednesdayProperty.get().equals(session.getDate().getWeekday())) {
                        list.remove(i);
                        break;
                    }
                case "THURSDAY":
                    if (list.get(i).getTimeProperty.get().equals(session.getStartTime())
                            && list.get(i).getThursdayProperty.get().equals(session.getDate().getWeekday())) {
                        list.remove(i);
                        break;
                    }
                case "FRIDAY":
                    if (list.get(i).getTimeProperty.get().equals(session.getStartTime())
                            && list.get(i).getFridayProperty.get().equals(session.getDate().getWeekday())) {
                        list.remove(i);
                        break;
                    }
            }

        }

    }
}