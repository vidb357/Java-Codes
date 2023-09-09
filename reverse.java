import java.util.*;

public class reverse{

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string: ");
        String s = sc.nextLine();
        int n = s.length();

        String reversed = "";

        for(int i = n-1; i>=0 ; i--){

            reversed+=s.charAt(i);
        }
        

        System.out.println("Reversed string is: "+reversed);


    }
}
