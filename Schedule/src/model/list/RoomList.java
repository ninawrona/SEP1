package model.list;

import model.basic.FoldableRoom;
import model.basic.Room;

import java.util.ArrayList;

/**
 * A class representing a list of Room objects.
 *
 * @author Christian Foyer, Kamil Fischbach, Martin Rosendahl, Nina Wrona, Robert Barta.
 * @version 1 - 2 December 2021.
 */
public class RoomList
{
  private ArrayList<Room> rooms;

  /**
   * Zero-argument constructor. The previously declared ArrayList "rooms" of type Teacher is initialized.
   */
  public RoomList()
  {
    rooms = new ArrayList<>();


    /*
    // Adding some fake rooms
    rooms.add(new Room(5, 'c', 16, 45));
    rooms.add(new Room(5, 'c', 13, 45));
    rooms.add(new Room(5, 'c', 12, 45));
    rooms.add(new Room(5, 'c', 6, 45));
    rooms.add(new Room(5, 'c', 7, 45));

     */

  }
  /**
   * A method returning a size of a RoomList object.
   *
   * @return an int size of a RoomList object.
   */
  public int size()
  {
    return rooms.size();
  }

  /**
   * A void method for adding a room to the list.
   * @param room
   *              the Room object to be added to the list (cannot be null).
   */
  public void addRoom(Room room)
  {
    if(room==null)
    {
      throw new IllegalArgumentException("Parameter cannot be null");
    }
    rooms.add(room);
  }

  /**
   * A void method for removing a room to the list. List cannot be empty.
   * @param room
   *            the Room object to be added to the list (cannot be null).
   */
  public void removeRoom(Room room)
  {
    if (size() == 0)
    {
      throw new NullPointerException(
          "The list is empty! You cannot remove anything!");
    }
    if (room == null)
    {
      throw new IllegalArgumentException("Parameter cannot be null!");
    }
    rooms.remove(room);
  }
  /**
   * A getter method returning a room from the list.
   * @param index
   *            the desired index to get the room from.
   * @return a Room object from the specified index.
   *
   */
  public Room get(int index)
  {
    return rooms.get(index);
  }

  /**
   * A getter method returning a Room object by searching for their floor.
   * @param floor
   *            An int representing the room's floor (cannot be negative).
   * @return a Teacher object.
   */
  public RoomList getRoomsOnFloor(int floor)
  {
    if(floor<0)
    {
      throw new IllegalArgumentException("Parameter cannot be negative.");
    }
    RoomList roomList = new RoomList();

    for (int i = 0; i < rooms.size(); i++)
    {
      if (rooms.get(i).getFloor() == floor)
      {
        roomList.addRoom(rooms.get(i));
      }
    }
    return roomList;
  }
  /**
   * A method checking if the list contains the specified room.
   * @param room
   *              the Room object to search by (cannot be null).
   * @return "True" if the list contains the specified Room object, or "False" if it does not.
   */
  public boolean contains(Room room){
    if (room instanceof FoldableRoom){
      return false;
    }
    if(room==null)
    {
      throw new IllegalArgumentException("Parameter cannot be null.");
    }
    for (int i = 0; i < rooms.size(); i++){
      if (rooms.get(i).equals(room)){
        return true;
      }
    }
    return false;
  }
  /**
   * A method returning a String representation of the ArrayList "rooms".
   * @return a String containing all the rooms and their information.
   */
  public String toString()
  {
    String str = "";
    for (int i = 0; i < rooms.size(); i++)
    {
      str += rooms.get(i).toString() + "\n";
    }
    return str;
  }
  /**
   * A method comparing two RoomList objects.
   * @param obj
   *          an object representing the other object to be compared.
   * @return "True" if the two RoomList objects are identical, or "False" if they are not.
   */
  public boolean equals(Object obj)
  {
    if (!(obj instanceof RoomList))
    {
      return false;
    }

    RoomList other = (RoomList) obj;

    if (rooms.size() == other.size())
    {
      for (int i = 0; i < rooms.size(); i++)
      {
        if (!(rooms.get(i).equals(other.get(i))))
        {
          return false;
        }
      }
      return true;
    }
    return false;
  }
}
