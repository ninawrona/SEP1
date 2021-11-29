package model.list;

import model.basic.Course;
import model.basic.Room;
import model.basic.Session;
import model.basic.TimeInterval;

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

  public SessionList getSessionByTimeInterval(TimeInterval timeInterval)
  {
    SessionList list = new SessionList();

    if (timeInterval == null)
    {
      throw new IllegalArgumentException("Time Interval Can Not Be Null");
    }

    for (int i = 0; i < sessions.size(); i++)
    {
      if (sessions.get(i).getTimeDate().equals(timeInterval))
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

  public SessionList getSessionsByRoom(Room room)
  {
    SessionList list = new SessionList();

    if (room == null)
    {
      throw new IllegalArgumentException("Room can not be null");
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

  public SessionList getSessionByCourse(Course course)
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

  public Session getExactSession(TimeInterval timeInterval, Room room)
  {//
    if (timeInterval == null || room == null)
    {
      throw new IllegalArgumentException("Parameters can not be null");
    }

    for (int i = 0; i < sessions.size(); i++)
    {
      if (sessions.get(i).getTimeDate().equals(timeInterval))
      {
        if (sessions.get(i).getRoom().equals(room))
        {
          return sessions.get(i);
        }
      }
    }
    System.out.println("There is no such session");
    return null;
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
