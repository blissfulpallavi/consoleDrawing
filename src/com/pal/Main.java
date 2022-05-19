package com.pal;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;


public class Main {

    public static void main(String[] args) throws IOException {

        // Display something in initial console.
        System.out.println("One - Previous console");

        // Preserve current console which contains 'One - Previous console'.
        PrintStream previousConsole = System.out;

        // Set the standard output to use newConsole.
        ByteArrayOutputStream newConsole = new ByteArrayOutputStream();
        System.setOut(new PrintStream(newConsole));

        // From here on, all System.out.println() calls will be stored in newConsole.
        //  Note: The output "Two - New console" you see from the console doesn't
        //        come from this line but from the line "previousConsole.println(...);"
        System.out.println("Two - New console");

        previousConsole.println(newConsole.toString()); // Display output of newConsole.

        // Restore back the standard console output.
        System.setOut(previousConsole);

        // Test print to console.
        System.out.println("Three - Restored console");
        System.out.println(newConsole.toString());

    }
}
