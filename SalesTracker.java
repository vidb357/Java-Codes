class Product {
    String name;
    int code;
    double amount;

    public Product(String n, int c, double p) {
        name = n;
        code = c;
        amount = p;
    }

    public void show() {
        System.out.println("Product Name: " + name);
        System.out.println("Product Code: " + code);
        System.out.println("Sale Amount: " + amount);
    }
}

class Sales extends Product {
    int day;
    double tax;
    double totamt;

    public Sales(String n, int c, double p, int d) {
        super(n, c, p);
        day = d;
        tax = 0;
        totamt = 0;
    }

    public void compute() {
        if (day > 30) {
            double fine = 0.025 * amount;
            totamt = amount + tax + fine;
        } else {
            totamt = amount + tax;
        }

        tax = 0.124 * amount;
    }

    @Override
    public void show() {
        super.show();
        System.out.println("Number of Days Taken to Pay: " + day);
        System.out.println("Service Tax: " + tax);
        System.out.println("Total Amount Paid: " + totamt);
    }
}

public class SalesTracker {
    public static void main(String[] args) {
        
        Sales sales = new Sales("XYZ", 100, 1250.0, 35);

        sales.compute();
        sales.show();
    }
}
