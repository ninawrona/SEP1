package model.basic;

import model.list.CourseList;
import model.list.SessionList;

public class Teacher
{
  private String name;
  private String viaId;
  private CourseList coursesTaught;
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
    return coursesTaught;
  }

  public void assignToCourse(Course course){
    coursesTaught.addCourse(course);
  }

  public void removeFromCourse(Course course){
    coursesTaught.removeCourse(course);
  }

  public SessionList getSessions()
  {
    return sessions;
  }

  public void addSession(Session session)
  {
    sessions.addSession(session);
  }

  public void removeSession(Session session)
  {
    sessions.removeSession(session);
  }


  public boolean isAvailable(Session session){
    for (int i = 0; i < sessions.size(); i++){
      if (sessions.get(i).isOverlapped(session)){
        return false;
      }
    }
    return true;
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
