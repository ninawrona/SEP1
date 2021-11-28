package model.basic;

public class TimeInterval
{
  private int hour;
  private int minute;
  private int numberOfLessons;
  private Date date;

  public TimeInterval(int hour, int minute, int numberOfLessons, Date date)
  {
    set(hour, minute, numberOfLessons);
    this.date=date;
  }
  public void set(int hour, int minute, int numberOfLessons)
  {
    if (hour < 8 || hour > 17)// if it has to end at 18, 17 is the last hour possible
    {
      throw new IllegalArgumentException("The lesson has to start between 08 and 20.");
    }
    if(!(hour==8 && minute==20))
    {
      throw new IllegalArgumentException("The lesson starts at 08:20");
    }
    if(!(hour==9 && minute==15))
    {
      throw new IllegalArgumentException("The lesson starts at 09:15");
    }
    if(!(hour==10 && minute==10))
    {
      throw new IllegalArgumentException("The lesson starts at 08:20");
    }

    // not finished, not sure which coniditions should be checked

    this.hour = hour;
    this.minute = minute;
    this.numberOfLessons = numberOfLessons;
  }


}
