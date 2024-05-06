import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class ProductFactory {
    private final List<Product> products = new ArrayList<>();

    public List<Product> getExpensiveBooks() {
        return products.stream()
                       .filter(product -> product.getType().equals("Book") && product.getPrice() > 250)
                       .collect(Collectors.toList());
    }

    public List<Product> getDiscountedBooks() {
        return products.stream()
                       .filter(product -> product.getType().equals("Book") && product.hasDiscount())
                       .map(product ->  new Product(product.getType(),
                                               product.getPrice() * 0.9,
                                                    product.hasDiscount(),
                                                    product.getCreateDate(),
                                                    product.getId())
                       )
                       .collect(Collectors.toList());
    }

    public Product getCheapestBook() {
        return products.stream()
                       .filter(product -> product.getType().equals("Book"))
                       .min(Comparator.comparingDouble(Product::getPrice))
                       .orElseThrow(() -> new NoSuchElementException("Product [category: Book] not found"));
    }

    public List<Product> getLatestProducts() {
        return products.stream()
                       .sorted(Comparator.comparing(Product::getCreateDate).reversed())
                       .limit(3)
                       .collect(Collectors.toList());
    }

    public double calculateTotalCost() {
        LocalDate currentDate = LocalDate.now();
        return products.stream()
                       .filter(product -> product.getCreateDate().getYear() == currentDate.getYear() &&
                                          product.getType().equals("Book") &&
                                          product.getPrice() <= 75
                       )
                       .mapToDouble(Product::getPrice)
                       .sum();
    }

    public Map<String, List<Product>> groupByType() {
        return products.stream()
                       .collect(Collectors.groupingBy(Product::getType));
    }

    public void createProduct(String type, double price, boolean discount, LocalDate createDate) {
        long id = products.stream()
                          .mapToLong(Product::getId)
                          .max()
                          .orElse(0);

        Product product = new Product(
                type,
                price,
                discount,
                createDate,
                id
        );
        products.add(product);
    }

    public void createProduct(String type, double price, boolean discount) {
        long id = products.stream()
                          .mapToLong(Product::getId)
                          .max()
                          .orElse(0);

        Product product = new Product(
                type,
                price,
                discount,
                id
        );
        products.add(product);
    }
}
