public class MapTester
{
	final int iter = 10000;
    public static void main(String[] argv)
    {
        Map mappy = new Map();
        for (int i = 0; i < iter; i++)
        {
           mappy.update();
        }
        mappy.printMap();
        mappy.dotMap();
    } 
  
}
