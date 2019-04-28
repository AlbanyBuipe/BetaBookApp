package com.nexus.view;

import com.nexus.command.Utils;
import com.nexus.domain.Book;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;

public class NexusMain extends Application {

    String path = "C:\\Users\\Albany\\GitHub\\BetaBookApp\\src\\com\\nexus\\res\\books.nx";

    private MenuBar mBar;
    private Menu mnFile; // File menu and children nodes
    private MenuItem itmOpen;
    private MenuItem itmNew;
    private MenuItem itmSave;
    private MenuItem itmSaveAs;
    private MenuItem itmPreferences;
    private MenuItem itmExit;

    private Menu mnEdit;
    private Menu mnView;
    private Menu mnTool;

    private Menu mnHelp; // Help menu and children nodes
    private MenuItem itmTutorial;
    private MenuItem itmHelp;
    private MenuItem itmAbout;

    private ListView<String> lstvBook;
    private Label lblItem;

    private Label lblTitle;
    private Label title;
    // private String titleStr;

    private Label lblAuthor;
    private Label author;
    // private String authorStr;

    private Label lblPublisher;
    private Label publisher;
    // private Label publisherStr;

    private Label lblYear;
    private Label year;
    // private Label yearInt;

    private Label lblEdition;
    private Label edition;
    // private String editionStr;

    private Label lblRef;
    private Label ref;

    @Override
    public void start(Stage stage) {

        mBar = new MenuBar();
        mnFile = new Menu("File");
        itmOpen = new MenuItem("Open");
        itmNew = new MenuItem("New");
        itmSave = new MenuItem("Save");
        itmSaveAs = new MenuItem("Save As");
        itmPreferences = new MenuItem("Preferences");
        itmExit = new MenuItem("Exit");
        itmExit.setOnAction(event -> Platform.exit());
        mnFile.getItems().addAll(itmOpen, itmNew, itmSave, itmSaveAs, itmPreferences, itmExit);

        mnEdit = new Menu("Edit");
        mnView = new Menu("View");
        mnTool = new Menu("Tool");
        mnHelp = new Menu("Help");
        itmTutorial = new MenuItem("Tutorial");
        itmHelp = new MenuItem("Help");
        itmAbout = new MenuItem("About");
        mnHelp.getItems().addAll(itmTutorial, itmHelp, itmAbout);

        mBar.getMenus().addAll(mnFile, mnEdit, mnView, mnTool, mnHelp);


        HashMap<String, Book> books = new HashMap<>();
        Utils.readBook(path, books);

        lstvBook = new ListView<String>();
        lstvBook.getItems().addAll(books.keySet());

        title = new Label("...");
        author = new Label("...");
        publisher = new Label("...");
        year = new Label("...");
        edition = new Label("...");
        ref = new Label("...");

        lstvBook.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            Book book = books.get(newValue);
            title.setText(book.getTitle());
            author.setText(book.getAuthor());
            publisher.setText(book.getPublisher());
            year.setText(String.valueOf(book.getYear()));
            edition.setText(String.valueOf(book.getEdition()));

            String[] name = book.getAuthor().split(" ");
            String ed = "";
            if (book.getEdition() == 1)
                ed = "st";
            if (book.getEdition() == 2)
                ed = "nd";
            if (book.getEdition() == 3)
                ed = "rd";
            if (book.getEdition() >= 4)
                ed = "th";

            ref.setText(String.format("%s, %s, %s (%s, %d, %d%s)",
                    name[1], name[0], book.getTitle(),
                    book.getPublisher(), book.getYear(),
                    book.getEdition(), ed));
        });

        lstvBook.setStyle("-fx-padding: 10;");

        lblTitle = new Label("Title:");
        lblAuthor = new Label("Author:");
        lblPublisher = new Label("Publisher:");
        lblYear = new Label("Year:");
        lblEdition = new Label("Edition:");
        lblRef = new Label("Ref.:");

        GridPane bookInfo = new GridPane();
        bookInfo.addRow(0, lblTitle, title);
        bookInfo.addRow(1, lblAuthor, author);
        bookInfo.addRow(2, lblPublisher, publisher);
        bookInfo.addRow(3, lblYear, year);
        bookInfo.addRow(4, lblEdition, edition);
        bookInfo.addRow(5, lblRef, ref);
        bookInfo.setVgap(10);
        bookInfo.setHgap(10);
//        bookInfo.setMinSize(550, 410);

        /*bookInfo.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 2;" +
                "-fx-border-color: grey"
        );*/

        GridPane root = new GridPane();
        root.setHgap(10);
        root.setVgap(10);
        root.addRow(0, mBar);
//        root.addRow(1, new Text(""));
        root.addRow(2, lstvBook, bookInfo);

        root.setStyle("-fx-padding: 10;");

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setMinWidth(960);
        stage.setMinHeight(800);
        stage.setTitle("Prof Nexus");
        stage.show();
    }

    public static void main(String[] args) { launch(args); }
}
