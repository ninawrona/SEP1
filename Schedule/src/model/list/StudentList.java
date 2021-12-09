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
   * A zero argument constructor intializing the instance variable "students"
   * to new ArrayList of Student object.
   */
  public StudentList()
  {
    this.students = new ArrayList<>();
  }

  /**
   * A method returning a size of a StudentList object.
   *
   * @return an int size of a StudentList object.
   */
  public int size()
  {
    return students.size();
  }

  /**
   * A getter method returning a student from the list.
   *
   * @param index the desired index to get the student from.
   * @return a Student object from the specified index.
   */
  public Student get(int index)
  {
    return students.get(index);
  }

  /**
   * A void method for adding a student to the list.
   *
   * @param student the Student object to be added to the list (cannot be null).
   */
  public void addStudent(Student student)
  {
    if (student == null)
    {
      throw new IllegalArgumentException("Student cannot be null!");
    }
    students.add(student);
  }

  /**
   * A void method for removing a student from the list.
   *
   * @param student the Student object to be removed from the list (cannot be null). There must be at least 1 Teacher object in a list in order to use the method.
   */
  public void removeStudent(Student student)
  {
    if (size() == 0)
    {
      throw new NullPointerException(
          "The list is empty! You cannot remove anything!");
    }

    if (student == null)
    {
      throw new IllegalArgumentException("You must select a student to remove");
    }

    students.remove(student);
  }
  /**
   * A getter method returning a Student object by searching for their name.
   * @param name
   *            A string representing the student's VIA ID (cannot be null).
   * @return a Student object.
   */
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
  /**
   * A getter method returning a Student object by searching for their VIA ID.
   * @param viaId
   *            A string representing the student's VIA ID (cannot be null).
   * @return a Student object.
   */

  public Student getStudentByViaId(int viaId)
  {
    if (!(String.valueOf(viaId).length() == 6))
    {
      throw new IllegalArgumentException("The VIA ID has to have 6 digits!");
    }
    for (int i = 0; i < size(); i++)
    {
      if (viaId == (students.get(i).getViaId()))
      {
        return students.get(i);
      }
    }
    return null;
  }
  /**
   * A method checking if the list contains the specified student.
   * @param student
   *              the Student object to search by (cannot be null).
   * @return "True" if the list contains the specified Student object, or "False" if it does not.
   */
  public boolean contains(Student student)
  {
    if (students.contains(student))
    {
      return true;
    }
    return false;
  }
  /**
   * A method returning a String representation of the ArrayList "students".
   * @return a String containing all the students and their information.
   */
  public String toString()
  {
    String s = "";
    for (int i = 0; i < size(); i++)
    {
      s += i + 1 + "." + students.get(i).toString();
    }
    return s;
  }
  /**
   * A method comparing two StudentList objects.
   * @param obj
   *          an object representing the other object to be compared.
   * @return "True" if the two StudentList objects are identical, or "False" if they are not.
   */
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
