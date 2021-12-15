package model.basic;

import model.list.CourseList;
import model.list.StudentList;

/**
 * A class representing a class of students(hereafter referred to as "ClassGroup"). A ClassGroup has a list of students, a list of courses,
 * a name (for example: 'X', 'Y', 'Z', or 'DK'), and a semester.
 *
 * @author Christian Foyer, Kamil Fischbach, Martin Rosendahl, Nina Wrona, Robert Barta
 * @version 1 - 2 December 2021
 */
public class ClassGroup
{
  private StudentList students;
  private CourseList courses;
  private String className;
  private int semester;

  /**
   * Three-argument constructor creating a Class Group for a chosen semester with a given class name and list of students.
   * A new course list is generated for the class.
   *
   * @param semester    the semester of the class.
   * @param className   the name of the class.
   * @param studentList the list of students enrolled in the class.
   */
  public ClassGroup(int semester, String className, StudentList studentList)
  {
    this.semester = semester;
    this.className = className;
    courses = new CourseList();
    this.students = studentList;
  }

  /**
   * Two-argument overloaded constructor taking only the name of the class and the semester.
   * A new course list and student list is generated for the class.
   *
   * @param semester  the semester of the class.
   * @param className the name of the class.
   */
  public ClassGroup(int semester, String className)
  {
    this.semester = semester;
    this.className = className;
    courses = new CourseList();
    students = new StudentList();
  }

  /**
   * A getter method returning the students from the ClassGroup.
   *
   * @return an ArrayList containing the Student objects enrolled into the ClassGroup.
   */
  public StudentList getStudents()
  {
    return students;
  }

  /**
   * A getter method returning the name of the ClassGroup.
   *
   * @return A string representing the name of the ClassGroup.
   */
  public String getClassName()
  {
    return className;
  }

  /**
   * A getter method returning the semester of the class.
   *
   * @return an int representing the semester of the Class Group.
   */
  public int getSemester()
  {
    return semester;
  }

  /**
   * A getter method returning the courses that are taught for the ClassGroup.
   *
   * @return an ArrayList containing the Course objects that are taught for the ClassGroup.
   */
  public CourseList getCourses()
  {
    return courses;
  }

  /**
   * A method that adds a course to the ClassGroup. The ClassGroup is set within the Course as well.
   *
   * @param course the course to be added to the CourseList of the ClassGroup.
   */
  public void addCourse(Course course)
  {
    courses.addCourse(course);
    course.setClassGroup(this);
  }

  /**
   * A method that adds a student to the ClassGroup.
   *
   * @param student the Student object to be added to the ClassGroup.
   */
  public void addStudent(Student student)
  {
    students.addStudent(student);
  }

  /**
   * A method that removes a student from the ClassGroup.
   *
   * @param student the Student object is removed from the ClassGroup.
   */
  public void removeStudent(Student student)
  {
    students.removeStudent(student);
  }

  /**
   * A method creating a copy of the ClassGroup object.
   *
   * @return a copy of the ClassGroup object
   */
  public ClassGroup copy()
  {
    ClassGroup copy = new ClassGroup(this.semester, this.className,
        this.students);
    return copy;
  }

  /**
   * An overridden method returning a string representing some of the ClassGroup's details.
   *
   * @return a string containing the semester and the name of the ClassGroup.
   */
  @Override public String toString()
  {
    return semester + className;
  }

  /**
   * A method comparing two objects.
   *
   * @param obj an object representing the object to be compared with.
   * @return "True" if the compared ClassGroup objects are the same, or "False" if they are different objects.
   */
  public boolean equals(Object obj)
  {
    if (!(obj instanceof ClassGroup))
    {
      return false;
    }
    ClassGroup other = (ClassGroup) obj;

    return className.equals(other.className) && semester == other.semester
        && students.equals(other.students) && courses.equals(other.courses);
  }
}
