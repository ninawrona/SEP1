package view;

import javafx.beans.property.*;
import model.basic.*;
import model.list.*;

import java.time.LocalDate;

public class SessionViewModel {
    private StringProperty courseProperty;
    private StringProperty dayOfWeekProperty;

    public SessionViewModel(Session session) {
        courseProperty = new SimpleStringProperty(session.getCourse().getName());
        LocalDate localDate = LocalDate.of(session.getDate().getYear(), session.getDate().getMonth(), session.getDate().getDay());
        dayOfWeekProperty = new SimpleStringProperty(localDate.getDayOfWeek().toString());
    }

    public String getCourseProperty() {
        return courseProperty.get();
    }

    public String getDayOfWeekProperty() {
        return dayOfWeekProperty.get();
    }
}
