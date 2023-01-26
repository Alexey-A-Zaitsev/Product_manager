package ProductManager;

public class Book extends Product {
    private String name;
    private String author;

    public Book(int productID, String name, int price, String author) {
        super(productID, name, price);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
