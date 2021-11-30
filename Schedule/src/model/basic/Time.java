package model.basic;

public class Time
{
  private int hour;
  private int minute;

  public Time(int hour, int minute)
  {
    this.hour = hour;
    this.minute = minute;
  //  setStartTime(hour, minute);
  }

  public int getHour()
  {
    return hour;
  }

  public int getMinute()
  {
    return minute;
  }



  public boolean isBefore(Time time)
  {
    return this.getTimeInSeconds() < time.getTimeInSeconds();
  }

  public int getTimeInSeconds()
  {
    return hour * 3600 + minute * 60;
  }



  public Time copy()
  {
    Time other = new Time(getHour(), getMinute());
    return other;
  }


  public String toString()
  {
    return "Hour: " + hour + "\nMinute: " + minute;
  }



/*
  public String toString()
  {
    String s = "";
    s += getStartTime() + "-" + getEndTime() + ", "
        + getDate();//Do we need a numberOfLessons?
    return s;
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Time))
    {
      return false;
    }

    Time other = (Time) obj;
    return getHour() == other.getHour() && getMinute() == other.getMinute()
        && getDate().equals(other.getDate()) && getNumberOfLessons() == other
        .getNumberOfLessons();

  }
 */
}
