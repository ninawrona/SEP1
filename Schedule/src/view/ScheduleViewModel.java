package view;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.basic.Session;

import javax.lang.model.util.ElementScanner6;

public class ScheduleViewModel {
    private StringProperty timeProperty;
    private StringProperty mondayProperty;
    private StringProperty tuesdayProperty;
    private StringProperty wednesdayProperty;
    private StringProperty thursdayProperty;
    private StringProperty fridayProperty;


    public ScheduleViewModel(Session session){
        timeProperty = new SimpleStringProperty(session.getStartTimeString());
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
        }
    }

    public StringProperty getTimeProperty(){
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

}
