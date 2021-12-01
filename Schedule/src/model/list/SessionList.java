package model.list;

import model.basic.*;

import java.util.ArrayList;

public class SessionList
{
  private ArrayList<Session> sessions;

  public SessionList()
  {
    sessions = new ArrayList<>();
  }

  public int size()
  {
    return sessions.size();
  }

  public Session get(int index)
  {
    return sessions.get(index);
  }

  public void addSession(Session session)
  {
    if (session == null)
    {
      throw new IllegalArgumentException("Session cannot be null!");
    }
    sessions.add(session);
  }

  public void removeSession(Session session)
  {
    if (session == null)
    {
      throw new IllegalArgumentException("Session cannot be null!");
    }
    sessions.remove(session);
  }

  public SessionList getSessionsByTimeDate(Date date, Time startTime,
      int numberOfLessons)
  {
    SessionList list = new SessionList();

    if (startTime == null || date == null || numberOfLessons == 0)
    {
      throw new IllegalArgumentException("None of the variables Can Be Null");
    }

    for (int i = 0; i < sessions.size(); i++)
    {
      if (sessions.get(i).getDate().equals(date) && sessions.get(i)
          .getStartTime().equals(startTime)
          && sessions.get(i).getNumberOfLessons() == numberOfLessons)
      {
        list.addSession(sessions.get(i));
      }
    }
    if (list.size() > 0)
    {
      return list;
    }
    else
    {
      throw new NullPointerException("No sessions at this time interval");
    }
  }

  public boolean isAvailable(Room room, Time timeStart, int numberOfLessons,
      Date date)
  {
    SessionList list = new SessionList();

    for (int i = 0; i < sessions.size(); i++)
    {
      if (sessions.get(i).getRoom().equals(room) && sessions.get(i).getDate()
          .equals(date))
      {
        list.addSession(sessions.get(i));
      }
    }
    for (int i = 0; i < list.size(); i++)
    {
      if (list.get(i).isOverlapped(timeStart, numberOfLessons))
      {
        return false;
      }
    }
    return true;
  }

  public boolean isTeacherAvailable(Session session){
    for (int i = 0; i < sessions.size(); i++){
      if (sessions.get(i).isOverlapped(session)){
        return false;
      }
    }
    return true;
  }

  public SessionList getSessionsByRoom(Room room)
  {
    SessionList list = new SessionList();

    if (room == null)
    {
      throw new IllegalArgumentException("Room cannot be null");
    }

    for (int i = 0; i < sessions.size(); i++)
    {
      if (sessions.get(i).getRoom().equals(room))
      {
        list.addSession(sessions.get(i));
      }
    }
    if (list.size() > 0)
    {
      return list;
    }
    else
    {
      throw new NullPointerException("There are no sessions in that room");
    }
  }

  public SessionList getSessionsByCourse(Course course)
  {
    SessionList list = new SessionList();

    if (course == null)
    {
      throw new IllegalArgumentException("Course can not be null");
    }

    for (int i = 0; i < sessions.size(); i++)
    {
      if (sessions.get(i).getCourse().equals(course))
      {
        list.addSession(sessions.get(i));
      }
    }
    if (list.size() > 0)
    {
      return list;
    }
    else
    {
      throw new NullPointerException("There are no sessions for that course");
    }
  }

  public Session getExactSession(Time time, Room room, Date date)
  {//
    if (time == null || room == null)
    {
      throw new IllegalArgumentException("Parameters can not be null");
    }

    for (int i = 0; i < sessions.size(); i++)
    {
      if (sessions.get(i).getDate().equals(date))
      {
        if (sessions.get(i).getStartTime().equals(time))
        {
          if (sessions.get(i).getRoom().equals(room))
          {
            return sessions.get(i);
          }
        }
      }
    }
    throw new NullPointerException("There is no such session");

  }

  public SessionList getSessionsByTeacher(Teacher teacher, Date date)
  {
    SessionList sessionsByTeacher = new SessionList();
    for (int i = 0; i < sessions.size(); i++)
    {
      if (sessions.get(i).getDate().equals(date))
      {
        if (sessions.get(i).getCourse().getTeachers().contains(teacher))
        {
          sessionsByTeacher.addSession(sessions.get(i));
        }
      }
    }
    if (sessionsByTeacher.size() > 0)
    {
      return sessionsByTeacher;
    }
    else
    {
      throw new NullPointerException(
          "There are no sessions for that teacher during this day.");
    }

  }

  public String toString()
  {
    String str = "";
    for (int i = 0; i < sessions.size(); i++)
    {
      str += sessions.get(i);
    }
    return str;
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof SessionList))
    {
      return false;
    }

    SessionList other = (SessionList) obj;

    if (sessions.size() == other.size())
    {
      for (int i = 0; i < sessions.size(); i++)
      {
        if (!(sessions.get(i).equals(other.get(i))))
        {
          return false;
        }
      }
      return true;
    }
    return false;
  }
}
