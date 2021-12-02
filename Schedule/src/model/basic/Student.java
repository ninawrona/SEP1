package model.basic;

public class Student
{
  private String name;
  private int viaId;
  private int semester;

  public Student(int semester, String name, int viaId)
  {
    this.semester = semester;
    this.name = name;
    if(String.valueOf(viaId).length()<6)
    {
      throw new IllegalArgumentException("VIA ID has to have 6 digits!");
    }
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
    return "\nName:" + name + "\nVia ID:" + viaId + "\nSemester:" + semester
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
