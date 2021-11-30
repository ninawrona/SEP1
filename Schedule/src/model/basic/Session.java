package model.basic;

public class Session
{
  private Course course;
  private Time timeDate;
  private Room room;

  public Session(Course course, Time timeDate)
  {
    this.course = course;
    this.timeDate = timeDate;
    // You can make a session before booking the room
    room = null;
  }

  public void bookRoom(Room room)
  {
    this.room = room;
  }

  public Room getRoom()
  {
    return room;
  }

  public Time getTimeDate()
  {
    return timeDate;
  }

  public void setTimeDate(Time timeDate)
  {
    this.timeDate = timeDate;
  }

  public Course getCourse()
  {
    return course;
  }

  @Override public String toString()
  {
    return "Session{" + "course=" + course + ", timeDate=" + timeDate
        + ", room=" + room + '}';
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Session))
    {
      return false;
    }

    Session other = (Session) obj;
    return course.equals(other.course) && timeDate.equals(other.timeDate)
        && room.equals(other.room);
  }
}
