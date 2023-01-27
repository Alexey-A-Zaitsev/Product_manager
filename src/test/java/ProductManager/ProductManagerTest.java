package ProductManager;

import Repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProductManagerTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);
    Book book1 = new Book(12, "The Green Mile", 734, "Stephen King");
    Book book2 = new Book(34, "Harry Potter 1", 1027, "Joanne Rowling");
    Book book3 = new Book(34, "Germinal", 2123, "Emile Zola");
    Smartphone smartphone1 = new Smartphone(76, "Iphone X", 13_500, "Apple");
    Smartphone smartphone2 = new Smartphone(44, "Iphone SE", 16_386, "Apple");
    Smartphone smartphone3 = new Smartphone(125, "Galaxy", 15_386, "Samsung");


    @Test
    public void shouldAddProductInRepo() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2, smartphone1, smartphone2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindBySmartphoneName() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] expected = {smartphone1, smartphone2};
        Product[] actual = manager.searchBy("Ipho");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldNotFindByName() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] expected = new Product[0];
        Product[] actual = manager.searchBy("EEEEEEEE");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindBookByAuthor() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] expected = {book2};
        Product[] actual = manager.searchBy("oann");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSmartphoneByManufacturer() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] expected = {smartphone3};
        Product[] actual = manager.searchBy("amsu");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindProductBySearchQuery() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] expected = {book1, book3, smartphone1, smartphone2};
        Product[] actual = manager.searchBy("le");

        Assertions.assertArrayEquals(expected, actual);
    }

}