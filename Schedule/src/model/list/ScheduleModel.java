package model.list;

import model.basic.*;

public interface ScheduleModel
{
    public void addTeacher(Teacher teacher);
    public void removeTeacher(Teacher teacher);
    public void addCourse(Course course);
    public void removeCourse(Course course);
    public CourseList getCourseListByClassGroup(ClassGroup classGroup);
    public void addSession(Session session, Room room);
    public void removeSession(Session session);
    public void setRoomList(RoomList roomList);
    public RoomList suggestRooms(Session session);
    public boolean isTeacherAvailable(Session session);
    public SessionList getSessionsByTimeDate(Date date, Time startTime, int numberOfLessons);
    public SessionList getSessionsByRoom(Room room);
    public SessionList getSessionsByTeacher(Teacher teacher, Date date);
    public SessionList getSessionsByCourse
    public SessionList getSessionsByClassGroup(ClassGroup classGroup);
    public SessionList getSessionsByStudent(Student student);
    public void addStudentToCourse(Student student, Course course);
    public void removeStudentFromCourse(Student student, Course course);
    public Student getStudentByViaId(int viaId);
}
