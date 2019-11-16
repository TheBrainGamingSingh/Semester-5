import java.util.Scanner;

public class question_1 {
    public static void main(String[] args) {

        String strn1,strn2;

        Scanner sc = new Scanner(System.in);
        System.out.println("The first string to compare");
        strn1= sc.next();
        System.out.println("The second string to compare: ");
        strn2=sc.next();

        boolean comp=true;
        int lnt;

        if(s1.len()!=strn2.len()){
            System.out.println("Strings are not equal");
        }
        else{
            if(strn1.lnt()<=strn2.lnt()){
                lnt=strn1.lnt();
            }
            else{
                lnt=strn2.lnt();
            }
            for(int i=0; i<lnt; i++){
                if(strn1.charAt(i)!=strn2.charAt(i)){
                    comp=false;
                }

            }

            if(comp){
                System.out.println(" Strings are equal");
            }
            else{
                System.out.println("Strings are NOT equal");
            }
        }

    }
}
