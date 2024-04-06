import java.rmi.registry.LocateRegistry; //!! To use the LocateRegistry
import java.rmi.registry.Registry;
import java.util.Scanner;
import java.util.List; 


public class Client {

    public static void viewProducts(Registry registry) throws Exception { // !! use for case 1 and view all products
        // Get all available products from the server
        Product[] products = {
                (Product) registry.lookup("Ak-47"),
                (Product) registry.lookup("M249"),
                (Product) registry.lookup("P90"),
                (Product) registry.lookup("P2000")
        };


        for (Product product : products) {                               //!  Display information for each product
            System.out.println("Name: " + product.Getname());
            System.out.println("Price: " + product.Getprice());
            System.out.println("Description: " + product.Getdesc());
            System.out.println();
        }
    }


    public static void addProductToCart(Registry registry, Scanner scanner) throws Exception { //!! use for case 2 to add products
        System.out.println("Enter the name of the product to add to the cart:");
        System.out.println("(This is a case-sensitive part)");
        String productName = scanner.next();
        //!! Look up the product in the registry
        Product product = (Product) registry.lookup(productName); //!! force the user to only add product name to cart 
        //!! Call the Cart service to add the product to the cart   
        Cart cart = (Cart) registry.lookup("Cart");            //?? Also ignore error above line 33
        cart.addProduct(productName);
        System.out.println("Product added to the cart successfully!");
    }
    
    public static void viewCart(Registry registry) throws Exception { //!! use for case 3 in displaying the products
        //!! Look up the Cart service from the registry
        Cart cart = (Cart) registry.lookup("Cart");
        List<String> productsInCart = cart.getProducts();
        if (productsInCart.isEmpty()) {
            System.out.println("Cart is empty.");
        } else {
            System.out.println("Products in the cart:");
            for (String productName : productsInCart) {
                Product product = (Product) registry.lookup(productName);
                System.out.println("Name: " + product.Getname());
                System.out.println("Price: " + product.Getprice());
                System.out.println("Description: " + product.Getdesc());
                System.out.println();
            }
        }
    }

    

    public static void main(String[] args) {
        try {
            // !! Here we call from the Server and get the objects from the RMI registry

            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9200);

            Scanner scanner = new Scanner(System.in); // ! Ignore error here...
            int userInput = 0;
            do {
                System.out.println("\n\n ==== Menu ==== \n");
                System.out.println("[1] Display all guns");
                System.out.println("[2] Add product to cart");
                System.out.println("[3] View Cart");
                System.out.println("[0] Exit");
                System.out.print("Input command: ");
                userInput = scanner.nextInt();
                // !! Switch case
                switch (userInput) {
                    case 1:
                        System.out.println("\n\nDisplaying guns\n\n");
                        viewProducts(registry);
                        break;
                    case 2:
                        System.out.println("\n\nAdding a new product to the cart:\n\n");
                        addProductToCart(registry, scanner);
                        break;
                    case 3:
                        System.out.println("\n\nCart inventory:\n\n");
                        viewCart(registry);
                        break;
                    case 0:
                        System.out.println("\n\nExiting...\n\n");
                        break;

                    default:
                        System.out.println("\n\nInvalid input... Try again\n\n");
                        break;
                }
                // !! End of switch case

            } while (userInput != 0);

            System.out.println("Client side done...");

        } catch (Exception e) {
            System.out.println("\n\n\nClient side error... " + e);
            System.out.println("================================================");
            System.out.println("Try following command :)");
        }
    }

}