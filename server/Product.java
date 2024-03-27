import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Product extends Remote{
    //!! Here we can define API 

    public String Getname() throws RemoteException;
    public String Getdesc() throws RemoteException;
    public double Getprice() throws RemoteException;
}