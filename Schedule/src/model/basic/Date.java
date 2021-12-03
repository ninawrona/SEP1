package model.basic;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

/**
 * A class representing the date.
 *
 *  @author Christian Foyer, Kamil Fischbach, Martin Rosendahl, Nina Wrona, Robert Barta
 *  @version 1 - 2 December 2021
 */

public class Date
{
  private int day;
  private int month;
  private int year;

  /**
   * Three-argument constructor taking a day, month, year all being an integer type.
   * If the date is before today, the exception is thrown as we cannot schedule a session for the past.
   *
   * @param day the day of the date
   * @param month the month of the date
   * @param year the year of the date
   */

  public Date(int day, int month, int year)
  {
    set(day, month, year);
    if (!isValid())
    {
      throw new IllegalArgumentException(
          "Date has to be today or after today.");
    }
  }

  /**
   * Overloaded zero-argument constructor creating a date object with today's date.
   */

  public Date()
  {
    LocalDate today = LocalDate.now();
    set(today.getDayOfMonth(), today.getMonthValue(), today.getYear());
  }

  /**
   * A method returning a string representing the name of the week day for this Date object.
   *
   * @return A String object.
   */

  public String getWeekday(){
    LocalDate date = LocalDate.of(year, month, day);
    int weekdayNumber = date.get(ChronoField.DAY_OF_WEEK);
    String weekdayName = "";
    switch (weekdayNumber) {
      case 1:
        weekdayName = "MONDAY";
      case 2:
        weekdayName = "TUESDAY";
      case 3:
        weekdayName = "WEDNESDAY";
      case 4:
        weekdayName = "THURSDAY";
      case 5:
        weekdayName = "FRIDAY";
      case 6:
        weekdayName ="SATURDAY";
      case 7:
        weekdayName = "SUNDAY";
    }
    return weekdayName;
  }

  /**
   * A boolean method checking if the date is not before today.
   *
   * @return "True" if this Date object is not before today's date. "False" if this Date is before today's date.
   */
  public boolean isValid()
  {
    return !isBefore(new Date());
  }

  /**
   * A getter method returning the day.
   *
   * @return a day int
   */

  public int getDay()
  {
    return day;
  }

  /**
   * A getter method returning a month object.
   *
   * @return a month int
   */

  public int getMonth()
  {
    return month;
  }
  /**
   * A getter method returning a year object.
   *
   * @return a year int
   */

  public int getYear()
  {
    return year;
  }
  /**
   * A String method returning a name of the month of this Date object.
   *
   * @return a monthName String.
   */
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

  /**
   * A void method checking if the values for day, month, year are legal.
   *
   * @param day a day int
   * @param month a month int
   * @param year a year int
   */

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
            throw new IllegalArgumentException(
                "There are 28 days in February.");
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

  /**
   * An int method checking for the number of days in month for month of this Date object.
   *
   * @return A number of days int
   */

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

  /**
   * A boolean method checking if the year of this Date object is a leap year.
   *
   * @return "True" when the year is a leap year. "False" when the year is not a leap year.
   */
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

  /**
   * A boolean method checking if this Date object is before other Date object.
   * @param date other Date object to which we want to compare this Date object.
   * @return "True" if this Date is before other Date. "False" if this Date is after other Date.
   */

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
    else
    {
      if (months < 0)
      {
        return true;
      }
      else if (months > 0)
      {
        return false;
      }
      else
      {
        if (days < 0)
        {
          return true;
        }
        else if (days > 0)
        {
          return false;
        }
        else
        {
          return false;
        }
      }
    }
  }

  /**
   * A void method increasing the value of the day for this Date object by one.
   */

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

  /**
   * A void method increasing the value of the day for this Date object by the given parameter.
   * @param days the number of the days to step forward.
   */
  public void stepForward(int days)
  {

    for (int i = 0; i < days; i++)
    {
      stepForwardOneDay();
    }

  }

  /**
   * A Date method creating a copy of this Date object.
   * @return A Date object.
   */
  public Date copy()
  {
    Date other = new Date(this.day, this.month, this.year);
    return other;
  }

  /**
   * A String method returning a day, month, year as a String in a proper format.
   * @return A String object.
   */
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

  /**
   * A boolean method taking an obj and comparing to this Date object.
   *
   * @param obj other Date object that we want to compare.
   * @return "True" if the two Dates are identical. "False" if the obj is not a Date object or the two Dates are not identical.
   */
  public boolean equals(Object obj)
  {
    if (!(obj instanceof Date))
    {
      return false;
    }

    Date other = (Date) obj;

    return day == other.day && month == other.month && year == other.year;
  }

}


