package model.basic;


import java.util.*;

import model.list.StudentList;
import model.list.TeacherList;

/**
 * A class representing a session. A session is a block of one or more consecutive lessons with the same teacher(s), students in the same room on the same day.
 * The length of a lesson is 45 minutes and the length of a break is 10 minutes.
 *
 * @author Christian Foyer, Kamil Fischbach, Martin Rosendahl, Nina Wrona, Robert Barta
 * @version 1 - 2 December 2021
 */
public class Session implements Comparable<Session> {
    private Course course;
    private Time startTime;
    private Date date;
    private Room room;
    private int numberOfLessons;
    public final static int LENGTHOFLESSON = 55;

    /**
     * Four-argument constructor taking a course object representing what course is taught in the given session,
     * a copy of a date object displaying the date on which the session will be held, the start time, and the number of lessons.
     *
     * @param course          name of the taught course
     * @param date            the date on which the session takes place
     * @param startTime       the time at which the session begins
     * @param numberOfLessons the number of lessons in the session
     */
    public Session(Course course, Date date, Time startTime, int numberOfLessons) {
        this.course = course;
        this.date = date.copy();
        this.startTime = startTime.copy();
        room = null;
        setNumberOfLessons(numberOfLessons);
    }

    /**
     * A void method that books a room for the session.
     *
     * @param room the preferred room to be booked for the session.
     */
    public void bookRoom(Room room) {
        this.room = room;
    }

    /**
     * A getter method returning a Room object representing the location in which the session is/will be held.
     *
     * @return a Room object
     */
    public Room getRoom() {
        return room;
    }

    /**
     * A getter method returning (a copy of) a Date object representing the date on which the session is/will be held.
     *
     * @return a Date object.
     */
    public Date getDate() {
        return date;
    }

    /**
     * A getter method returning a Course object representing the course which is/will be taught at the session.
     *
     * @return a Course object.
     */
    public Course getCourse() {
        return course;
    }

    /**
     * A getter method returning the number of lessons in the chosen session.
     *
     * @return the number of lessons.
     */
    public int getNumberOfLessons() {
        return numberOfLessons;
    }

    /**
     * A getter method returning an ArrayList of Teacher objects representing the teacher(s) who are/will be teaching at the session.
     *
     * @return an ArrayList of type TeacherList containing Teacher objects.
     */
    public TeacherList getTeachers() {
        return course.getTeachers();
    }

    /**
     * A getter method returning a Time object representing the time at which the session begins.
     *
     * @return the Time at which the session begins.
     */
    public Time getStartTime() {
        return startTime;
    }

    /**
     * A method returning a Time object representing the time at which a session ends. The end time of a session is calculated by multiplying the value of the two parameters:
     * the number of lessons with the length of a lesson(45 minutes per lesson and a 10-minute break included).
     * The result is subtracted by 10 (representing a redundant break at the end of the last lesson). The result is then converted into a valid hours and minutes format.
     *
     * @param startTime       the time at which the session starts
     * @param numberOfLessons the number of lessons the session contains
     * @return a Time object representing the time at which the session ends.
     */
    public Time getEndTime(Time startTime, int numberOfLessons) {

        int totalMinutes = numberOfLessons * LENGTHOFLESSON - 10;
        int hours = totalMinutes / 60;
        int minutes = totalMinutes % 60;

        int endHour = startTime.getHour() + hours;
        int endMinute = startTime.getMinute() + minutes;

        if (endMinute > 59) {
            endMinute = endMinute % 60;
            endHour++;
        }
        if ((startTime.getHour() <= 11 && endHour > 11)) {
            endMinute = endMinute + 45;
        }
        if (endMinute > 59) {
            endMinute = endMinute % 60;
            endHour++;
        }
        return new Time(endHour, endMinute);
    }

    /**
     * An overridden method returning the end time of a session. This method takes no parameters.  The end time of a session is calculated
     * by multiplying the number of lessons with the length of a lesson (45 minutes per lesson and a 10-minute break included).
     * The result is subtracted by 10 (representing a redundant break at the end of the last lesson). The result is then converted into a valid hours and minutes format.
     *
     * @return a Time object representing the time at which the session ends.
     */
    public Time getEndTime() {

        int totalMinutes = getNumberOfLessons() * LENGTHOFLESSON - 10;
        int hours = totalMinutes / 60;
        int minutes = totalMinutes % 60;

        int endHour = startTime.getHour() + hours;
        int endMinute = startTime.getMinute() + minutes;

        if (endMinute > 59) {
            endMinute = endMinute % 60;
            endHour++;
        }
        if ((startTime.getHour() <= 11 && endHour > 11)) {
            endMinute = endMinute + 45;
        }
        if (endMinute > 59) {
            endMinute = endMinute % 60;
            endHour++;
        }

        return new Time(endHour, endMinute);
    }

