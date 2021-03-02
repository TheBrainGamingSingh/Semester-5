import java.util.Scanner;

public class question_3{
    public static void main(String[] args) {

        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of strings: ");
        n=sc.nextInt();

        String arr[] = new String[n];

        for(int k=0; k<n; k++){
            System.out.print("\nEnter string #"+(k+1)+": ");
            arr[k]=sc.next();
        }


        for(int k=0; k<n; k++){
            for(int k=0; k<n-1; k++){
                if(compare(arr[k], arr[k+1])>0){
                    String temp = new String(arr[k]);
                    arr[k]=arr[k+1];
                    arr[k+1]=temp;
                }
            }
        }

        for(String s : arr)
        System.out.println(s);
    }

    public static int compare(String a, String b){
        for(int k=0; k<a.length() && k<b.length(); k++) {
            if(a.charAt(k) != b.charAt(k))
                return a.charAt(k) < b.charAt(k) ? -1 : 1;
        }
        return a.length() < b.length() ? -1 : a.length() == b.length() ? 0 : 1;
    }

}
