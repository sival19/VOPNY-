package vop;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

public class PrimaryController implements Initializable {
    @FXML
    RadioButton atbash, ceaser;
    @FXML
    TextField message, encrypted, decrypted;
    @FXML
    Spinner<Integer> rotFactor;
    @FXML
    Button encrypt, decrypt;

    private CipherInterface cipherInterface;

    @FXML
    private void cipherHandler(ActionEvent event){
        Object source = event.getSource();

        if(atbash.isSelected()){
            cipherInterface = new AtbashCipher();
        } else if (ceaser.isSelected()){
            int keyValue = rotFactor.getValue();
            System.out.println(keyValue);
            cipherInterface = new CeasarCipher(keyValue);

        }
        if (source == encrypt){
            encrypted.setText(cipherInterface.encrypt(message.getText()));
        } else if (source == decrypt) {
            decrypted.setText(cipherInterface.decrypt(encrypted.getText()));
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ToggleGroup toggleGroup = new ToggleGroup();
        atbash.setToggleGroup(toggleGroup);
        ceaser.setToggleGroup(toggleGroup);
        rotFactor.setValueFactory(
                new SpinnerValueFactory.IntegerSpinnerValueFactory(
                        0,
                        CipherInterface.ALPHABETH.length - 1,
                        CipherInterface.ALPHABETH.length / 2
                )
        );

    }

}
