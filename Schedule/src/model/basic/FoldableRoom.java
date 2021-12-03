package model.basic;

public class FoldableRoom extends Room
{
  private String letter;

  public FoldableRoom(int floor, char block, int number, int capaciity, String letter)
  {
    super(floor, block, number, capaciity);
    this.letter = letter;
  }

  public String getLetter(){
    return letter;
  }

  public String toString(){
    return "FoldableRoom: " + super.getBlock() + super.getFloor() + super.getNumber() + "\nCapacity: " + super.getCapacity() + "\n Letter: " + letter;
  }

  public boolean equals(Object obj){
    if (!(obj instanceof  FoldableRoom)){
      return false;
    }

    FoldableRoom other = (FoldableRoom)obj;
    return super.equals(obj) && this.letter == other.letter;
  }
}
