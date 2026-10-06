package org.example;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class MorseCodeTranslator {
    HashMap<Character, String> morseList = new HashMap<>();

    private StringBuilder translatedMessage = new StringBuilder();

    private final String inputMessage;

    private boolean isValid = false;
    private boolean hasLetters = false;
    private boolean hasSymbols = false;


    public MorseCodeTranslator(String inputMessage) {

        //Converts to uppercase making lowercase input valid.
        this.inputMessage = inputMessage.toUpperCase();

        morseList.put('A', ".-");
        morseList.put('B', "-...");
        morseList.put('C', "-.-.");
        morseList.put('D', "-..");
        morseList.put('E', ".");
        morseList.put('F', "..-.");
        morseList.put('G', "--.");
        morseList.put('H', "....");
        morseList.put('I', "..");
        morseList.put('J', ".---");
        morseList.put('K', "-.-");
        morseList.put('L', ".-..");
        morseList.put('M', "--");
        morseList.put('N', "-.");
        morseList.put('O', "---");
        morseList.put('P', ".--.");
        morseList.put('Q', "--.-");
        morseList.put('R', ".-.");
        morseList.put('S', "...");
        morseList.put('T', "-");
        morseList.put('U', "..-");
        morseList.put('V', "...-");
        morseList.put('W', ".--");
        morseList.put('X', "-..-");
        morseList.put('Y', "-.--");
        morseList.put('Z', "--..");
        morseList.put(' ', " ");

        checkValidInput();
        if (isValid) {
            translateMessage();
        }
    }

    //Returns if input is valid or not.
    public void checkValidInput() {
        String errorMessage = "Please enter only A-Z (lowercase included) or dashes (-) and dots (.).\nPlease try again.";

        if (inputMessage.matches("[A-Z. -]+")) {
            if (!inputMessage.isBlank()) {
                for (int i = 0; i < inputMessage.length(); i++) {
                    if (Character.isLetter(inputMessage.charAt(i))) {
                        hasLetters = true;
                    }
                    if (!Character.isLetterOrDigit(inputMessage.charAt(i)) && !(inputMessage.charAt(i) == ' ')) {
                        hasSymbols = true;
                    }
                }
                /*
                 * If input has valid symbols && letters, the input is not valid.
                 * Combining is not allowed.
                 */
                if (!(hasSymbols && hasLetters)) {
                    isValid = true;
                } else {
                    translatedMessage.append(errorMessage);
                }
            }
            //Prints errorMessage if input only has blanks.
            else {
                translatedMessage.append(errorMessage);
            }
        }
        //Prints errorMessage if input has numbers or invalid characters (e.g. å, ä, ö or /, ?, !).
        else translatedMessage.append(errorMessage);
    }

    public void translateMessage() {
        if (hasLetters) {
            for (int i = 0; i < inputMessage.length(); i++) {
                if (inputMessage.charAt(i) == ' ') {
                    translatedMessage.append("   ");
                } else {
                    translatedMessage.append(morseList.get(inputMessage.charAt(i)));

                }
            }
        } else {
            String[] morseWords = inputMessage.split("   ");
            for (String morseLetter : morseWords) {
                String[] individualLetter = morseLetter.split("(?<=\\s)|(?=\\s)");
                for (String eachLetter : individualLetter) {
                    morseList.forEach((key, value) -> {
                        if (eachLetter.equals(value)) {
                            translatedMessage.append(key);
                        }
                    });
                }
            }

        }
    }

    public String getTranslatedMessage() {
        return translatedMessage.toString().trim();
    }
}
