package model.files;

import model.basic.Student;
import model.list.ClassGroupList;
import model.list.StudentList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

import model.list.CourseList;

public class ReadWrite
{

  public static void main(String[] args)
  {
    System.out.println(manualReadStudent());
    //   manualWriteStudent(manualReadStudent());
    //   manualWriteCourse(manualReadCourse());
  }

  /*
    public static void manualWriteStudent(ClassGroupList students)
    {
      File file = new File("Students.xml");
      try

      {
        PrintWriter out = new PrintWriter(file);

        String xml = "";
        xml +=
            "<?xml version=\"1.0\" encoding=\"UTF-8\"" + "standalone=\"no\"?>\n";
        for (int i = 0; i < students.size(); i++)
        {
          xml += "\n<Student>";
          xml +=
              "\n    <Semester>" + students.get(i).getSemester() + "</Semester>";
          xml +=
              "\n    <ClassGroup>" + students.get(i).getClassName() + "</ClassGroup>";
          xml += "\n    <Name>" + students.get(i).getName() + "</Name>";
          xml += "\n    <ViaID>" + students.get(i).getViaId() + "</ViaID>";

          xml += "\n</Student>";
        }
        out.println(xml);
        out.close();

      }
      catch (FileNotFoundException e)

      {
        e.printStackTrace();
      }
    }

    public static void manualWriteCourse(CourseList courses)
    {
      File file = new File("Courses.xml");
      try

      {
        PrintWriter out = new PrintWriter(file);

        String xml = "";
        xml +=
            "<?xml version=\"1.0\" encoding=\"UTF-8\"" + "standalone=\"no\"?>\n";
        for (int i = 0; i < courses.size(); i++)
        {
          xml += "\n<Course>";
          xml += "\n    <Semester>" + courses.get(i).getSemesterTaught()
              + "</Semester>";
          xml += "\n    <Class>" + courses.get(i).getClassGroup().getClassName()
              + "</Class>";
          xml +=
              "\n    <CourseName>" + courses.get(i).getName() + "</CourseName>";
          for (int j = 0; j < courses.get(i).getTeachers().size(); j++)
          {
            xml += "\n    <Teacher>" + courses.get(i).getTeachers().get(j)
                + "</Teacher>";
          }
          xml += "\n    <ECTS>" + courses.get(i).getECTS() + "</ECTS>";

          xml += "\n</Course>";
        }
        out.println(xml);
        out.close();

      }
      catch (FileNotFoundException e)

      {
        e.printStackTrace();
      }
    }


   */
  public static ClassGroupList manualReadStudent()
  {
    File file = new File("students.txt");
    ClassGroupList classGroupList = new ClassGroupList();

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
                for (int i = 0; i < classGroupList.size(); i++)
                {
                  if (classGroupList.get(i).getSemester() == 1
                      && classGroupList.get(i).getClassName().equals("X"))
                  {
                    classGroupList.get(i).addStudent(student);
                    break;
                  }
                }
                break;
              }

              case "1Y":
              {
                for (int i = 0; i < classGroupList.size(); i++)
                {
                  if (classGroupList.get(i).getSemester() == 1
                      && classGroupList.get(i).getClassName().equals("Y"))
                  {
                    classGroupList.get(i).addStudent(student);
                    break;
                  }
                }
                break;
              }

              case "1Z":
              {
                for (int i = 0; i < classGroupList.size(); i++)
                {
                  if (classGroupList.get(i).getSemester() == 1
                      && classGroupList.get(i).getClassName().equals("Z"))
                  {
                    classGroupList.get(i).addStudent(student);
                    break;
                  }
                }
                break;
              }

              case "1DK":
              {
                for (int i = 0; i < classGroupList.size(); i++)
                {
                  if (classGroupList.get(i).getSemester() == 1
                      && classGroupList.get(i).getClassName().equals("DK"))
                  {
                    classGroupList.get(i).addStudent(student);
                    break;
                  }
                }
                break;
              }

              case "2X":
              {
                for (int i = 0; i < classGroupList.size(); i++)
                {
                  if (classGroupList.get(i).getSemester() == 2
                      && classGroupList.get(i).getClassName().equals("X"))
                  {
                    classGroupList.get(i).addStudent(student);
                    break;
                  }
                }
                break;
              }

              case "2Y":
              {
                for (int i = 0; i < classGroupList.size(); i++)
                {
                  if (classGroupList.get(i).getSemester() == 2
                      && classGroupList.get(i).getClassName().equals("Y"))
                  {
                    classGroupList.get(i).addStudent(student);
                    break;
                  }
                }
                break;
              }

