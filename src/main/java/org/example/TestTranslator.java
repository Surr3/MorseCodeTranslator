package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

//public class TestTranslator {
//    @Test
//    public void validLettersShouldReturnTrue(){
//        //Arrange
//        MorseCodeTranslator translator = new MorseCodeTranslator("A");
//        boolean expected = true;
//
//        //Act
//        translator.validator();
//
//        //Assert
//        assertEquals(expected, translator.validator());
//    }
//
//    @Test
//    public void validSymbolsShouldReturnTrue(){
//        //Arrange
//        MorseCodeTranslator translator = new MorseCodeTranslator("-");
//        boolean expected = true;
//
//        //Act
//        translator.validator();
//
//        //Assert
//        assertEquals(expected, translator.validator());
//    }
//
//    @Test
//    public void numericalInputsShouldReturnFalse(){
//        //Arrange
//        MorseCodeTranslator translator = new MorseCodeTranslator("1");
//        boolean expected = true;
//
//        //Act
//        translator.validator();
//
//        //Assert
//        assertEquals(expected, translator.validator());
//    }
//
//    @Test
//    public void invalidLettersShouldReturnFalse(){
//        //Arrange
//        MorseCodeTranslator translator = new MorseCodeTranslator();
//        boolean expected = false;
//
//        //Act
//        translator.validator();
//
//        //Assert
//        assertEquals(expected, translator.validator());
//    }
//
//    @Test
//    public void blankOrEmptyShouldReturnFalse(){
//        //Arrange
//        MorseCodeTranslator translator = new MorseCodeTranslator();
//        boolean expected = false;
//
//        //Act
//        translator.validator();
//
//        //Assert
//        assertEquals(expected, translator.validator());
//    }
//
//    @Test
//    public void symbolAndLetterShouldReturnFalse(){
//        //Arrange
//        MorseCodeTranslator translator = new MorseCodeTranslator();
//        boolean expected = false;
//
//        //Act
//        translator.validator();
//
//        //Assert
//        assertEquals(expected, translator.validator());
//    }
//
//}