package model.list;

import model.basic.ClassGroup;
import model.basic.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A class representing a collection of classes
 *
 *   @author Christian Foyer, Kamil Fischbach, Martin Rosendahl, Nina Wrona, Robert Barta
 *   @version 1 - 2 December 2021
 */
public class ClassGroupList
{
  private ArrayList<ClassGroup> classes;

  /**
   * A non-argument constructor that creates a new list of classes.
   * Classes are added manually.
   */
  public ClassGroupList()
  {
    classes = new ArrayList<>();

    // debugging by making simple course
    //ClassGroup x1 = new ClassGroup(1, "X");
    //classes.add(x1);
    //x1.addCourse(new Course("RWD"));
    //classes.add((new ClassGroup(1,"X")).copy());
    classes.add(new ClassGroup(1, "X"));
    classes.add((new ClassGroup(1, "Y")));
    classes.add((new ClassGroup(1, "Z")));
    classes.add((new ClassGroup(1, "DK")));

    classes.add((new ClassGroup(2, "X")));
    classes.add((new ClassGroup(2, "Y")));
    classes.add((new ClassGroup(2, "Z")));
    classes.add((new ClassGroup(2, "DK")));

    classes.add((new ClassGroup(3, "X")));
    classes.add((new ClassGroup(3, "Y")));
    classes.add((new ClassGroup(3, "Z")));
    classes.add((new ClassGroup(3, "DK")));

    classes.add((new ClassGroup(4, "X")));
    classes.add((new ClassGroup(4, "Y")));
    classes.add((new ClassGroup(4, "Z")));
    classes.add((new ClassGroup(4, "DK")));

  }

  /**
   * A method returning the number of classes that are stored in the list.
   *
   * @return the number of classes.
   */
  public int size()
  {
    return classes.size();
  }

  /**
   * A void method that takes a classGroup as an argument and adds it to a class collection.
   * @param classGroup
   *            the ClassGroup object to be added.
   */

  public void addClass(ClassGroup classGroup)
  {
    classes.add(classGroup);
  }

  /**
   * A void method that takes a classGroup as an argument. It checks the size of the list and if it is 0
   * it throws a NullPointerException. If the list is null it throws an IllegalArgumentException.
   * Otherwise it removes a ClassGroup object from the list.
   * @param classGroup
   *              A ClassGroup object to be removed from the list.
   */

  public void removeClass(ClassGroup classGroup)
  {
    if (size() == 0)
    {
      throw new NullPointerException(
          "The list is empty! You cannot remove anything!");
    }
    if (classes == null)
    {
      throw new IllegalArgumentException("Parameter cannot be null!");
    }
    classes.remove(classGroup);
  }

  /**
   * A getter method that takes an integer and returns the class that is assigned with this number in the array.
   * @param index
   *          The number of the course in the list.
   * @return
   *       A ClassGroup object that is stored in the classes list.
   */

  public ClassGroup get(int index)
  {
    return classes.get(index);
  }

