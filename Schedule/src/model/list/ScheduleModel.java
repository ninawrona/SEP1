package model.list;

import model.basic.*;

import java.io.File;
import java.util.ArrayList;

/**
 * Interface class with methods needed for the controllers.
 * Method implemented in ScheduleModelManager class.
 *
 * @author Christian Foyer, Kamil Fischbach, Martin Rosendahl, Nina Wrona, Robert Barta.
 * @version 3 - 10 December 2021.
 */
public interface ScheduleModel
{
  
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

  public boolean isTeacherAvailable(Session session);

  public SessionList getSessionsByClassGroup(ClassGroup classGroup);

  public SessionList getSessionsByDateAndClassGroup(Date date,
      ClassGroup classGroup);

  public void setChosenTeacher(Teacher chosenTeacher);

  public Teacher getChosenTeacher();

  public void setAllTeachers(TeacherList list);

  public TeacherList getAllTeachers();

  public SessionList getSessionsByDateAndTeacher(Date date,
      Teacher teacher);

  public SessionList getSessionsByTeacher(Teacher teacher);

  SessionList getSessionsByDateAndTeacher(SessionList sessionsByTeacher);
}
