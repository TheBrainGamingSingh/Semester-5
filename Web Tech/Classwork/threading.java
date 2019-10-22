import java.util.*;

class threaded extends Thread{
    threaded(String str)
    {
      super(str);
    }
    public void run()
    {
      for(int i = 0; i < 10; i++)
        System.out.println(getName() + "------" + i);
      try{
        //Thread.sleep(10);
        System.out.println("-----------------------------------------------");

      }
      catch(Exception e)
      {

      }
    }
  }
class threading{
  public static void main(String[] args) {
    System.out.println("Hello World");
    threaded t1 = new threaded("One");
    threaded t2 = new threaded("Two");
    threaded t3 = new threaded("Thr");

    t1.setPriority(10);
    t2.setPriority(1);
    t3.setPriority(5);

    t1.start();
    t2.start();
    t3.start();
  }
}
