package product;

import java.util.*;

public class Product {

    private final ProductList name;
    private double price;
    private double weightKilo;
    public Set<Product> products;


    public Product(ProductList name, double price, double weightKilo) throws Exception {
        this.name = name;
        setPrice(price);
        setWeightKilo(weightKilo);
    }


    public Set<Product> getProducts() {
        return products;
    }

    public ProductList getName() {
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

    @Override
    public boolean equals(Object o) {
        throw new UnsupportedOperationException("Одинаковые продукты " + name.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, weightKilo);
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
