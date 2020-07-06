package org.ntutssl.library;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) 
    {
        Library library = new Library();
        String instruction = new String();
        Scanner input = new Scanner(System.in);
        InputOutput inputOutput = new InputOutput();
        while(!instruction.equals("exit"))
        {
            inputOutput.printLibraryInstructions();
            instruction = input.nextLine();
            inputOutput.handleLibraryInstructions(instruction, library);
        }
        input.close();
    }
}