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
  private StudentList students;
  private TeacherList teachers;
  private Teacher teach1;
  private Teacher teach2;

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
    teach1 = new Teacher(teacher1);
    teach2 = null;
    students = new StudentList();
    teachers = new TeacherList();
    teachers.addTeacher(teach1);
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
    teach2 = new Teacher(teacher2);
    students = new StudentList();
    teachers = new TeacherList();
    teachers.addTeacher(teach1);
    teachers.addTeacher(teach2);
  }

  public void addTeacher(Teacher teacher)
  {
    if (teachers.size()<4){
      teachers.addTeacher(teacher);
    } else {
      throw new ArrayStoreException("Max Number of Teachers Reached");
    }
  }

  public void removeTeacher(Teacher teacher)
  {
    teachers.removeTeacher(teacher);
  }

  public void addStudent(Student student)
  {
    students.addStudent(student);
  }

  public void removeStudent(Student student)
  {
    students.removeStudent(student);
  }

  public Class1 getClass1(){
    return class1;
  }

  public TeacherList getTeachers(){
    return teachers;
  }

  public StudentList getStudents(){
    return students;
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
    return "\nClass: " + class1 + "\nCourseName:"
        + courseName + "\nTeacher1:" + teacher1 + "\nTeacher2:" + teacher2
        + "\nECTS:" + ECTS + "\n";
  }
}
