package model.basic;

import java.time.LocalDate;

public class Date
{
  private int day;
  private int month;
  private int year;

  public Date(int day, int month, int year)
  {
    set(day, month, year);
  }

  public Date()
  {
    LocalDate today = LocalDate.now();
    set(today.getDayOfMonth(), today.getMonthValue(), today.getYear());
  }

  public void set(int day, int month, int year)
  {
    if (day < 1 || day > 31 || month < 1 || month > 12 || year < 1)
    {
      throw new IllegalArgumentException("Entered values are illegal.");
    }
    if (month == 2)
    {
      if (isLeapYear())
      {
        if (day > 29)
        {
          throw new IllegalArgumentException(
              "In a leap year there are 29 days in February.");
        }
        else
        {
          if (day > 28)
          {
            throw new IllegalArgumentException("There are 28 days in February.");
          }
        }
      }
      else if (month == 4 || month == 6 || month == 9 || month == 11)
      {
        if (day > 30)
        {
          throw new IllegalArgumentException(
              "There are 30 days in chosen month.");
        }
      }
      else
      {
        if (day > 31)
        {
          throw new IllegalArgumentException(
              "There are 31 days in chosen month.");
        }
      }
    }
    this.day = day;
    this.month = month;
    this.year = year;
  }

  public int getDay()
  {
    return day;
  }

  public int getMonth()
  {
    return month;
  }

  public int getYear()
  {
    return year;
  }

  public String getMonthName()
  {
    switch (month)
    {
      case 1:
        return "January";
      case 2:
        return "February";
      case 3:
        return "March";
      case 4:
        return "April";
      case 5:
        return "May";
      case 6:
        return "June";
      case 7:
        return "July";
      case 8:
        return "August";
      case 9:
        return "September";
      case 10:
        return "October";
      case 11:
        return "November";
      case 12:
        return "December";
    }
    return "null";
  }

  public int numberOfDaysInMonth()
  {
    if (month == 2)
    {
      if (isLeapYear())
      {
        return 29;
      }
      else
      {
        return 28;
      }
    }
    else if (month == 4 || month == 6 || month == 9 || month == 11)
    {
      return 30;
    }
    else
    {
      return 31;
    }
  }

  public boolean isLeapYear()
  {
    if ((year % 4) == 0 && (((year % 100) != 0) || ((year % 400) == 0)))
    {
      return true;
    }
    else
    {
      return false;
    }

  }

  public boolean isBefore(Date date)
  {
    int years = this.year - date.year;
    int months = this.month - date.month;
    int days = this.day - date.day;

    if (years < 0)
    {
      return true;
    }
    else if (years > 0)
    {
      return false;
    }
    else if (years == 0)
    {
      if (months < 0)
      {
        return true;
      }
      else if (months > 0)
      {
        return false;
      }
      else if (months == 0)
      {
        if (days < 0)
        {
          return true;
        }
        else if (days > 0)
        {
          return false;
        }
        else if (days == 0)
        {
          return false;
        }
      }
    }

    return false;

  }
  public int daysBefore(Date date)
  {
    return 42;
    //idk how to do it, is it relevant?
  }
  public int yearsBetween(Date date)
  {
    int yearsbtw = this.year - date.year;
    int months = this.month - date.month;
    int days = this.day - date.day;

    if (this.isBefore(date))
    {
      if (months < 0)
      {
        yearsbtw = yearsbtw;
      }
      else if (months > 0)
      {
        yearsbtw = yearsbtw + 1;
      }
      else if (months == 0)
      {
        if (days < 0)
        {
          yearsbtw = yearsbtw;
        }
        else if (days > 0)
        {
          yearsbtw = yearsbtw + 1;
        }
        else if (days == 0)
        {
          yearsbtw = yearsbtw;
        }

      }
      yearsbtw = yearsbtw * (-1);
    }
    else
    {
      if (months < 0)
      {
        yearsbtw = yearsbtw - 1;
      }
      else if (months > 0)
      {
        yearsbtw = yearsbtw;
      }
      else if (months == 0)
      {
        if (days < 0)
        {
          yearsbtw = yearsbtw - 1;
        }
        else if (days > 0)
        {
          yearsbtw = yearsbtw;
        }
        else if (days == 0)
        {
          yearsbtw = yearsbtw;
        }
      }
    }
    return yearsbtw;
  }

  public void stepForwardOneDay()
  {
    day++;
    if (day > numberOfDaysInMonth())
    {
      day = 1;
      month++;
      if (month > 12)
      {
        month = 1;
        year++;
      }
    }
  }

  public void stepForward(int days)
  {

    for (int i = 0; i < days; i++)
    {
      stepForwardOneDay();
    }

  }

  public Date copy()
  {

  }

  public String toString()
  {
    String s = "";
    if (day < 10)
    {
      s += "0";
    }
    s += day + "/";
    if (month < 10)
    {
      s += "0";
    }
    s += month + "/";
    s += year;

    return s;
  }

  public boolean equals(Object obj)
  {

  }

}


