package model.basic;

public class Student
{
  private String name;
  private int viaId;
  private int semester;
  private ClassGroup classGroup;

  public Student(int semester, ClassGroup classGroup, String name, int viaId){
    this.semester = semester;
    this.name = name;
    this.viaId = viaId;
    this.classGroup = classGroup;
  }


  public ClassGroup getClassGroup(){
    return classGroup;
  }

  public String getName(){
    return name;
  }

  public int getSemester()
  {
    return semester;
  }

  public int getViaId(){
    return viaId;
  }

  public String toString(){
    return "\nName:" + name + "\nVia ID:" + viaId + "\nClass:" + classGroup + "\n";
  }

  public void setSemester(int semester){
    this.semester = semester;
  }

  public boolean equals(Object obj){
    if (!(obj instanceof Student)){
      return false;
    }

    Student other = (Student)obj;

    return name.equals(other.name) && viaId == other.viaId && classGroup.equals(other.classGroup);
  }
}
