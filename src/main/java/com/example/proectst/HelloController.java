package com.example.proectst;

import org.controlsfx.control.textfield.CustomTextField;
import org.controlsfx.control.textfield.TextFields;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.net.URL;
import java.util.ResourceBundle;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class HelloController  {

    @FXML
    private Label welcomeText;
    @FXML
    private Button searchbtn;

    @FXML
    private Button deletebtn;

    @FXML
    private Button opendtn;

    @FXML
    private Button editbtn;

    @FXML
    private TextField searchrtxt;

    @FXML
    private Label labelCount;

    @FXML
    private TableView<Person> table;

    @FXML
    private Button Exitbutton;

    @FXML
    private TableColumn<Person, String> columnPip;

    @FXML
    private TableColumn<Person, String> columnPhone;

    @FXML
    private VBox scenePane;
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    private Stage stage;

    private Stage newStage;
    private Stage editDialogStage;
    private Parent root;
    private FXMLLoader fxmlLoader = new FXMLLoader();
    private ControllerModalWindow controllerModalWindow;
    private ObservableList<Person> backupList;

     CollectionAddressBook addressBookImpl = new CollectionAddressBook();

    @FXML
    public void initialize(){

        try {
            fxmlLoader.setLocation(HelloController.class.getResource("/com/example/proectst/ModalWindow.fxml"));
            root = fxmlLoader.load();
            controllerModalWindow = fxmlLoader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }

        columnPip.setCellValueFactory(new PropertyValueFactory<Person,String>("pip"));
        columnPhone.setCellValueFactory(new PropertyValueFactory<Person,String>("phone"));

        addressBookImpl.fillTestData();
        table.setItems(addressBookImpl.getPersonList());
        addressBookImpl.fillTestData();
        backupList = FXCollections.observableArrayList();
        backupList.addAll(addressBookImpl.getPersonList());
        table.setItems(addressBookImpl.getPersonList());
    }

    @FXML
    void open (ActionEvent event) throws IOException {

        Button clickedButton = (Button) event.getSource();

        switch (clickedButton.getId()){
            case "opendtn":
                controllerModalWindow.setPerson(new Person());
                showDialogadd();
                addressBookImpl.add(controllerModalWindow.getPerson());
                break;
            case "editbtn":
                controllerModalWindow.setPerson((Person) table.getSelectionModel().getSelectedItem());
                showDialog();
                break;
            case "deletebtn":
                addressBookImpl.delete((Person) table.getSelectionModel().getSelectedItem());
                break;
        }
    }
    private void updateCountLabel(){
        labelCount.setText("Кількість записів: " + addressBookImpl.getPersonList().size());
    }
    public void showDialogadd(){
        editDialogStage = new Stage();
        Scene scene1 = new Scene(root);
        editDialogStage.setScene(scene1);
        scene1.getStylesheets().clear();
        File file = new File("my.css");
        String file_s = file.toURI().toString();
        scene1.getStylesheets().add(file_s);

        //stage.setScene(new Scene(root));
        editDialogStage.setTitle("Додавання");
        editDialogStage.setMinHeight(170);
        editDialogStage.setMinWidth(600);
        editDialogStage.setResizable(false);
        editDialogStage.initOwner(newStage);
        editDialogStage.initModality(Modality.WINDOW_MODAL);
        editDialogStage.showAndWait();
    }
    public void showDialog(){
        editDialogStage = new Stage();
        Scene scene1 = new Scene(root);
        editDialogStage.setScene(scene1);
        scene1.getStylesheets().clear();
        File file = new File("my.css");
        String file_s = file.toURI().toString();
        scene1.getStylesheets().add(file_s);

        //stage.setScene(new Scene(root));
        editDialogStage.setTitle("Редагування");
        editDialogStage.setMinHeight(170);
        editDialogStage.setMinWidth(600);
        editDialogStage.setResizable(false);
        editDialogStage.initOwner(newStage);
        editDialogStage.initModality(Modality.WINDOW_MODAL);
        editDialogStage.showAndWait();
    }
    @FXML
    public void add(ActionEvent actionEvent) {
        controllerModalWindow.setPerson(new Person());
        showDialogadd();
        addressBookImpl.add(controllerModalWindow.getPerson());
    }

    @FXML
    public void edit(ActionEvent actionEvent) {
        controllerModalWindow.setPerson((Person) table.getSelectionModel().getSelectedItem());
        showDialog();
    }

    @FXML
    public void delete(ActionEvent actionEvent) {
        addressBookImpl.delete((Person) table.getSelectionModel().getSelectedItem());
    }

    public void searchfield(ActionEvent actionEvent) {
    }
    @FXML
    void btnsearch(ActionEvent event) {
        addressBookImpl.getPersonList().clear();
        for (Person person : backupList){
            if(person.getPip().toLowerCase().contains(searchbtn.getText().toLowerCase()) ||

                    person.getPhone().toLowerCase().contains(searchrtxt.getText().toLowerCase())) {
                addressBookImpl.getPersonList().add(person);
            }
        }
    }
    public void Exit(ActionEvent actionEvent) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Вихід з програми");
            alert.setContentText("Ви дійсно бажаєте вийти ? ");
            if (alert.showAndWait().get() == ButtonType.OK) {
                Stage stage = (Stage) scenePane.getScene().getWindow();
                System.out.println("Ви успішно вийшли з програми");
                stage.close();
        }
    }

    public void openotherlabs(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloControllerOtherLabs.class.getResource("OtherLabs.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1035, 500);
        Stage stage = new Stage();
        stage.setTitle("Інші лабораторні");
        stage.setScene(scene);
        stage.show();
    }


    public void openvideoplayer(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloControllerOtherLabs.class.getResource("media.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = new Stage();
        stage.setTitle("Video Player");
        stage.setScene(scene);
        stage.show();
    }
}