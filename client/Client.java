import java.rmi.registry.LocateRegistry; //!! To use the LocateRegistry
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) {
        try {
            // !! Here we call from the Server and get the objects from the RMI registry

            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9200);

            // !! now we get the objects from the RMI registry
            Product Assault = (Product) registry.lookup("Assault");
            Product LMG = (Product) registry.lookup("LMG");
            Product SMG = (Product) registry.lookup("SMG");
            Product SPistol = (Product) registry.lookup("Semi Pistol");

            // !! now to invoke the methods
            System.out.println("The name of the Item is " + Assault.Getname());
            System.out.println("Price " + Assault.Getprice());
            System.out.println("Description " + Assault.Getdesc());

            System.out.println("");

            System.out.println("The name of the Item is " + LMG.Getname());
            System.out.println("Price " + LMG.Getprice());
            System.out.println("Description " + LMG.Getdesc());

            System.out.println("");

            System.out.println("The name of the Item is " + SMG.Getname());
            System.out.println("Price " + SMG.Getprice());
            System.out.println("Description " + SMG.Getdesc());

            System.out.println("");
            
            System.out.println("The name of the Item is " + SPistol.Getname());
            System.out.println("Price " + SPistol.Getprice());
            System.out.println("Description " + SPistol.Getdesc());

            System.out.println("");
            
            System.out.println("Client side done...");

        } catch (Exception e) {
            System.out.println("Client side error... " + e);
        }
    }

}