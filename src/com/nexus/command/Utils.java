package com.nexus.command;

import com.nexus.domain.Author;
import com.nexus.domain.Book;
import com.nexus.domain.Publisher;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Utils {

    public static String err;

    public static void makeJSON(Book book) {

    }

    public static void getJSON(String path){

    }

    private static String[] readJSON(String path) {
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader(path)) {

            Object obj = parser.parse(reader);

            JSONArray bookList = (JSONArray) obj;

            bookList.forEach(bk -> parseBook((JSONObject) bk));

        } catch (FileNotFoundException e) {
            err = e.getMessage();
        } catch (IOException e) {
            err = e.getMessage();
        } catch (ParseException e) {
            err = e.getMessage();
        }

        return null;
    }

    private static String[] parseBook(JSONObject bk) {

        String[] args = new String[4];

        JSONObject bkObj = (JSONObject) bk.get("book");

        String title = bkObj.get("title").toString();
        args[0] = title;
        String author = bkObj.get("author").toString();
        args[1] = author;
        String publisher = bkObj.get("publisher").toString();
        args[2] = publisher;
        String year = bkObj.get("year").toString();
        args[3] = year;

        return args;

    }

    public static void saveBook(HashMap<String, Book> list, String path) {

        File file = new File(path);
        FileWriter writer = null;
        try {
            writer = new FileWriter(file);

            for (Book entry : list.values()) {
                String title = entry.getTitle();
                String author[] = entry.getAuthor().split(" ");
                String firstName = author[0];
                String lastName = author[1];
                String publisher = entry.getPublisher();
                int year = entry.getYear();
                int edition = entry.getEdition();

                writer.append(title + "//" + firstName + "//" + lastName + "//" + year + "//" + publisher + "//" + edition + "\n");
            }

        } catch (IOException e) {
            err = e.getMessage();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void readBook(String path, HashMap<String, Book> list) {

        Scanner input = null;
        File file = new File(path);

        try {
            input = new Scanner(file);
            while (input.hasNextLine()) {
                String str[] = input.nextLine().split("//");
                String title = str[0];
                String firstName = str[1];
                String lastName = str[2];
                int year = Integer.parseInt(str[3]);
                String publisherStr = str[4];
                int edition = Integer.parseInt(str[5]);

                Author author = new Author(firstName, lastName);
                Publisher publisher = new Publisher(publisherStr);

                Book book = new Book(title, author);
                book.setPublisher(publisher);
                book.setYear(year);
                book.setEdition(edition);
                list.put(title, book);
            }
        } catch (FileNotFoundException e) {
            err = e.getMessage();
        }

    }

}
