package model.list;

import model.basic.Course;
import model.basic.Teacher;

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

  public Course get(int index)
  {
    return courses.get(index);
  }

  public void addCourse(Course course)
  {
    if (course == null)
    {
      throw new IllegalArgumentException("Parameter cannot be null!");
    }
    courses.add(course);
  }

  public void removeCourse(Course course)
  {
    if (size() == 0)
    {
      throw new NullPointerException(
          "The list is empty! You cannot remove anything!");
    }
    if (course == null)
    {
      throw new IllegalArgumentException("Parameter cannot be null!");
    }
    courses.remove(course);
  }

  public Course getCourseByName(String name)
  {
    for (int i = 0; i < courses.size(); i++)
    {
      if (courses.get(i).getName().equals(name))
      {
        return courses.get(i);
      }
    }
    throw new NullPointerException("There is no course by that name");
  }

  public CourseList getCoursesByTeacher(Teacher teacher)
  {
    CourseList list = new CourseList();

    for (int i = 0; i < courses.size(); i++)
    {
      if (courses.get(i).getTeachers().contains(teacher))
      {
        list.addCourse(courses.get(i));
      }
    }
    if (list.size() > 0)
    {
      return list;
    }
    else
    {
      throw new NullPointerException("No courses are taught by this teacher");
    }
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
