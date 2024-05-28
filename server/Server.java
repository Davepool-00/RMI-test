import java.rmi.server.UnicastRemoteObject; //!! To use the UnicastRemoteObject
import java.rmi.registry.LocateRegistry; //!! To use the LocateRegistry
import java.rmi.registry.Registry; //!! To use the Registry

public class Server {

    public static void viewProducts(Registry registry) throws Exception { // !! view all products
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

    public static void main(String[] args) {
        try {
            Registry startRMI = LocateRegistry.createRegistry(9200); // ?? Ignore error here... || this automatically start the rmi instead of using start RMI
            // !! Set Hostname Server using JavaProperty
            System.setProperty("java.rmi.server.hostname", "127.0.0.1");
            System.out.println("The server is running");

            // !! Here we can define API or product objects
            // !! Creating Objects
            ProductImp p1 = new ProductImp("Ak-47", "Assault-Rifle", 200.0);
            ProductImp p2 = new ProductImp("M249", "Light-Machine Gun", 4087.0);
            ProductImp p3 = new ProductImp("P90", "Sub Machine Gun", 2350.0);
            ProductImp p4 = new ProductImp("P2000", "Semi-automatic Pistol", 560.47);

            // !! Exporting Objects using UnicastRemoteObject class
            Product stub1 = (Product) UnicastRemoteObject.exportObject(p1, 0);
            Product stub2 = (Product) UnicastRemoteObject.exportObject(p2, 0);
            Product stub3 = (Product) UnicastRemoteObject.exportObject(p3, 0);
            Product stub4 = (Product) UnicastRemoteObject.exportObject(p4, 0);

            // !! Register the Exported in the RMI registry
            // !! Client will use the name to get those objects

            // !! Get the registry to the object
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9200);

            Cart cart = new CartImp();

            // !! binding 
            registry.bind("Cart", cart);
            registry.bind("Ak-47", stub1);
            registry.bind("M249", stub2);
            registry.bind("P90", stub3);
            registry.bind("P2000", stub4);


            viewProducts(registry);
            System.out.println("Exporting and Binding done...");

        } catch (Exception e) {
            System.out.println("Some server error ..." + e);
        }
    }

}
