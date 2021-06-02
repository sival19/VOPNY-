package vop;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class PrimaryController implements Initializable {

    @FXML
    TextField searchWord, replaceWord;
    @FXML
    Button replace, open, save;
    @FXML
    private TextArea textField;
    private FileChooser fileChooser;
    private IoFacade facade;

    public void openHandler(){
        textField.clear();
        File inFile = fileChooser.showOpenDialog(textField.getScene().getWindow());
        if (inFile == null)
            return;

        String txt = facade.readFile(inFile);
        textField.setText(txt);
    }

    public void saveHandler(){
        File outFile = fileChooser.showOpenDialog(textField.getScene().getWindow());
        if (outFile == null)
            return;

        facade.writeFile(textField.getText(), outFile);
    }

    public void replaceHandler(){
        String search = searchWord.getText();
        String replace = replaceWord.getText();
        String original = textField.getText();
        String newText = original.replaceAll(search, replace);
        textField.setText(newText);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("."));
        facade = new IoFacade();
    }
}
