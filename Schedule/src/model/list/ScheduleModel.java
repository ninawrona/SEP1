package model.list;

import model.basic.*;

public interface ScheduleModel
{
    public void addTeacher(Teacher teacher);
    public void removeTeacher(Teacher teacher);
    public void addCourse(Course course);
    public void removeCourse(Course course);
    public void addSession(Session session, Room room);
    public void removeSession(Session session);
    public void setRoomList(RoomList roomList);
    public boolean isTeacherAvailable(Session session);
    public SessionList getSessionsByTimeDate(Date date, Time timeStart, int numberOfLessons);
    public SessionList getSessionsByRoom(Room room);
    public SessionList getSessionsByTeacher(Teacher teacher, Date date);
    public SessionList getSessionsByClassGroup(ClassGroup classGroup);
    public SessionList getSessionsByClassGroup(Student student);
    public void addStudentToCourse(Student student);
    public void removeStudentFromCourse(Student student);
    public Student getStudentByViaId(int viaId);
}
