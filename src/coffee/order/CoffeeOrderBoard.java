package coffee.order;

import java.util.*;

public class CoffeeOrderBoard {
    private final Queue<Order> orders = new LinkedList<>();
    private int orderIdCounter = 0;

    public void add(String customerName) {
        Order newOrder = new Order(orderIdCounter++, customerName);
        orders.add(newOrder);
    }

    public Order deliver() {
        return orders.poll();
    }

    public Order deliver(int id) {
        for (Order order : orders) {
            if (order.id() == id) {
                orders.remove(order);
                return order;
            }
        }
        return null;
    }

    public void draw() {
        System.out.println("===============");
        System.out.println("ID | Name");
        for (Order order : orders) {
            System.out.println(STR."\{order.id()} | \{order.customerName()}");
        }
    }
}
