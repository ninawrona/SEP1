package model.basic;

import model.list.StudentList;
import model.list.TeacherList;
/**
 * A subclass representing the course.
 *
 * @author Christian Foyer, Kamil Fischbach, Martin Rosendahl, Nina Wrona, Robert Barta
 * @version 1 - 2 December 2021
 */
public class Course
{
  private String name;
  private ClassGroup classGroup;
  private TeacherList teachers;
  private int semesterTaught;
  private int ECTS;

  /**
   * Five-argument constructor. The name cannot be null, the semester has to be an integer between 1 and 7. The legal values for
   * the ECTS are 5, 10 and 15.
   * @param name
   *          the name of the course.
   * @param classGroup
   *          the class this course is taught to.
   * @param teachers
   *          the teacher(s) teaching this course.
   * @param semesterTaught
   *          the semester in which this course is taught.
   * @param ECTS
   *          the ECTS value of this course.
   */
  public Course(String name, ClassGroup classGroup, TeacherList teachers,
      int semesterTaught, int ECTS)
  {
    if (name == null || classGroup == null || teachers == null)
    {
      throw new IllegalArgumentException("Parameters cannot be null!");
    }
    if (semesterTaught < 1 || semesterTaught > 7)
    {
      throw new IllegalArgumentException(
          "Semester has to be an integer between 1 and 7.");
    }
    if (!(ECTS == 5 || ECTS == 10 || ECTS == 15))
    {
      throw new IllegalArgumentException(
          "Legal values for ECTS are 5, 10 or 15.");
    }
    this.name = name;
    this.classGroup = classGroup.copy();
    this.teachers = teachers;
    this.semesterTaught = semesterTaught;
    this.ECTS = ECTS;
  }

  // Debugging constructor
  public Course(String name)
  {
    this.name = name;
    classGroup = null;
    teachers = null;
    semesterTaught = 0;
    ECTS = 0;
  }

  /**
   * A void method that adds a teacher to the course. A course may not have more than 3 teachers.
   * @param teacher
   *            the Teacher object to be added to the course.
   */
  public void addTeacher(Teacher teacher)
  {
    if (teachers.size() < 4)
    {
      teachers.addTeacher(teacher);
    }
    else
    {
      throw new ArrayStoreException("Max Number of Teachers Reached");
    }
  }

  /**
   * A void method that removes a teacher from the course. There must be at least one teacher on the list before removing.
   * @param teacher
   *              the teacher to be removed from the course.
   */
  public void removeTeacher(Teacher teacher)
  {
    if (teachers.size()==0)
    {
      throw new NullPointerException(
          "The list is empty! You cannot remove anything!");
    }
    teachers.removeTeacher(teacher);
  }

  /**
   * A void method that adds a student to the copy of the ClassGroup. The student is then assigned to this course.
   * @param student
   *              the Student object to be added.
   */
  public void addStudent(Student student)
  {
    classGroup.addStudent(student);
  }

  /**
   * A void method that removes a student from the copy of the ClassGroup. The studdent is only removed from this course, not the whole ClassGroup (if he is a member of it).
   * @param student
   *              the Student object to be removed.
   */
  public void removeStudent(Student student)
  {
    classGroup.removeStudent(student);
  }

  /**
   * A getter method returning the name of the course.
   * @return a String representation of the Course object's name.
   */
  public String getName()
  {
    return name;
  }

  /**
   * A getter method returning the class assigned to this course.
   * @return the ClassGroup object assigned to this Course.
   */
  public ClassGroup getClassGroup()
  {
    return classGroup;
  }

  // I needed a method to set the classGroup inside a course because courses
  // are within classgroups. When I added a course to a classgroup, that
  // course was not getting the classgroup set at the same time.
  // Alt + F7 to find usages- CF 5/12

  /**
   *
   * @param classGroup
   */
  public void setClassGroup(ClassGroup classGroup)
  {
    this.classGroup = classGroup;
  }

  public TeacherList getTeachers()
  {
    return teachers;
  }

  public StudentList getStudents()
  {
    return classGroup.getStudents();
  }

  public int getSemesterTaught()
  {
    return semesterTaught;
  }

  public int getECTS()
  {
    return ECTS;
  }

  /*public String toString()
  {
    String s = "";

    s += "Class: " + classGroup + "\nCourseName:" + name;
    for (int j = 0; j < teachers.size(); j++)
    {
      s += "\nTeacher: " + teachers.get(j).getViaId();
    }
    s += "\nECTS: " + ECTS +"\n";
    return s;
  }*/

  @Override public String toString()
  {
    return name;
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Course))
    {
      return false;
    }

    Course other = (Course) obj;

    return name.equals(other.name) && semesterTaught == other.semesterTaught
        && ECTS == other.ECTS;
  }

}
