package product;

import java.util.HashSet;
import java.util.Set;

public class ShopList {

    private Set<Product> products;

    public ShopList() {
        products = new HashSet<>();
    }

    public void addProduct(ProductList name, double price, double weightKilo) throws Exception {
        final Product product = new Product(name, price, weightKilo);
        if (name == null || product.getPrice() == 0 || product.getWeightKilo() == 0) {
            throw new Exception("Заполните карточку товара полностью");
        } else {
            products.add(product);
        }
        if (products.contains(product)) {
            products.add(product);
        } else {
            throw new Exception("Продукт " + name.getName() + " уже есть в корзине");
        }
    }

    public void remove(ProductList name) {
        products.remove(name);
    }

    public void alreadyBought(ProductList name) {
        System.out.println("Продукт " + name.getName() + " куплен");
    }

    @Override
    public String toString() {
        return "product.ShopList{" +
                "products=" + products +
                '}';
    }
}
