package model;

import java.util.ArrayList;

public class RoomList
{
  private ArrayList<Room> rooms;
  private RoomList roomList;

  public RoomList(){
    rooms = new ArrayList<>();
    roomList = new RoomList();
  }

  public int size(){
    return rooms.size();
  }

  public void addRoom(Room room){
    rooms.add(room);
  }

  public void removeRoom(Room room){
    rooms.remove(room);
  }

  public Room getRoomByIndex(int index){
    return rooms.get(index);
  }

  public RoomList getRoomsOnFloor(int floor){
    for (int i = 0; i < rooms.size(); i++){
      if (rooms.get(i).getFloor() == floor){
        roomList.addRoom(rooms.get(i));
      }
    }
    return roomList;
  }


  public String toString(){
    String str = "";
    for (int i = 0; i < rooms.size(); i++){
      str += rooms.get(i).toString();
    }
    return str;
  }

  public boolean equals(Object obj){
    if (!(obj instanceof RoomList)){
      return false;
    }

    RoomList other = (RoomList)obj;

    if (rooms.size() == other.size()){
      for (int i = 0; i < rooms.size(); i++){
        if (!(rooms.get(i).equals(other.getRoomByIndex(i)))){
          return false;
        }
      }
      return true;
    }

    return false;
  }
}
