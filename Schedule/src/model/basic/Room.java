package model.basic;

/**
 * A superclass representing the rooms.
 *
 * @author Christian Foyer, Kamil Fischbach, Martin Rosendahl, Nina Wrona, Robert Barta
 * @version 1 - 2 December 2021
 */
public abstract class Room
{
  private int floor;
  private char block;
  private int number;
  private int capacity;

  /**
   * Four-argument constructor. The floor must be 1 or greater. The room number must be 0 or greater. The capacity of the room must be a positive number.
   * @param floor
   *              the floor on which the room is
   * @param block
   *              the block in which the room is
   * @param number
   *              the number of the room
   * @param capacity
   *              the capacity of the room
   */
  public Room(int floor, char block, int number, int capacity)
  {

    if (floor < 1)
    {
      throw new IllegalArgumentException("Floor number has to be at least 1!");
    }
    if (number < 0)
    {
      throw new IllegalArgumentException("Room number has to be a positive integer or 0!");
    }
    if (capacity < 1)
    {
      throw new IllegalArgumentException("The capacity of the room has to be at least 1!");
    }

    this.floor = floor;
    this.block = block;
    this.number = number;
    this.capacity = capacity;

  }

  /**
   * A getter method for the floor of the room.
   * @return floor
   */
  public int getFloor()
  {
    return floor;
  }

  /**
   * A getter method for the block in which the room is.
   * @return block
   */
  public char getBlock()
  {
    return block;
  }

  /**
   * A getter method for the number of the room.
   * @return number
   */
  public int getNumber()
  {
    return number;
  }

  /**
   * A getter method for the capacity of the room.
   * @return capacity
   */
  public int getCapacity()
  {
    return capacity;
  }

  /**
   * A method returning the String representation of the Room object.
   * @return A string containing the block, the floor, the number and the capacity of the room.
   */
  public String toString()
  {
    return "Room: " + block + floor + number + "\nCapacity: " + capacity;
  }
  /**
   * A method comparing two Room objects.
   * @param obj
   *            an object representing the other object to be compared.
   * @return "True" if the compared Room objects are the same, or "False" if they are different objects.
   */
  public boolean equals(Object obj)
  {
    if (!(obj instanceof Room))
    {
      return false;
    }

    Room other = (Room) obj;

    return floor == other.floor && block == other.block
        && capacity == other.capacity;
  }
}
