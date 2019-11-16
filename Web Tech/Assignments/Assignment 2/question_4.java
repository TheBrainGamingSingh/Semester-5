public class question_4 {
    public static void main(String[] args) {

        long k=1, total=0;

        while(sum<=2147483647){
            total+=(k*k);
            k++;
        }

        System.out.println("The smallest value of i is: " +(k-1));

    }
}
