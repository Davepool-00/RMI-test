import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Cart extends Remote {
    void addProduct(String productName) throws RemoteException;
    List<String> getProducts() throws RemoteException;
}
