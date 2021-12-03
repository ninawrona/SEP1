package model.basic;

import model.list.CourseList;
import model.list.StudentList;

public class ClassGroup
{
  private StudentList students;
  private CourseList courses;
  private String className;
  private int semester;

  public ClassGroup(int semester, String className, StudentList studentList)
  {
    this.semester = semester;
    this.className = className;
    courses = new CourseList();
    this.students = studentList;
  }

  public ClassGroup(int semester, String className){
    this.semester = semester;
    this.className = className;
    courses = new CourseList();
    students = new StudentList();
  }



  public StudentList getStudents()
  {
    return students;
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

  public void addCourse(Course course)
  {
    courses.addCourse(course);
  }

  public void addStudent(Student student){
    students.addStudent(student);
  }

  public void removeStudent(Student student){
    students.removeStudent(student);
  }

  public ClassGroup copy()
  {
    ClassGroup copy = new ClassGroup(this.semester, this.className,
        this.students);
    return copy;
  }

  public String fullPrintOut()
  {
    String str = "\n" +semester + className +"\n";

    for (int i = 0; i < courses.size(); i++)
    {
      str += courses.get(i).toString();
    }

    for (int i = 0; i < students.size(); i++)
    {
      str += students.get(i).toString();
    }
    return str;
  }

  @Override
  public String toString() {
    return semester + className;
  }

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
