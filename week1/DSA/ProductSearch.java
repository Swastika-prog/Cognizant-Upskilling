package DSA;

import java.util.HashMap;

public class ProductSearch {

    static class Product {
        int id;
        String name;
        double price;

        Product(int id, String name, double price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }
    }

    private final HashMap<String, Product> index = new HashMap<>();

    public void addProduct(Product p) {
        index.put(p.name.toLowerCase(), p);
    }

    public Product search(String name) {
        return index.get(name.toLowerCase());
    }

    public static void main(String[] args) {
        ProductSearch catalog = new ProductSearch();
        catalog.addProduct(new Product(1, "Laptop", 55000));
        catalog.addProduct(new Product(2, "Mouse", 500));
        catalog.addProduct(new Product(3, "Keyboard", 1200));

        Product result = catalog.search("Mouse");
        System.out.println(result != null ? result.price : "Not found");
    }
}