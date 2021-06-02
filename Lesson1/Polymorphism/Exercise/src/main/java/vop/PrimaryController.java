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
    RadioButton elipseR, rectangleR, circleR, squareR;

    @FXML
    TextField value1, value2;

    @FXML
    TextArea textArea;
    @FXML
    Button calc;

    @FXML
    ToggleGroup toggleGroup;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        toggleGroup = new ToggleGroup();
        elipseR.setToggleGroup(toggleGroup);
        rectangleR.setToggleGroup(toggleGroup);
        circleR.setToggleGroup(toggleGroup);
        squareR.setToggleGroup(toggleGroup);
        elipseR.setUserData(ShapeFacade.SHAPES.ELLIPSE);
        rectangleR.setUserData(ShapeFacade.SHAPES.RECTANGLE);
        circleR.setUserData(ShapeFacade.SHAPES.CIRCLE);
        squareR.setUserData(ShapeFacade.SHAPES.SQUERE);
    }

    @FXML
    public void caclHandler(ActionEvent event){
        String result = "";
        ShapeFacade.SHAPES shape = (ShapeFacade.SHAPES) toggleGroup.getSelectedToggle().getUserData();
        double para1 = Double.parseDouble(value1.getText());
        if (circleR.isSelected() || squareR.isSelected()){
            result = ShapeFacade.getInstance().getShapeInfo(shape, para1);
        } else {
            double para2 = Double.parseDouble(value2.getText());
            result = ShapeFacade.getInstance().getShapeInfo(shape,para1,para2);
        }

        textArea.appendText(result + "\n");
    }

    @FXML
    public void radioHandler(){
        if (elipseR.isSelected() || rectangleR.isSelected()){
            value2.setVisible(true);
        } else {
            value2.setVisible(false);
        }

    }
}
