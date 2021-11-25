package model;

public class Student
{
  private String name;
  private int viaId;
  private String classString;
  private int semester;
  private Class1 class1;

  public Student(int semester, String classString, String name, int viaId){
    this.semester = semester;
    this.classString = classString;
    this.name = name;
    this.viaId = viaId;
    class1 = new Class1(semester,classString);
  }

  public Student(Class1 class1, String name, int viaId){
    this.class1 = class1;
    this.name = name;
    this.viaId = viaId;
    this.semester = class1.getSemester();
    this.classString = class1.getClassName();
  }

  public Class1 getClass1(){
    return class1;
  }

  public String getName(){
    return name;
  }
  public String getClassString(){
    return classString;
  }

  public int getSemester()
  {
    return semester;
  }

  public int getViaId(){
    return viaId;
  }

  public String toString(){
    return "\nName:" + name + "\nVia ID:" + viaId + "\nClass:" + class1 + "\n";
  }

  public void setSemester(int semester){
    this.semester = semester;
  }

  public boolean equals(Object obj){
    if (!(obj instanceof Student)){
      return false;
    }

    Student other = (Student)obj;

    return name.equals(other.name) && viaId == other.viaId && class1.equals(other.class1);
  }
}
