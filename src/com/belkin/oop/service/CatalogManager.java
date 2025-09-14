package com.belkin.oop.service;

import com.belkin.oop.exceptions.BookNotFoundException;
import com.belkin.oop.exceptions.NoAvailableCopiesException;
import com.belkin.oop.model.Book;

import java.util.ArrayList;
import java.util.List;

public class CatalogManager {
    private final List<Book> catalog;

    public CatalogManager() {
        catalog = new ArrayList<>();
    }

    public void addBook(String title, String author, int copies) {
        Book book = new Book(title, author, copies);
        catalog.add(book);
    }

    public void takeBook(String title) {
        try {
            if (catalog.isEmpty()) {
                throw new BookNotFoundException("Книга не найдена");
            }
            for (Book book : catalog) {
                if (book.getTitle().equalsIgnoreCase(title)) {
                    if (book.getAvailableCopies() <= 0) {
                        throw new NoAvailableCopiesException("нет свободных копий");
                    } else {
                        book.setAvailableCopies(book.getAvailableCopies() - 1);
                        return;
                    }
                }
            }
            throw new BookNotFoundException("Книга не найдена");

        } catch (NoAvailableCopiesException | BookNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void returnBook(String title) {
        try {
            for (Book book : catalog) {
                if (book.getTitle().equalsIgnoreCase(title)) {
                    book.setAvailableCopies(book.getAvailableCopies() + 1);
                    return;
                }
            }
            throw new BookNotFoundException("Нет такой книги ");
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Book> getAllBooks() {
        return this.catalog;
    }
}




