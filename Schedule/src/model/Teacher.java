package model;

import java.util.ArrayList;

public class Teacher
{
  private String name;
  private String viaId;
  private ArrayList<Course> courseList;
  private SessionList sessionList;

  public Teacher(String viaId){
    this.viaId = viaId;
    this.name = "";
    courseList = new ArrayList<>();
    sessionList = new SessionList();
  }

  public String getName(){
    return name;
  }

  public String getViaId(){
    return viaId;
  }

  public ArrayList<Course> getCourses(){
    return courseList;
  }

  public void assignToCourse(Course course){
    courseList.add(course);
  }

  public void removeFromCourse(Course course){
    courseList.remove(course);
  }

  public boolean isAvailable(TimeInterval timeDate){
    for (int i = 0; i < sessionList.size(); i++){
      if (sessionList.get(i).getTimeInterval.isOverlap(timeDate)){
        return false;
      }
    }
    return true;
  }

  public String toString(){
    return "Name: " + name + "\nVia ID: " + viaId + "\nCourses: " + courseList;
  }

  public boolean equals(Object obj){
    if (!(obj instanceof Teacher)){
      return false;
    }
    Teacher other = (Teacher)obj;

    return name.equals(other.name) && viaId.equals(other.viaId);
  }
}
