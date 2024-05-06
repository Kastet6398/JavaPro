import java.time.LocalDate;

public class Product {
    @Override
    public String toString() {
        return STR."Product{type='\{type}', price=\{price}, hasDiscount=\{hasDiscount}, createDate=\{createDate}}";
    }

    private String type;
    private double price;
    private boolean hasDiscount;
    private LocalDate createDate;
    private long id;

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setHasDiscount(boolean hasDiscount) {
        this.hasDiscount = hasDiscount;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Product(String type, double price, boolean hasDiscount, LocalDate createDate, long id) {
        this.type = type;
        this.price = price;
        this.hasDiscount = hasDiscount;
        this.createDate = createDate;
        this.id = id;
    }

    public Product(String type, double price, boolean hasDiscount, long id) {
        this(type, price, hasDiscount, LocalDate.now(), id);
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public boolean hasDiscount() {
        return hasDiscount;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public long getId() {
        return id;
    }
}
