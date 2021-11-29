package model.basic;

public class TimeInterval
{
  private int hour;
  private int minute;
  private int numberOfLessons;
  private Date date;

  public static void main(String[] args)
  {
    TimeInterval timeInterval = new TimeInterval(8, 20, 5,
        new Date(30, 11, 2021));
    System.out.println(timeInterval.getEndTime());
  }

  public TimeInterval(int hour, int minute, int numberOfLessons, Date date)
  {
    set(hour, minute, numberOfLessons);
    this.date = date.copy();
  }

  public void set(int hour, int minute, int numberOfLessons)
  {
    if (hour < 8
        || hour > 17)// if it has to end at 18, 17 is the last hour possible
    {
      throw new IllegalArgumentException(
          "The lesson has to start between 08 and 20.");
    }
    if (hour == 8 && minute != 20)
    {
      throw new IllegalArgumentException("The lesson starts at 08:20");
    }
    else if (hour == 9 && minute != 15)
    {
      throw new IllegalArgumentException("The lesson starts at 09:15");
    }
    else if (hour == 10 && minute != 10)
    {
      throw new IllegalArgumentException("The lesson starts at 10:10");
    }

    // not finished, not sure which conditions should be checked

    this.hour = hour;
    this.minute = minute;
    this.numberOfLessons = numberOfLessons;
  }

  public int getHour()
  {
    return hour;
  }

  public int getMinute()
  {
    return minute;
  }

  public int getNumberOfLessons()
  {
    return numberOfLessons;
  }

  public Date getDate()
  {
    return date.copy();
  }

  public boolean isBefore(TimeInterval timeInterval)
  {
    return this.getTimeInSeconds() < timeInterval.getTimeInSeconds();
  }

  public int getTimeInSeconds()
  {
    return hour * 3600 + minute * 60;
  }

  public boolean isOverlapped(
      TimeInterval timeInterval)//Also some hard methods here idk how to do it
  {
    double startTime = 0;
    double startOtherTime = 0;
    double startMinuteTime = 0;
    double startMinuteOtherTime = 0;

    if (getMinute() < 10)
    {
      startMinuteTime = getMinute() * 0.01;
    }
    else
    {
      startMinuteTime = getMinute() * 0.1;
    }

    if (timeInterval.getMinute() < 10)
    {
      startMinuteOtherTime = getMinute() * 0.01;
    }
    else
    {
      startMinuteOtherTime = getMinute() * 0.1;
    }

    if (getDate() == timeInterval.getDate())
    {

    }

    return true;
  }

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

    int endHour = getHour() + hours;
    int endMinute = getMinute() + minutes;

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

  public void setStartTime(int hour, int minute)
  {
    //Exceptions needed
    this.hour = hour;
    this.minute = minute;
  }

  public void setNumberOfLessons(int numberOfLessons)
  {
    if(getHour()==8 && getMinute()==20 && numberOfLessons>10)
    {
      throw new IllegalArgumentException("There cannot be more than 10 lessons from 08:20.");
    }
    this.numberOfLessons = numberOfLessons;
  }
  public TimeInterval copy()
  {
    TimeInterval other = new TimeInterval(getHour(), getMinute(),
        getNumberOfLessons(), getDate());
    return other;
  }

  public String toString()
  {
    String s = "";
    s += getStartTime() + "-" + getEndTime() + ", "
        + getDate();//Do we need a numberOfLessons?
    return s;
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof TimeInterval))
    {
      return false;
    }

    TimeInterval other = (TimeInterval) obj;
    return getHour() == other.getHour() && getMinute() == other.getMinute()
        && getDate().equals(other.getDate()) && getNumberOfLessons() == other
        .getNumberOfLessons();

  }

}
