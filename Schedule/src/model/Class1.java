package model;

import java.util.ArrayList;

public class Class1
{
  private ArrayList<Student> students;
  private CourseList courses;
  private String className;
  private int semester;

  public Class1(int semester, String className){
    this.semester = semester;
    this.className = className;
    students = new ArrayList<>();
    courses = new CourseList();
  }

  public ArrayList<Student> getStudents(){
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
      str += courses.getCourseByIndex(i).toString();
    }

    for (int i = 0; i < students.size(); i++){
      str += students.get(i).toString();
    }
    return str;
  }

  public boolean equals(Object obj){
    if (!(obj instanceof Class1)){
      return false;
    }
    Class1 other = (Class1)obj;

    return className.equals(other.className) && semester == other.semester && students.equals(other.students) && courses.equals(other.courses);
  }
}
