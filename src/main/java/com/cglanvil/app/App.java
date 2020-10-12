package com.cglanvil.app;

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
            if (args[0].equalsIgnoreCase("gui")){
                System.out.println("Swingy doesn't support GUI mode yet.\nSwingy is now in Console mode.");
            } else {
                System.out.println("Swingy is now in Console mode.");
            }
        } else {
            System.out.println("Modes are console and gui.");
            return;
        }

        // create an empty model
        GameModel model = new GameModel();
        // create a view
        GameView view = new GameView();
        // create a controller
        GameController controller = new GameController(model, view);
        // start the game
        controller.GameStart();
    }
}
