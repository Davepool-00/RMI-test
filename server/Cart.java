import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Cart extends Remote {
    void addProduct(Product product) throws RemoteException;
    List<Product> getProducts() throws RemoteException;
}
