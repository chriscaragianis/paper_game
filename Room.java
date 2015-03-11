public class Room {

    private int[] nbrs; //holds the identifying numbers of neighboring rooms
	//Note that as of now a room does not
	//know its own identifying number.
 
	//Constructor taking id number of the room that created it 
    public Room(int parent)
    {
        nbrs = new int[4];
        for (int i = 0; i < 4; i++)
			nbrs[i] = -1;
        nbrs[0] = parent;
    }
 
	//Constructor creates a room with no connections (base step)
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
	
	//Returns true is there is an open spot in nbrs[]
    public boolean isOpen()
    {
        for (int v : nbrs)
			if (v == -1)
				return true;
        return false;
    }
 
	//Returns true if the given index appears in nbrs[]
    public boolean isNbr(int index)
    {
        for (int v: nbrs)
			if (v == index)
				return true;
        return false;
    }
 
	//Places given id number in first open spot in nbrs[]
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