              case "2Z":
              {
                for (int i = 0; i < classGroupList.size(); i++)
                {
                  if (classGroupList.get(i).getSemester() == 2
                      && classGroupList.get(i).getClassName().equals("Z"))
                  {
                    classGroupList.get(i).addStudent(student);
                    break;
                  }
                }
                break;
              }

              case "2DK":
              {
                for (int i = 0; i < classGroupList.size(); i++)
                {
                  if (classGroupList.get(i).getSemester() == 2
                      && classGroupList.get(i).getClassName().equals("DK"))
                  {
                    classGroupList.get(i).addStudent(student);
                    break;
                  }
                }
                break;
              }

              case "3X":
              {
                for (int i = 0; i < classGroupList.size(); i++)
                {
                  if (classGroupList.get(i).getSemester() == 3
                      && classGroupList.get(i).getClassName().equals("X"))
                  {
                    classGroupList.get(i).addStudent(student);
                    break;
                  }
                }
                break;
              }

              case "3Y":
              {
                for (int i = 0; i < classGroupList.size(); i++)
                {
                  if (classGroupList.get(i).getSemester() == 3
                      && classGroupList.get(i).getClassName().equals("Y"))
                  {
                    classGroupList.get(i).addStudent(student);
                    break;
                  }
                }
                break;
              }

              case "3Z":
              {
                for (int i = 0; i < classGroupList.size(); i++)
                {
                  if (classGroupList.get(i).getSemester() == 3
                      && classGroupList.get(i).getClassName().equals("Z"))
                  {
                    classGroupList.get(i).addStudent(student);
                    break;
                  }
                }
                break;
              }

              case "3DK":
              {
                for (int i = 0; i < classGroupList.size(); i++)
                {
                  if (classGroupList.get(i).getSemester() == 3
                      && classGroupList.get(i).getClassName().equals("DK"))
                  {
                    classGroupList.get(i).addStudent(student);
                    break;
                  }
                }
                break;
              }

              case "4X":
              {
                for (int i = 0; i < classGroupList.size(); i++)
                {
                  if (classGroupList.get(i).getSemester() == 4
                      && classGroupList.get(i).getClassName().equals("X"))
                  {
                    classGroupList.get(i).addStudent(student);
                    break;
                  }
                }
                break;
              }

              case "4Y":
              {
                for (int i = 0; i < classGroupList.size(); i++)
                {
                  if (classGroupList.get(i).getSemester() == 4
                      && classGroupList.get(i).getClassName().equals("Y"))
                  {
                    classGroupList.get(i).addStudent(student);
                    break;
                  }
                }
                break;
              }

              case "4Z":
              {
                for (int i = 0; i < classGroupList.size(); i++)
                {
                  if (classGroupList.get(i).getSemester() == 4
                      && classGroupList.get(i).getClassName().equals("Z"))
                  {
                    classGroupList.get(i).addStudent(student);
                    break;
                  }
                }
                break;
              }

              case "4DK":
              {
                for (int i = 0; i < classGroupList.size(); i++)
                {
                  if (classGroupList.get(i).getSemester() == 4
                      && classGroupList.get(i).getClassName().equals("Dk"))
                  {
                    classGroupList.get(i).addStudent(student);
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
    return classGroupList;
  }
/*
  public static CourseList manualReadCourse()
  {
    File file = new File("courses.txt");
    CourseList courses = new CourseList();
    try
    {
      Scanner in = new Scanner(file);
      Course course;
      int semesterTaught = 0;
      String classGroup = "";
      String courseName = null;
      String teacher1 = "";
      String teacher2 = "";
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
            classGroup = parts[1];
            courseName = parts[2];
            teacher1 = parts[3];
            ECTS = Integer.parseInt(parts[4]);
            course = new Course(courseName, classGroup,  teacher1, semesterTaught, ECTS);
            courses.addCourse(course);
          }
          else if (parts.length == 6)
          {
            semesterTaught = Integer.parseInt(parts[0]);
            classGroup = parts[1];
            courseName = parts[2];
            teacher1 = parts[3];
            teacher2 = parts[4];
            ECTS = Integer.parseInt(parts[5]);
            course = new Course(semesterTaught, classGroup, courseName, teacher1,teacher2, ECTS);
            courses.addCourse(course);
          }
          else
          {
            throw new IllegalArgumentException("Unable to read line" + line);
          }
        }
        else
        {
          throw new IllegalArgumentException("Error reading line: " + line);
        }
      }
      System.out.println(courses.toString());
    }
    catch (FileNotFoundException e)
    {
      e.printStackTrace();
    }
    return courses;
  }

 */

}
