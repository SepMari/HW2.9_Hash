package product;

public enum ProductType {
    BREAD("Хлеб"),
    BUTTER("Масло"),
    FISH("Рыбка");

    private final String name;

    ProductType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
