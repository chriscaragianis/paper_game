public class Room {

    private int[] nbrs;
 
    public Room(int parent, int newLoc)
    {
         nbrs = new int[4];
         for (int i = 0; i < 4; i++)
         nbrs[i] = -1;
         nbrs[0] = parent;
    }
 
    public Room()
    {
         nbrs = new int[4];
         for (int i = 0; i < 4; i++)
         nbrs[i] = -1;
    }
 
    public int[] getNbrs()
    {
         return nbrs;
    }
 
    public boolean isOpen()
    {
         for (int v : nbrs)
         if (v == -1)
         return true;
         return false;
    }
 
    public boolean isNbr(int index)
    {
         for (int v: nbrs)
         if (v == index)
         return true;
         return false;
    }
 
    public void connect(int parent)
    {
         for (int i = 0; i < 4; i++)
         if (nbrs[i] == -1)
         {  
             nbrs[i] = parent;
             break;
         }
    }
 
}
