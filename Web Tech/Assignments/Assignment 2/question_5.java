import java.util.Arrays;
import java.util.Scanner;

public class question_5 {
    public static void main(String[] args) {

        int k,h;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements in first set: ");
        k=sc.nextInt();
        System.out.print("Enter the number of elements in second set: ");
        h=sc.nextInt();
        int univ[]=new int[11];
        int a[]=new int[k];
        int b[]= new int[h];

        //populate the universe
        for(int i=0; i<11; i++){
            univ[i]=i;
        }

        //input the first set
        System.out.println("For first set: ");
        for(int i=0;i<k; i++){
            System.out.println("Enter #"+(i+1)+" element: ");
            a[i]=sc.nextInt();

            if(a[i]<0 || a[i]>11){
                while (a[i]<0 || a[i]>11){
                    System.out.println("Enter a number in (0-11):");
                    a[i]=sc.nextInt();
                }
            }
        }

        //input the second set
        System.out.println("For second set: ");
        for(int i=0;i<h; i++){
            System.out.println("Enter #"+(i+1)+" element: ");
            b[i]=sc.nextInt();

            if(b[i]<0 || b[i]>11){
                while (b[i]<0 || b[i]>11){
                    System.out.println("Enter a number in (0-11):");
                    b[i]=sc.nextInt();
                }
            }
        }

        union(a,b);
        intersection(a,b);
        System.out.println("\n\nComplement of a is:");
        complement(a);
        System.out.println("\n\nComplement of b is:");
        complement(b);
    }


    public static void union(int[] firstArr, int[] secondArr) {
        int i = 0;
        int j = 0;

        Arrays.sort(firstArr);
        Arrays.sort(secondArr);

        System.out.println("\n\nUnion is:");
        while (i < firstArr.length && j < secondArr.length) {
            if (firstArr[i] < secondArr[j]) {
                System.out.print(firstArr[i] + " ");
                i++;
            } else if (secondArr[j] < firstArr[i]) {
                System.out.print(secondArr[j] + " ");
                j++;
            } else {
                System.out.print(firstArr[i] + " ");
                i++;
                j++;
            }
        }
        while (i < firstArr.length) {
            System.out.print(firstArr[i] + " ");
            i++;
        }
        while (j < secondArr.length) {
            System.out.print(secondArr[j] + " ");
            j++;
        }
    }


    public static void intersection(int[] firstArr, int[] secondArr) {
        int i = 0;
        int j = 0;

        Arrays.sort(firstArr);
        Arrays.sort(secondArr);

        System.out.println("\n\nIntersection is:");
        while (i < firstArr.length && j < secondArr.length) {
            if (firstArr[i] < secondArr[j]) {
                i++;
            } else if (firstArr[i] > secondArr[j]) {
                j++;
            } else {
                System.out.print(firstArr[i] + " ");
                i++;
                j++;
            }
        }
    }

    public  static void complement(int arr[]){
        int aux[] = new int[12];


        for(int i=0; i< arr.length; i++){
            aux[arr[i]]++;
        }

        for(int i=0; i<11; i++){
            if(aux[i]==0){
                System.out.print(i+" ");
            }
        }
    }
}
