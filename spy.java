import java.util.*;


public class spy{

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number: ");

        int n = sc.nextInt();
        int sum = 0;
        int r;
        int p =1;

        while(n!=0){

            r = n%10;
            sum+=r;

            p*=r;
            n/=10;
        }

        if(sum==p){
            System.out.println("SPY");
        }

        else{
            System.out.println("Not SPY");
        }



    }
}