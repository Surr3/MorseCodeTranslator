package org.example;

import java.util.HashMap;

public class MorseCodeTranslator {
    HashMap<Character, String> morseList = new HashMap<>();

    private final StringBuilder translatedMessage = new StringBuilder();

    private final String inputMessage;

    boolean hasLetters, hasSymbols = false;

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
    }

    //Returns if input is valid or not.
    public void checkValidInput() {

        //Processes input if it contains only letters a-z, dashes (-), dots (.) and blanks.
        if (inputMessage.matches("[A-Z. -]+") && !inputMessage.isBlank()) {

            //Processes input as long as it is not only blanks.
            for (int i = 0; i < inputMessage.length(); i++) {
                if (Character.isLetter(inputMessage.charAt(i))) {
                    hasLetters = true;
                }
                if (!Character.isLetterOrDigit(inputMessage.charAt(i)) && !(inputMessage.charAt(i) == ' ')) {
                    hasSymbols = true;
                }
            }
            /*
             * If inputMessage is valid and doesn't have combinations of symbols and letters --> translateMessage()
             * Else prints error message.
             */
            if (!(hasSymbols && hasLetters)) {
                translateMessage();
            } else translatedMessage.append("Combining alphabets and morse is not allowed. Try again.");
        }
        // Call function if there are invalid inputs (e.g. 123, åäö, !? or only blanks/empty).
        else errorMessageHandler();
    }

    private void errorMessageHandler() {

        boolean hasDigits = false;
        boolean hasInvalidLetters = false;
        boolean hasInvalidSymbols = false;

        if (inputMessage.isBlank()) {
            translatedMessage.append("Input can't be empty or only blanks.\n");
        } else {

            for (int i = 0; i < inputMessage.length(); i++) {

                char currentCharacter = inputMessage.charAt(i);

                if (Character.isDigit(currentCharacter) && !hasDigits) {
                    translatedMessage.append("You can't translate numbers.\n");
                    hasDigits = true;
                }
                if (Character.isLetter(currentCharacter) && !inputMessage.matches("[A-Z]") && !hasInvalidLetters) {
                    translatedMessage.append("You can't use invalid letters.\n");
                    hasInvalidLetters = true;
                }
                if (!Character.isLetterOrDigit(currentCharacter) && !inputMessage.matches("[[.\\s-]]") && !hasInvalidSymbols) {
                    translatedMessage.append("You can't use invalid symbols.\n");
                    hasInvalidSymbols = true;
                }
            }
        }
        translatedMessage.append("Please try again and use only A-Z, a-z or dots (.) and dashes (-).");
    }

    public void translateMessage() {

        //Processes input if inputs are letters
        if (hasLetters) {
            for (int i = 0; i < inputMessage.length(); i++) {

                //If character is blank, appends blank for morse code (3 blanks) to translation.
                if (inputMessage.charAt(i) == ' ') {
                    translatedMessage.append("  ");
                }

                //If not blank, appends corresponding morse code.
                else {
                    translatedMessage.append(morseList.get(inputMessage.charAt(i)));
                    if (i < inputMessage.length() - 1) {
                        translatedMessage.append(" ");
                    }
                }
            }
        }

        //Translates input if inputs is morse code.
        else {

            //Separates words that are morse code into array morseWords.
            String[] morseWords = inputMessage.split("   ");

            //Iterates through all morse words in order to separate letters.
            for (String morseLetter : morseWords) {

                //Separates all morse letters, including blank spaces.
                String[] individualLetter = morseLetter.split(" ");

                //Iterates through all morse letters.
                for (String eachLetter : individualLetter) {

                    //Iterates through all morse letters and corresponding English letters.
                    morseList.forEach((key, value) -> {
                        /*
                         * If morseList contains value, append the corresponding key to translatedMessage.
                         * Including blanks.
                         */
                        if (eachLetter.equals(value)) {
                            translatedMessage.append(key);
                        }
                    });
                }
                translatedMessage.append(" ");
            }
        }
    }

    public String getTranslatedMessage() {
        return translatedMessage.toString().trim();
    }
}
