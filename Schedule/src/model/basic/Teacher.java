package model.basic;

import model.list.CourseList;
import model.list.SessionList;

public class Teacher
{
  private String name;
  private String viaId;
  private CourseList coursesTaught;
  private SessionList sessions;

  public Teacher(String viaId)
  {
    // Name is viaId for debugging
    // todo add name to list
    this.name = viaId;
    if (viaId.equals(null))
    {
      throw new IllegalArgumentException("Via ID can not be null");
    }
    coursesTaught = new CourseList();

    this.viaId = viaId;
  }

  public String getName()
  {
    return name;
  }

  public String getViaId()
  {
    return viaId;
  }

  public CourseList getCoursesTaught()
  {
    return coursesTaught;
  }

  public void assignToCourseTaught(Course course)
  {
    coursesTaught.addCourse(course);
  }

  public void removeFromCoursesTaught(Course course)
  {
    coursesTaught.removeCourse(course);
  }

  public String toString()
  {
    return "Name: " + name + "\nVia ID: " + viaId + "\nCourses Taught: "
        + coursesTaught;
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Teacher))
    {
      return false;
    }
    Teacher other = (Teacher) obj;

    return name.equals(other.name) && viaId.equals(other.viaId);
  }
}
