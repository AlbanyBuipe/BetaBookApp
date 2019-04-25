package com.nexus.view;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.stage.PopupWindow;
import javafx.stage.Stage;

public class NexusMain extends Application {

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
        itmAbout = new MenuItem("About");
        mnHelp.getItems().addAll(itmTutorial, itmAbout);

        mBar.getMenus().addAll(mnFile, mnHelp);

        Pane root = new Pane();
        root.setMinSize(1000, 800);
        root.getChildren().add(mBar);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setMinWidth(1000);
        stage.setMinHeight(800);
        stage.setTitle("Prof Nexus");
        stage.show();
    }

    public static void main(String[] args) { launch(args); }
}
