package test;

import model.basic.*;
import model.files.ReadWrite;
import model.list.*;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddSessionTest {
    // Very basic test to show syntax
    private Teacher teacher;

    // This is a precondition of the test found below
    @Before
    public void setup() {
        teacher = new Teacher("TEST");
    }

    // Running this open a neat window below
    @Test
    public void testGetName() {
        assertEquals("It's alive!!!", "TEST", teacher.getViaId());
    }

    // Create some classgroups -> courses -> sessions manually to see time
    ClassGroup class1 = new ClassGroup(1, "X");
    ClassGroup class2 = new ClassGroup(1, "Y");

    Teacher teacher1 = new Teacher("GJGL");
    Teacher teacher2 = new Teacher("OIUY");

    TeacherList teacherList = new TeacherList();

    Course course1 = new Course("ASD", class1, teacherList, 1, 5);
    Course course2 = new Course("SDI", class2, teacherList, 1, 5);

    Time t1 = new Time(8, 20);
    Time t2 = new Time(9, 15);
    Time t3 = new Time(10, 10);
    Time t4 = new Time(11, 5);

    Date d1 = new Date(14, 12, 2021);
    Date d2 = new Date(15, 12, 2021);
    Date d3 = new Date(16, 12, 2021);
    Date d4 = new Date(17, 12, 2021);

    Room r1 = new Room(5, 'C', 10, 45);
    Room r2 = new Room(5, 'C', 11, 45);
    Room r3 = new Room(5, 'C', 12, 45);
    Room r4 = new Room(5, 'C', 13, 45);
    Room r5 = new Room(5, 'C', 14, 45);


    SessionList list = new SessionList();

    @Before
    public void setUpTeacher() {
        teacherList.addTeacher(teacher1);
        teacherList.addTeacher(teacher2);
    }

    Session session1 = new Session(course1, d1, t1, 3);
    Session session2 = new Session(course1, d2, t2, 4);
    Session session3 = new Session(course1, d3, t3, 5);
    Session session4 = new Session(course1, d4, t4, 6);

    Session session5 = new Session(course2, d1, t1, 3);
    Session session6 = new Session(course2, d2, t2, 4);
    Session session7 = new Session(course2, d3, t3, 5);
    Session session8 = new Session(course2, d4, t4, 6);

    ClassGroupList classGroupList = new ClassGroupList();

    @Test
    public void courseNames() {

        assertEquals("Name 1 found", "ASD", session1.getCourse().getName());
        assertEquals("Name 2 found", "SDI", session5.getCourse().getName());
    }

    @Test
    public void StartTimes() {
        assertEquals(9, session2.getStartTime().getHour());
        assertEquals(15, session2.getStartTime().getMinute());
        assertEquals(10, session7.getStartTime().getHour());
        assertEquals(10, session7.getStartTime().getHour());
    }

    @Test
    public void listTest() {
        list.addSession(session1, r1);
        list.addSession(session2, r2);
        list.addSession(session3, r1);
        list.addSession(session4, r2);
        assertTrue(list.size() != 0);
    }

    @Test
    public void studentParseTest() {
        File studentFile = new File("../Students.txt");
        classGroupList.manualReadStudents(studentFile);
        System.out.println(classGroupList);
        for (int i = 0; i < classGroupList.size(); i++) {
            System.out.println(classGroupList.get(i).getStudents());
        }
        assertTrue(classGroupList.size() != 0);
    }

    @Test
    public void courseParseTest() {
        File courseFile = new File("../Courses.txt");
        CourseList courses = ReadWrite.manualReadCourses(courseFile);
        for (int i = 0; i < courses.size(); i++)
        {
            System.out.println(courses.get(i));
        }
        assertTrue(courses.size() != 0);
    }

    @Test
    public void teacherSessionTest() {
        course1.addTeacher(teacher1);
        course2.addTeacher(teacher2);
        listTest();
        SessionList teach1 = list.getSessionsByTeacher(teacher1, d1);
        System.out.println(teach1);
        assertTrue(teach1.size() != 0);
    }

    @Test
    public void classSessionTest() {
        listTest();
        SessionList classSessions1 = list.getSessionsByClassGroup(class1);
        System.out.println(classSessions1);
        assertTrue(classSessions1.size() != 0);
    }
}

