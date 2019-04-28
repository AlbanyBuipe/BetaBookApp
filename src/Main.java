import com.nexus.command.Utils;
import com.nexus.domain.Author;
import com.nexus.domain.Book;
import com.nexus.domain.Publisher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        HashMap<String, Book> books = new HashMap<>();
        String path = "C:\\Users\\Albany\\GitHub\\BetaBookApp\\src\\com\\nexus\\res\\books.nx";

        Scanner input = new Scanner(System.in);
        int counter = 0;

        int menu = 0;
        String title = "";
        String firstName = "";
        String lastName = "";
        boolean condition = true;

        while (condition) {

            System.out.println("\nPick an option: ");
            System.out.println("1. Add a book\n2. Check Books\n3. Exit");
            System.out.print(":> ");

            menu = input.nextInt();
            input.nextLine();

            switch (menu) {
                case 1:
                    System.out.println("\nAdding a book to library\n");
                    System.out.print("Title: ");
                    title = input.nextLine();

                    System.out.print("First name: ");
                    firstName = input.nextLine();

                    System.out.print("Last name: ");
                    lastName = input.nextLine();

                    System.out.print("Enter year: ");
                    int year = input.nextInt();
                    input.nextLine();

                    System.out.print("Enter publisher: ");
                    String publisherName = input.nextLine();

                    System.out.print("Enter edition: ");
                    int edition = input.nextInt();
                    input.nextLine();

                    Author author = new Author(firstName, lastName);
                    Book book = new Book(title, author);
                    book.setYear(year);
                    Publisher publisher = new Publisher(publisherName);
                    book.setPublisher(publisher);
                    book.setEdition(edition);

                    Utils.readBook(path, books);
                    books.put(title, book);

                    Utils.saveBook(books, path);
                    System.out.println(book.getTitle() + " added!\n");

                    break;
                case 2:
                    System.out.println("\nBooks in Nexus Home Library\n");
                    Utils.readBook(path, books);
                    for (Book entry : books.values()) {
                        System.out.println(entry.getTitle());
                        System.out.println("Author: " + entry.getAuthor());
                        System.out.println("Publisher: " + entry.getPublisher());
                        System.out.println();
                    }

                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Unknown option.");
            }

            counter += 1;

        }

        if (input != null)
            input.close();
    }

}
