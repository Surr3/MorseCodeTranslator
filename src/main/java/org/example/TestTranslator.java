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
        String expected = "....   .";

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
    public void lowercaseLettersShouldReturnMorse() {
        MorseCodeTranslator translator = new MorseCodeTranslator("h e");
        String expected = "....   .";

        //Act
        String actual = translator.getTranslatedMessage();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void numericalInputsShouldPrintErrorMessage() {
        //Arrange
        MorseCodeTranslator translator = new MorseCodeTranslator("1");
        String expected = "Please enter only A-Z (lowercase included) or dashes (-) and dots (.).\nPlease try again.";

        //Act
        String actual = translator.getTranslatedMessage();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void invalidLettersShouldPrintErrorMessage() {
        //Arrange
        MorseCodeTranslator translator = new MorseCodeTranslator("å");
        String expected = "Please enter only A-Z (lowercase included) or dashes (-) and dots (.).\nPlease try again.";

        //Act
        String actual = translator.getTranslatedMessage();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void invalidSymbolsShouldPrintErrorMessage() {
        //Arrange
        MorseCodeTranslator translator = new MorseCodeTranslator("(");
        String expected = "Please enter only A-Z (lowercase included) or dashes (-) and dots (.).\nPlease try again.";

        //Act
        String actual = translator.getTranslatedMessage();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void emptyInputShouldPrintErrorMessage() {
        //Arrange
        MorseCodeTranslator translator = new MorseCodeTranslator("");
        String expected = "Please enter only A-Z (lowercase included) or dashes (-) and dots (.).\nPlease try again.";

        //Act
        String actual = translator.getTranslatedMessage();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void onlyBlankInputShouldPrintErrorMessage() {
        //Arrange
        MorseCodeTranslator translator = new MorseCodeTranslator("       ");
        String expected = "Please enter only A-Z (lowercase included) or dashes (-) and dots (.).\nPlease try again.";

        //Act
        String actual = translator.getTranslatedMessage();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void combiningCharactersPrintErrorMessage() {
        //Arrange
        MorseCodeTranslator translator = new MorseCodeTranslator("A -");
        String expected = "Please enter only A-Z (lowercase included) or dashes (-) and dots (.).\nPlease try again.";

        //Act
        String actual = translator.getTranslatedMessage();

        //Assert
        assertEquals(expected, actual);
    }
}
