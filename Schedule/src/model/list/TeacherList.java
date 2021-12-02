package model.list;

import model.basic.Course;
import model.basic.Teacher;

import java.util.ArrayList;

public class TeacherList
{
  private ArrayList<Teacher> teachers;

  public TeacherList()
  {
    teachers = new ArrayList<>();
  }

  public int size()
  {
    return teachers.size();
  }

  public Teacher get(int index)
  {
    return teachers.get(index);
  }

  public void addTeacher(Teacher teacher)
  {
    if (teacher == null)
    {
      throw new IllegalArgumentException("Teacher can not be null");
    }
    teachers.add(teacher);
  }

  public void removeTeacher(Teacher teacher)
  {
    if(size()==0)
    {
      throw new NullPointerException("The list is empty! You cannot remove anything!");
    }
    if (teacher == null)
    {
      throw new IllegalArgumentException("Teacher can not be null");
    }
    teachers.remove(teacher);
  }

  public Teacher getTeacherByName(String name)
  {
    if (name == null)
    {
      throw new NullPointerException("Name cannot be null!");
    }
    for (int i = 0; i < teachers.size(); i++)
    {
      if (teachers.get(i).getName().equals(name))
      {
        return teachers.get(i);
      }
    }
    throw new IllegalArgumentException("There is no such teacher");
  }

  public Teacher getTeacherByViaId(String viaId)
  {

    if (viaId == null)
    {
      throw new NullPointerException("Via ID can not be null");
    }
    //There might be an exception if there more than 4 characters or so
    //but we are not sure
    for (int i = 0; i < teachers.size(); i++)
    {
      if (teachers.get(i).getViaId().equals(viaId))
      {
        return teachers.get(i);
      }
    }
    throw new IllegalArgumentException("There is no teacher with that via id");
  }

  public TeacherList getTeachersByCourse(Course course)
  {
    TeacherList list = new TeacherList();

    for (int i = 0; i < teachers.size(); i++)
    {
      for (int j = 0; i < teachers.get(i).getCoursesTaught().size(); j++)
      {
        if (teachers.get(i).getCoursesTaught().get(i).equals(course))
        {
          list.addTeacher(teachers.get(i));
        }
      }
    }
    if (list.size() > 0)
    {
      return list;
    }
    else
    {
      throw new NullPointerException("That course is not taught");
    }
  }



  public boolean contains(Teacher teacher)
  {
    if(teacher==null)
    {
      throw new NullPointerException("Parameter cannot be null!");
    }
    if(teachers.contains(teacher))
    {
      return true;
    }
    return false;
  }

  public void clear(){
    for (int i = 0; i < teachers.size(); i++){
      teachers.remove(i);
    }
  }

  public String toString()
  {
    String str = "";
    for (int i = 0; i < teachers.size(); i++)
    {
      if (teachers.get(i) == null){
        str += "";
      } else {
        str += i + 1 + ". " + teachers.get(i).toString();
      }

    }
    return str;
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof TeacherList))
    {
      return false;
    }

    TeacherList other = (TeacherList) obj;

    boolean equals = true;

    for (int i = 0; i < teachers.size(); i++)
    {
      if (!(teachers.get(i).equals(other.get(i))))
      {
        equals = false;
      }
    }
    return equals;
  }
}
