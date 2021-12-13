package model.basic;

/**
 * A subclass representing the auditorium.
 *
 * @author Christian Foyer, Kamil Fischbach, Martin Rosendahl, Nina Wrona, Robert Barta
 * @version 1 - 2 December 2021
 */

public class Auditorium extends Room
{
  private final static int AUDCAPACITY = 150;

  /**
   * Four-argument constructor. Same exceptions as in its superclass for the same instance variables.
   *
   * @param floor       the floor on which the room is.
   * @param block       the block in which the room is.
   * @param number      the number of the room.
   * @param AUDCAPACITY the capacity of the auditorium.
   */
  public Auditorium(int floor, char block, int number, int AUDCAPACITY)
  {
    super(floor, block, number, AUDCAPACITY);
  }

  /**
   * A method returning the String representation of the Auditorium object.
   *
   * @return A string containing the block, the floor and the number of the auditorium.
   */

  public String toString()
  {
    return "Auditorium: " + super.getBlock() + super.getFloor()
        + super.getNumber();
  }

}
