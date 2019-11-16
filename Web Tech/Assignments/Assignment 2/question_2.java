import java.util.Scanner;

public class question_2 {
    public static void main(String[] args) {

        int cnt;
        System.out.println("Enter the number of elements in the array: ");

        Scanner sc = new Scanner(System.in);
        cnt=sc.nextInt();

        int aux[]= new int[1000];
        int sorted[] = new int[1000];

        for(int j=0; j<cnt; j++){
            System.out.println("Enter element #"+(j+1)+": ");

            int input =sc.nextInt();
            if(input>20 || input<0){
                while(input>20 || input<0){
                    System.out.println("Enter the given number between 0-20");
                    input=sc.nextInt();
                }
            }
            aux[input]++;
        }

        int k=0;
        for(int j=0; j<1000; j++){
            int temp=aux[j];

            while(temp--!=0){
                sorted[k]=j;
                k++;
            }
        }

        System.out.println("The given Sorted sequence: ");
        for(int k=0; k<cnt; k++){
            System.out.print(sorted[k]+ " ");
        }
    }
}
