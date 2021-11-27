package model.list;

import model.basic.Student;

import java.util.ArrayList;

public class StudentList
{
  private ArrayList<Student> students;

  public StudentList()
  {
    this.students = new ArrayList<>();
  }

  public int size()
  {
    return students.size();
  }

  public Student get(int index) //This methods overrides a get in ArrayList class
  {
    return students.get(index);
  }
  public void addStudent(Student student)
  {
    if(student == null)
    {
      throw new IllegalArgumentException("Student cannot be null!");
    }
    students.add(student);
  }

  public void removeStudent(Student student)
  {
    if(student == null)
    {
      throw new IllegalArgumentException("Student cannot be null!");
    }
    for(int i =0; i<size(); i++)
    {
      if(student.equals(students.get(i)))
      {
        students.remove(student);
        break;
      }
    }
  }

  public Student getStudentByName(String name)
  {
    if(name == null)
    {
      throw new IllegalArgumentException("Name cannot be null!");
    }
    for(int i =0; i<size(); i++)
    {
      if(name.equals(students.get(i).getName()))
      {
        return students.get(i);
      }
    }
    return null;
  }

  public Student getStudentByViaId(int ViaId)
  {
    if(!(String.valueOf(ViaId).length() == 6))
    {
      throw new IllegalArgumentException("The VIA ID has to have 6 digits!");
    }
    for(int i =0; i<size(); i++)
    {
      if(ViaId == (students.get(i).getViaId()))
      {
        return students.get(i);
      }
    }
    return null;
  }

  public String toString()
  {

    String s ="";
    for(int i =0; i<size(); i++)
    {
      s+= i+1 +"." + students.get(i).toString();
    }
    return s;
  }

  public boolean equals(Object obj)
  {
    if(!(obj instanceof StudentList))
    {
      return false;
    }
    StudentList other = (StudentList)obj;
    if(size() == other.size())
    {
      for(int i=0; i<size(); i++)
      {
        if (!(students.get(i).equals(other.get(i))))
        {
          return false;
        }
      }
      return true;
    }
    return false;

  }




}
