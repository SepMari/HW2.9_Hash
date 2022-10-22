package product;

public enum ProductList {
    BREAD("Хлеб"),
    BUTTER("Масло"),
    FISH("Рыбка");

    private final String name;

    ProductList(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
