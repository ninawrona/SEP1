package model;

public class TimeInterval
{
  private int hour;
  private int minute;
  private int numberOfLessons;
  private Date date;

  public TimeInterval(int hour, int minute, int numberOfLessons){
    this.hour = hour;
    this.minute = minute;
    this.numberOfLessons = numberOfLessons;
    date = new Date();
  }

  public boolean isOverlapped(TimeInterval other){
    if (!(this.equals(other))){
      return true;
    }
  }
}
