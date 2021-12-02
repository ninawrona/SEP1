package view;

import javafx.beans.property.*;
import model.basic.*;
import model.list.*;

import java.time.LocalDate;

public class SessionViewModel {
    private StringProperty courseProperty;
    private IntegerProperty dayOfWeekProperty;

    public SessionViewModel(Session session) {
        courseProperty = new SimpleStringProperty(session.getCourse().getName());
        LocalDate localDate = LocalDate.of(session.getDate().getYear(), session.getDate().getMonth(), session.getDate().getDay());
        // Set day of week as an int. 1 is Monday, 7 is Sunday
        dayOfWeekProperty = new SimpleIntegerProperty(localDate.getDayOfWeek().getValue());
    }

    public String getCourseProperty() {
        return courseProperty.get();
    }

    public int getDayOfWeekProperty() {
        return dayOfWeekProperty.get();
    }
}
