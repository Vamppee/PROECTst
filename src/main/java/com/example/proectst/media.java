package com.example.proectst;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class media implements Initializable {
    private File file;
    private Media media;
    private MediaPlayer mediaPlayer;
    @FXML
    private Button pauseButton; // fx:id кнопки Pause
    @FXML
    private MediaView mediaView; // fx:id контролу mediaView
    @FXML
    private Button playButton; // fx:id кнопки Play
    @FXML
    private Button resetButton; // fx:id кнопки Reset

    @FXML
    void playbtn(ActionEvent event) {
        mediaPlayer.play();
    }
    @FXML
    void pausebtn(ActionEvent event) {
        mediaPlayer.pause();
    }
    @FXML
    void resetbtn(ActionEvent event) {
        if (mediaPlayer.getStatus() != MediaPlayer.Status.READY) {
            mediaPlayer.seek(Duration.seconds(0.0));
            mediaPlayer.play();

        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        file = new File("video.mp4");
        media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
    }

    public void openvideoplayer(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(media.class.getResource("media.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = new Stage();
        stage.setTitle("Video Player");
        stage.setScene(scene);
        stage.show();
    }
}