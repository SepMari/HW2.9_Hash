package product;

import java.util.*;

public class Recipes {
    private String nameRecipes;
    private double sumOfProductsRecipes;
    private Integer count;
    private HashMap<Product, Integer> products;

    public Recipes(String nameRecipes) {
        setNameRecipes(nameRecipes);
        sumOfProductsRecipes = 0;
        products = new HashMap<>();
    }

    public void addProductsRecipes(Product product, Integer count){
        if (products.containsKey(product) || count <= 0) {
            throw new IllegalArgumentException(product + " " + count + " уже добавлен в рецепт или указано неверное количество");
        } else{
            products.put(product, count);
            sumOfProductsRecipes = sumOfProductsRecipes + product.getPrice() * Math.abs(count);
        }
    }

    public void setSumOfProductsRecipes(double sumOfProductsRecipes) {
        this.sumOfProductsRecipes = sumOfProductsRecipes;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getNameRecipes() {
        return nameRecipes;
    }

    public double getSumOfProductsRecipes() {
        return sumOfProductsRecipes;
    }

    public HashMap<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(HashMap<Product, Integer> products) {
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