  public void manualReadStudents(File file)
  {

    try
    {
      Scanner in = new Scanner(file);
      Student student;
      int semester = 0;
      String classGroup = "";
      String name = null;
      int viaId = 0;
      String[] parts;

      while (in.hasNext())
      {
        String line = in.nextLine();
        if (line.contains(","))
        {
          //divides the line by commas
          parts = line.split(",");
          if (parts.length == 4)
          {
            semester = Integer.parseInt(parts[0]);
            classGroup = parts[1].toUpperCase();
            viaId = Integer.parseInt(parts[2]);
            name = parts[3];

            student = new Student(semester, name, viaId);

            String classGroupString = "";
            classGroupString += semester;

            classGroupString += classGroup;
            switch (classGroupString)
            {
              case "1X":
              {
                for (int i = 0; i < size(); i++)
                {
                  if (get(i).getSemester() == 1 && get(i).getClassName()
                      .equals("X"))
                  {
                    get(i).addStudent(student);
                    break;
                  }
                }
                break;
              }

              case "1Y":
              {
                for (int i = 0; i < size(); i++)
                {
                  if (get(i).getSemester() == 1 && get(i).getClassName()
                      .equals("Y"))
                  {
                    get(i).addStudent(student);
                    break;
                  }
                }
                break;
              }

              case "1Z":
              {
                for (int i = 0; i < size(); i++)
                {
                  if (get(i).getSemester() == 1 && get(i).getClassName()
                      .equals("Z"))
                  {
                    get(i).addStudent(student);
                    break;
                  }
                }
                break;
              }

              case "1DK":
              {
                for (int i = 0; i < size(); i++)
                {
                  if (get(i).getSemester() == 1 && get(i).getClassName()
                      .equals("DK"))
                  {
                    get(i).addStudent(student);
                    break;
                  }
                }
                break;
              }

              case "2X":
              {
                for (int i = 0; i < size(); i++)
                {
                  if (get(i).getSemester() == 2 && get(i).getClassName()
                      .equals("X"))
                  {
                    get(i).addStudent(student);
                    break;
                  }
                }
                break;
              }

              case "2Y":
              {
                for (int i = 0; i < size(); i++)
                {
                  if (get(i).getSemester() == 2 && get(i).getClassName()
                      .equals("Y"))
                  {
                    get(i).addStudent(student);
                    break;
                  }
                }
                break;
              }

              case "2Z":
              {
                for (int i = 0; i < size(); i++)
                {
                  if (get(i).getSemester() == 2 && get(i).getClassName()
                      .equals("Z"))
                  {
                    get(i).addStudent(student);
                    break;
                  }
                }
                break;
              }

              case "2DK":
              {
                for (int i = 0; i < size(); i++)
                {
                  if (get(i).getSemester() == 2 && get(i).getClassName()
                      .equals("DK"))
                  {
                    get(i).addStudent(student);
                    break;
                  }
                }
                break;
              }

              case "3X":
              {
                for (int i = 0; i < size(); i++)
                {
                  if (get(i).getSemester() == 3 && get(i).getClassName()
                      .equals("X"))
                  {
                    get(i).addStudent(student);
                    break;
                  }
                }
                break;
              }

              case "3Y":
              {
                for (int i = 0; i < size(); i++)
                {
                  if (get(i).getSemester() == 3 && get(i).getClassName()
                      .equals("Y"))
                  {
                    get(i).addStudent(student);
                    break;
                  }
                }
                break;
              }

              case "3Z":
              {
                for (int i = 0; i < size(); i++)
                {
                  if (get(i).getSemester() == 3 && get(i).getClassName()
                      .equals("Z"))
                  {
                    get(i).addStudent(student);
                    break;
                  }
                }
                break;
              }

              case "3DK":
              {
                for (int i = 0; i < size(); i++)
                {
                  if (get(i).getSemester() == 3 && get(i).getClassName()
                      .equals("DK"))
                  {
                    get(i).addStudent(student);
                    break;
                  }
                }
                break;
              }

              case "4X":
              {
                for (int i = 0; i < size(); i++)
                {
                  if (get(i).getSemester() == 4 && get(i).getClassName()
                      .equals("X"))
                  {
                    get(i).addStudent(student);
                    break;
                  }
                }
                break;
              }

              case "4Y":
              {
                for (int i = 0; i < size(); i++)
                {
                  if (get(i).getSemester() == 4 && get(i).getClassName()
                      .equals("Y"))
                  {
                    get(i).addStudent(student);
                    break;
                  }
                }
                break;
              }

              case "4Z":
              {
                for (int i = 0; i < size(); i++)
                {
                  if (get(i).getSemester() == 4 && get(i).getClassName()
                      .equals("Z"))
                  {
                    get(i).addStudent(student);
                    break;
                  }
                }
                break;
              }

              case "4DK":
              {
                for (int i = 0; i < size(); i++)
                {
                  if (get(i).getSemester() == 4 && get(i).getClassName()
                      .equals("DK"))
                  {
                    get(i).addStudent(student);
                    break;
                  }
                }
                break;
              }

            }
          }
          else
          {
            throw new IllegalArgumentException("Error reading line: " + line);
          }
        }
      }
    }
    catch (FileNotFoundException e)
    {
      e.printStackTrace();
    }

  }

