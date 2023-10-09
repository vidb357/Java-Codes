import java.util.*;

public class Prime{

    public static boolean isPrime(int n){

        if(n ==1 || n == 0){
            return false;
        }
        for(int i = 2 ; i<= (n/2); i++){

            if(n%i==0){
                return false;
            }
        }

        return true;
    }

    public static void main(String args[]){

        int count=0;
        int i=0;

        while(count<10){
            boolean p = isPrime(i);
            if(p == true){
                System.out.print(i+ " ");
                count++;
            }
            i++;


        }

    }
}