package model.list;

import model.basic.ClassGroup;
import model.basic.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A class representing a list of ClassGroup objects.
 *
 * @author Christian Foyer, Kamil Fischbach, Martin Rosendahl, Nina Wrona, Robert Barta.
 * @version 1 - 2 December 2021.
 */
public class ClassGroupList
{
  private ArrayList<ClassGroup> classes;

  /**
   * A constructor taking no arguments and creating a new ArrayList of type ClassGroup.
   * The ArrayList is filled up with the legal classes(1-4 and 'X','Y','Z' or 'DK'),
   * where X','Y','Z' are for international classes and 'DK' for Danish class.
   */
  public ClassGroupList()
  {
    classes = new ArrayList<>();

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
   * An overridden method returning size of an ClassGroupList object.
   *
   * @return size int
   */
  public int size()
  {
    return classes.size();
  }

  // TODO in project future

  /**
   * A void method adding a ClassGroup to ClassGroupList.
   *
   * @param classGroup A classGroup object which is to be added.
   */
  public void addClass(ClassGroup classGroup)
  {
    classes.add(classGroup);
  }

  /**
   * A void method removing ClassGroup from ClassGroupList.
   *
   * @param classGroup A classGroup object which is to be removed.
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
   * A getter method returning a ClassGroup at the specified index from ClassGroupList.
   *
   * @param index An int index of a ClassGroup to be returned.
   * @return ClassGroup object at the specified index.
   */
  public ClassGroup get(int index)
  {
    return classes.get(index);
  }

  /**
   * A void method reading students from the given file and
   * assigning them to the correct, already existing ClassGroup.
   *
   * @param file the file containing information about each Student
   *             (semester, class name, VIA ID, name of the Student)
   */
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

  /**
   * A void method reading the courses from the given file and
   * assigning them to the correct, already existing ClassGroup.
   *
   * @param file the file that contains information about each Course
   *             (semester, class name, teacher's VIA ID, name of the course, ECTS points)
   */
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
              courses.addCourse(course);
            }
            else if (courses.size() >= 1)
            {
              boolean teacherFound = false;
              for (int i = 0; i < courses.size(); i++)
              {
                if (courses.get(i).getClassGroup().equals(classGroup)
                    && courses.get(i).getName().equals(courseName)
                    && !(courses.get(i).getTeachers()
                    .contains(new Teacher(parts[3]))))
                {
                  courses.get(i).addTeacher(new Teacher(parts[3]));
                  teacherFound = true;
                }
              }
              if (!teacherFound)
              {
                course = new Course(courseName, classGroup, teacherList,
                    semesterTaught, ECTS);
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

  /**
   * A method returning a String Object containing the list of the ClassGroup.toString().
   *
   * @return String containing the list of the ClassGroup.toString().
   */
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

  /**
   * A method comparing two objects.
   *
   * @param obj an object that represents the object to be compared with
   * @return "True" if the two Course objects are identical, or "False" if they are not.
   */
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
