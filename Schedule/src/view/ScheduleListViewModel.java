
package view;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.basic.ClassGroup;
import model.basic.Session;
import model.list.ScheduleModel;

public class ScheduleListViewModel {
    private ObservableList<SessionViewModel> list;
    private ScheduleModel model;
    // We should have a class group to specify which schedule we are looking at
    private ClassGroup classGroup;

    public ScheduleListViewModel(ScheduleModel model, ClassGroup classGroup) {
        this.model = model;
        // Trying a different list implementation
        this.list = FXCollections.observableArrayList();
        this.classGroup = classGroup;

        update();
    }

    public ObservableList<SessionViewModel> getList() {
        return list;
    }

    public void update() {
        list.clear();
        for (int i = 0; i < model.getSessionsByClassGroup(classGroup).size(); i++) {
            list.add(new SessionViewModel(model.getSessionsByClassGroup(classGroup).get(i)));
        }
    }

    public void add(Session session) {
        list.add(new SessionViewModel(session));
    }

    /* to do
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

     */

}