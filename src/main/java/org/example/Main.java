package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("Please write a text with letters OR morse code only. No combination allowed. " + "\n(For morse: Separate letters with 1 blank spaces, separate words with 3 blank spaces (   ). Use dots (.) for short signals and dashes (-) for long signals): ");

        Scanner scan = new Scanner(System.in);

        MorseCodeTranslator translator = new MorseCodeTranslator(scan.nextLine());

        System.out.println(translator.getTranslatedMessage());
    }
}

