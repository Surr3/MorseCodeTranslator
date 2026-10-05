package org.example;

import java.util.HashMap;

public class MorseCodeTranslator {
    HashMap<Character, String> morseList = new HashMap<>();
    String translatedMessage;
    String inputMessage;
    boolean isValid = false;

    public MorseCodeTranslator(String inputMessage){

        this.inputMessage=inputMessage;

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

    }

    public boolean validator(){
        return false;

    }
}
