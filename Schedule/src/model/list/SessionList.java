package model.list;

import model.basic.*;

import java.util.ArrayList;

public class SessionList
{
  private ArrayList<Session> sessions;
  private RoomList roomList;

  public SessionList()
  {
    this.sessions = new ArrayList<>();
    roomList = new RoomList();
  }

  public int size()
  {
    return sessions.size();
  }

  public Session get(int index)
  {
    return sessions.get(index);
  }

  public void addSession(Session session, Room room)
  {
    if (session == null)
    {
      throw new IllegalArgumentException("Session cannot be null!");
    }
    if (!(isTeacherAvailable(session)))
    {
      //throw new IllegalCallerException("Teacher not available!");
    }
    bookRoomForASession(room, session);//Exceptions inside this method
    sessions.add(session);
  }

  public void removeSession(Session session)
  {
    if(size()==0)
    {
      throw new NullPointerException("The list is empty! You cannot remove anything!");
    }
    if (session == null)
    {
      throw new IllegalArgumentException("Session cannot be null!");
    }

    sessions.remove(session);
  }

  /*
  public void setRoomList(RoomList roomList)
  {
    if (roomList == null)
    {
      throw new IllegalArgumentException("Parameter cannot be null!");
    }
    this.roomList = roomList;
  }

   */

  public RoomList suggestRooms(Session session)
  {
    if (session == null)
    {
      throw new IllegalArgumentException("Parameter cannot be null!");
    }

    RoomList suggestedRoomList = new RoomList();

    for (int i = 0; i < roomList.size(); i++)
    {
      if (isRoomAvailable(roomList.get(i), session.getStartTime(),
          session.getNumberOfLessons(), session.getDate()))
      {
        // Add this if again when the student list work
        /*if (roomList.get(i).getCapacity() >= session.getCourse().getClassGroup()
            .getStudents().size())
        {
          suggestedRoomList.addRoom(roomList.get(i));
        }

         */
        suggestedRoomList.addRoom(roomList.get(i));
      }
    }
    if(suggestedRoomList.size()>0)
    {
      return suggestedRoomList;
    }
    throw new NullPointerException("There no rooms found fulfilling given values!");

  }

  public void bookRoomForASession(Room room, Session session)
  {
    if (session == null || room == null)
    {
      throw new IllegalArgumentException("Parameters cannot be null!");
    }
    if (isRoomAvailable(room, session.getStartTime(),
        session.getNumberOfLessons(), session.getDate()))
    {
      session.bookRoom(room);
    }
    else
    {
      throw new IllegalCallerException("Booking not possible!");
    }
  }

  public boolean isRoomAvailable(Room room, Time timeStart, int numberOfLessons,
      Date date)
  {
    SessionList list = new SessionList();

    for (int i = 0; i < sessions.size(); i++)
    {
      if (sessions.get(i).getRoom().equals(room) && sessions.get(i).getDate()
          .equals(date))
      {
        list.addSession(sessions.get(i), sessions.get(i).getRoom());
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

  public boolean isTeacherAvailable(Session session)
  {
    for (int i = 0; i < sessions.size(); i++)
    {
      if (sessions.get(i).getDate().equals(session.getDate()))//Another isOverlapped method possible to use
      {
        if (!(sessions.get(i).isOverlapped(session)))
        {
          for (int j = 0; j < session.getTeachers().size(); j++)
          {
            if (!(sessions.get(i).getCourse().getTeachers()
                .contains(session.getTeachers().get(j))))
            {
              return true;
            }
          }
        }
      }
    }
    return false;
  }

  public SessionList getSessionsByTimeDate(Date date, Time startTime,
      int numberOfLessons)
  {
    SessionList list = new SessionList();

    if (startTime == null || date == null || numberOfLessons == 0)
    {
      throw new IllegalArgumentException("None of the variables can be null");
    }

    for (int i = 0; i < sessions.size(); i++)
    {
      if (sessions.get(i).getDate().equals(date) && sessions.get(i)
          .getStartTime().equals(startTime)
          && sessions.get(i).getNumberOfLessons() == numberOfLessons)
      {
        list.addSession(sessions.get(i), sessions.get(i).getRoom());
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
      throw new IllegalArgumentException("Room cannot be null");
    }

    for (int i = 0; i < sessions.size(); i++)
    {
      if (sessions.get(i).getRoom().equals(room))
      {
        list.addSession(sessions.get(i), sessions.get(i).getRoom());
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
        list.addSession(sessions.get(i), sessions.get(i).getRoom());
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
          sessionsByTeacher
              .addSession(sessions.get(i), sessions.get(i).getRoom());
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

  public SessionList getSessionsByClassGroup(ClassGroup classGroup)
  {
    if (classGroup == null)
    {
      throw new IllegalArgumentException("Parameter cannot be null!");
    }
    SessionList sessionListClassGroup = new SessionList();
    for (int i = 0; i < sessions.size(); i++)
    {
      if (sessions.get(i).getCourse().getClassGroup().getClassName().equals(classGroup.getClassName())
          && sessions.get(i).getCourse().getClassGroup().getSemester() == classGroup.getSemester())
      {
        sessionListClassGroup.addSession(sessions.get(i), sessions.get(i).getRoom());
      }
    }
    if(sessionListClassGroup.size()>0)
    {
      return sessionListClassGroup;
    }
    throw new NullPointerException("There no sessions for this class.");
  }

  public SessionList getSessionsByStudent(Student student)
  {
    if(student==null)
    {
      throw new IllegalArgumentException("Parameter cannot be null!");
    }
    SessionList sessionListOfStudent = new SessionList();

    for(int i = 0; i<sessions.size(); i++)
    {
      if(sessions.get(i).getCourse().getClassGroup().getStudents().contains(student))
      {
        sessionListOfStudent.addSession(sessions.get(i), sessions.get(i).getRoom());
      }
    }
    if(sessionListOfStudent.size()>0)
    {
      return sessionListOfStudent;
    }
    throw new NullPointerException("There are no sessions for this student.");
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
