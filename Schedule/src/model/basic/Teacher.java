package model.basic;

import model.list.CourseList;
import model.list.SessionList;
/**
 * A class representing a teacher.
 *
 * @author Christian Foyer, Kamil Fischbach, Martin Rosendahl, Nina Wrona, Robert Barta
 * @version 1 - 2 December 2021
 */
public class Teacher
{
  private String viaId;
  private CourseList coursesTaught;
  private SessionList sessions;

  /**
   * One-argument constructor taking the teacher's VIA ID.
   * @param viaId
   *            the VIA ID of the teacher.
   */
  public Teacher(String viaId)
  {


    if (viaId==(null))
    {
      throw new IllegalArgumentException("VIA ID can not be null");
    }

    this.viaId = viaId;
    this.sessions= new SessionList();
    this.coursesTaught=new CourseList();
  }

  /**
   * A getter method returning the VIA ID of the teacher.
   * @return a String representing the teacher's VIA ID.
   */
  public String getViaId()
  {
    return viaId;
  }

  /**
   * A getter method returning the list of courses taught by the teacher.
   * @return A CourseList object.
   */
  public CourseList getCoursesTaught()
  {
    return coursesTaught;
  }

  /**
   * A void method assigning a course to a teacher.
   * @param course
   *            the Course object to be added to the teacher's course list.
   */
  public void assignToCourseTaught(Course course)
  {
    coursesTaught.addCourse(course);
  }

  /**
   * A void method removing a course from a teacher's list. There must be at least one course to be removed.
   * @param course
   *            the Course object to be removed from the teacher's course list.
   */
  public void removeFromCoursesTaught(Course course)
  {
    if (coursesTaught.size()==0)
    {
      throw new NullPointerException(
          "The list is empty! You cannot remove anything!");
    }
    else coursesTaught.removeCourse(course);
  }

  /**
   * A method returning the teacher's information.
   * @return a String representation of the Teacher object containing the teacher's VIA ID, and the taught courses.
   */
  public String toString()
  {
    return "\nVia ID: " + viaId + "\nCourses Taught: "
        + coursesTaught;
  }

  /**
   * A method comparing two objects.
   * @param obj
   *          an object representing the other object to be compared.
   * @return "True" if the two Teacher objects are identical, "False" if they are not.
   */
  public boolean equals(Object obj)
  {
    if (!(obj instanceof Teacher))
    {
      return false;
    }
    Teacher other = (Teacher) obj;

    return viaId.equals(other.viaId);
  }
}
