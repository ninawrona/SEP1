package model.list;

import model.basic.ClassGroup;
import model.basic.*;

import java.util.ArrayList;

public class ClassGroupList
{
  private ArrayList<ClassGroup> classes;

  public ClassGroupList(){
    classes = new ArrayList<>();

    // debugging by making simple course
    ClassGroup x1 = new ClassGroup(1, "X");

    classes.add(x1);
    x1.addCourse(new Course("RWD"));
    //classes.add((new ClassGroup(1,"X")).copy());



   /* classes.add((new ClassGroup(1,"Y")).copy());
    classes.add((new ClassGroup(1,"Z")).copy());
    classes.add((new ClassGroup(1,"DK")).copy());

    classes.add((new ClassGroup(2,"X")).copy());
    classes.add((new ClassGroup(2,"Y")).copy());
    classes.add((new ClassGroup(2,"Z")).copy());
    classes.add((new ClassGroup(2,"DK")).copy());

    classes.add((new ClassGroup(3,"X")).copy());
    classes.add((new ClassGroup(3,"Y")).copy());
    classes.add((new ClassGroup(3,"Z")).copy());
    classes.add((new ClassGroup(3,"DK")).copy());

    classes.add((new ClassGroup(4,"X")).copy());
    classes.add((new ClassGroup(4,"Y")).copy());
    classes.add((new ClassGroup(4,"Z")).copy());
    classes.add((new ClassGroup(4,"DK")).copy());

*/

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
      if (classes.get(i).getStudents().size()==0){
        str += "";
      } else {
        str += classes.get(i).toString();
      }
    }
    return str;
  }

  public boolean equals(Object obj){
    if (!(obj instanceof ClassGroupList)){
      return false;
    }

    ClassGroupList other = (ClassGroupList)obj;

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
