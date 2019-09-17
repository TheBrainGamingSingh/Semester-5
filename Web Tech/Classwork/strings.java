public class strings
{
  public static void main(String args[])
  {
    String s1 = "Hello";
    char s2[] = {'H','e','l','l','o'};
    String s3 = new String(s2);
    String s4 = new String(s1);
    if(s1.equals(s3))
      System.out.println("True");

    if(s1 == s3)
      System.out.println("True");
    else
      System.out.println("False");

      if(s1.equals(s4))
        System.out.println("True");
        else
          System.out.println("False");
      if(s1 == s4)
        System.out.println("True");
        else
          System.out.println("False");






  }
}
