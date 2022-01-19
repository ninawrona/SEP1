package model.list;

import model.basic.*;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A class representing a list of all the sessions.
 *
 * @author Christian Foyer, Kamil Fischbach, Martin Rosendahl, Nina Wrona, Robert Barta
 * @version 1 - 2 December 2021
 */
public class SessionList
{
  private ArrayList<Session> sessions;
  private RoomList roomList;

  /**
   * A constructor taking no arguments that initializes two ArrayLists: one with Session objects and one with Room objects.
   */
  public SessionList()
  {
    this.sessions = new ArrayList<>();
    roomList = new RoomList();
  }

  /**
   * A method returning the size of the SessionList.
   *
   * @return an int representing how many Session objects the list contains.
   */
  public int size()
  {
    return sessions.size();
  }

  /**
   * A getter method returning a Session at a chosen index.
   *
   * @param index the index of the desired Session.
   * @return the Session object at the specified index.
   */
  public Session get(int index)
  {
    return sessions.get(index);
  }

  /**
   * A void method adding a Session object to the list (cannot be null) and booking a room for it. The method is checking if the teacher is
   * available for the session.
   *
   * @param session a Session object
   * @param room    a Room object
   */
  public void addSession(Session session, Room room)
  {

    if (session == null)
    {
      throw new IllegalArgumentException("Session cannot be null!");
    }

    if (!(isTeacherAvailable(session)))
    {
      if (session.getRoom().getNumber()!=room.getNumber()&&
          session.getRoom().getFloor()!=room.getFloor()&&
          session.getRoom().getBlock()!=room.getBlock())
      {
        throw new IllegalCallerException("Teacher not available!");
      }
    }
    if (!(isClassGroupAvailable(session.getCourse().getClassGroup(), session)))
    {
     if (session.getRoom().getNumber()!=room.getNumber()&&
      session.getRoom().getFloor()!=room.getFloor()&&
      session.getRoom().getBlock()!=room.getBlock())
     {
       throw new IllegalCallerException(
           "This would overlap one of the ClassGroup's existing Sessions!");
     }
    }
    bookRoomForASession(room, session);
    sessions.add(session);
  }

  /**
   * A void method for removing a Session object from the SessionList. If there is no Session in the list, or the Session is null, an exception is thrown.
   *
   * @param session the Session object to be removed from the list.
   */
  public void removeSession(Session session)
  {
    if (size() == 0)
    {
      throw new NullPointerException(
          "The list is empty! You cannot remove anything!");
    }
    if (session == null)
    {
      throw new IllegalArgumentException("Session cannot be null!");
    }

    sessions.remove(session);
  }

  /**
   * A getter method returning a list of Session objects with the same date for a chosen ClassGroup
   * and sorting the sessions based on their starting time.
   *
   * @param date       a Date object representing the date.
   * @param classGroup a ClassGroup object representing the ClassGroup.
   * @return a list of Session objects (if there are any) with the same date and classGroup.
   */
  public SessionList getSessionsByDateAndClassGroup(Date date,
      ClassGroup classGroup)
  {
    SessionList list = new SessionList();
    for (int i = 0; i < sessions.size(); i++)
    {
      if (sessions.get(i).getDate().equals(date) && sessions.get(i).getCourse()
          .getClassGroup().equals(classGroup))
      {
        list.addSession(sessions.get(i), sessions.get(i).getRoom());
      }
    }
    Collections.sort(list.sessions);
    return list;
  }

  /**
   * A setter method for the RoomLists, used in the ViewController.
   *
   * @param roomList the roomList to be set.
   */
  public void setRoomList(RoomList roomList)
  {
    if (roomList == null)
    {
      throw new IllegalArgumentException("Parameter cannot be null!");
    }
    this.roomList = roomList;
  }

  /**
   * A method that returns a list of available rooms when booking a session.
   *
   * @param session the session that needs a room.
   * @return an ArrayList of Room objects that are available for booking.
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
        if (roomList.get(i).getCapacity() >= session.getCourse().getClassGroup()
            .getStudents().size())
        {
          suggestedRoomList.addRoom(roomList.get(i));
        }
      }
    }
    if (suggestedRoomList.size() > 0)
    {
      return suggestedRoomList;
    }
    throw new NullPointerException(
        "There are no rooms found fulfilling given values!");

  }

  /**
   * A void method that books a room for a session. The parameters cannot be null, and booking is only done if the room is available.
   *
   * @param room    the Room object to be booked for the Session object.
   * @param session the Session object that needs a room booking.
   */
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

