package model.basic;

/**
 * A class representing the time.
 *
 * @author Christian Foyer, Kamil Fischbach, Martin Rosendahl, Nina Wrona, Robert Barta
 * @version 1 - 2 December 2021
 */
public class Time
{
  private int hour;
  private int minute;

  /**
   * Two-argument constructor. The hour has to be between 0 and 23, and the minute has to be between 0 and 59.
   * @param hour
   *            the hour.
   * @param minute
   *            the minute.
   */
  public Time(int hour, int minute)
  {
    if (hour<0||hour>23){
      throw new IllegalArgumentException("Hour must be between 0-23");
    }
    if (minute<0||minute>59){
      throw new IllegalArgumentException("Minute must be between 0-59");
    }
    this.hour = hour;
    this.minute = minute;
  }

  /**
   * A getter method for the hour.
   * @return an int representing the hour
   */
  public int getHour()
  {
    return hour;
  }

  /**
   * A getter method for the minute.
   * @return an int representing the minute
   */
  public int getMinute()
  {
    return minute;
  }

  /**
   * A setter method for the hour
   *
   * @param hour
   *            the hour
   */
  public void setHour(int hour)
  {
    this.hour = hour;
  }

  /**
   * A setter method for the minute
   * @param minute
   *             the minute
   */
  public void setMinute(int minute)
  {
    this.minute = minute;
  }

  /**
   * A method checking if the time is before another time by converting both times into seconds and comparing the results.
   *
   * @param time
   *            time object to be compared with
   * @return "True" if the time is before the time represented by the object in the parameter and "False" if the time is not before the time represented by the object in the parameter.
   */
  public boolean isBefore(Time time)
  {
    return this.getTimeInSeconds() < time.getTimeInSeconds();
  }

  /**
   * A method converting the time into seconds.
   * @return an int representing the seconds.
   */
  public int getTimeInSeconds()
  {
    return hour * 3600 + minute * 60;
  }

  /**
   * A method creating a copy of the Time object.
   * @return a Time object with the same values.
   */
  public Time copy()
  {
    return new Time(getHour(), getMinute());
  }

  /**
   * A method returning the String representation of the Time object.
   * @return A string containing the hour and the minute.
   */
  public String toString()
  {
    String str = "";
    str += hour + ":";
    if(minute<10){
      str += "0" + minute;
    }
    else{
      str += minute;
    }
    return str;
  }

  /**
   * A method comparing two Time objects.
   * @param obj
   *            an object representing the other object to be compared.
   * @return "True" if the compared Time objects are the same, or "False" if they are different objects.
   */
  public boolean equals(Object obj)
  {
    if (!(obj instanceof Time))
    {
      return false;
    }

    Time other = (Time) obj;

    return hour == other.hour && minute == other.minute;
  }


}
