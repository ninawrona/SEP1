package model.list;

import model.basic.*;

import java.io.File;
import java.util.ArrayList;

public interface ScheduleModel
{
  public void addTeacher(Teacher teacher);
  public ClassGroupList getAllClasses();
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
  public void addSession(Session session, Room room);
  public void removeSession(Session session);
  public void setRoomList(RoomList roomList);
  public RoomList suggestRooms(Session session);
  public SessionList getSessionsByClassGroup(ClassGroup classGroup);
  // TODO ensure these "meethodes" aren't used
  public void addStudentToCourse(Student student, Course course);
  public void removeStudentFromCourse(Student student, Course course);
  public SessionList getSessionsByDateAndClassGroup(Date date, ClassGroup classGroup);
  public void setChosenTeacher(Teacher chosenTeacher);
  public Teacher getChosenTeacher();
  public CourseList getCoursesByTeacher(Teacher teacher);
  public void setAllTeachers(TeacherList list);
  public TeacherList getAllTeachers();
}
