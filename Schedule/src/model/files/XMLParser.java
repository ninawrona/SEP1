package model.files;

import model.basic.Session;
import model.list.SessionList;
import model.list.StudentList;
import model.list.TeacherList;
import model.basic.ClassGroup;
import model.basic.Course;
import parser.ParserException;
import parser.XmlJsonParser;
import view.ScheduleGridViewController;

import java.io.File;

public class XMLParser
{
  public static void main(String[] args)
  {
   // Course course = new Course("RWD", new ClassGroup(2, "Y",new StudentList()), new TeacherList(),
   //     2, 10);
   // toXML(course, "CourseTest.xml");
    //Course course2 = new Course();
    //fromXML(course2, "CourseTest.xml");


  }

  public static void toXML(Object obj, String fileName)
  {
    XmlJsonParser parser = new XmlJsonParser();
    File file = null;
    try
    {
      file = parser.toXml(obj, fileName);
    }
    catch (ParserException e)
    {
      e.printStackTrace();
    }

    System.out.println("XML: " + file.getAbsolutePath());
  }

  public static void fromXML(Object obj ,String fileName)
  {
    XmlJsonParser parser = new XmlJsonParser();
    try
    {
      obj = parser.fromXml(fileName, Object.class);
    }
    catch (ParserException e)
    {
      e.printStackTrace();
    }

    System.out.println(obj);
  }

  public static void toJson(Object obj, String filename) throws ParserException

  {
    XmlJsonParser parser= new XmlJsonParser();
    File file1=parser.toJson(obj, filename);
    System.out.println("JSon file: "+file1.getAbsolutePath());
  }
}



