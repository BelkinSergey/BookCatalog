import com.belkin.oop.model.Book;
import com.belkin.oop.service.CatalogManager;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final CatalogManager manager = new CatalogManager();

    public static void main(String[] args) {

        boolean isRunning = true;

        while (isRunning) {
            try {
                printMenu();
                int number = scanner.nextInt();
                scanner.nextLine();
                switch (number) {
                    case 1:
                        printCatalog();
                        break;
                    case 2:
                        addBook();
                        break;
                    case 3:
                        getBook();
                        break;
                    case 4:
                        returnBook();
                        break;
                    case 5:
                        System.out.println("Good by");
                        isRunning = false;
                        break;

                    default:
                        System.out.println("Завершение программы...");
                }
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Повторите ввод");
            }
        }
    }

    private static void printMenu() {
        System.out.println("---Welcome to menu---");
        System.out.println("Выберети одну из команд!");
        System.out.println("""
                1. Вывести каталог.
                2. Добавить объект.
                3. Выдать объект.
                4. Вернуть объект.
                5. Выйти из приложения.
                            
                """);
    }

    private static void printCatalog() {
        for (Book book : manager.getAllBooks()) {
            System.out.println(book);
        }
    }

    private static void addBook() {
        System.out.println("Напишите название книги");
        String title = scanner.nextLine();
        System.out.println("Напишите автора");
        String author = scanner.nextLine();
        System.out.println(" Напишите количество копий ");
        int copies = scanner.nextInt();
        manager.addBook(title, author, copies);
    }

    private static void getBook() {
        System.out.println("Какую книгу вы хотите взять? Напишите название книги");
        String bookTitle = scanner.nextLine();
        manager.takeBook(bookTitle);
    }

    private static void returnBook() {
        System.out.println("Какую книгу вы хотите вернуть ? Напишите название книги");
        String bookTitle = scanner.nextLine();
        manager.returnBook(bookTitle);
    }
}
