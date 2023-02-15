package com.intern.connectfour;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class connect4 extends Application {
    private Controller controller;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(connect4.class.getResource("game.fxml"));
        GridPane rootGridPane = fxmlLoader.load();
        controller = fxmlLoader.getController();
        controller.createPlayGround();

        MenuBar menuBar = createMenu();
        menuBar.prefWidthProperty().bind(stage.widthProperty());

        Pane menuPane = (Pane) rootGridPane.getChildren().get(0);
        menuPane.getChildren().add(menuBar);


        Scene scene = new Scene(rootGridPane);
        stage.setTitle("Connect Four");
        stage.setScene(scene);
        stage.show();
    }

    //file menu
    private MenuBar createMenu() {
        Menu fileMenu = new Menu("File");
        MenuItem newGame = new MenuItem("New Game");

        newGame.setOnAction(actionEvent -> controller.restGame());

        MenuItem resetGame = new MenuItem("Reset Game");

        resetGame.setOnAction(actionEvent -> controller.restGame());

        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
        MenuItem exitGame = new MenuItem("Exit Game");

        exitGame.setOnAction(actionEvent -> exitGame());

        fileMenu.getItems().addAll(newGame, resetGame, separatorMenuItem, exitGame);
//help menu
        Menu helpMenu = new Menu("Help");

        MenuItem aboutGame = new MenuItem("About Connect4");

        aboutGame.setOnAction(actionEvent -> aboutConnect4());


        MenuItem aboutMe = new MenuItem("About Me");

        aboutMe.setOnAction(actionEvent -> aboutMe());
        SeparatorMenuItem separator = new SeparatorMenuItem();
        helpMenu.getItems().addAll(aboutGame, separator, aboutMe);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, helpMenu);
        return menuBar;

    }

    private void aboutMe() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About The Developer");
        alert.setHeaderText("Shubham Pandey");
        alert.setContentText("I love playing with code and create games");
        alert.show();
    }

    private void aboutConnect4() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Connect Four");
        alert.setHeaderText("How To Play");
        alert.setContentText("Connect Four is a two-player game with perfect information for both sides. " +
                "This term describes games " +
                "where one player at a time plays, players have all the information about moves that" +
                " have taken place and all moves that can take place, for a given game state.");
        alert.show();
    }

//    private void resetGame() {
        //to do ....
//    }

    private void exitGame() {
        Platform.exit();
        System.exit(0);
    }


    public static void main(String[] args) {
        launch();
    }
}