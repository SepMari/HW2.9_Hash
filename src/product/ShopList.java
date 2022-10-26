package product;

import java.util.HashSet;
import java.util.Set;

public class ShopList {

    private Set<Product> products;

    public ShopList() {
        products = new HashSet<>();
    }

    public void addProduct(ProductType name, double price, double weightKilo) throws Exception {
        final Product product = new Product(name, price, weightKilo);
        if (name == null || product.getPrice() == 0 || product.getWeightKilo() == 0) {
            throw new Exception("Заполните карточку товара полностью");
        } else if (products.contains(product)) {
            throw new IllegalArgumentException(name.getName() + " уже есть в корзине!");
        }
        products.add(product);


    }

    public void remove(ProductType name) {
        products.remove(name);
    }

    public void alreadyBought(ProductType name) {

        System.out.println("Продукт " + name.getName() + " куплен");
    }

    @Override
    public String toString() {
        return "product.ShopList{" +
                "products=" + products +
                '}';
    }
}
