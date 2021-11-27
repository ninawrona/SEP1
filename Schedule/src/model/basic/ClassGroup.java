package model.basic;

import model.list.CourseList;
import model.list.StudentList;

public class ClassGroup
{
  private StudentList students;
  private CourseList courses;
  private String className;
  private int semester;

  public ClassGroup(int semester, String className){
    this.semester = semester;
    this.className = className;
    students = new StudentList();
    courses = new CourseList();
  }

  public StudentList getStudents(){
    return students;
  }

  public String getClassName(){
    return className;
  }

  public int getSemester()
  {
    return semester;
  }

  public CourseList getCourses()
  {
    return courses;
  }

  public String toString(){
    String str = semester + className;


    for (int i = 0; i < courses.size(); i++){
      str += courses.get(i).toString();
    }

    for (int i = 0; i < students.size(); i++){
      str += students.get(i).toString();
    }
    return str;
  }

  public boolean equals(Object obj){
    if (!(obj instanceof ClassGroup)){
      return false;
    }
    ClassGroup other = (ClassGroup)obj;

    return className.equals(other.className) && semester == other.semester && students.equals(other.students) && courses.equals(other.courses);
  }
}