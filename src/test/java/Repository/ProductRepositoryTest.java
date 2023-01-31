package Repository;

import ProductManager.Book;
import ProductManager.Product;
import ProductManager.Smartphone;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    ProductRepository repo = new ProductRepository();

    Book book1 = new Book(12, "The Green Mile", 734, "Stephen King");
    Book book2 = new Book(34, "Harry Potter 1", 1027, "Joanne Rowling");
    Smartphone smartphone1 = new Smartphone(76, "Iphone X", 13_500, "Apple");
    Smartphone smartphone2 = new Smartphone(44, "razr V3i ", 6_386, "Motorola");

    @Test
    public void shouldSavedProducts() {
        repo.save(book1);
        repo.save(smartphone2);
        repo.save(book2);

        Product[] expected = {book1, smartphone2, book2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        repo.save(book1);
        repo.save(book2);
        repo.save(smartphone1);
        repo.save(smartphone2);

        repo.removeById(76);

        Product[] expected = {book1, book2, smartphone2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldIssueNotFoundException() {
        repo.save(book1);
        repo.save(book2);
        repo.save(smartphone1);
        repo.save(smartphone2);

        Assertions.assertThrows(NotFoundException.class ,
                () -> repo.removeById(4498));
    }
}