    /**
     * A method checking if two sessions are overlapped. A second Time object is created inside the method using the two parameters:
     * a Time object representing the time at which the session to be compared with begins, and an integer representing the number of lessons in that session (referred to as Session 2).
     * There are six if-statements checking for the six different possible scenarios:
     * 1. Session 1 begins and ends before Session 2 begins. This is NOT considered an overlap.
     * 2. Session 1 begins before Session 2 and ends after Session 2 begins. This is considered an overlap.
     * 3. Session 1 begins after Session 2 begins and ends before Session 2 ends. This is considered an overlap.
     * 4. Session 2 begins and ends before Session 1 begins. This is NOT considered an overlap.
     * 5. Session 2 begins after Session 1 begins and ends before Session 1 ends. This is considered an overlap.
     * 6. Session 2 begins before Session 1 and ends after Session 1 begins. This is considered an overlap.
     * 7. Session 1 and Session 2 begin at the same time.
     * 8. Session 1 and Session 2 ends at the same time.
     *
     * @param timeStart       the time at which Session 2 starts.
     * @param numberOfLessons the number of lessons inside Session 2.
     * @return "True" for scenario 2, 3, 5, 6, 7 and 8, or "False" for scenario 1 and 4.
     */
    public boolean isOverlapped(Time timeStart, int numberOfLessons) {
        Time endTime2 = getEndTime(timeStart, numberOfLessons);

        if ((startTime.isBefore(timeStart) && (startTime.isBefore(endTime2))
                && getEndTime().isBefore(timeStart) && getEndTime().isBefore(
                endTime2))) //Session 1 ends before Session 2 begins
        {
            return false;
        } else if ((startTime.isBefore(timeStart) && (startTime.isBefore(endTime2))
                && !(getEndTime().isBefore(timeStart)) && getEndTime().isBefore(
                endTime2))) // Session 1 extends into Session 2
        {
            return true;
        } else if (timeStart.isBefore(startTime) && timeStart.isBefore(getEndTime())
                && !(endTime2.isBefore(startTime)) && !(endTime2.isBefore(
                getEndTime()))) //Session 1 begins and ends inside Session 2
        {
            return true;
        } else if (timeStart.isBefore(startTime) && timeStart.isBefore(getEndTime())
                && endTime2.isBefore(startTime) && endTime2.isBefore(
                getEndTime())) // Session 2 ends before Session 1 begins
        {
            return false;
        } else if ((startTime.isBefore(startTime) && (startTime.isBefore(endTime2))
                && !(getEndTime().isBefore(timeStart)) && !(getEndTime().isBefore(
                endTime2)))) // Session 2 begins and ends inside Session 1
        {
            return true;
        } else if ((timeStart.isBefore(startTime) && timeStart.isBefore(getEndTime())
                && !(endTime2.isBefore(startTime)) && endTime2.isBefore(
                getEndTime())))//Session 2 extends into Session 1//
        {
            return true;
        } else if (timeStart.getTimeInSeconds()
                == startTime.getTimeInSeconds()) //Session 1 and Session 2 begin at the same time

        {
            return true;
        }
        return (endTime2.getTimeInSeconds()
                == getEndTime().getTimeInSeconds()); //Session 1 and 2 end at the same time
    }

