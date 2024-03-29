import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> products;

    public Cart() {
        this.products = new ArrayList<>();
    }

    // Method to add a product to the cart
    public void addProduct(Product product) {
        products.add(product);
    }

    // Method to view all added products in the cart
    public void viewAddedProducts() {
        System.out.println("Products in the cart:");
        for (Product product : products) {
            System.out.println(product.Getname() + " - " + product.Getdesc() + " - $" + product.Getprice());
        }
    }
}
