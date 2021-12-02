package view;

import javafx.beans.property.*;
import model.basic.*;
import model.list.*;

import java.time.LocalDate;

public class SessionViewModel {
    private StringProperty courseProperty;
    private IntegerProperty dayOfWeekProperty;
    private IntegerProperty startHourProperty;
    private IntegerProperty startMinuteProperty;
    private IntegerProperty numberOfLessonsProperty;

    public SessionViewModel(Session session) {
        courseProperty = new SimpleStringProperty(session.getCourse().getName());
        LocalDate localDate = LocalDate.of(session.getDate().getYear(), session.getDate().getMonth(), session.getDate().getDay());
        // Set day of week as an int. 1 is Monday, 7 is Sunday
        dayOfWeekProperty = new SimpleIntegerProperty(localDate.getDayOfWeek().getValue());
        startHourProperty = new SimpleIntegerProperty(session.getStartTime().getHour());
        startMinuteProperty = new SimpleIntegerProperty(session.getStartTime().getMinute());
        numberOfLessonsProperty = new SimpleIntegerProperty(session.getNumberOfLessons());
    }

    public String getCourseProperty() {
        return courseProperty.get();
    }

    public int getDayOfWeekProperty() {
        return dayOfWeekProperty.get();
    }

    public int getStartHourProperty() {
        return startHourProperty.get();
    }

    public int getStartMinuteProperty() {
        return startMinuteProperty.get();
    }

    public int getNumberOfLessonsProperty() {
        return numberOfLessonsProperty.get();
    }
}
