package model.list;

import model.basic.Student;

import java.util.ArrayList;

/**
 * A class representing a list of teachers.
 *
 * @author Christian Foyer, Kamil Fischbach, Martin Rosendahl, Nina Wrona, Robert Barta
 * @version 1 - 2 December 2021
 */
public class StudentList
{
  private ArrayList<Student> students;

  /**
   * A zero argument constructor intializing the instance variable 'students'
   * to new ArrayList of Student object.
   */
  public StudentList()
  {
    this.students = new ArrayList<>();
  }

  /**
   * A method returning a size of a StudentList object.
   *
   * @return an int size();
   */
  public int size()
  {
    return students.size();
  }

  public Student get(
      int index) //This methods overrides a get in ArrayList class
  {
    return students.get(index);
  }

  public void addStudent(Student student)
  {
    if (student == null)
    {
      throw new IllegalArgumentException("Student cannot be null!");
    }
    students.add(student);
  }

  public void removeStudent(Student student)
  {
    if (size() == 0)
    {
      throw new NullPointerException(
          "The list is empty! You cannot remove anything!");
    }

    if (student == null)
    {
      throw new IllegalArgumentException("Student cannot be null!");
    }
    for (int i = 0; i < size(); i++)
    {
      if (student.equals(students.get(i)))
      {
        students.remove(student);
        break;
      }
    }
  }

  public Student getStudentByName(String name)
  {
    if (name == null)
    {
      throw new IllegalArgumentException("Name cannot be null!");
    }
    for (int i = 0; i < size(); i++)
    {
      if (name.equals(students.get(i).getName()))
      {
        return students.get(i);
      }
    }
    return null;
  }

  public Student getStudentByViaId(int ViaId)
  {
    if (!(String.valueOf(ViaId).length() == 6))
    {
      throw new IllegalArgumentException("The VIA ID has to have 6 digits!");
    }
    for (int i = 0; i < size(); i++)
    {
      if (ViaId == (students.get(i).getViaId()))
      {
        return students.get(i);
      }
    }
    return null;
  }

  public boolean contains(Student student)
  {
    if (students.contains(student))
    {
      return true;
    }
    return false;
  }

  public String toString()
  {

    String s = "";
    for (int i = 0; i < size(); i++)
    {
      s += i + 1 + "." + students.get(i).toString();
    }
    return s;
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof StudentList))
    {
      return false;
    }
    StudentList other = (StudentList) obj;
    if (size() == other.size())
    {
      for (int i = 0; i < size(); i++)
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
