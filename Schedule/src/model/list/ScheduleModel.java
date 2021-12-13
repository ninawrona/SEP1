package model.list;

import model.basic.*;

import java.io.File;
import java.util.ArrayList;

public interface ScheduleModel
{
  public void addTeacher(Teacher teacher);
  public void removeTeacher(Teacher teacher);
  public void addCourse(Course course);
  public void removeCourse(Course course);
  public ClassGroupList getAllClasses();
  public CourseList getCourseListByClassGroup(ClassGroup classGroup);
  public ClassGroup getChosenClassGroup();
  public void setChosenClassGroup(ClassGroup classGroup);
  public Session getChosenSession();
  public void setChosenSession(Session session);
  public int getChosenWeekNumber();
  public void setChosenWeekNumber(int chosenWeekNumber);
  public Date getChosenMonday();
  public void setChosenMonday(Date date);
  public void setHolidayWeeks(ArrayList<Integer> holidayWeeks);
  public ArrayList<Integer> getHolidayWeeks();
  public void addClassGroupList(ClassGroupList classList);
  public void addSession(Session session, Room room);
  public void removeSession(Session session);
  public void setRoomList(RoomList roomList);
  public RoomList suggestRooms(Session session);
  public boolean isTeacherAvailable(Session session);
  public SessionList getSessionsByTimeDate(Date date, Time startTime,
      int numberOfLessons);
  public SessionList getSessionsByRoom(Room room);
  public SessionList getSessionsByTeacher(Teacher teacher, Date date);
  public SessionList getSessionsByCourse(Course course);
  public SessionList getSessionsByClassGroup(ClassGroup classGroup);
  public SessionList getSessionsByStudent(Student student);
  public void addStudentToCourse(Student student, Course course);
  public void removeStudentFromCourse(Student student, Course course);
  public Student getStudentByViaId(int viaId);
  public SessionList getSessionsByDateAndClassGroup(Date date, ClassGroup classGroup);
  public void setChosenTeacher(Teacher chosenTeacher);
  public Teacher getChosenTeacher();
  public CourseList getCoursesByTeacher(Teacher teacher);
  public void setAllTeachers(TeacherList list);
  public TeacherList getAllTeachers();
}
