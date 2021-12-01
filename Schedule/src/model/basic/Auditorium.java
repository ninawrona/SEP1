package model.basic;

public class Auditorium extends Room {
    private final static int AUDCAPACITY = 150;

    public Auditorium(int floor, char block, int number, int AUDCAPACITY) {
        super(floor, block, number, AUDCAPACITY);
    }

    public String toString() {
        return "Auditorium: " + super.getBlock() + super.getFloor() + super.getNumber() + "\nCapacity: " + getCapacity();
    }

    public boolean equals(Object obj)
    {
        if(!(obj instanceof Auditorium ))
        {
            return false;
        }
        Auditorium other = (Auditorium)obj;

        return super.equals(obj);
    }

}
