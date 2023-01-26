package ProductManager;

public class Smartphone extends Product {
    private String name;
    private String manufacturer;

    public Smartphone(int productID, String name, int price, String manufacturer) {
        super(productID, name, price);
        this.manufacturer = manufacturer;

    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
