import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Order {
    private int orderId;
    private String customerName;
    private float baseAmount;

    public Order(int orderId, String customerName, float baseAmount) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.baseAmount = baseAmount;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public float getBaseAmount() {
        return baseAmount;
    }

    public float calculateTotal() {
        return baseAmount;
    }

    public String getOrderSummary() {
        return "Id: " + orderId +
               ", Name: " + customerName +
               ", Base Amount: " + baseAmount;
    }
}

class DiscountedOrder extends Order {
    private int discountRate;

    public DiscountedOrder(int orderId, String customerName, float baseAmount, int discountRate) {
        super(orderId, customerName, baseAmount);
        this.discountRate = discountRate;
    }

    public int getDiscountRate() {
        return discountRate;
    }

    @Override
    public float calculateTotal() {
        return getBaseAmount() - (getBaseAmount() * discountRate / 100);
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Order> orders = new ArrayList<>();

        Order o1 = new Order(101, "Abhinand", 5000);
        DiscountedOrder o2 = new DiscountedOrder(102, "Arjun", 8000, 10);

        orders.add(o1);
        orders.add(o2);

        for (Order o : orders) {
            System.out.println(o.getOrderSummary());
            System.out.println("Total: " + o.calculateTotal());
            System.out.println();
        }
    }
}
