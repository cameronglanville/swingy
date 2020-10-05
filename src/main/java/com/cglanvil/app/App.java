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
            System.out.println("Swingy is now in " + args[0] + " mode.");
        } else {
            System.out.println("Modes are console and gui.");
            return;
        }

        // -------------------------
        // create an empty model
        GameModel model = new GameModel();
        // create a view
        GameView view = new GameView();
        // create a controller
        GameController controller = new GameController(model, view);
        // start the game
        controller.GameStart();
        // -------------------------

        // // initiate everything
        // Scanner scan = new Scanner(System.in);
        // // String input;
        // String name;
        // String job;
        // ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        // Validator validator = factory.getValidator();

        // validate name
        // Set<ConstraintViolation<GameModel>> propertyViolations = validator.validateProperty(model, "name");

        // // capture hero name
        // while (propertyViolations.size() != 0) {
        //     System.out.println("Please input a name:");
        //     name = scan.nextLine();
        //     controller.setName(name);
        //     propertyViolations = validator.validateProperty(model, "name");
        //     if (propertyViolations.size() != 0) {
        //         for (ConstraintViolation<GameModel> violation : propertyViolations) {
        //             System.out.println(violation.getMessage());
        //         }
        //     }
        // }

        // // check the entire model
        // Set<ConstraintViolation<GameModel>> violations = validator.validate(model);
        // for (ConstraintViolation<GameModel> violation : violations) {
        // System.out.println(violation.getMessage());
        // }

        // // validate job
        // propertyViolations = validator.validateProperty(model, "job");

        // // capture job
        // while (propertyViolations.size() != 0) {
        //     System.out.println("Please select a job: Fighter or Rogue.\n1: Fighter\n2: Rogue");
        //     job = scan.nextLine();
        //     if (job.equals("1")) {
        //         controller.setJob("Fighter");
        //     } else if (job.equals("2")) {
        //         controller.setJob("Rogue");
        //     }
        //     propertyViolations = validator.validateProperty(model, "job");
        //     if (propertyViolations.size() != 0) {
        //         for (ConstraintViolation<GameModel> violation : propertyViolations) {
        //             System.out.println(violation.getMessage());
        //         }
        //     }
        // }

        // controller.createHero();
        // controller.updateView();

        // scan.close();
        // System.out.println("Yay, you got to the end!");
    }
}
