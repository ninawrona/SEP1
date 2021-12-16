package model.list;

import model.basic.*;
import model.files.ReadWrite;

import java.io.File;
import java.util.ArrayList;

/**
 * A class implementing all the methods from ScheduleModel interface.
 * It also has all the needed associations as instance variables.
 *
 * @author Christian Foyer, Kamil Fischbach, Martin Rosendahl, Nina Wrona, Robert Barta
 * @version 3 - December 2021
 */
public class ScheduleModelManager implements ScheduleModel {
    private TeacherList allTeachers;
    private CourseList courseList;
    private SessionList sessionList;
    private ClassGroupList classList;
    private StudentList studentList;
    private RoomList roomList;
    private ClassGroup chosenClassGroup;
    private Session chosenSession;
    private int chosenWeekNumber;
    private ArrayList<Integer> holidayWeeks;
    private Date chosenMonday;
    private Teacher chosenTeacher;


    /**
     * A constructor taking no arguments that initializes all the instance variables -
     * - either creating a new list object or set the values to default.
     */
    public ScheduleModelManager() {
        this.allTeachers = new TeacherList();
        this.courseList = new CourseList();
        this.sessionList = new SessionList();
        this.classList = new ClassGroupList();
        this.studentList = new StudentList();
        this.roomList = new RoomList();
        this.chosenClassGroup = null;
        this.chosenSession = null;
        this.chosenWeekNumber = 0;
        this.holidayWeeks = null;
        this.chosenMonday = null;
        this.chosenTeacher = null;

    }

    /**
     * A getter method returning all classes in this object.
     *
     * @return ClassGroupList object containing all the ClassGroup objects in this ScheduleModelManager.
     */

    public ClassGroupList getAllClasses() {
        return classList;
    }

    /**
     * A getter method returning all teachers in this object.
     *
     * @return TeacherList object containing all the Teacher objects in this ScheduleModelManager.
     */

    public TeacherList getAllTeachers() {
        return allTeachers;
    }

    /**
     *A getter method returning the sessions by a given teacher
     * @param date a Date object representing the date.
     * @param teacher a Teacher object representing the teacher
     * @return a SessionList with the same teachers and date.
     */
    @Override public SessionList getSessionsByDateAndTeacher(Date date,
        Teacher teacher)
    {
        return sessionList.getSessionsByDateAndTeacher(date, teacher);
    }

    /**
     * A setter method assigning the given TeacherList object to the 'allTeachers' variable.
     *
     * @param list a TeacherList object which will be used to set.
     */
    public void setAllTeachers(TeacherList list) {
        this.allTeachers = list;

    }

    /**
     * Method for setting chosenClassGroup to ClassGroup classgroup
     * @param classGroup ClassGroup to set chosenClassGroup to
     */
    @Override
    public void setChosenClassGroup(ClassGroup classGroup) {
        this.chosenClassGroup = classGroup;
    }

    /**
     * Method for getting the ChosenClassGroup
     * @return Returns chosenClassGroup
     */
    @Override
    public ClassGroup getChosenClassGroup() {
        return chosenClassGroup;
    }

    /**
     * method for getting the chosen session
     * @return Returns the chosenSession
     */
    @Override
    public Session getChosenSession() {
        return chosenSession;
    }

    /**
     * Method for setting the chosen Session
     * @param session The session to set chosenSession to
     */
    @Override
    public void setChosenSession(Session session) {
        this.chosenSession = session;
    }

    /**
     * method for getting the chosenWeekNumber
     * @return Returns the chosenWeekNumber
     */
    @Override
    public int getChosenWeekNumber() {
        return chosenWeekNumber;
    }

    /**
     * Method for setting the chosen week number
     * @param chosenWeekNumber The week number to set chosenWeekNumber to
     */
    @Override
    public void setChosenWeekNumber(int chosenWeekNumber) {
        this.chosenWeekNumber = chosenWeekNumber;
    }

    /**
     * method for getting the chosen monday
     * @return Returns chosenMonday
     */
    public Date getChosenMonday() {
        return chosenMonday;
    }

    /**
     * Method for setting the chosen monday
     * @param chosenMonday The Date chosenMonday to set object chosen monday to
     */
    @Override
    public void setChosenMonday(Date chosenMonday) {
        this.chosenMonday = chosenMonday;
    }

    /**
     * method for setting the holiday weeks
     * @param holidayWeeks ArrayList<Integer>
     */
    public void setHolidayWeeks(ArrayList<Integer> holidayWeeks) {
        this.holidayWeeks = holidayWeeks;
    }

    /**
     * method for getting holdiay weeks
     * @return ArrayList<Integer> holiday weeks
     */
    public ArrayList<Integer> getHolidayWeeks() {
        return holidayWeeks;
    }

    /**
     * method for adding session
     * @param session session to be added
     * @param room room the session is added to
     */
    public void addSession(Session session, Room room) {
        sessionList.addSession(session, room);
    }

    /**
     * method for removing sessions
     * @param session session that is being removed
     */
    public void removeSession(Session session) {
        sessionList.removeSession(session);
    }

    /**
     * method for setting RoomList
     * @param roomList the RoomList that sessionList's RoomList is being set to
     */
    public void setRoomList(RoomList roomList) {
        sessionList.setRoomList(roomList);
    }

    /**
     * Method suggesting rooms to book
     * @param session A Session object for which we are suggesting rooms for
     * @return RoomList of suggested rooms
     */
    public RoomList suggestRooms(Session session) {
        return sessionList.suggestRooms(session);
    }

    /**
     * Method for checking if the teacher is available for a specific session
     * @param session A session object that we want to check if the teacher is available to teach
     * @return returns a Boolean true or false depending on whether or not the teacher is available to teach that session
     */
    public boolean isTeacherAvailable(Session session) {
        return sessionList.isTeacherAvailable(session);
    }

    /**
     * A method that returns a list of sessions by a selected teacher.
     * @param teacher a Teacher object representing the teacher to sort the list by.
     * @return a SessionList with Session taught by the same teacher.
     */
    public SessionList getSessionsByTeacher(Teacher teacher) {
        return sessionList.getSessionsByTeacher(teacher);
    }

    /**
     * A method that returns a list of sessions by date and teacher.
     * @param sessionsByTeacher a list of sessions sorted by the teachers.
     * @return a list of sessions by a chosen teacher.
     */
    @Override public SessionList getSessionsByDateAndTeacher(
        SessionList sessionsByTeacher)
    {
        return null;
    }

    /**
     * Method for getting sessions by classGroup
     * @param classGroup A classGroup object that we are using to search for sessions
     * @return A SessionList containing the sessions for a specific classGroup
     */
    public SessionList getSessionsByClassGroup(ClassGroup classGroup) {
        return sessionList.getSessionsByClassGroup(classGroup);
    }

    /**
     * Method for getting sessions by date and classGroup
     * @param date When the sessions should be taking place
     * @param classGroup Which classGroup you want sessions for
     * @return
     */
    @Override
    public SessionList getSessionsByDateAndClassGroup(Date date,
                                                      ClassGroup classGroup) {
        return sessionList.getSessionsByDateAndClassGroup(date, classGroup);
    }

    /**
     * Method for setting the chosen Teacher
     * @param chosenTeacher The teacher that chosenTeacher is set to
     */
    @Override
    public void setChosenTeacher(Teacher chosenTeacher) {
        this.chosenTeacher = chosenTeacher;
    }

    /**
     * method for getting the chosen teacher
     * @return Returns the chosen teacher
     */
    @Override
    public Teacher getChosenTeacher() {
        return chosenTeacher;
    }
}