  /**
   * A method that checks if a room is available. This is done by creating an ArrayList and looping through all the sessions.
   * If a session's room and date from the list is the same as the one from the parameters, it is added to the list.
   * The second for loop is checking if there is an overlap in terms of time between the sessions from the list, and the session from the parameters.
   *
   * @param room            the Room object to be checked.
   * @param timeStart       the beginning time of the Session.
   * @param numberOfLessons the number of lessons in the Session.
   * @param date            the Date of the session.
   * @return "True" if there is no overlap in the second for loop, "False" if there is an overlap.
   */
  public boolean isRoomAvailable(Room room, Time timeStart, int numberOfLessons,
      Date date)
  {
    SessionList list = new SessionList(); //Creation of a SessionList object takes 1.
    if (sessions.size() != 0) //Comparison takes 1, size() takes 1.
    {
      // "=" takes 1, size() takes 1 and the for loop takes O(N).
      //The whole loop takes 2 + (N*9)
      //Dropping constants and coefficients, the time complexity is O(N).
      for (int i = 0; i < sessions.size(); i++)

      {
        // The comparison takes 1, get(i) takes 1, getRoom() takes 1,
        // get(i) takes 1, getDate() takes 1, equals(date) takes 1.
        if (sessions.get(i).getRoom().equals(room) && sessions.get(i).getDate()
            .equals(date))
        {
          // addSession() takes 1, get(i) takes 1, getRoom() takes 1.
          list.addSession(sessions.get(i), sessions.get(i).getRoom());
        }
      }
      //"=" takes 1, size() takes 1 and the for loop takes O(N).
      //The whole loop takes 2 + (N*3) + 1.
      //Dropping constants and coefficients, the time complexity is O(N).
      for (int i = 0; i < list.size(); i++)

      {
        // the comparison takes 1, get(i) takes 1,
        // isOverlapped takes 1 because it only contains if statements.
        if (list.get(i).isOverlapped(timeStart, numberOfLessons))
        {
          // takes 1
          return false;
        }
      }
    }
    return true;
  }
  // We chose this method because it contains two for loops and calls different methods.
  // T(O)= 3 + N + N = 2*N + 3.
  // Dropping constants and coefficients the time complexity of this method id O(N).

  /**
   * A method that checks if a ClassGroup could have a session without overlaps. The method takes all the sessions from
   * the SessionList for the ClassGroup specified in the parameter and checking if the Session from the parameter
   * is overlapping any of these, returning "False" if it is, or "True" if it is not.
   *
   * @param classgroup the ClassGroup object to be booked a Session for.
   * @param session    the Session to be booked for the ClassGroup object.
   * @return "False" if the ClassGroup's new Session overlaps with an existing Session, or "True" if it does not.
   */
  public boolean isClassGroupAvailable(ClassGroup classgroup, Session session)
  {
    if (sessions.size() != 0)
    {
      SessionList list = getSessionsByClassGroup(classgroup);
      for (int i = 0; i < list.size(); i++)
      {
        if (list.get(i).isOverlapped(session))
        {
          return false;
        }
      }
    }
    return true;
  }

