package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class TestTranslator {

    @Test
    public void translatesLetterAtoMorse() {
        //Arrange
        MorseCodeTranslator translator = new MorseCodeTranslator("A");
        String expected = ".-";

        //Act
        String actual = translator.getTranslatedMessage();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void translatesLetterZtoMorse() {
        //Arrange
        MorseCodeTranslator translator = new MorseCodeTranslator("Z");
        String expected = "--..";

        //Act
        String actual = translator.getTranslatedMessage();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void translatesMorseToLetterA() {
        //Arrange
        MorseCodeTranslator translator = new MorseCodeTranslator(".-");
        String expected = "A";

        //Act
        String actual = translator.getTranslatedMessage();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void translatesMorseToLetterZ() {
        //Arrange
        MorseCodeTranslator translator = new MorseCodeTranslator("--..");
        String expected = "Z";

        //Act
        String actual = translator.getTranslatedMessage();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void multipleLettersAreTranslatedAndBlankSeparated() {
        //Arrange
        MorseCodeTranslator translator = new MorseCodeTranslator("AKZ");
        String expected = ".- -.- --..";

        //Act
        String actual = translator.getTranslatedMessage();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void multipleMorsesAreTranslated() {
        //Arrange
        MorseCodeTranslator translator = new MorseCodeTranslator(".- -.- --..");
        String expected = "AKZ";

        //Act
        String actual = translator.getTranslatedMessage();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void translatingToMorseIncludesBlanks() {
        MorseCodeTranslator translator = new MorseCodeTranslator("H E");
        String expected = "....   .";

        //Act
        String actual = translator.getTranslatedMessage();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void translatingToLettersIncludesBlanks() {
        MorseCodeTranslator translator = new MorseCodeTranslator(".- -...   .-");
        String expected = "AB A";

        //Act
        String actual = translator.getTranslatedMessage();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void lowercaseLettersTranslatesToMorse() {
        MorseCodeTranslator translator = new MorseCodeTranslator("h e");
        String expected = "....   .";

        //Act
        String actual = translator.getTranslatedMessage();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void numericalInputsPrintsErrorMessage() {
        //Arrange
        MorseCodeTranslator translator = new MorseCodeTranslator("1");
        String expected = "Please enter only A-Z (lowercase included) or dashes (-) and dots (.).\nPlease try again.";

        //Act
        String actual = translator.getTranslatedMessage();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void invalidLettersPrintsErrorMessage() {
        //Arrange
        MorseCodeTranslator translator = new MorseCodeTranslator("å");
        String expected = "Please enter only A-Z (lowercase included) or dashes (-) and dots (.).\nPlease try again.";

        //Act
        String actual = translator.getTranslatedMessage();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void invalidSymbolsPrintsErrorMessage() {
        //Arrange
        MorseCodeTranslator translator = new MorseCodeTranslator("(");
        String expected = "Please enter only A-Z (lowercase included) or dashes (-) and dots (.).\nPlease try again.";

        //Act
        String actual = translator.getTranslatedMessage();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void emptyInputPrintsErrorMessage() {
        //Arrange
        MorseCodeTranslator translator = new MorseCodeTranslator("");
        String expected = "Please enter only A-Z (lowercase included) or dashes (-) and dots (.).\nPlease try again.";

        //Act
        String actual = translator.getTranslatedMessage();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void onlyBlankInputPrintsErrorMessage() {
        //Arrange
        MorseCodeTranslator translator = new MorseCodeTranslator("       ");
        String expected = "Please enter only A-Z (lowercase included) or dashes (-) and dots (.).\nPlease try again.";

        //Act
        String actual = translator.getTranslatedMessage();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void combiningCharactersPrintsErrorMessage() {
        //Arrange
        MorseCodeTranslator translator = new MorseCodeTranslator("A -");
        String expected = "Please enter only A-Z (lowercase included) or dashes (-) and dots (.).\nPlease try again.";

        //Act
        String actual = translator.getTranslatedMessage();

        //Assert
        assertEquals(expected, actual);
    }
}
