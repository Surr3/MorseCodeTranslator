package org.example;

import java.util.HashMap;

public class MorseCodeTranslator {
    HashMap<Character, String> morseList = new HashMap<>();

    private String translatedMessage;
    private final String inputMessage;

    private boolean isValid;
    private boolean hasLetters = false;
    private boolean hasSymbols = false;

    public MorseCodeTranslator(String inputMessage) {

        this.inputMessage = inputMessage.toUpperCase();

        morseList.put('A', ".-");
        morseList.put('B', "-...");
        morseList.put('C', "-.-.");
        morseList.put('D', "-..");
        morseList.put('E', ".");
        morseList.put('F', "..-.");
        morseList.put('G', "--.");
        morseList.put('H', "....");
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

        checkValidInput();
    }

    public boolean checkValidInput() {
        if (inputMessage.matches("[A-Z. -]+")) {
            if (!inputMessage.isBlank()) {
                for (int i = 0; i < inputMessage.length(); i++) {
                    if (Character.isLetter(inputMessage.charAt(i))){
                        hasLetters = true;
                    }
                    if (!Character.isLetterOrDigit(inputMessage.charAt(i))){
                        hasSymbols = true;
                    }
                }
                if (!(hasSymbols && hasLetters)){
                    isValid = true;
                }
            }
            else isValid = false;
        }

        return isValid;
    }

    public boolean getValidity() {
        return isValid;
    }

    public String getTranslatedMessage() {
        return "ge";
    }

}
