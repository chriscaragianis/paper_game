import java.util.*;
import java.io.*;

public class Map {

    private int playerLoc;
    private List<Room> rooms;
 
 public int getPlayerLoc()
 {
  return playerLoc;
 }
    public Map()
    {
        playerLoc = 0;
        rooms = new ArrayList<Room>();
        rooms.add(new Room());
    }
 
    public void addNbr(int index)
    {
        Random rand = new Random();
        double choice = rand.nextDouble();
   
        List<Integer> candidates = new ArrayList<Integer>();
        for (int i = 0; i < rooms.size(); i++)
            if (rooms.get(i).isOpen() && i != index && !rooms.get(index).isNbr(i))
            {
                candidates.add(i);
            }
        for (int j = 0; j < candidates.size(); j++)
            if (choice <= (double)(j + 1)/(candidates.size() + 1))
            {
                rooms.get(index).connect(candidates.get(j));
                rooms.get(candidates.get(j)).connect(index);
                return;
            }
        rooms.add(new Room());
        rooms.get(index).connect(rooms.size()-1);
        rooms.get(rooms.size()-1).connect(index);
    }
 
    public void printMap()
    {
        for (int i = 0; i < rooms.size(); i++)
        {
            System.out.print(i + ": ");
            for (int v : rooms.get(i).getNbrs())
                System.out.print(v + " ");
            System.out.println();
        }
    }  
 
    public void dotMap() 
    {
        try
        {
           FileWriter fout = new FileWriter("map.dot");
           fout.write("graph mappy {\n  node [shape=circle]\n" );
          for (int i = 0; i < rooms.size(); i++)
         {
          for (int v : rooms.get(i).getNbrs())
              if (v > i)
                    fout.write(i + " -- " + v + ";\n");
         }  
          fout.write("}");
          fout.close();
        }
        catch(IOException e)
        {
          return;
        }
    }    
 
    public void update()
    {
        Random rand = new Random();
        while (rooms.get(playerLoc).isOpen())
   addNbr(playerLoc);
        playerLoc = rooms.get(playerLoc).getNbrs()[rand.nextInt(3)];
    } 
 
 public void update(int i)
 {
  while (rooms.get(playerLoc).isOpen())
   addNbr(playerLoc);
        playerLoc = rooms.get(playerLoc).getNbrs()[i];
 }
}
