package budget;

public class Purchase {
    String name;
    Double price;
    String type;

    Purchase() {
    }

    Purchase (String name, Double price, String type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }
}
