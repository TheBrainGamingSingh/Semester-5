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
    }
}