  public void manualReadCourses(File file)
  {

    CourseList courses = new CourseList();
    TeacherList masterTeacherList = new TeacherList();//We don't use it
    try
    {
      Scanner in = new Scanner(file);
      Course course;
      int semesterTaught = 0;
      ClassGroup classGroup;
      String courseName = null;
      int ECTS = 0;
      String[] parts;

      while (in.hasNext())
      {
        String line = in.nextLine();

        if (line.contains(","))
        {

          parts = line.split(",");
          if (parts.length == 5)
          {
            semesterTaught = Integer.parseInt(parts[0]);
            classGroup = new ClassGroup(semesterTaught, parts[1]);
            courseName = parts[2];
            TeacherList teacherList = new TeacherList();
            teacherList.addTeacher(new Teacher(parts[3]));
            if (!(masterTeacherList.contains(new Teacher(parts[3]))))
            {
              masterTeacherList.addTeacher(new Teacher(parts[3]));
            }
            ECTS = Integer.parseInt(parts[4]);

            if (courses.size() == 0)
            {
              course = new Course(courseName, classGroup, teacherList,
                  semesterTaught, ECTS);
              //System.out.println("Size is 0, New Course Made:\n" + course);
              for (int j = 0; j < teacherList.size(); j++)
              {
                if (!(teacherList.get(j) == null))
                {
                  // todo this was not working
                  // teacherList.get(j).assignToCourseTaught(course);
                  /*System.out.println(
                      "Courses taught: " + teacherList.get(j).getCoursesTaught()
                          + "\n--------------");

                   */
                }
              }
              courses.addCourse(course);
            }

            else if (courses.size() >= 1)
            {
              boolean teacherFound = false;
              for (int i = 0; i < courses.size(); i++)
              {
                if (courses.get(i).getClassGroup().equals(classGroup) && courses
                    .get(i).getName().equals(courseName) && !(courses.get(i)
                    .getTeachers().contains(new Teacher(parts[3]))))
                {
                  courses.get(i).addTeacher(new Teacher(parts[3]));
                 /* System.out.println("I added a teacher to an existing course"
                      + "\nEXISTING CLASS: " + courses.get(i)
                      + "----------------");

                  */
                  teacherFound = true;

                }
              }
              if (!teacherFound)
              {
                course = new Course(courseName, classGroup, teacherList,
                    semesterTaught, ECTS);
               /* System.out.println("New Course being printed: \n" + course
                    + "\n-----------------");

                */
                for (int j = 0; j < teacherList.size(); j++)
                {
                  if (!(teacherList.get(j) == null))
                  {
                    teacherList.get(j).assignToCourseTaught(course);
                  }
                }
                courses.addCourse(course);
              }
            }

          }
          else
          {
            throw new IllegalArgumentException("Unable to read line" + line);
          }
        }
      }
    }
    catch (FileNotFoundException e)
    {
      e.printStackTrace();
    }

    for (int j = 0; j < courses.size(); j++)
    {
      String classGroupString =
          "" + courses.get(j).getClassGroup().getSemester();
      classGroupString += courses.get(j).getClassGroup().getClassName();
      switch (classGroupString)
      {
        case "1X":
        {
          for (int i = 0; i < size(); i++)
          {
            if (get(i).getSemester() == 1 && get(i).getClassName().equals("X"))
            {
              get(i).addCourse(courses.get(j));
              break;
            }
          }
        }
        break;
        case "1Y":
        {
          for (int i = 0; i < size(); i++)
          {
            if (get(i).getSemester() == 1 && get(i).getClassName().equals("Y"))
            {
              get(i).addCourse(courses.get(j));
              break;
            }
          }
        }
        break;
        case "1Z":
        {
          for (int i = 0; i < size(); i++)
          {
            if (get(i).getSemester() == 1 && get(i).getClassName().equals("Z"))
            {
              get(i).addCourse(courses.get(j));
              break;
            }
          }
        }
        break;
        case "1DK":
        {
          for (int i = 0; i < size(); i++)
          {
            if (get(i).getSemester() == 1 && get(i).getClassName().equals("DK"))
            {
              get(i).addCourse(courses.get(j));
              break;
            }
          }
        }
        break;
        case "2X":
        {
          for (int i = 0; i < size(); i++)
          {
            if (get(i).getSemester() == 2 && get(i).getClassName().equals("X"))
            {
              get(i).addCourse(courses.get(j));
              break;
            }
          }
        }
        break;
        case "2Y":
        {
          for (int i = 0; i < size(); i++)
          {
            if (get(i).getSemester() == 2 && get(i).getClassName().equals("Y"))
            {
              get(i).addCourse(courses.get(j));
              break;
            }
          }
        }
        break;
        case "2Z":
        {
          for (int i = 0; i < size(); i++)
          {
            if (get(i).getSemester() == 2 && get(i).getClassName().equals("Z"))
            {
              get(i).addCourse(courses.get(j));
              break;
            }
          }
        }
        break;
        case "2DK":
        {
          for (int i = 0; i < size(); i++)
          {
            if (get(i).getSemester() == 2 && get(i).getClassName().equals("DK"))
            {
              get(i).addCourse(courses.get(j));
              break;
            }
          }
        }
        break;
        case "3X":
        {
          for (int i = 0; i < size(); i++)
          {
            if (get(i).getSemester() == 3 && get(i).getClassName().equals("X"))
            {
              get(i).addCourse(courses.get(j));
              break;
            }
          }
        }
        break;
        case "3Y":
        {
          for (int i = 0; i < size(); i++)
          {
            if (get(i).getSemester() == 3 && get(i).getClassName().equals("Y"))
            {
              get(i).addCourse(courses.get(j));
              break;
            }
          }
        }
        break;
        case "3Z":
        {
          for (int i = 0; i < size(); i++)
          {
            if (get(i).getSemester() == 3 && get(i).getClassName().equals("Z"))
            {
              get(i).addCourse(courses.get(j));
              break;
            }
          }
        }
        break;
        case "3DK":
        {
          for (int i = 0; i < size(); i++)
          {
            if (get(i).getSemester() == 3 && get(i).getClassName().equals("DK"))
            {
              get(i).addCourse(courses.get(j));
              break;
            }
          }
        }
        break;
        case "4X":
        {
          for (int i = 0; i < size(); i++)
          {
            if (get(i).getSemester() == 4 && get(i).getClassName().equals("X"))
            {
              get(i).addCourse(courses.get(j));
              break;
            }
          }
        }
        break;
        case "4Y":
        {
          for (int i = 0; i < size(); i++)
          {
            if (get(i).getSemester() == 4 && get(i).getClassName().equals("Y"))
            {
              get(i).addCourse(courses.get(j));
              break;
            }
          }
        }
        break;
        case "4Z":
        {
          for (int i = 0; i < size(); i++)
          {
            if (get(i).getSemester() == 4 && get(i).getClassName().equals("Z"))
            {
              get(i).addCourse(courses.get(j));
              break;
            }
          }
        }
        break;
        case "4DK":
        {
          for (int i = 0; i < size(); i++)
          {
            if (get(i).getSemester() == 4 && get(i).getClassName().equals("DK"))
            {
              get(i).addCourse(courses.get(j));
              break;
            }
          }
        }
        break;
      }
    }
  }

  //throw new IllegalArgumentException("Error reading line: " + line)

  public String toString()
  {
    String str = "";
    for (int i = 0; i < classes.size(); i++)
    {
      if (classes.get(i).getStudents().size() == 0)
      {
        str += "";
      }
      else
      {
        str += classes.get(i).toString();
      }
    }
    return str;
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof ClassGroupList))
    {
      return false;
    }

    ClassGroupList other = (ClassGroupList) obj;

    if (classes.size() == other.size())
    {
      for (int i = 0; i < classes.size(); i++)
      {
        if (!(classes.get(i).equals(other.get(i))))
        {
          return false;
        }
      }
      return true;
    }
    return false;
  }

}
