package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadWrite
{

  public static void main(String[] args)
  {
    manualWriteStudent(manualReadStudent());
    manualWriteCourse(manualReadCourse());
  }

  public static void manualWriteStudent(ArrayList<Student> students)
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
        xml += "\n    <Class>" + students.get(i).getClassString() + "</Class>";
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


  public static void manualWriteCourse(ArrayList<Course> courses)
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
        xml +=
            "\n    <Semester>" + courses.get(i).getSemester() + "</Semester>";
        xml += "\n    <Class>" + courses.get(i).getClassString() + "</Class>";
        xml += "\n    <CourseName>" + courses.get(i).getCourseName() + "</CourseName>";
        xml += "\n    <Teacher1>" + courses.get(i).getTeacher1() + "</Teacher1>";
        xml += "\n    <Teacher2>" + courses.get(i).getTeacher2() + "</Teacher2>";
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

  public static ArrayList<Student> manualReadStudent()
  {
    File file = new File("students.txt");
    ArrayList<Student> students = new ArrayList<>();
    try
    {
      Scanner in = new Scanner(file);
      Student student;
      int semester = 0;
      String classString = "";
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
            classString = parts[1];
            name = parts[2];
            viaId = Integer.parseInt(parts[3]);
            student = new Student(semester, classString, name, viaId);
            students.add(student);
          }
          else
          {
            throw new IllegalArgumentException("Unable to line" + line);
          }
        }
        else
        {
          throw new IllegalArgumentException("Error reading line: " + line);
        }
      }
      System.out.println(students.toString());
    }
    catch (FileNotFoundException e)
    {
      e.printStackTrace();
    }
    return students;
  }

  public static ArrayList<Course> manualReadCourse()
  {
    File file = new File("courses.txt");
    ArrayList<Course> courses = new ArrayList<>();
    try
    {
      Scanner in = new Scanner(file);
      Course course;
      int semester = 0;
      String classString = "";
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
            semester = Integer.parseInt(parts[0]);
            classString = parts[1];
            courseName = parts[2];
            teacher1 = parts[3];
            ECTS = Integer.parseInt(parts[4]);
            course = new Course(semester, classString, courseName, teacher1, ECTS);
            courses.add(course);
          }
          else if (parts.length == 6)
          {
            semester = Integer.parseInt(parts[0]);
            classString = parts[1];
            courseName = parts[2];
            teacher1 = parts[3];
            teacher2 = parts[4];
            ECTS = Integer.parseInt(parts[5]);
            course = new Course(semester, classString, courseName, teacher1,teacher2, ECTS);
            courses.add(course);
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



}
