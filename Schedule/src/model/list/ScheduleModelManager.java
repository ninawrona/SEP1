package model.list;

import model.basic.*;

public class ScheduleModelManager implements ScheduleModel
{
  private TeacherList teacherList;
  private CourseList courseList;
  private SessionList sessionList;
  private ClassGroupList classList;
  private StudentList studentList;
  private RoomList roomList;
  private ClassGroup chosenClassGroup;
  private Session chosenSession;
  private int chosenWeekNumber;
  private Date chosenMonday;
  private Teacher chosenTeacher;

  public ScheduleModelManager()
  {
    this.teacherList = new TeacherList();
    this.courseList = new CourseList();
    this.sessionList = new SessionList();
    this.classList = new ClassGroupList();
    this.studentList = new StudentList();
    this.roomList = new RoomList();
    this.chosenClassGroup = null;
    this.chosenSession = null;
    this.chosenWeekNumber = 0;
    this.chosenTeacher = null;
  }

  public ClassGroupList getAllClasses()
  {
    return classList;
  }

  public TeacherList getAllTeachers(){
    return teacherList;
  }

  public void addTeacher(Teacher teacher)
  {
    teacherList.addTeacher(teacher);
  }

  public void removeTeacher(Teacher teacher)
  {
    teacherList.removeTeacher(teacher);
  }

  public void addCourse(Course course)
  {
    courseList.addCourse(course);
  }

  public void removeCourse(Course course)
  {
    courseList.removeCourse(course);
  }

  public CourseList getCourseListByClassGroup(ClassGroup classGroup)
  {
    if (classGroup == null)
    {
      throw new IllegalArgumentException("Parameter cannot be null!");
    }
    CourseList courseListClassGroup = new CourseList();
    for (int i = 0; i < sessionList.size(); i++)
    {
      if (sessionList.get(i).getCourse().getClassGroup().getClassName()
          .equals(classGroup.getClassName())
          && sessionList.get(i).getCourse().getClassGroup().getSemester()
          == classGroup.getSemester())
      {
        courseListClassGroup.addCourse(sessionList.get(i).getCourse());
      }
    }
    if (courseListClassGroup.size() > 0)
    {
      return courseListClassGroup;
    }
    throw new NullPointerException("No courses found for this class.");
  }

  @Override public void setChosenClassGroup(ClassGroup classGroup)
  {
    this.chosenClassGroup = classGroup;
    System.out.println("I just set the class" + classGroup);
  }

  @Override public ClassGroup getChosenClassGroup()
  {
    return chosenClassGroup;
  }

  @Override
  public Session getChosenSession() {
    return chosenSession;
  }

  @Override
  public void setChosenSession(Session session) {
    this.chosenSession = session;
  }

  @Override
  public int getChosenWeekNumber() {
    return chosenWeekNumber;
  }

  @Override
  public void setChosenWeekNumber(int chosenWeekNumber) {
    this.chosenWeekNumber = chosenWeekNumber;
  }

 // Bla bla
  public Date getChosenMonday()
  {
    return chosenMonday;
  }

  @Override
  public void setChosenMonday(Date chosenMonday) {
    this.chosenMonday = chosenMonday;
  }

  public void addClassGroupList(ClassGroupList classList)
  {
    this.classList = classList;
  }

  public void addSession(Session session, Room room)
  {
    sessionList.addSession(session, room);
  }

  public void removeSession(Session session)
  {
    sessionList.removeSession(session);
  }

  public void setRoomList(RoomList roomList)
  {
    sessionList.setRoomList(roomList);
  }


  public RoomList suggestRooms(Session session)
  {
    return sessionList.suggestRooms(session);
  }

  public boolean isTeacherAvailable(Session session)
  {
    return sessionList.isTeacherAvailable(session);
  }

  public SessionList getSessionsByTimeDate(Date date, Time startTime,
      int numberOfLessons)
  {
    return sessionList.getSessionsByTimeDate(date, startTime, numberOfLessons);
  }

  public SessionList getSessionsByRoom(Room room)
  {
    return sessionList.getSessionsByRoom(room);
  }


  public SessionList getSessionsByCourse(Course course)
  {
    return sessionList.getSessionsByCourse(course);
  }

  public SessionList getSessionsByTeacher(Teacher teacher, Date date)
  {
    return sessionList.getSessionsByTeacher(teacher, date);
  }

  public SessionList getSessionsByClassGroup(ClassGroup classGroup)
  {
    return sessionList.getSessionsByClassGroup(classGroup);
  }

  public SessionList getSessionsByStudent(Student student)
  {
    return sessionList.getSessionsByStudent(student);
  }

  public void addStudentToCourse(Student student, Course course)
  {
    if (student == null || course == null)
    {
      throw new IllegalArgumentException("Parameters cannot be null!");
    }
    for (int i = 0; i < sessionList.size(); i++)
    {
      if (sessionList.get(i).getCourse().equals(course))
      {
        sessionList.get(i).getCourse().addStudent(student);
      }
    }
  }

  public void removeStudentFromCourse(Student student, Course course)
  {
    if (student == null || course == null)
    {
      throw new IllegalArgumentException("Parameters cannot be null!");
    }
    for (int i = 0; i < sessionList.size(); i++)
    {
      if (sessionList.get(i).getCourse().equals(course))
      {
        if (sessionList.get(i).getCourse().getStudents().contains(student))
        {
          sessionList.get(i).getCourse().addStudent(student);
        }
      }
    }
  }

  public Student getStudentByViaId(int viaId)
  {
    if (String.valueOf(viaId).length() < 6)
    {
      throw new IllegalArgumentException("VIA ID has to have 6 digits!");
    }

    for (int i = 0; i < classList.size(); i++)
    {
      for (int j = 0; j < classList.get(i).getStudents().size(); j++)
      {
        if (classList.get(i).getStudents().get(j).getViaId() == viaId)
        {
          return classList.get(i).getStudents().get(j);
        }
      }
    }
    throw new NullPointerException("There are no students with this VIA ID.");
  }

    @Override
    public SessionList getSessionsByDateAndClassGroup(Date date, ClassGroup classGroup) {
        return sessionList.getSessionsByDateAndClassGroup(date, classGroup);
    }

  @Override public void setChosenTeacher(Teacher chosenTeacher)
  {
    this.chosenTeacher = chosenTeacher;
  }

  @Override public Teacher getChosenTeacher()
  {
    return chosenTeacher;
  }

  public CourseList getCoursesByTeacher(Teacher teacher){
    return courseList.getCoursesByTeacher(teacher);
    }
}
