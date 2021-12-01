package model.basic;

import model.list.StudentList;
import model.list.TeacherList;

public class Course
{
  private String name;
  private ClassGroup classGroup;
  private TeacherList teachers;
  private int semesterTaught;
  private int ECTS;

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

  public void removeTeacher(Teacher teacher)
  {
    teachers.removeTeacher(teacher);
  }

  public void addStudent(Student student)
  {
    classGroup.addStudent(student);
  }

  public void removeStudent(Student student)
  {
    classGroup.removeStudent(student);
  }

  public String getName()
  {
    return name;
  }

  public ClassGroup getClassGroup()
  {
    return classGroup;
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

  public String toString()
  {
    String s = "";

    s += "\nClass: " + classGroup + "\nCourseName:" + name;
    for (int j = 0; j < teachers.size(); j++)
    {
      s += "\n Teacher: " + teachers.get(j);
    }
    s += "\n ECTS: " + ECTS;
    return s;
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
