package model;

import java.util.ArrayList;

public class Course
{
  private int semester;
  private String classString;
  private String courseName;
  private String teacher1;
  private String teacher2;
  private int ECTS;
  private Class1 class1;
  private ArrayList<Teacher> teachers;
  private ArrayList<Student> students;

  public Course(int semester, String classString, String courseName,
      String teacher1, int ECTS)
  {
    this.semester = semester;
    this.classString = classString;
    this.courseName = courseName;
    this.teacher1 = teacher1;
    this.teacher2 = null;
    this.ECTS = ECTS;
    class1 = new Class1(semester, classString);
    teachers = new ArrayList<>();
    students = new ArrayList<>();
  }

  public Course(int semester, String classString, String courseName,
      String teacher1, String teacher2, int ECTS)
  {
    this.semester = semester;
    this.classString = classString;
    this.courseName = courseName;
    this.teacher1 = teacher1;
    this.teacher2 = teacher2;
    this.ECTS = ECTS;
    class1 = new Class1(semester, classString);
    teachers = new ArrayList<>();
    students = new ArrayList<>();
  }

  public void addTeacher(Teacher teacher)
  {
    teachers.add(teacher);
  }

  public void removeTeacher(Teacher teacher)
  {
    teachers.remove(teacher);
  }

  public void addStudent(Student student)
  {
    students.add(student);
  }

  public void removeStudent(Student student)
  {
    students.remove(student);
  }



  public int getSemester()
  {
    return semester;
  }

  public String getClassString()
  {
    return classString;
  }

  public String getCourseName()
  {
    return courseName;
  }

  public String getTeacher1()
  {
    return teacher1;
  }

  public String getTeacher2()
  {
    return teacher2;
  }

  public int getECTS()
  {
    return ECTS;
  }

  public String toString()
  {
    return "\nSemester:" + semester + "\nClass:" + classString + "\nCourseName:"
        + courseName + "\nTeacher1:" + teacher1 + "\nTeacher2:" + teacher2
        + "\nECTS:" + ECTS + "\n";
  }
}
