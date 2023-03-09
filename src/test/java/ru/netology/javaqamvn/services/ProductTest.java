package ru.netology.javaqamvn.services;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.javaqamvn.services.domain.Book;
import ru.netology.javaqamvn.services.domain.Product;
import ru.netology.javaqamvn.services.domain.Smartphone;
import ru.netology.javaqamvn.services.manager.ProductManager;
import ru.netology.javaqamvn.services.repository.NotFoundException;
import ru.netology.javaqamvn.services.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Book book1 = new Book(1, "Book 1", 100, "John J.");
    private Book book2 = new Book(2, "Book 2", 1000, "James J.");
    private Book book3 = new Book(3, "Book 3", 10000, "Joseph J.");
    private Smartphone smartphone1 = new Smartphone(4, "Phone 1", 1000, "Company 1");
    private Smartphone smartphone2 = new Smartphone(5, "Phone 2", 1100, "Cpmpany 2");
    private Smartphone smartphone3 = new Smartphone(6, "Phone 3", 1200, "Company 3");

    @BeforeEach
    public void setUp() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
    }

    @Test
    public void removeNonExistingId() {
        assertThrows(NotFoundException.class, () -> {
            repository.removeById(8);
        });
    }

    @Test
    public void removeExistingId() {
        repository.removeById(4);
        assertArrayEquals(new Product[]{book1, book2, book3, smartphone2, smartphone3}, repository.findAll());
    }
}


