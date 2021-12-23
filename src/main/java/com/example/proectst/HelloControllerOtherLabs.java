package com.example.proectst;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class HelloControllerOtherLabs implements Initializable {
    @FXML
    private CheckBox ChBSklad;

    @FXML
    private CheckBox ChBSDruz;

    @FXML
    private CheckBox ChBPogod;

    @FXML
    private CheckBox ChBGnuch;

    @FXML
    private Label LbTrue;

    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private Label lbChoiceBox;

    @FXML
    private Label lbcomboBox;

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private RadioButton RadioBtnCode;

    @FXML
    private RadioButton RadioBtnProp;

    @FXML
    private RadioButton RadioBtnLay;

    @FXML
    private RadioButton RadioBtnHier;

    @FXML
    private Label radio;

    @FXML
    private Label labelDate;

    @FXML
    private DatePicker datePicker;

    @FXML
    private ColorPicker colorPicker;

    @FXML
    private HBox hBox;

    @FXML
    private Slider mySlider;

    @FXML
    private Label labelSlider;

    @FXML
    void openotherLabs(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("OtherLabs.fxml"));
        Scene scene = new Scene(root, 800, 800);
        Stage stage = new Stage();

        stage.setTitle("Other labs");

        stage.setScene(scene);

        stage.show();

    }


    @FXML
    void getDate(ActionEvent event) {
        LocalDate localDate = datePicker.getValue();
        String dateF = localDate.format(DateTimeFormatter.ofPattern("dd.MM.YY."));
        labelDate.setText(dateF);

    }

    @FXML
    void changeBackground(ActionEvent event) {
        Color myColor = colorPicker.getValue();
        hBox.setBackground(new Background(new BackgroundFill(myColor, null, null)));

    }



    private ToggleGroup radiotoggleGroup;

    int score;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        LbTrue.setText("");

        lbChoiceBox.setText("");
        choiceBox.getItems().addAll("Правильно", "Неправильно");

        lbcomboBox.setText("");
        comboBox.getItems().addAll("BorderPane", "AnchorPane", "Vbox", "Hbox");

        radio.setText("");
        radiotoggleGroup = new ToggleGroup();
        this.RadioBtnProp.setToggleGroup(radiotoggleGroup);
        this.RadioBtnLay.setToggleGroup(radiotoggleGroup);
        this.RadioBtnHier.setToggleGroup(radiotoggleGroup);
        this.RadioBtnCode.setToggleGroup(radiotoggleGroup);


        score = (int) mySlider.getValue();
        labelSlider.setText(score + " балів");

        mySlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                score = (int) mySlider.getValue();
                labelSlider.setText(score + " балів");

            }
        });
    }

    @FXML
    void checkBoxAnswer(ActionEvent event) {
        String string = "Ваша відповідь: ";
        if (ChBPogod.isSelected()) string += "\nПогодженість";
        if (ChBSklad.isSelected()) string += "\nГнучкість";
        if (ChBSDruz.isSelected()) string += "\nДружність";
        if (ChBGnuch.isSelected()) string += "\nСкладність";

        LbTrue.setText(string);
    }

    @FXML
    void choiceBoxAnswer(ActionEvent event) {
        lbChoiceBox.setText("Відповідь: " + choiceBox.getValue().toString());

    }

    @FXML
    void comboBoxPressed(ActionEvent event) {
        lbcomboBox.setText("Відповідь: " + comboBox.getValue().toString());

    }


    @FXML
    void RadioAnswer(ActionEvent event) {
        if (this.radiotoggleGroup.getSelectedToggle().equals(this.RadioBtnCode))
            radio.setText("Відповідь: Code");
        if (this.radiotoggleGroup.getSelectedToggle().equals(this.RadioBtnProp))
            radio.setText("Відповідь: Properties");
        if (this.radiotoggleGroup.getSelectedToggle().equals(this.RadioBtnLay))
            radio.setText("Відповідь: Layout");
        if (this.radiotoggleGroup.getSelectedToggle().equals(this.RadioBtnHier))
            radio.setText(("Відповідь: Hierarchy"));
    }
}

