package model.list;

import model.basic.ClassGroup;
import model.basic.Room;

import java.util.ArrayList;

public class ClassList
{
  private ArrayList<ClassGroup> classes;

  public ClassList(){
    classes = new ArrayList<>();
  }

  public int size(){
    return classes.size();
  }

  public void addClass(ClassGroup classGroup){
    classes.add(classGroup);
  }

  public void removeClass(ClassGroup classGroup){
    if(size()==0)
    {
      throw new NullPointerException("The list is empty! You cannot remove anything!");
    }
    if(classes==null)
    {
      throw new IllegalArgumentException("Parameter cannot be null!");
    }
    classes.remove(classGroup);
  }

  public ClassGroup get(int index){
    return classes.get(index);
  }

  public String toString(){
    String str = "";
    for (int i = 0; i < classes.size(); i++){
      str += classes.get(i).toString();
    }
    return str;
  }

  public boolean equals(Object obj){
    if (!(obj instanceof ClassList)){
      return false;
    }

    ClassList other = (ClassList)obj;

    if (classes.size() == other.size()){
      for (int i = 0; i < classes.size(); i++){
        if (!(classes.get(i).equals(other.get(i)))){
          return false;
        }
      }
      return true;
    }
    return false;
  }

}
