package model.basic;

public class Room
{
  private int floor;
  private char block;
  private int number;
  private int capacity;
  private boolean available;

  public Room(int floor, char block, int number, int capacity){
    this.floor = floor;
    this.block = block;
    this.number = number;
    this.capacity = capacity;
    available = true;
  }

  public void book(){
    available = false;
  }

  public boolean isAvailable(){
    return available;
  }

  public int getFloor(){
    return floor;
  }

  public char getBlock(){
    return block;
  }

  public int getNumber(){
    return number;
  }

  public int getCapacity(){
    return capacity;
  }

  public String toString(){
    return "Room: " + block + floor + number + "\nCapacity: " + capacity + "\nAvailable: " + available;
  }

  public boolean equals(Object obj){
    if (!(obj instanceof Room))
    {
      return false;
    }

    Room other = (Room)obj;

    return floor == other.floor && block == other.block && capacity == other.capacity && available == other.available;
  }
}
