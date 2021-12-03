package model.list;

import model.basic.Room;

import java.util.ArrayList;

public class RoomList
{
  private ArrayList<Room> rooms;

  public RoomList(){
    rooms = new ArrayList<>();

    // Adding some fake rooms
    rooms.add(new Room(5, 'c', 16, 45));
    rooms.add(new Room(5, 'c', 13, 45));
    rooms.add(new Room(5, 'c', 12, 45));
    rooms.add(new Room(5, 'c', 6, 45));
    rooms.add(new Room(5, 'c', 7, 45));



  }

  public int size(){
    return rooms.size();
  }

  public void addRoom(Room room){
    rooms.add(room);
  }

  public void removeRoom(Room room){
    if(size()==0)
    {
      throw new NullPointerException("The list is empty! You cannot remove anything!");
    }
    if(rooms==null)
    {
      throw new IllegalArgumentException("Parameter cannot be null!");
    }
    rooms.remove(room);
  }

  public Room get(int index){
    return rooms.get(index);
  }

  public RoomList getRoomsOnFloor(int floor){
    RoomList roomList = new RoomList();

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
        if (!(rooms.get(i).equals(other.get(i)))){
          return false;
        }
      }
      return true;
    }
    return false;
  }
}
