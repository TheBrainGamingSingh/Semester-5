import java.util.Scanner;

public class question_6{
    public static void main(String[] args) {

        long numb = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the Number to display hailstone sequence for: ");
        numb = scanner.nextLong();

        if(numb<=0){
            while(numb<=0){
                System.out.println("Enter a positive number: ");
                numb = scanner.nextLong();
            }
        }
        System.out.println("The Hailstone Sequence is:");
        while(numb!=1){

            if(numb%2==0){
                numb/=2;
                System.out.print(numb + " ");
            }
            else{
                numb = numb*3+1;
                System.out.print(number + " ");
            }
        }
    }
}
