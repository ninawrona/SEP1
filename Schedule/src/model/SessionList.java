package model;

import java.util.ArrayList;

public class SessionList
{
  private ArrayList<Session> sessions;

  public SessionList(){
    sessions = new ArrayList<>();
  }

  public int size(){
    return sessions.size();
  }

  public Session get(int index){
    return sessions.get(index);
  }

  public void addSession(Session session){
    if(session == null)
    {
      throw new IllegalArgumentException("Session cannot be null!");
    }
    sessions.add(session);
  }

  public void removeSession(Session session){
    if(session == null)
    {
      throw new IllegalArgumentException("Session cannot be null!");
    }
    sessions.remove(session);
  }

  public Session getSessionByTimeInterval(TimeInterval timeInterval){
    if (timeInterval == null){
      throw new IllegalArgumentException("Time Interval Can Not Be Null");
    }

    for (int i = 0; i < sessions.size(); i++){
      if (sessions.get(i).getTimeInterval().equals(timeInterval)){
        return sessions.get(i);
      }
    }
    System.out.println("There is no session at that time interval");
    return null;
  }

  public Session getSessionByRoom(Room room){
    if (room == null){
      throw new IllegalArgumentException("Room can not be null");
    }

    for (int i = 0; i < sessions.size(); i++){
      if (sessions.get(i).getRoom().equals(room)){
        return sessions.get(i);
      }
    }
    System.out.println("There is no session in that room");
    return null;
  }

  public Session getSessionByCourse(Course course){
    if (course == null){
      throw new IllegalArgumentException("Course can not be null");
    }

    for (int i = 0; i < sessions.size(); i++){
      if (sessions.get(i).getCourse().equals(course)){
        return sessions.get(i);
      }
    }
    System.out.println("There is no session for that course");
    return null;
  }

  public Session forAllTheAbove(TimeInterval timeInterval,Room room, Course course){
    if (timeInterval == null || room == null || course == null){
      throw new IllegalArgumentException("Parameters can not be null");
    }

    for (int i = 0; i < sessions.size(); i++){
      if (sessions.get(i).getTimeInterval().equals(timeInterval)){
        if (sessions.get(i).getRoom().equals(room)){
          if (sessions.get(i).getCourse().equals(course)){
            return sessions.get(i);
          }
        }
      }
    }
    System.out.println("There is no such session");
    return null;
  }

  public String toString(){
    String str = "";
    for (int i = 0; i < sessions.size(); i++){
      str += sessions.get(i);
    }
    return str;
  }

  public boolean equals(Object obj){
    if (!(obj instanceof SessionList)){
      return false;
    }

    SessionList other = (SessionList)obj;

    if (sessions.size() == other.size()){
      for (int i = 0; i < sessions.size(); i++){
        if (!(sessions.get(i).equals(other.get(i)))){
          return false;
        }
      }
      return true;
    }
    return false;
  }







}
