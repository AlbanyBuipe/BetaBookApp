package com.nexus;

import com.nexus.command.Utils;
import com.nexus.domain.Book;

import java.util.HashMap;

public class Run {

    public static void main(String[] args) {

        String path = "C:\\Users\\Albany\\GitHub\\BetaBookApp\\src\\com\\nexus\\res\\books.nx";
        HashMap<String, Book> books = new HashMap<>();
        Utils.readBook(path, books);

        for (Book entry : books.values()) {
            System.out.println(entry.getTitle());
            System.out.println(entry.getAuthor());
            System.out.println("------------------------");
        }
    }

}
