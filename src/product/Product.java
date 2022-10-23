package product;

import java.util.*;

public class Product {

    private final ProductType name;
    private double price;
    private double weightKilo;
    private boolean alreadyBought;

    public Product(ProductType name, double price, double weightKilo) throws Exception {
        this.name = name;
        setPrice(price);
        setWeightKilo(weightKilo);
        this.alreadyBought = false;
    }


    public ProductType getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws Exception {
        if (price == 0.0) {
            throw new UnsupportedOperationException("Заполните карточку продукта полностью");
        } else {
            this.price = price;
        }
    }

    public double getWeightKilo() {
        return weightKilo;
    }

    public void setWeightKilo(double weightKilo) throws Exception {
        if (weightKilo == 0.0) {
            throw new UnsupportedOperationException("Заполните карточку продукта полностью");
        } else {
            this.weightKilo = weightKilo;
        }
    }

    private boolean alreadyBought() {
        return alreadyBought;
    }

    public void setAlreadyBought(boolean alreadyBought) {
        this.alreadyBought = alreadyBought;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 && Double.compare(product.weightKilo, weightKilo) == 0 && alreadyBought == product.alreadyBought && name == product.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, weightKilo, alreadyBought);
    }

    @Override
    public String toString() {
        return "product.Product{" +
                "name='" + name.getName() + '\'' +
                ", price=" + price +
                ", weightKilo=" + weightKilo +
                '}';
    }
}
