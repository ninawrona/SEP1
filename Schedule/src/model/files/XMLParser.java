package model.files;

import com.google.gson.JsonParser;
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
  public static void main(String[] args) throws ParserException
  {
   // Course course = new Course("RWD", new ClassGroup(2, "Y",new StudentList()), new TeacherList(),
   //     2, 10);
   // toXML(course, "CourseTest.xml");
    //Course course2 = new Course();
    //fromXML(course2, "CourseTest.xml");
    File file = new File("SessionList.xml");
    XmlJsonParser parser = new XmlJsonParser();
    SessionList list = parser.fromXml("SessionList.xml",SessionList.class);
    System.out.println(list);


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
/*
  public static SessionList fromXML(File file)
  {
    XmlJsonParser parser = new XmlJsonParser();
    SessionList sessionList = null;
    try
    {
      sessionList = parser.fromXml(file.getName(), SessionList.class);
    }
    catch (ParserException e)
    {
      e.printStackTrace();
    }

    if(sessionList!=null)
    {
      System.out.println(sessionList);
      return sessionList;
    }
    System.out.println("ooga booga");
    return null;
  }

 */

  public static void toJson(Object obj, String filename) throws ParserException

  {
    XmlJsonParser parser= new XmlJsonParser();
    File file1=parser.toJson(obj, filename);
    System.out.println("JSon file: "+file1.getAbsolutePath());
  }
}



