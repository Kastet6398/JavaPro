import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Product {
    private String type;
    private double price;
    private boolean discount;
    private LocalDate createDate;

    public Product(String type, double price, boolean discount, LocalDate createDate) {
        this.type = type;
        this.price = price;
        this.discount = discount;
        this.createDate = createDate;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public boolean hasDiscount() {
        return discount;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public static List<Product> getExpensiveBooks(List<Product> products) {
        return products.stream()
                .filter(product -> product.getType().equals("Book") && product.getPrice() > 250)
                .collect(Collectors.toList());
    }

    public static List<Product> getDiscountedBooks(List<Product> products) {
        return products.stream()
                .filter(product -> product.getType().equals("Book") && product.hasDiscount())
                .map(product -> {
                    double discountedPrice = product.getPrice() * 0.9;
                    return new Product(product.getType(), discountedPrice, product.hasDiscount(), product.getCreateDate());
                })
                .collect(Collectors.toList());
    }

    public static Product getCheapestBook(List<Product> products) {
        return products.stream()
                .filter(product -> product.getType().equals("Book"))
                .min(Comparator.comparingDouble(Product::getPrice))
                .orElseThrow(() -> new NoSuchElementException("Продукт [категорія: Book] не знайдено"));
    }

    public static List<Product> getLatestProducts(List<Product> products) {
        return products.stream()
                .sorted(Comparator.comparing(Product::getCreateDate).reversed())
                .limit(3)
                .collect(Collectors.toList());
    }

    public static double calculateTotalCost(List<Product> products) {
        LocalDate currentDate = LocalDate.now();
        return products.stream()
                .filter(product -> product.getCreateDate().getYear() == currentDate.getYear())
                .filter(product -> product.getType().equals("Book"))
                .filter(product -> product.getPrice() <= 75)
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public static Map<String, List<Product>> groupByType(List<Product> products) {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getType));
    }
}
