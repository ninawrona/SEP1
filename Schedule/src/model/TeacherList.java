package model;

import java.util.ArrayList;

public class TeacherList
{
  private ArrayList<Teacher> teachers;

  public TeacherList(){
    teachers = new ArrayList<>();
  }

  public int size(){
    return teachers.size();
  }

  public void addTeacher(Teacher teacher){
    teachers.add(teacher);
  }

  public void removeTeacher(Teacher teacher){
    teachers.remove(teacher);
  }

  public Teacher getTeacherByName(String name){
    for (int i = 0; i < teachers.size(); i++){
      if (teachers.get(i).getName().equals(name)){
        return teachers.get(i);
      }
    }
    System.out.println("There is no such teacher");
    return null;
  }

  public Teacher getTeacherByViaId(String viaId){
    for (int i = 0; i < teachers.size();i++){
      if (teachers.get(i).getViaId().equals(viaId)){
        return teachers.get(i);
      }
    }
    System.out.println("There is no teacher with that Via Id");
    return null;
  }

  public Teacher getTeacherByIndex(int index){
    return teachers.get(index);
  }

  public String toString(){
    String str = "";
    for (int i = 0; i < teachers.size(); i++){
      str += teachers.get(i).toString();
    }
    return str;
  }

  public boolean equals(Object obj){
    if (!(obj instanceof TeacherList)){
      return false;
    }

    TeacherList other = (TeacherList)obj;

    boolean equals = true;

    for (int i = 0; i < teachers.size(); i++){
      if (!(teachers.get(i).equals(other.teachers.get(i)))){
        equals = false;
      }
    }
    return equals;
  }
}
