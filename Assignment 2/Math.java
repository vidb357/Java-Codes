import java.util.*;

public class Math{

    public static void main(String args[]){

        MathOperations maths = new MathOperations();

        int s1 = maths.sum(4,5);
        System.out.println("Sum of two integers: " + s1 + "\n");

        double s2 = maths.sum(4.5,5.4);
        System.out.println("Sum of two doubles: " + s2 + "\n");

        double s3 = maths.sum(4,5.5);
        System.out.println("Sum of an integer and a double: " + s3 + "\n");

        double s4 = maths.sum(4.5,5);
        System.out.println("Sum of a double and an integer: " + s4 + "\n");

    }
}

    class MathOperations{

        public int sum(int n1, int n2){
            return n1+n2;
        }

        public double sum(double n1, double n2){
            return n1+n2;
        }

        public double sum(int n1, double n2){
            return n1+n2;
        }

        public double sum(double n1, int n2){
            return n1+n2;
        }

    }
