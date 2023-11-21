import java.util.*;

public class sum{

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number: ");

        int n = sc.nextInt();

        int sum = 0;
        int r;

        while(n!=0){

            r = n%10;
            sum+=r;
            n/=10;
        }

        System.out.println("The sum of its digits is: "+ sum);
    }
}