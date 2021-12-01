package model.basic;

import model.list.CourseList;
import model.list.SessionList;

public class Teacher
{
  private String name;
  private String viaId;
  private CourseList courses;
  private SessionList sessions;

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
    return courses;
  }

  public void assignToCourse(Course course){
    courses.addCourse(course);
  }

  public void removeFromCourse(Course course){
    courses.removeCourse(course);
  }


  public String toString(){
    return "Name: " + name + "\nVia ID: " + viaId + "\nCourses: " + courses;
  }

  public boolean equals(Object obj){
    if (!(obj instanceof Teacher)){
      return false;
    }
    Teacher other = (Teacher)obj;

    return name.equals(other.name) && viaId.equals(other.viaId);
  }
}
