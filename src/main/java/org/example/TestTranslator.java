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
        MorseCodeTranslator translator = new MorseCodeTranslator("a z");
        String expected = ".-   --..";

        //Act
        String actual = translator.getTranslatedMessage();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void numericalInputsPrintsErrorMessage() {
        //Arrange
        MorseCodeTranslator translator = new MorseCodeTranslator("11");
        String expected = "You can't translate numbers.\nPlease try again and use only A-Z, a-z or dots (.) and dashes (-).";

        //Act
        String actual = translator.getTranslatedMessage();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void invalidLettersPrintsErrorMessage() {
        //Arrange
        MorseCodeTranslator translator = new MorseCodeTranslator("åå");
        String expected = "You can't use invalid letters.\nPlease try again and use only A-Z, a-z or dots (.) and dashes (-).";

        //Act
        String actual = translator.getTranslatedMessage();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void multipleInvalidsPrintsErrorMessages() {
        MorseCodeTranslator translator = new MorseCodeTranslator("1å!");
        String expected = "You can't translate numbers.\n" + "You can't use invalid letters.\n" + "You can't use invalid symbols.\n" + "Please try again and use only A-Z, a-z or dots (.) and dashes (-).";

        //Act
        String actual = translator.getTranslatedMessage();

        //Assert
        assertEquals(expected, actual);

    }

    @Test
    public void invalidSymbolsPrintsErrorMessage() {
        //Arrange
        MorseCodeTranslator translator = new MorseCodeTranslator("((");
        String expected = "You can't use invalid symbols.\nPlease try again and use only A-Z, a-z or dots (.) and dashes (-).";

        //Act
        String actual = translator.getTranslatedMessage();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void emptyInputPrintsErrorMessage() {
        //Arrange
        MorseCodeTranslator translator = new MorseCodeTranslator("");
        String expected = "Input can't be empty or only blanks.\nPlease try again and use only A-Z, a-z or dots (.) and dashes (-).";

        //Act
        String actual = translator.getTranslatedMessage();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void onlyBlankInputPrintsErrorMessage() {
        //Arrange
        MorseCodeTranslator translator = new MorseCodeTranslator("       ");
        String expected = "Input can't be empty or only blanks.\nPlease try again and use only A-Z, a-z or dots (.) and dashes (-).";

        //Act
        String actual = translator.getTranslatedMessage();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void combiningCharactersPrintsErrorMessage() {
        //Arrange
        MorseCodeTranslator translator = new MorseCodeTranslator("A -");
        String expected = "Combining alphabets and morse is not allowed. Try again.";

        //Act
        String actual = translator.getTranslatedMessage();

        //Assert
        assertEquals(expected, actual);
    }
}
