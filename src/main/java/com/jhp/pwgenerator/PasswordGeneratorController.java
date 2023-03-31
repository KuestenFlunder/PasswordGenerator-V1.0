package com.jhp.pwgenerator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PasswordGeneratorController {
    @FXML
    private Label password;

    @FXML
    protected void onGeneratePasswordClick() {
        password.setText(PasswordGenerator.generatePassword());
    }

    @FXML
    protected void onCopyToClipboardClick(){PasswordGenerator.copyToClipboard(password);

    }

}