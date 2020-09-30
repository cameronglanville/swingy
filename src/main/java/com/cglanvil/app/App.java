package com.cglanvil.app;

public class App {

    public static void main(String[] args) throws Exception {
        // check the number of arguments the program receives
        if (args.length == 0) {
            System.out.println("Enter a mode.");
            return;
        } else if (args.length > 1) {
            System.out.println("Modes are console and gui.");
            return;
        }

        if (args[0].equalsIgnoreCase("console") || args[0].equalsIgnoreCase("gui")) {
            System.out.println("Swingy is now in " + args[0] + " mode.");
        } else {
            System.out.println("Modes are console and gui.");
            return;
        }
        // System.out.println("Yay, you got to the end!");
    }
}
