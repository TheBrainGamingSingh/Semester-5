import java.util.Random;
public class market
{
    public static void main(String[] args) throws InterruptedException
    {

        final PC pc = new PC();
        Thread t1 = new Thread(new Runnable()
        {
            public void run()
            {
                try
                {
                    pc.produce();
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    pc.consume();
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }

    public static class PC
    {

        int arr[] = new int[4];
        int capacity = 5;
        String str[] = {"Apple","Orange","Watermelon","Bananas"};

        public void produce() throws InterruptedException
        {
            Random rand = new Random();
            int i = 0;
            while (true)
            {

                synchronized (this)
                {
                    i = rand.nextInt(4);

                    while (arr[i] == capacity)
                      wait();

                    arr[i]++;
                    System.out.println("--------------------------------------------");

                    System.out.println("Producer produced - " + str[i]);
                    System.out.println("--------------------------------------------");

                    for(int k = 0; k < 4;k++)
                    {
                      System.out.println(str[k] + "s" + "--" + arr[k]);
                    }
                    System.out.println("--------------------------------------------");

                    notify();
                    Thread.sleep(1000);
                }
            }
        }

        public void consume() throws InterruptedException
        {
            Random ran = new Random();
            int j = 0;
            while (true)
            {
                synchronized (this)
                {
                    j = ran.nextInt(4);

                    while (arr[j] == 0)
                      wait();

                    arr[j]--;
                    System.out.println("--------------------------------------------");
                    System.out.println("Consumer consumed-" + str[j]);
                    System.out.println("--------------------------------------------");
                    for(int k = 0; k < 4;k++)
                    {
                      System.out.println(str[k] + "s" + "--" + arr[k]);
                    }
                    System.out.println("--------------------------------------------");

                    notify();

                    Thread.sleep(1000);
                }
            }
        }
    }
}
