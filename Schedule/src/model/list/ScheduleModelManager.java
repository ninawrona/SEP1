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
    private TeacherList teacherList;
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
        //TODO What is the difference with 'teacherList' and 'allTeachers' variables? Why do we need both?
        this.teacherList = new TeacherList();
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
     * A setter method assigning the given TeacherList object to the 'allTeachers' variable.
     *
     * @param list a TeacherList object which will be used to set.
     */
    public void setAllTeachers(TeacherList list) {
        this.allTeachers = list;
        System.out.println("I set my teacherList: " + allTeachers);
    }

    @Override
    public void setChosenClassGroup(ClassGroup classGroup) {
        this.chosenClassGroup = classGroup;
        System.out.println("I just set the class" + classGroup);
    }

    @Override
    public ClassGroup getChosenClassGroup() {
        return chosenClassGroup;
    }

    @Override
    public Session getChosenSession() {
        return chosenSession;
    }

    @Override
    public void setChosenSession(Session session) {
        this.chosenSession = session;
    }

    @Override
    public int getChosenWeekNumber() {
        return chosenWeekNumber;
    }

    @Override
    public void setChosenWeekNumber(int chosenWeekNumber) {
        this.chosenWeekNumber = chosenWeekNumber;
    }

    // Bla bla
    public Date getChosenMonday() {
        return chosenMonday;
    }

    @Override
    public void setChosenMonday(Date chosenMonday) {
        this.chosenMonday = chosenMonday;
    }

    public void setHolidayWeeks(ArrayList<Integer> holidayWeeks) {
        this.holidayWeeks = holidayWeeks;
    }

    public ArrayList<Integer> getHolidayWeeks() {
        return holidayWeeks;
    }

    public void addSession(Session session, Room room) {
        sessionList.addSession(session, room);
    }

    public void removeSession(Session session) {
        sessionList.removeSession(session);
    }

    public void setRoomList(RoomList roomList) {
        sessionList.setRoomList(roomList);
    }

    public RoomList suggestRooms(Session session) {
        return sessionList.suggestRooms(session);
    }

    public boolean isTeacherAvailable(Session session) {
        return sessionList.isTeacherAvailable(session);
    }

    // TODO check method in grid view
    public SessionList getSessionsByTeacher(Teacher teacher, Date date) {
        return sessionList.getSessionsByTeacher(teacher, date);
    }

    public SessionList getSessionsByClassGroup(ClassGroup classGroup) {
        return sessionList.getSessionsByClassGroup(classGroup);
    }

    public void addStudentToCourse(Student student, Course course) {
        if (student == null || course == null) {
            throw new IllegalArgumentException("Parameters cannot be null!");
        }
        for (int i = 0; i < sessionList.size(); i++) {
            if (sessionList.get(i).getCourse().equals(course)) {
                sessionList.get(i).getCourse().addStudent(student);
            }
        }
    }

    public void removeStudentFromCourse(Student student, Course course) {
        if (student == null || course == null) {
            throw new IllegalArgumentException("Parameters cannot be null!");
        }
        for (int i = 0; i < sessionList.size(); i++) {
            if (sessionList.get(i).getCourse().equals(course)) {
                if (sessionList.get(i).getCourse().getStudents().contains(student)) {
                    sessionList.get(i).getCourse().addStudent(student);
                }
            }
        }
    }

    public Student getStudentByViaId(int viaId) {
        if (String.valueOf(viaId).length() < 6) {
            throw new IllegalArgumentException("VIA ID has to have 6 digits!");
        }

        for (int i = 0; i < classList.size(); i++) {
            for (int j = 0; j < classList.get(i).getStudents().size(); j++) {
                if (classList.get(i).getStudents().get(j).getViaId() == viaId) {
                    return classList.get(i).getStudents().get(j);
                }
            }
        }
        throw new NullPointerException("There are no students with this VIA ID.");
    }

    @Override
    public SessionList getSessionsByDateAndClassGroup(Date date,
                                                      ClassGroup classGroup) {
        return sessionList.getSessionsByDateAndClassGroup(date, classGroup);
    }

    @Override
    public void setChosenTeacher(Teacher chosenTeacher) {
        this.chosenTeacher = chosenTeacher;
    }

    @Override
    public Teacher getChosenTeacher() {
        return chosenTeacher;
    }
}
