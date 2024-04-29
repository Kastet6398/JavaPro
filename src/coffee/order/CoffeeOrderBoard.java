package coffee.order;

import java.util.*;

public class CoffeeOrderBoard {
    private final Queue<Order> ordersQueue = new LinkedList<>();
    private int orderIdCounter = 0;

    public void add(String customerName) {
        Order newOrder = new Order(orderIdCounter++, customerName);
        ordersQueue.offer(newOrder);
    }

    public Order deliver() {
        return ordersQueue.poll();
    }

    public Order deliver(int id) {
        for (Order order : ordersQueue) {
            if (order.id() == id) {
                ordersQueue.remove(order);
                return order;
            }
        }
        return null;
    }

    public void draw() {
        System.out.println("===============");
        System.out.println("ID | Name");
        for (Order order : ordersQueue) {
            System.out.println(STR."\{order.id()} | \{order.customerName()}");
        }
    }
}
