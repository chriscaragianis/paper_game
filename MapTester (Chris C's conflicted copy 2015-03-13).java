public class MapTester
{
  public static void main(String[] argv)
  {
    Map mappy = new Map();
    for (int i = 0; i < 1000; i++)
    {
      mappy.update();
    }
    mappy.printMap();
    mappy.dotMap();
  }
  
}