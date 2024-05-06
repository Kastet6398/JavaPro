import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ProductStore store = new ProductStore();
        store.createProduct("Book", 300, false);
        store.createProduct("Book", 200, true);
        store.createProduct("Toy", 150, false);
        store.createProduct("Toy", 140, true);
        store.createProduct("Book", 100, true);
        store.createProduct("Book", 75, true);

        List<Product> expensiveBooks = store.getExpensiveBooks();
        System.out.println(STR."Expensive Books: \{expensiveBooks}");

        List<Product> discountedBooks = store.getDiscountedBooks();
        System.out.println(STR."Discounted Books: \{discountedBooks}");

        Product cheapestBook = store.getCheapestBook();
        System.out.println(STR."Cheapest Book: \{cheapestBook}");

        List<Product> latestProducts = store.getLatestProducts();
        System.out.println(STR."Latest Products: \{latestProducts}");

        double totalCost = store.calculateTotalCost();
        System.out.println(STR."Total cost of eligible books: \{totalCost}");

        System.out.println("Grouped Products:");
        Map<String, List<Product>> groupedProducts = store.groupByType();
        printGroupedProducts(groupedProducts);
    }

    private static void printGroupedProducts(Map<String, List<Product>> groupedProducts) {
        System.out.println("{");
        int i = 0;
        for (Map.Entry<String, List<Product>> category : groupedProducts.entrySet()) {
            System.out.println(STR."    \"\{category.getKey()}\":\n    [");
            for (int j = 0; j < category.getValue().size(); j++) {
                Product product = category.getValue().get(j);
                if (j < category.getValue().size() - 1) {
                    System.out.println(STR."        {type: \"\{product.getType()}\", price: \{product.getPrice()}, hasDiscount: \{product.hasDiscount()}, createDate: \{product.getCreateDate()}},");
                } else {
                    System.out.println(STR."        {type: \"\{product.getType()}\", price: \{product.getPrice()}, hasDiscount: \{product.hasDiscount()}, createDate: \{product.getCreateDate()}}");
                }

            }

            if (i < groupedProducts.size() - 1) {
                System.out.println("    ],\n");
                i++;
            } else {
                System.out.println("    ]\n");
            }
        }
        System.out.println("}");
    }
}
