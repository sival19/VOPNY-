package vop;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class PrimaryController7 implements Initializable, CallBackInterface {

    @FXML
    private TextArea textArea;
    @FXML
    private Button startButton;
    @FXML
    private Button stopButton;
    @FXML
    private ImageView die1view;
    @FXML
    private ImageView die2view;

    private FacadeWithCallback facade;


    @Override
    public void initialize(URL url, ResourceBundle rb) {

        startButton.setDisable(false);
        stopButton.setDisable(true);
    }

    @FXML
    private void buttonAction(ActionEvent event) {
        if (event.getSource() == startButton) {

            // Initialize the facade and start it.
            try {
                facade = new FacadeWithCallback(this);
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            facade.start();
            startButton.setDisable(true);
            stopButton.setDisable(false);
            // handle access to the buttons
        } else {
            if (event.getSource() == stopButton) { // Stop the facade
                facade.interrupt();
                startButton.setDisable(false);
                stopButton.setDisable(true);
            }

        }
    }

    @Override
    public void updateMessage(String message) {
        Platform.runLater(() -> {

                textArea.appendText(message);
                if (!facade.isAlive()) {
                    stopButton.fire();
                    System.out.println("hola");
                }


        });



        // This is the implementation of the CallBack. Remember it is called fro a Thread!
        // append the message to the textArea

    }

    @Override
    public void updateImages(File i1, File i2) {

        synchronized (this) {
            die1view.setImage(new Image(i1.toURI().toString()));
            die2view.setImage(new Image(i2.toURI().toString()));
        }
        // change the pictures on the imageViews

    }


}