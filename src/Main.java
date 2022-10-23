import passport.Passport;
import product.*;

import java.util.*;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) throws Exception {
        product();
        multiplicationTable();
        passport();
        removingOddNumbers();

    }

    public static void product() throws Exception {
        var shopList = new ShopList();
        shopList.addProduct(ProductType.BREAD, 2, 0.1);
        shopList.addProduct(ProductType.BUTTER, 50, 300);
        shopList.addProduct(ProductType.FISH,250,0.3);

        System.out.println(shopList);

        shopList.alreadyBought(ProductType.FISH);
        shopList.remove(ProductType.FISH);

        System.out.println(shopList);

        var recipesBook = new RecipesBook();

        var buter = new Recipes("Бутерброд");
        buter.addProductsRecipes(new Product(ProductType.BREAD, 5, 0.2));
        buter.addProductsRecipes(new Product(ProductType.BUTTER, 50, 300));
        buter.addProductsRecipes(new Product(ProductType.FISH,250,0.3));

        var buter2 = new Recipes("Бутерброд");
        buter2.addProductsRecipes(new Product(ProductType.BREAD, 5, 0.2));
        buter2.addProductsRecipes(new Product(ProductType.BUTTER, 50, 300));


        recipesBook.addRecipes(buter);
        recipesBook.addRecipes(buter2);

        System.out.println(recipesBook);
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

    public static void removingOddNumbers() {
        Set<Integer> number = new HashSet<>(20);

        Random random = new Random();

        for (int i = 0; i < 20; i++) {
            number.add(random.nextInt(1000));
        }

        number.removeIf(integer -> integer %2 == 0);
        System.out.println(number);
    }
}