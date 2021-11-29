package model.list;

import model.basic.ClassGroup;

import java.util.ArrayList;

public class ClassList
{
  private ArrayList<ClassGroup> classList;

  public ClassList(){
    classList = new ArrayList<>();
  }

  public int size(){
    return classList.size();
  }

  public void addClass(ClassGroup classGroup){
    classList.add(classGroup);
  }

  public void removeClass(ClassGroup classGroup){
    classList.remove(classGroup);
  }

  public String toString(){
    String str = "";
    for (int i = 0; i < classList.size(); i++){
      str += classList.get(i).toString();
    }
    return str;
  }


}
