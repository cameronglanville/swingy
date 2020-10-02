package com.cglanvil.app;

import java.util.Scanner;

import com.cglanvil.app.controller.GameController;
import com.cglanvil.app.model.GameModel;
import com.cglanvil.app.view.GameView;

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
        // if one argument check the mode
        if (args[0].equalsIgnoreCase("console") || args[0].equalsIgnoreCase("gui")) {
            System.out.println("Swingy is now in " + args[0] + " mode.");
        } else {
            System.out.println("Modes are console and gui.");
            return;
        }

        //initiate everything
        Scanner scan = new Scanner(System.in);
        //String input;
        String name;
        String job;

        //create an empty model
        GameModel model = new GameModel();
        // create a view
        GameView view = new GameView();
        //create a controller
        GameController controller = new GameController(model, view);

        //capture hero name
        System.out.println("Please input a name:");
        name = scan.nextLine();
        System.out.println("Please input a job:");
        job = scan.nextLine();
        controller.setHero(name, job);
        controller.updateView();
        scan.close();
        // System.out.println("Yay, you got to the end!");
    }
}
