package product;

import java.util.*;

public class Recipes {
    private String nameRecipes;
    private double sumOfProductsRecipes;
    private Set<Product> products;

    public Recipes(String nameRecipes) {
        setNameRecipes(nameRecipes);
        sumOfProductsRecipes = 0;
        products = new HashSet<>();
    }

    public void addProductsRecipes(Product product){
        if (products.contains(product)) {
            throw new IllegalArgumentException(product + " уже добавлен в рецепт");
        } else {
            products.add(product);
            sumOfProductsRecipes = sumOfProductsRecipes + product.getPrice();
        }
    }

    public String getNameRecipes() {
        return nameRecipes;
    }

    public double getSumOfProductsRecipes() {
        return sumOfProductsRecipes;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public void setNameRecipes(String nameRecipes) {
        if (nameRecipes == null || nameRecipes.isEmpty() || nameRecipes.isBlank()) {
            throw new IllegalArgumentException("Введите название рецепта!");
        } else  {
            this.nameRecipes = nameRecipes;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipes recipes = (Recipes) o;
        return Double.compare(recipes.sumOfProductsRecipes, sumOfProductsRecipes) == 0 && Objects.equals(nameRecipes, recipes.nameRecipes) && Objects.equals(products, recipes.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameRecipes, sumOfProductsRecipes, products);
    }

    @Override
    public String toString() {
        return "product.Recipes{" +
                "nameRecipes='" + nameRecipes + '\'' +
                ", sumOfProductsRecipes=" + sumOfProductsRecipes +
                ", products=" + products +
                '}';
    }

}