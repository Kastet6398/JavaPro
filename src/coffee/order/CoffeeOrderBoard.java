package coffee.order;

import java.util.*;

public class CoffeeOrderBoard {
    private final Map<Integer, Order> orders = new HashMap<>();

    public void add(String customerName) {
        int id = orders.keySet().stream().mapToInt(a -> a).max().orElse(0) + 1;
        Order newOrder = new Order(id, customerName);
        orders.put(id, newOrder);
    }

    public Order deliver() {
        if (orders.isEmpty()) {
            return null;
        }
        int nextId = orders.keySet().stream().findFirst().get();
        return orders.remove(nextId);
    }

    public Order deliver(int id) {
        return orders.remove(id);
    }

    public void draw() {
        System.out.println("===============");
        System.out.println("ID | Name");
        for (Map.Entry<Integer, Order> order : orders.entrySet()) {
            System.out.println(STR."\{order.getKey()} | \{order.getValue().customerName()}");
        }
    }
}
