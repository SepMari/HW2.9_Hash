import passport.Passport;
import product.*;

import java.util.*;
import java.util.Collections;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) throws Exception {
//        product();
//        multiplicationTable();
//        passport();
//        removingOddNumbers();
//        Phonebook();
        collections();
//        sumElement();
//        allElement();
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
        buter.addProductsRecipes(new Product(ProductType.BREAD, 5, 0.2), 2);
        buter.addProductsRecipes(new Product(ProductType.BUTTER, 50, 300), 1);
        buter.addProductsRecipes(new Product(ProductType.FISH,250,0.3), 1);

        var buter2 = new Recipes("Бутерброд");
        buter2.addProductsRecipes(new Product(ProductType.BREAD, 5, 0.2), 1);
        buter2.addProductsRecipes(new Product(ProductType.BUTTER, 50, 300), 2);


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

    public static void Phonebook() {
        HashMap<String, String> phonebook = new HashMap<>();

        phonebook.put("Ivan Ivanov", "79099756547");
        phonebook.put("Ilya Sidorov", "790965788766");
        phonebook.put("Inna Neznama", "7998564356");
        phonebook.put("Anna Mihailova", "792156887");
        phonebook.put("Mike Mikov", "7956876899");
        phonebook.put("Denis Lipov", "796435445");
        phonebook.put("Phillip Nikov", "7967888888");
        phonebook.put("Dean Vikov", "7955556375");
        phonebook.put("Sem Rinov", "79457675686");
        phonebook.put("Senya Mishin", "79346576567");

        System.out.println(phonebook.values());
    }

    public static Map<String, Integer> map2;

    private final Map<String, Integer> map3 = new HashMap<>();


    public static void collections() {
        var collections = new Main();

        collections.putCollections("str1", 2);
        collections.putCollections("str2", 1);
        collections.putCollections("str1", 2);

        System.out.println(collections);
    }

    public void putCollections(String string, Integer num) {
        if (Objects.equals(map3.put(string, num), num)) {
            throw new IllegalArgumentException("Одинаковые ключи");
        }
    }

    private static final Map<String, List<Integer>> elementsMap = new HashMap<>(5);

    public static void sumElement() {
        var sumElement = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            elementsMap.put("Значения " + i, List.of((int)(Math.random() * 1000), (int)(Math.random() * 1000), (int)(Math.random() * 1000)));
        }
        for (Map.Entry<String, List<Integer>> entry : elementsMap.entrySet()) {
            sumElement.put(entry.getKey(), entry.getValue().get(0) + entry.getValue().get(1) + entry.getValue().get(2));
        }

        System.out.println(elementsMap);
        System.out.println(sumElement);
    }

    public static void allElement() {
        map2 = new LinkedHashMap<>();
        for (int i = 0; i < 10; i++) {
            map2.put("Ключ " + i, i);
        }

        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            System.out.println(entry.getKey() + ':' + entry.getValue());
        }
    }


    @Override
    public String toString() {
        return "Main{" +
                "map3=" + map3 +
                '}';
    }
}