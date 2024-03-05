import java.rmi.RemoteException; //!! to use the RemoteException

public class ProductImp implements Product {
    //!! Attribute of Products
    

    public String name;
    public String desc;
    public double price;

    public ProductImp(String Newname, String Newdesc, double Newprice) throws RemoteException {
        this.name = Newname;
        this.desc = Newdesc;
        this.price = Newprice;
    }

    public String Getname() throws RemoteException {
        return this.name;
    }

    public String Getdesc() throws RemoteException {
        return this.desc;
    }

    public double Getprice() throws RemoteException {
        return this.price;
    }
     

}