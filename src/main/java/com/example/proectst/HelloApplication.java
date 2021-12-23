package com.example.proectst;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setTitle("Адресна Книга");
        stage.setScene(scene);
        stage.show();
    }
    public void test(){
        CollectionAddressBook addressBook = new CollectionAddressBook();
        addressBook.fillTestData();
        addressBook.print();
    }
    void logout(Stage stage) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Вихід з програми");
        alert.setContentText("Ви дійсно бажаєте вийти?");

        if (alert.showAndWait().get() == ButtonType.OK) {
            System.out.println("Ви успішно вийшли з програми");
            stage.close();
        }
}
}