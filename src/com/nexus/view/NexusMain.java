package com.nexus.view;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class NexusMain extends Application {

    private String[] books = new String[5];

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
    private String titleStr;

    private Label lblAuthor;
    private Label author;
    private String authorStr;

    private Label lblEdition;
    private Label edition;
    private String editionStr;

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

        for (int i = 0; i < books.length; ++i)
            books[i] = "Book" + i;

        lstvBook = new ListView<String>();
        lstvBook.getItems().addAll(books);

        title = new Label();
        author = new Label();
        edition = new Label();

        lstvBook.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            title.setText(newValue);
            author.setText(newValue);
            edition.setText(newValue);
        });

        lstvBook.setStyle("-fx-padding: 10;");

        lblTitle = new Label("Title:");
        lblAuthor = new Label("Author:");
        lblEdition = new Label("Edition:");

        GridPane bookInfo = new GridPane();
        bookInfo.addRow(0, lblTitle, title);
        bookInfo.addRow(1, lblAuthor, author);
        bookInfo.addRow(2, lblEdition, edition);
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
