package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class TestTranslator {
    @Test
    public void validLettersShouldReturnMorse() {
        //Arrange
        MorseCodeTranslator translator = new MorseCodeTranslator("A");
        String expected = ".-";

        //Act
        String actual = translator.getTranslatedMessage();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void validSymbolsShouldReturnLetter() {
        //Arrange
        MorseCodeTranslator translator = new MorseCodeTranslator("-");
        String expected = "T";

        //Act
        String actual = translator.getTranslatedMessage();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void blanksAreIncludedWithMorse() {
        MorseCodeTranslator translator = new MorseCodeTranslator("H E");
        String expected = ".... .";

        //Act
        String actual = translator.getTranslatedMessage();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void blanksAreIncludedWithSymbols() {
        MorseCodeTranslator translator = new MorseCodeTranslator(".- -...");
        String expected = "A B";

        //Act
        String actual = translator.getTranslatedMessage();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void lowercaseLettersShouldReturnMorse(){
        MorseCodeTranslator translator = new MorseCodeTranslator("h e");
        String expected = ".... .";

        //Act
        String actual = translator.getTranslatedMessage();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void numericalInputsShouldReturnFalse() {
        //Arrange
        MorseCodeTranslator translator = new MorseCodeTranslator("1");
        boolean expected = false;

        //Act
        boolean actual = translator.getValidity();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void invalidLettersShouldReturnFalse() {
        //Arrange
        MorseCodeTranslator translator = new MorseCodeTranslator("å");
        boolean expected = false;

        //Act
        boolean actual = translator.getValidity();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void emptyInputShouldReturnFalse() {
        //Arrange
        MorseCodeTranslator translator = new MorseCodeTranslator("");
        boolean expected = false;

        //Act
        boolean actual = translator.getValidity();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void onlyBlankInputShouldReturnFalse() {
        //Arrange
        MorseCodeTranslator translator = new MorseCodeTranslator("       ");
        boolean expected = false;

        //Act
        boolean actual = translator.getValidity();

        //Assert
        assertEquals(expected, actual);
    }


    @Test
    public void combiningSymbolsAndLetterShouldReturnFalse() {
        //Arrange
        MorseCodeTranslator translator = new MorseCodeTranslator("A -");
        boolean expected = false;

        //Act
        boolean actual = translator.getValidity();

        //Assert
        assertEquals(expected, actual);
    }


}
