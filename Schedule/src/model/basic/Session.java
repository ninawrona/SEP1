package model.basic;

public class Session
{
  private Course course;
  private Time startTime;
  private Date date;
  private Room room;
  private int numberOfLessons;
  public final static int LENGTHOFLESSON = 55;


  public Session(Course course,Date date, Time startTime,int numberOfLessons )
  {
    this.course = course;
    this.date = date.copy();
    this.startTime = startTime.copy();
    // You can make a session before booking the room
    room = null;
    this.numberOfLessons = numberOfLessons;
  }

  public void bookRoom(Room room)
  {
    this.room = room;
  }

  public Room getRoom()
  {
    return room;
  }
  public Course getCourse()
  {
    return course;
  }

  public int getNumberOfLessons(){
    return numberOfLessons;
}

  public Time getStartTime()
  {
    return startTime;
  }

  public Time getEndTime(){

    int totalMinutes = getNumberOfLessons() * 55;
    int hours = totalMinutes / 60;
    int minutes = totalMinutes % 60;

    int endHour = startTime.getHour() + hours;
    int endMinute = startTime.getMinute() + minutes;

    if (endMinute > 60)
    {
      endMinute = endMinute % 60;
      endHour++;
    }
    if ((startTime.getHour() <= 11 && endHour > 11))
    {
      endMinute = endMinute + 45;
    }
    if (endMinute > 60)
    {
      endMinute = endMinute % 60;
      endHour++;
    }

    if (endHour == 12){
      endHour = 11;
      endMinute = 50;
    } else if (endHour == 18 && endMinute == 5){
      endHour = 17;
      endMinute = 55;
    }

    Time endTime = new Time(endHour,endMinute);
    return endTime;
  }

  public boolean isOverlapped(Session other)
  {
    if (startTime.getHour() < other.startTime.getHour() && startTime.getMinute() < other.startTime.getMinute()){
      if (getEndTime().getHour() > other.getEndTime().getHour() && getEndTime().getMinute() > other.getEndTime().getMinute()){
        return true;
      }
    }
    if (other.getEndTime().getHour() < startTime.getHour() && other.getEndTime().getMinute() < startTime.getMinute()){
      if (other.getEndTime().getHour() > getEndTime().getHour() && other.getEndTime().getMinute() > getEndTime().getMinute()){
        return true;
      }
    }
    return false;
  }

  public void setStartTime(Time startTime)
  {
    this.startTime = startTime;
  }



  @Override public String toString()
  {
    return "Session{" + "course=" + course + ", startTime=" + startTime
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












/*

  public String getStartTime()
  {
    String s = "";
    if (getHour() < 10)
    {
      s += "0";
    }
    s += getHour() + ":";
    if (getMinute() < 10)
    {
      s += "0";
    }
    s += getMinute();
    return s;
  }

  public String getEndTime()
  {
    int totalMinutes = getNumberOfLessons() * 55 - 10;
    int hours = totalMinutes / 60;
    int minutes = totalMinutes % 60;

    int endHour = timeDate.getHour() + hours;
    int endMinute = timeDate.getMinute() + minutes;

    if (endMinute > 60)
    {
      endMinute = endMinute % 60;
      endHour++;
    }
    if ((getHour() <= 11 && endHour > 11))
    {
      endMinute = endMinute + 45;
    }
    if (endMinute > 60)
    {
      endMinute = endMinute % 60;
      endHour++;
    }

    String s = "";
    if (endHour < 10)
    {
      s += "0";
    }
    s += endHour + ":";
    if (endMinute < 10)
    {
      s += "0";
    }
    s += endMinute;
    return s;
  }

  public boolean isOverlapped()
  {
    return true;
  }



  public void setStartTime(int hour, int minute)
  {
    if (hour == 8 && minute != 20)
    {
      throw new IllegalArgumentException("The lesson start from 08:20.");
    }
    else if (hour == 9 && minute != 15)
    {
      throw new IllegalArgumentException("The lesson start from 09:15.");
    }
    else if (hour == 10 && minute != 10)
    {
      throw new IllegalArgumentException("The lesson start from 10:10.");
    }
    else if (hour == 11 && minute != 5)
    {
      throw new IllegalArgumentException("The lesson start from 11:05.");
    }
    else if (hour == 12 && minute != 45)
    {
      throw new IllegalArgumentException("The lesson start from 12:45.");
    }
    else if (hour == 13 && minute != 40)
    {
      throw new IllegalArgumentException("The lesson start from 13:40.");
    }
    else if (hour == 14 && minute != 35)
    {
      throw new IllegalArgumentException("The lesson start from 14:35.");
    }
    else if (hour == 15 && minute != 30)
    {
      throw new IllegalArgumentException("The lesson start from 15:30.");
    }
    else if (hour == 16 && minute != 25)
    {
      throw new IllegalArgumentException("The lesson start from 16:25.");
    }
    else if (hour == 17 && minute != 20)
    {
      throw new IllegalArgumentException("The lesson start from 17:20.");
    }
    else if (hour < 8 || hour > 17)
    {
      throw new IllegalArgumentException(
          "The lessons start from 8:20 and finish at 18:05.");
    }
    this.hour = hour;
    this.minute = minute;
  }

  public void setNumberOfLessons(int numberOfLessons)
  {
    if (getHour() == 8 && getMinute() == 20 && numberOfLessons > 10)
    {
      throw new IllegalArgumentException(
          "There cannot be more than 10 lessons from 08:20.");
    }
    else if (getHour() == 9 && getMinute() == 15 && numberOfLessons > 9)
    {
      throw new IllegalArgumentException(
          "There cannot be more than 9 lessons from 09:15.");
    }
    else if (getHour() == 10 && getMinute() == 10 && numberOfLessons > 8)
    {
      throw new IllegalArgumentException(
          "There cannot be more than 8 lessons from 10:10.");
    }
    else if (getHour() == 11 && getMinute() == 5 && numberOfLessons > 7)
    {
      throw new IllegalArgumentException(
          "There cannot be more than 7 lessons from 11:05.");
    }
    else if (getHour() == 12 && getMinute() == 45 && numberOfLessons > 6)
    {
      throw new IllegalArgumentException(
          "There cannot be more than 6 lessons from 12:45.");
    }
    else if (getHour() == 13 && getMinute() == 40 && numberOfLessons > 5)
    {
      throw new IllegalArgumentException(
          "There cannot be more than 5 lessons from 13:40.");
    }
    else if (getHour() == 14 && getMinute() == 35 && numberOfLessons > 4)
    {
      throw new IllegalArgumentException(
          "There cannot be more than 4 lessons from 14:35.");
    }
    else if (getHour() == 15 && getMinute() == 30 && numberOfLessons > 3)
    {
      throw new IllegalArgumentException(
          "There cannot be more than 3 lessons from 15:30.");
    }
    else if (getHour() == 16 && getMinute() == 25 && numberOfLessons > 2)
    {
      throw new IllegalArgumentException(
          "There cannot be more than 2 lessons from 16:25.");
    }
    else if (getHour() == 17 && getMinute() == 20 && numberOfLessons > 1)
    {
      throw new IllegalArgumentException(
          "There cannot be more than 1 lessons from 17:20.");
    }

    this.numberOfLessons = numberOfLessons;
  }

 */

}
