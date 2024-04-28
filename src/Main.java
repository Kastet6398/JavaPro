import coffee.order.CoffeeOrderBoard;
import coffee.order.Order;

public class Main {
    public static void main(String[] args) {
        CoffeeOrderBoard pendingOrders = new CoffeeOrderBoard();

        pendingOrders.add("Alice");
        pendingOrders.add("Bob");
        pendingOrders.add("Charlie");
        pendingOrders.add("Tom");

        System.out.println("Current queue:");
        pendingOrders.draw();
        System.out.println();

        Order nextOrder = pendingOrders.deliver();
        System.out.println("Next order delivered:");
        System.out.println(nextOrder);
        System.out.println();

        int orderIdToDeliver = 3;
        Order specificOrder = pendingOrders.deliver(orderIdToDeliver);
        System.out.println(STR."Delivered order with ID \{orderIdToDeliver}:");
        System.out.println(specificOrder);
        System.out.println();

        System.out.println("Updated queue:");
        pendingOrders.draw();
    }
}