    /**
     * An overridden method checking if the current session and the one from the parameter (referred to as Session 2) are overlapped.
     * There are seven if-statements checking for the nine different possible scenarios:
     * 1. Session 1 begins and ends before Session 2 begins. This is NOT considered an overlap.
     * 2. Session 1 begins before Session 2 and ends after Session 2 begins. This is considered an overlap.
     * 3. Session 1 begins after Session 2 begins and ends before Session 2 ends. This is considered an overlap.
     * 4. Session 2 begins and ends before Session 1 begins. This is NOT considered an overlap.
     * 5. Session 2 begins after Session 1 begins and ends before Session 1 ends. This is considered an overlap.
     * 6. Session 2 begins before Session 1 and ends after Session 1 begins. This is considered an overlap.
     * 7. Session 1 and Session 2 begin at the same time.
     * 8. Session 1 and Session 2 end at the same time.
     * 9. Session 1 and Session 2 are on two different dates.
     *
     * @param other an object of type Session representing Session 2.
     * @return "True" for scenario 2, 3, 5, 6, 7 and 8, or "False" for scenario 1, 4 and 9.
     */
    public boolean isOverlapped(Session other) {
        if (getDate().equals(other.getDate())) {

            if ((startTime.isBefore(other.getStartTime()) && (startTime.isBefore(
                    other.getEndTime())) && getEndTime().isBefore(other.getStartTime())
                    && getEndTime().isBefore(
                    other.getEndTime()))) //Session 1 ends before Session 2 begins
            {
                return false;
            } else if ((startTime.isBefore(other.getStartTime()) && (startTime.isBefore(
                    other.getEndTime())) && !(getEndTime().isBefore(other.getStartTime()))
                    && getEndTime().isBefore(
                    other.getEndTime()))) // Session 1 extends into Session 2
            {
                return true;
            } else if (other.startTime.isBefore(startTime) && other.startTime.isBefore(
                    getEndTime()) && !(other.getEndTime().isBefore(startTime))
                    && !(other.getEndTime()
                    .isBefore(getEndTime()))) //Session 1 begins and ends inside Session 2
            {
                return false;
            } else if ((startTime.isBefore(other.getStartTime()) && (startTime.isBefore(
                    other.getEndTime())) && !(getEndTime().isBefore(other.getStartTime()))
                    && !(getEndTime().isBefore(
                    other.getEndTime())))) // Session 2 begins and ends inside Session 1
            {
                return true;
            } else if (other.startTime.isBefore(startTime) && other.startTime.isBefore(
                    getEndTime()) && other.getEndTime().isBefore(startTime)
                    && other.getEndTime()
                    .isBefore(getEndTime())) // Session 2 ends before Session 1 begins
            {
                return false;
            } else if ((other.startTime.isBefore(startTime) && other.startTime.isBefore(
                    getEndTime()) && !(other.getEndTime().isBefore(startTime))
                    && other.getEndTime()
                    .isBefore(getEndTime())))//Session 2 extends into Session 1
            {
                return true;
            } else if (startTime.getTimeInSeconds()
                    == other.startTime.getTimeInSeconds()) //Session 1 and Session 2 start at the same time
            {
                return true;
            } else
                return (getEndTime().getTimeInSeconds() == other.getEndTime()
                        .getTimeInSeconds()); //Session 1 and Session 2 end at the same time
        }
        return false;
    }

    /**
     * A setter method setting the number of lessons for a session. The method will throw an exception if
     * the number of lessons would push the end of the session outside the valid time-frame: 8:20-17:55.
     * Normally the lunch break is not considered as a slot for lessons, but it is possible to book it, with a maximum of 7 lessons, ending at 17:55
     *
     * @param numberOfLessons the number of lessons to be set for the session.
     */
    public void setNumberOfLessons(int numberOfLessons) {
        if (startTime.getHour() == 8 && startTime.getMinute() == 20
                && numberOfLessons > 10) {
            throw new IllegalArgumentException(
                    "There cannot be more than 10 lessons from 08:20.");
        } else if (startTime.getHour() == 9 && startTime.getMinute() == 15
                && numberOfLessons > 9) {
            throw new IllegalArgumentException(
                    "There cannot be more than 9 lessons from 09:15.");
        } else if (startTime.getHour() == 10 && startTime.getMinute() == 10
                && numberOfLessons > 8) {
            throw new IllegalArgumentException(
                    "There cannot be more than 8 lessons from 10:10.");
        } else if (startTime.getHour() == 11 && startTime.getMinute() == 5
                && numberOfLessons > 7) {
            throw new IllegalArgumentException(
                    "There cannot be more than 7 lessons from 11:05.");
        } else if (startTime.getHour() == 12 && startTime.getMinute() == 45
                && numberOfLessons > 6) {
            throw new IllegalArgumentException(
                    "There cannot be more than 6 lessons from 12:45.");
        } else if (startTime.getHour() == 13 && startTime.getMinute() == 40
                && numberOfLessons > 5) {
            throw new IllegalArgumentException(
                    "There cannot be more than 5 lessons from 13:40.");
        } else if (startTime.getHour() == 14 && startTime.getMinute() == 35
                && numberOfLessons > 4) {
            throw new IllegalArgumentException(
                    "There cannot be more than 4 lessons from 14:35.");
        } else if (startTime.getHour() == 15 && startTime.getMinute() == 30
                && numberOfLessons > 3) {
            throw new IllegalArgumentException(
                    "There cannot be more than 3 lessons from 15:30.");
        } else if (startTime.getHour() == 16 && startTime.getMinute() == 25
                && numberOfLessons > 2) {
            throw new IllegalArgumentException(
                    "There cannot be more than 2 lessons from 16:25.");
        } else if (startTime.getHour() == 17 && startTime.getMinute() == 20
                && numberOfLessons > 1) {
            throw new IllegalArgumentException(
                    "There cannot be more than 1 lessons from 17:20.");
        } else if (startTime.getHour() == 12 && startTime.getMinute() == 0
                && numberOfLessons > 7) {
            throw new IllegalArgumentException(
                    "There cannot be more than 7 lessons from 12:00.");
        }
        this.numberOfLessons = numberOfLessons;
    }

