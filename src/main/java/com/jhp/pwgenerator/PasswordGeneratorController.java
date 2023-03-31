package com.jhp.pwgenerator;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

import java.net.URL;
import java.util.ResourceBundle;

public class PasswordGeneratorController implements Initializable {
    @FXML
    private Label password;
    @FXML
    private Slider pwLengthSlider;
    private double pwLength;

    @FXML
    protected void onGeneratePasswordClick() {
        password.setText(PasswordGenerator.generatePassword(pwLength));}

    @FXML
    protected void onCopyToClipboardClick(){PasswordGenerator.copyToClipboard(password);}

    @FXML
    protected void onSliderClickRelease(){pwLength = Math.round(pwLengthSlider.getValue());}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        onSliderClickRelease();
    }
}