package model.basic;

import model.list.CourseList;
import model.list.SessionList;

public class Teacher
{
  private String name;
  private String viaId;
  private CourseList coursesTaught;
  private SessionList sessions;

  public Teacher(String viaId){
    name = null;
    if (viaId.equals(null)){
      throw new IllegalArgumentException("Via ID can not be null");
    }

    this.viaId = viaId;
    coursesTaught = new CourseList();
    sessions = new SessionList();
  }

  public String getName(){
    return name;
  }

  public String getViaId(){
    return viaId;
  }

  public CourseList getCoursesTaught(){
    return coursesTaught;
  }

  public void assignToCourseTaught(Course course){
    coursesTaught.addCourse(course);
  }

  public void removeFromCoursesTaught(Course course){
    coursesTaught.removeCourse(course);
  }


  public String toString(){
    return "Name: " + name + "\nVia ID: " + viaId ;
  }

  public boolean equals(Object obj){
    if (!(obj instanceof Teacher)){
      return false;
    }
    Teacher other = (Teacher)obj;

    if(name==null && other.name==null)
    {
      return viaId.equals(other.viaId);
    }
    else
    {
      return name.equals(other.name) && viaId.equals(other.viaId);
    }
  }
}
