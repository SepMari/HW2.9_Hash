import passport.Passport;
import product.Product;
import product.ProductList;
import product.Recipes;
import product.ShopList;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        product();
        multiplicationTable();
        passport();

    }

    public static void product() throws Exception {
        var shopList = new ShopList();
        shopList.addProduct(ProductList.BREAD, 2, 0.1);
        shopList.addProduct(ProductList.BUTTER, 50, 300);
        shopList.addProduct(ProductList.FISH,250,0.3);

        System.out.println(shopList);

        shopList.alreadyBought(ProductList.FISH);
        shopList.remove(ProductList.FISH);

        System.out.println(shopList);


        Recipes buter = new Recipes("Бутерброд");
        buter.addProductsRecipes(new Product(ProductList.BREAD, 5, 0.2));
        buter.addProductsRecipes(new Product(ProductList.BUTTER, 50, 300));
        buter.addProductsRecipes(new Product(ProductList.FISH,250,0.3));

        System.out.println(buter);
    }

    public static void multiplicationTable() {

        Set<TaskMultiplicationTable> set = new HashSet<>(15);
        while (set.size() < 15) {
            set.add(new TaskMultiplicationTable());
        }
        set.forEach(t -> System.out.println(t.getTask()));
    }

    private static class TaskMultiplicationTable {
        private final String s, rs;

        TaskMultiplicationTable() {
            int a = (int) (Math.random() * 8 + 2);
            int b = (int) (Math.random() * 8 + 2);
            s = String.format("%d * %d", a, b);
            rs = String.format("%d * %d", b, a);
        }

        String getTask() {
            return s;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TaskMultiplicationTable task = (TaskMultiplicationTable) o;
            return (s.equals(task.s) || s.equals(task.rs));
        }

        @Override
        public int hashCode() {
            return s.hashCode() + rs.hashCode();
        }
    }

    private static void passport() {
        Passport anna = new Passport(346598, "Ivanova", "Anna", "Ivanovna", 1995);
        addPassport(anna);

        Passport passport = getPassportNumber(346598);

        System.out.println(passport);
    }

    public static Map<Integer, Passport> map = new HashMap<>();

    public static void addPassport(Passport passport) {
        map.put(passport.getNumber(), passport);
    }

    public static Passport getPassportNumber(int number) {
        return map.get(number);
    }
}