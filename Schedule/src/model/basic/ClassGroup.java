package model.basic;

import model.list.CourseList;
import model.list.StudentList;

public class ClassGroup
{
  private StudentList studentList;
  private CourseList courses;
  private String className;
  private int semester;

  public ClassGroup(int semester, String className, StudentList studentList)
  {
    this.semester = semester;
    this.className = className;
    courses = new CourseList();
    this.studentList = studentList;
  }

  public ClassGroup(int semester, String className){
    this.semester = semester;
    this.className = className;
    courses = new CourseList();
    studentList = new StudentList();
  }



  public StudentList getStudents()
  {
    return studentList;
  }

  public String getClassName()
  {
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

  public void addStudent(Student student){
    studentList.addStudent(student);
  }

  public void removeStudent(Student student){
    studentList.removeStudent(student);
  }

  public ClassGroup copy()
  {
    ClassGroup copy = new ClassGroup(this.semester, this.className,
        this.studentList);
    return copy;
  }

  public String toString()
  {
    String str = "\n" +semester + className +"\n";

    for (int i = 0; i < courses.size(); i++)
    {
      str += courses.get(i).toString();
    }

    for (int i = 0; i < studentList.size(); i++)
    {
      str += studentList.get(i).toString();
    }
    return str;
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof ClassGroup))
    {
      return false;
    }
    ClassGroup other = (ClassGroup) obj;

    return className.equals(other.className) && semester == other.semester
        && studentList.equals(other.studentList) && courses.equals(other.courses);
  }
}
