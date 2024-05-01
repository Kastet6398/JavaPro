package coffee.order;

import java.util.Objects;

public record Order(int id, String customerName) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order other = (Order) o;
        return id == other.id && Objects.equals(customerName, other.customerName);
    }

    @Override
    public String toString() {
        return STR."Order{id=\{id}, customerName='\{customerName}'}";
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerName);
    }
}
