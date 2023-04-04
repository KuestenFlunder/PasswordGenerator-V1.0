package com.jhp.pwgenerator;

import javafx.scene.control.Label;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

import java.util.Random;

public class PasswordGenerator {
    private static final String CHARACTERSLOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String CHARACTERSUPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
    private static final Random random = new Random();


    public static String generatePassword(double pwLength) {



        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        String password = "";


        StringBuilder passwordBuilder = new StringBuilder();


        for (int i = 0; i <= pwLength-1; i++) {
            int pick = random.nextInt(1, 5);
            if (pick == 1) {
                passwordBuilder.append(getRandomCharacterLowerCase());
                hasLower = true;
            }
            if (pick == 2) {
                passwordBuilder.append(getRandomDigit());
                hasDigit = true;
            }
            if (pick == 3) {
                passwordBuilder.append(getRandomSpecialCharacter());
                hasSpecial = true;
            }
            if (pick == 4) {
                passwordBuilder.append(getRandomCharacterUpperCase());
                hasUpper = true;
            }

        }

        if (hasDigit == true && hasLower == true && hasUpper == true && hasSpecial == true)
            password = passwordBuilder.toString();
        else {
            password = generatePassword(pwLength);
        }
        return password;
    }

    private static char getRandomCharacterLowerCase() {
        return CHARACTERSLOWER.charAt(random.nextInt(CHARACTERSLOWER.length()));
    }

    private static char getRandomCharacterUpperCase() {
        return CHARACTERSUPPER.charAt(random.nextInt(CHARACTERSUPPER.length()));
    }

    private static char getRandomDigit() {
        return DIGITS.charAt(random.nextInt(DIGITS.length()));
    }

    private static char getRandomSpecialCharacter() {
        return SPECIAL_CHARACTERS.charAt(random.nextInt(SPECIAL_CHARACTERS.length()));//todo modify list to omit special characters by list.
    }

    public static void copyToClipboard(Label text) {
        try {
            Clipboard clipboard = Clipboard.getSystemClipboard();
            ClipboardContent content = new ClipboardContent();
            content.putString(text.getText());
            clipboard.setContent(content);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
