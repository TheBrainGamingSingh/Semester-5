class overloading{
  static void sum(int a,long b)
  {
    System.out.println("a method invoked");
  }

  /*static void sum(int a,int b)
  {
    System.out.println("b method invoked");
  }
  */
 public static void main(String[] args) {
   sum(1,2);
   sum(1,2l);
  }

}