    /**
     * A method returning a String representation of the session's start time in a "hh:mm" format.
     *
     * @return a string representing the start time of the session.
     */
    public String getStartTimeString() {
        String s = "";
        if (startTime.getHour() < 10) {
            s += "0";
        }
        s += startTime.getHour() + ":";
        if (startTime.getMinute() < 10) {
            s += "0";
        }
        s += startTime.getMinute();
        return s;
    }

    /**
     * A method calculating and returning a String representation of the session's end time in a "hh:mm" format.
     * The end time of a session is calculated by multiplying the number of lessons with the length of a lesson (45 minutes per lesson and a 10-minute break included).
     * The result is subtracted by 10 (representing a redundant break at the end of the last lesson). The result is then converted into a valid hours and minutes format.
     * In case of booking a session through the lunch break, 10 more minutes are subtracted; no break after the lesson of 12:00-12:45.
     *
     * @return a string representing the time at which the session ends.
     */

    public String getEndTimeString() {
        int totalMinutes = getNumberOfLessons() * 55 - 10;
        int hours = totalMinutes / 60;
        int minutes = totalMinutes % 60;

        int endHour = startTime.getHour() + hours;
        int endMinute = startTime.getMinute() + minutes;

        if (startTime.getHour() <= 12 && startTime.getMinute() != 45
                && endHour >= 12) { //If the lunch session is also booked, the session will be 10 minutes shorter.
            endMinute -= 10;
        }

        if (endMinute > 59) {
            endMinute = endMinute % 60;
            endHour++;
        }
        if ((startTime.getHour() <= 11 && endHour > 11)) {
            endMinute = endMinute + 45;
        }
        if (endMinute > 59) {
            endMinute = endMinute % 60;
            endHour++;
        }

        String s = "";
        if (endHour < 10) {
            s += "0";
        }
        s += endHour + ":";
        if (endMinute < 10) {
            s += "0";
        }
        s += endMinute;
        return s;

    }



    /**
     * Method for making a copy of Session
     * @param otherDate date of the other session
     * @return Returns a copy of Session with another date
     */
    public Session copySessionToDate(Date otherDate) {
        Session other = new Session(course, otherDate, startTime, numberOfLessons);
        other.bookRoom(room);
        return other;
    }

    /**
     * A method returning the string representation of the session's details.
     *
     * @return A string containing the name of the course, the class group, the start time,
     * the number of lessons, the end time and the room (or unassigned room) of a session.
     */

    public String toString() {
        String str =
                "Session{" + "Course= " + course + ", Class= " + course.getClassGroup()
                        + ", Start Time= " + startTime + ", Number of Lessons= "
                        + numberOfLessons + ", End Time = " + getEndTime() + ", Room= ";
        if (room == null) {
            str += "unassigned}";
        } else {
            str += room + "}";
        }

        return str;
    }

    /**
     * A method comparing two Session objects.
     *
     * @param obj an object representing the other object to be compared.
     * @return "True" if the compared Session objects are the same, or "False" if they are different objects.
     */
    public boolean equals(Object obj) {
        if (!(obj instanceof Session)) {
            return false;
        }

        Session other = (Session) obj;
        return course.equals(other.course) && startTime.equals(other.startTime)
                && room.equals(other.room) && date.equals(other.date)
                && numberOfLessons == other.numberOfLessons;
    }

    /**
     * A shortened toString() method
     * @return returns a String containing course name, date, and room or "unassigned" if room is null
     */
    public String shortString() {
        String str = "";
        str += course.getName() + "\n" + date + "\n";
        if (room == null) {
            str += "unassigned";
        } else {
            str += room;
        }
        return str;
    }

    /**
     * Method for comparing sessions
     * @param obj is a Session object
     * @return returns a different  number depending on the values of the start times in seconds
     */
    @Override
    public int compareTo(Session obj) {
        if (startTime.getTimeInSeconds() == obj.startTime.getTimeInSeconds()) {
            return 0;
        } else if (startTime.getTimeInSeconds() > obj.startTime.getTimeInSeconds()) {
            return 1;
        } else
            return -1;

    }
}


