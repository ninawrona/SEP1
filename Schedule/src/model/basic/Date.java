package model.basic;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

/**
 * A class representing the date.
 *
 * @author Christian Foyer, Kamil Fischbach, Martin Rosendahl, Nina Wrona, Robert Barta
 * @version 1 - 2 December 2021
 */

public class Date {
    private int day;
    private int month;
    private int year;

    /**
     * Three-argument constructor taking a day, month, year all being an integer type.
     *
     * @param day   the day of the date
     * @param month the month of the date
     * @param year  the year of the date
     */

    public Date(int day, int month, int year) {
        set(day, month, year);

        if (isWeekend()) {
            throw new IllegalArgumentException(
                    "You cannot book the sessions during weekend!");
        }

    }

    /**
     * Overloaded zero-argument constructor creating a date object with today's date.
     */

    public Date() {
        LocalDate today = LocalDate.now();
        set(today.getDayOfMonth(), today.getMonthValue(), today.getYear());
    }

    /**
     * A method returning a String representing the name of the week day for this Date object.
     *
     * @return A String object containing the weekday name.
     */

    public String getWeekday() {
        LocalDate date = LocalDate.of(year, month, day);
        String weekdayName = "";
        weekdayName = date.getDayOfWeek().toString();
        return weekdayName;
    }

    //todo java doc
    public int getWeekNumber() {
        LocalDate date = LocalDate.of(year, month, day);
        return date.get(ChronoField.ALIGNED_WEEK_OF_YEAR);
    }

    /**
     * A boolean method checking if this Date object is a weekend.
     *
     * @return "True" if it is a day of the weekend, or "False" if it is not.
     */
    public boolean isWeekend() {
        return (getWeekday().equals("SATURDAY") || getWeekday().equals("SUNDAY"));
    }

    /**
     * A getter method returning the day.
     *
     * @return a day int
     */

    public int getDay() {
        return day;
    }

    /**
     * A getter method returning a month object.
     *
     * @return a month int
     */

    public int getMonth() {
        return month;
    }

    /**
     * A getter method returning a year object.
     *
     * @return a year int
     */

    public int getYear() {
        return year;
    }

    /**
     * A void method checking if the values for day, month, year are legal.
     *
     * @param day   a day int
     * @param month a month int
     * @param year  a year int
     */

    public void set(int day, int month, int year) {
        if (day < 1 || day > 31 || month < 1 || month > 12 || year < 1) {
            throw new IllegalArgumentException("Entered values are illegal.");
        }
        if (month == 2) {
            if (isLeapYear()) {
                if (day > 29) {
                    throw new IllegalArgumentException(
                            "In a leap year there are 29 days in February.");
                } else {
                    if (day > 28) {
                        throw new IllegalArgumentException(
                                "There are 28 days in February.");
                    }
                }
            } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                if (day > 30) {
                    throw new IllegalArgumentException(
                            "There are 30 days in chosen month.");
                }
            } else {
                if (day > 31) {
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

    public int numberOfDaysInMonth() {
        if (month == 2) {
            if (isLeapYear()) {
                return 29;
            } else {
                return 28;
            }
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else {
            return 31;
        }
    }

    /**
     * A boolean method checking if the year of this Date object is a leap year.
     *
     * @return "True" when the year is a leap year. "False" when the year is not a leap year.
     */
    public boolean isLeapYear() {
        if ((year % 4) == 0 && (((year % 100) != 0) || ((year % 400) == 0))) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * A void method increasing the value of the day for this Date object by one.
     */

    public void stepForwardOneDay() {
        day++;
        if (day > numberOfDaysInMonth()) {
            day = 1;
            month++;
            if (month > 12) {
                month = 1;
                year++;
            }
        }
    }

    /**
     * A void method increasing the value of the day for this Date object by the given parameter.
     *
     * @param days the number of the days to step forward.
     */
    public void stepForward(int days) {

        for (int i = 0; i < days; i++) {
            stepForwardOneDay();
        }

    }

    /**
     * A Date method creating a copy of this Date object.
     *
     * @return A Date object.
     */
    public Date copy() {
        return new Date(this.day, this.month, this.year);
    }

    /**
     * A String method returning a day, month, year as a String in a proper format.
     *
     * @return A String object.
     */
    public String toString() {
        String s = "";
        if (day < 10) {
            s += "0";
        }
        s += day + "/";
        if (month < 10) {
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
    public boolean equals(Object obj) {
        if (!(obj instanceof Date)) {
            return false;
        }

        Date other = (Date) obj;

        return day == other.day && month == other.month && year == other.year;
    }

}


