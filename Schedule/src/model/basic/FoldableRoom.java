package model.basic;

/**
 * A subclass representing the foldable rooms by adding the letter 'a' or 'b' to the end of the room's identifier.
 *
 * @author Christian Foyer, Kamil Fischbach, Martin Rosendahl, Nina Wrona, Robert Barta
 * @version 1 - 2 December 2021
 */

public class FoldableRoom extends Room
{
  private char letter;

  /**
   * Five-argument constructor with the same exceptions as its superclass for the same instance variables. The letter must be either 'a' or 'b'.
   *
   * @param floor    the floor on which the room is.
   * @param block    the block in which the room is.
   * @param number   the number of the room.
   * @param capacity the capacity of the room.
   * @param letter   the identifier for the different halves of the room.
   */
  public FoldableRoom(int floor, char block, int number, int capacity,
      char letter)
  {
    super(floor, block, number, capacity);
    if (letter=='a')
    {
      this.letter = letter;
    }
    else if (letter=='b')
    {
      this.letter = letter;
    }
    else
      throw new IllegalArgumentException("The letter must be 'a' or 'b'!");
  }

  /**
   * A getter method returning the letter of the room.
   *
   * @return a char representing the letter of the room.
   */
  public char getLetter()
  {
    return letter;
  }

  /**
   * A method returning the String representation of a FoldableRoom object.
   *
   * @return A string containing the block, the floor, the number and the letter of one half of the foldable room.
   */


  public String toString()
  {
    return "" + super.toString() + letter;
  }

  /**
   * A method comparing two FoldableRoom objects.
   *
   * @param obj an object representing the other object to be compared.
   * @return "True" if the compared FoldableRoom objects are the same, or "False" if they are different.
   */
  public boolean equals(Object obj)
  {
    if (!(obj instanceof FoldableRoom))
    {
      return false;
    }

    FoldableRoom other = (FoldableRoom) obj;
    return super.equals(obj) && this.letter == other.letter;
  }
}
