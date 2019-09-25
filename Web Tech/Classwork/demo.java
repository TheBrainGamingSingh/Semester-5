class demo
{
    public static void main(String args[])
    {
      StringBuffer str1 = new StringBuffer("Java");
      System.out.println(str1.append("Programming") );
      System.out.println(str1.capacity());
      System.out.println(str1.append(123));
      System.out.println(str1.capacity());
      System.out.println(str1.append(str1));
      System.out.println(str1.capacity());
      int j = 0;
      for(int i = 0; i < 100; i++)
      j = j++;
      http://google.com;
      System.out.println(j);
    }
}
