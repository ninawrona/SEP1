package model.basic;

/**
 * A class representing a student.
 *
 * @author Christian Foyer, Kamil Fischbach, Martin Rosendahl, Nina Wrona, Robert Barta
 * @version 1 - 2 December 2021
 */
public class Student
{
  private String name;
  private int viaId;
  private int semester;

  /**
   * Three-argument constructor. The semester has to be a positive integer, the name cannot be null and, and the VIA ID has to be
   *
   * @param semester
   * @param name
   * @param viaId
   */
  public Student(int semester, String name, int viaId)
  {
    if (semester<1){
      throw new IllegalArgumentException("The semester has to be 1 or higher!");
    }
    if (name==null){
      throw new IllegalArgumentException("Name cannot be null!");
    }
    if(String.valueOf(viaId).length()<6)
    {
      throw new IllegalArgumentException("The VIA ID has to be 6 digits long!");
    }
    this.semester = semester;
    this.name = name;
    this.viaId = viaId;
  }

  public String getName()
  {
    return name;
  }

  public int getSemester()
  {
    return semester;
  }

  public int getViaId()
  {
    return viaId;
  }

  public void setSemester(int semester)
  {
    this.semester = semester;
  }

  public String toString()
  {
    return "\nName:" + name + "\nVia ID:" + viaId
        + "\n";
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Student))
    {
      return false;
    }

    Student other = (Student) obj;

    return name.equals(other.name) && viaId == other.viaId && semester == other.semester;
  }
}
