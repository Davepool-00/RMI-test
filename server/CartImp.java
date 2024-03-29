import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class CartImp extends UnicastRemoteObject implements Cart {
    private List<Product> products;

    public CartImp() throws RemoteException {
        this.products = new ArrayList<>();
    }

    @Override
    public void addProduct(Product product) throws RemoteException {
        products.add(product);
    }

    @Override
    public List<Product> getProducts() throws RemoteException {
        return products;
    }
}
