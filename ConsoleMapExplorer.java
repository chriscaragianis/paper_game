import java.util.Scanner;

public class ConsoleMapExplorer {

 private Map mappy;
 
 public ConsoleMapExplorer()
 {
  mappy = new Map();
 }
 
 public void move() 
 {
  Scanner in = new Scanner(System.in);
  String dir = in.nextLine();
  if (dir.equals("N"))
   mappy.update(1);
  else if (dir.equals("E"))
   mappy.update(2);
  else if (dir.equals("S"))
   mappy.update(3);
  else if (dir.equals("W"))
   mappy.update(0);
  else if (dir.equals("draw"))
    mappy.dotMap();
  else 
   System.out.println("Not a valid direction.");
 }
 
 public static void main(String[] args)
 {
  ConsoleMapExplorer conmap = new ConsoleMapExplorer();
  while (true)
  {
   System.out.println("You are in room " + conmap.mappy.getPlayerLoc());
   System.out.println("Enter a direction.");
   conmap.move();
  }
 }

}