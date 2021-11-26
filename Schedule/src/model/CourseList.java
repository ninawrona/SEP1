package model;

import java.util.ArrayList;

public class CourseList
{
  private ArrayList<Course> courses;

  public CourseList()
  {
    courses = new ArrayList<>();
  }

  public int size()
  {
    return courses.size();
  }

  public Course getCourseByName(String name)
  {
    for (int i = 0; i < courses.size(); i++)
    {
      if (courses.get(i).getCourseName().equals(name))
      {
        return courses.get(i);
      }
    }
    System.out.println("There is no course by that name");
    return null;
  }

  public Course getCourseByIndex(int index)
  {
    return courses.get(index);
  }

  public void addCourse(Course course)
  {
    courses.add(course);
  }

  public void removeCourse(Course course)
  {
    courses.remove(course);
  }

  public String toString()
  {
    String str = "";
    for (int i = 0; i < courses.size(); i++)
    {
      str += courses.get(i).toString();
    }
    return str;
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof CourseList))
    {
      return false;
    }

    CourseList other = (CourseList) obj;

    if (courses.size() == other.size())
    {
      for (int i = 0; i < courses.size(); i++)
      {
        if (!(courses.get(i).equals(other.courses.get(i))))
        {
          return false;
        }
      }
      return true;
    }
    return false;
  }
}
