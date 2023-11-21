import java.util.*;

public class line{

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a word: ");
        String w = sc.next();
        sc.nextLine();
        System.out.println("Enter a sentence: ");
        String s = sc.nextLine();

        System.out.println(w + " " + s);

        sc.close();

    }
}