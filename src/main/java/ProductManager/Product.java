package ProductManager;

public class Product {

    protected int productID;
    protected String name;
    protected int price;

    public Product(int productID, String name, int price) {
        this.productID = productID;
        this.name = name;
        this.price = price;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
