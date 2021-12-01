package model.basic;

import model.list.CourseList;
import model.list.SessionList;

public class Teacher
{
  private String name;
  private String viaId;
  private CourseList coursesTaught;

  public Teacher(String viaId, String name){
    if (name.equals(null)){
      throw new IllegalArgumentException("Name can not be null");
    }
    if (viaId.equals(null)){
      throw new IllegalArgumentException("Via ID can not be null");
    }

    this.viaId = viaId;
    this.name = name;
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

  public void assignToCourse(Course course){
    coursesTaught.addCourse(course);
  }

  public void removeFromCourse(Course course){
    coursesTaught.removeCourse(course);
  }





  public String toString(){
    return "Name: " + name + "\nVia ID: " + viaId + "\nCourses: " + coursesTaught;
  }

  public boolean equals(Object obj){
    if (!(obj instanceof Teacher)){
      return false;
    }
    Teacher other = (Teacher)obj;

    return name.equals(other.name) && viaId.equals(other.viaId);
  }
}
