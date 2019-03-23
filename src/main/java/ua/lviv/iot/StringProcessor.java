package ua.lviv.iot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class StringProcessor {

    public static String readInputText() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("waiting for your text ...");
        return br.readLine();
    }

    public static void main(String ... args) {

        try {
            String input = StringProcessor.readInputText();
            TextInput text = new TextInput(input);
            text.showResults();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("waiting for your input  ...");
        String input = scanner.nextLine();
        TextInput text = new TextInput(input);
        text.showResults();
    }
}
