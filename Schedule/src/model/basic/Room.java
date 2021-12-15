package model.basic;

/**
 * A superclass representing the rooms.
 *
 * @author Christian Foyer, Kamil Fischbach, Martin Rosendahl, Nina Wrona, Robert Barta
 * @version 1 - 2 December 2021
 */
public class Room {
    private int floor;
    private char block;
    private int number;
    private int capacity;

    /**
     * Four-argument constructor. The floor must be 1 or greater. The room number must be 0 or greater. The capacity of the room must be a positive number.
     *
     * @param floor    the floor on which the room is.
     * @param block    the block in which the room is.
     * @param number   the number of the room.
     * @param capacity the capacity of the room.
     */
    public Room(int floor, char block, int number, int capacity) {

        if (floor < 1) {
            throw new IllegalArgumentException("Floor number has to be at least 1!");
        }
        if (number < 0) {
            throw new IllegalArgumentException(
                    "Room number has to be a positive integer or 0!");
        }
        if (capacity < 1) {
            throw new IllegalArgumentException(
                    "The capacity of the room has to be at least 1!");
        }

        this.floor = floor;
        this.block = block;
        this.number = number;
        this.capacity = capacity;

    }

    /**
     * A getter method for the floor of the room.
     *
     * @return the floor of the room.
     */
    public int getFloor() {
        return floor;
    }

    /**
     * A getter method for the block in which the room is.
     *
     * @return the block of the room.
     */
    public char getBlock() {
        return block;
    }

    /**
     * A getter method for the number of the room.
     *
     * @return the number of the room.
     */
    public int getNumber() {
        return number;
    }

    /**
     * A getter method for the capacity of the room.
     *
     * @return the capacity of the room
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * A method returning the String representation of the Room object.
     *
     * @return A string containing the block, the floor, the number and the capacity of the room in
     * a correct format (for example C05.16a, or C05.08).
     */
    public String toString() {
        String str = "";
        str += block;
        if (floor < 10) {
            str += 0;
        }
        str += floor + ".";
        if (number < 10) {
            str += 0;
        }
        str += number;
        return str;
    }

    /**
     * A method comparing two Room objects.
     *
     * @param obj an object representing the other object to be compared.
     * @return "True" if the compared Room objects are the same, or "False" if they are different objects.
     */
    public boolean equals(Object obj) {
        if (!(obj instanceof Room)) {
            return false;
        }

        Room other = (Room) obj;

        return floor == other.floor && block == other.block
                && number == other.number;
    }
}
