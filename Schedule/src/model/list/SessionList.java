package model.list;
// TODO: 06/12/2021 CONTINUE DOCUMENTING ON TUESDAY 07/12. 
import model.basic.*;

import java.util.ArrayList;

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
   * A method returning the size of the SessionList
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
   * A void method adding a Session object to the list (cannot be null) and booking a room for it. The method todo *is checking if the teacher is
   * todo available for the session.
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
      // TODO: 06/12/2021 Remove comment/delete method.
      //throw new IllegalCallerException("Teacher not available!");
    }
    // assign room with the session itself
    // session.bookRoom(room);
    bookRoomForASession(room, session);//Exceptions inside this method
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
    SessionList list = new SessionList();
    if (sessions.size() != 0)
    {
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
    for (int i = 0; i < sessions.size(); i++)
    {
      if (sessions.get(i).getDate().equals(
          session.getDate()))//Another isOverlapped method possible to use
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

  /**
   * @param date
   * @param startTime
   * @param numberOfLessons
   * @return
   */
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
  {
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

  public SessionList getSessionsByClassGroup(ClassGroup classGroup)//SEQUENCE DIAGRAM!
  {
    SessionList sessionListClassGroup = new SessionList();
    for (int i = 0; i < sessions.size(); i++)
    {
      if (sessions.get(i).getCourse().getClassGroup().equals(classGroup))
      {
        sessionListClassGroup
            .addSession(sessions.get(i), sessions.get(i).getRoom());
      }
    }
      return sessionListClassGroup;

  }

  public SessionList getSessionsByStudent(Student student)
  {
    if (student == null)
    {
      throw new IllegalArgumentException("Parameter cannot be null!");
    }
    SessionList sessionListOfStudent = new SessionList();

    for (int i = 0; i < sessions.size(); i++)
    {
      if (sessions.get(i).getCourse().getClassGroup().getStudents()
          .contains(student))
      {
        sessionListOfStudent
            .addSession(sessions.get(i), sessions.get(i).getRoom());
      }
    }
    if (sessionListOfStudent.size() > 0)
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
  public static void main(String[] args)
  {
    Teacher teacher1 = new Teacher("SVA");
    TeacherList teacherList1= new TeacherList();
    teacherList1.addTeacher(teacher1);
    Student student1 = new Student(1, "Bob",654654);
    Student student2 = new Student(1, "Wendy",655655);
    Room room1= new Room(5,'C',16,45);
    Room room2= new Room(5,'C',14,45);
    Time time1=new Time(8,20);
    Time time2=new Time(12,45);

    Date date1= new Date(10,10,2022);
    Date date2= new Date(11,11,2022);
    System.out.println(date1);
    StudentList studentList1=new StudentList();
    studentList1.addStudent(student1);
    studentList1.addStudent(student2);
    ClassGroup group1=new ClassGroup(1,"Y",studentList1);
    Course course1=new Course("SDJ", group1,teacherList1,1,10);
    SessionList sessionList1= new SessionList();
    Session session1=new Session(course1,date1,time1,4);
    Session session2=new Session(course1,date1,time1,2);

    System.out.println("Session1 : "+session1.toString());
    System.out.println("Session2 : "+session2.toString());
    System.out.println("Session 1 is overlapped by session 2: "+session1.isOverlapped(session2));




  }
}