  /**
   * A method that is checking for the availability of a Teacher. This is done by checking for sessions with the same date as this Session's date.
   * If there are such sessions, the next if statement is checking if the session is overlapped by this.
   * If the sessions are not overlapped, the method is looping through the TeachersList of the session and checking if
   * it contains the same teacher(s).
   * If it does contain the same teacher, the method returns "False".
   *
   * @param session the Session object to be compared with
   * @return "True" if all the teachers from the Session are available, or "False" if at least one of them is unavailable.
   */
  public boolean isTeacherAvailable(Session session)
  {
    boolean teacherAvailable = true;

    if (sessions.size() >= 1) //This takes 1
    {
      for (int i = 0; i
          < sessions.size(); i++)   //"=" takes 1, and the for loop takes O(N) where N is the size of the sessions.
      {
        // The comparison takes 1, get(i) takes 1, getDate() takes 1, equals() takes 1, the second getDate() takes 1.
        // This operation takes a total of 5.
        if (sessions.get(i).getDate().equals(session.getDate()))
        {
          //This comparison takes 1, get(i) takes 1, the method isOverlapped() which only
          // contains if statements also takes 1, the whole operation totaling 3.
          if (sessions.get(i).isOverlapped(session))

          {
            //"=" takes 1. The for loop takes N, where N is the size of the TeacherList.
            // For each iteration the if statement takes 1 for the comparison, 1 for get(i), 1 for getCourse(), 1 for getTeachers(),
            // N for contains(), 1 for getTeachers(), 1 for get(j) and 1 for returning.

            //For this loop T(0)= 1 + N*(N+7) = N^(2)+ 7 * N + 1. Dropping coefficients and constants we get O(N)=N^2.
            for (int j = 0; j < session.getTeachers().size(); j++)

            {
              if ((sessions.get(i).getCourse().getTeachers()
                  .contains(session.getTeachers().get(j))))

              {
                teacherAvailable = false;
              }
              else
              {
                teacherAvailable = true;
              }
            }
          }
          else
          {
            return teacherAvailable;
          }
        }
        else
        {
          return teacherAvailable;
        }
      }
    }
    return teacherAvailable; // O(1)
    //Returns take 1
  }
  // We chose this method because it contains two loops and multiple if statements,
  // which we find complex compared to the rest of our methods.
  // For the whole method O(N)= 2 + N*( N^2 + 8) + 1 = N^3 + 8*N + 3.
  // Dropping the coefficients and constants the time complexity is N^3.

  /**
   * A getter method returning a session with a specified teacher.
   *
   * @param teacher a Teacher object representing the teacher to search the sessions by.
   * @return A list of Sessions (if there are any) that take place on the specified date with the given teacher.
   */
  public SessionList getSessionsByTeacher(Teacher teacher)
  {
    SessionList sessionsByTeacher = new SessionList();
    for (int i = 0; i < sessions.size(); i++)
    {

      if (sessions.get(i).getCourse().getTeachers().contains(teacher))
      {
        sessionsByTeacher.addSession(sessions.get(i),
            sessions.get(i).getRoom());
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

  /**
   * A getter method returning a list of Session objects with the specified ClassGroup.
   *
   * @param classGroup a ClassGroup object representing the ClassGroup by which the sessions are sorted.
   * @return A list of Sessions (if there are any) with the same ClassGroup as the one specified in the parameter.
   */
  public SessionList getSessionsByClassGroup(ClassGroup classGroup)
  {
    if (classGroup == null)
    {
      throw new IllegalArgumentException("Parameter cannot be null!");
    }
    SessionList sessionListClassGroup = new SessionList();
    for (int i = 0; i < sessions.size(); i++)
    {
      if (sessions.get(i).getCourse().getClassGroup().equals(classGroup))
      {
        sessionListClassGroup.addSession(sessions.get(i),
            sessions.get(i).getRoom());
      }
    }
    return sessionListClassGroup;
  }

  /**
   * A method returning a String representation of the Session List.
   *
   * @return A String object containing all the sessions.
   */
  public String toString()
  {
    String str = "";
    for (int i = 0; i < sessions.size(); i++)
    {
      str += sessions.get(i);
    }
    return str;
  }

  /**
   * A method comparing two objects.
   *
   * @param obj the object to be compared with
   * @return "True" if the two SessionList objects are identical, "False" if they are not.
   */
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

  /**
   * A getter method returning the sessions by a given teacher
   *
   * @param date    a Date object representing the date.
   * @param teacher a Teacher object representing the teacher
   * @return a SessionList with the same teachers and date.
   */
  public SessionList getSessionsByDateAndTeacher(Date date, Teacher teacher)
  {
    SessionList list = new SessionList();
    for (int i = 0; i < sessions.size(); i++)
    {
      if (sessions.get(i).getDate().equals(date))
      {
        for (int j = 0;
             j < sessions.get(i).getCourse().getTeachers().size(); j++)
        {
          if (sessions.get(i).getCourse().getTeachers().get(j).equals(teacher))
          {
            list.addSession(sessions.get(i), sessions.get(i).getRoom());
          }
        }
      }
    }
    Collections.sort(list.sessions);
    return list;
  }

}