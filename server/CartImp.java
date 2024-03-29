import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class CartImp extends UnicastRemoteObject implements Cart {
    private List<String> products;

    public CartImp() throws RemoteException {
        products = new ArrayList<>();
    }

    @Override
    public void addProduct(String productName) throws RemoteException {
        products.add(productName);
    }

    @Override
    public List<String> getProducts() throws RemoteException {
        return products;
    }
}
