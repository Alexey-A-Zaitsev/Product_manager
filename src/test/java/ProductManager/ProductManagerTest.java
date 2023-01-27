package ProductManager;

import Repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);
    Book book1 = new Book(12, "The Green Mile", 734, "Stephen King");
    Book book2 = new Book(34, "Harry mile 1", 1027, "Joanne Rowling");
    Smartphone smartphone1 = new Smartphone(76, "Iphone X", 13_500, "Apple");
    Smartphone smartphone2 = new Smartphone(44, "Iphone 11", 16_386, "Apple");

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
    public void shouldFind() {
        repo.save(book1);
        repo.save(book2);
        repo.save(smartphone1);
        repo.save(smartphone2);

        Product[] expected = {smartphone1, smartphone2};
        Product[] actual = manager.searchBy("Ipho");


        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldNotFindByID() {
        repo.save(book1);
        repo.save(book2);
        repo.save(smartphone1);
        repo.save(smartphone2);

        Product[] expected = new Product[0];
        Product[] actual = manager.searchBy("EEEEEEEE");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindIgnoreCase() {
        repo.save(book1);
        repo.save(book2);
        repo.save(smartphone1);
        repo.save(smartphone2);

        Product[] expected = {book1, book2};
        Product[] actual = manager.searchBy("  mil");


        Assertions.assertArrayEquals(expected, actual);
    }
}