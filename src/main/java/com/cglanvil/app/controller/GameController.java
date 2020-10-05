package com.cglanvil.app.controller;

//import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.cglanvil.app.model.GameModel;
import com.cglanvil.app.view.GameView;

public class GameController {
    private GameModel model;
    private GameView view;

    public GameController(GameModel model, GameView view) {
        this.model = model;
        this.view = view;
    }

    public void GameStart() {

        // initiate everything
        Scanner scan = new Scanner(System.in);
        String input;
        String job;
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        //initiate input to empty
        input = "";
        //Main menu
        view.setFooter("1. New Game\n2. Load Game");
        while (!input.equals("1") && !input.equals("2")) {
            view.gameView();
            input = scan.nextLine();
        }
        view.setFooter("");

        // validate name
        Set<ConstraintViolation<GameModel>> propertyViolations = validator.validateProperty(model, "name");

        // capture hero name
        view.setFooter("Please input a name:");
        while (propertyViolations.size() != 0) {
            view.gameView();
            model.setName(scan.nextLine().trim());
            propertyViolations = validator.validateProperty(model, "name");
            if (propertyViolations.size() != 0) {
                for (ConstraintViolation<GameModel> violation : propertyViolations) {
                    System.out.println(violation.getMessage());
                }
            }
        }

        propertyViolations = validator.validateProperty(model, "job");

        // capture job
        view.setFooter("Please select a job: Fighter or Rogue.\n1: Fighter\n2: Rogue");
        while (propertyViolations.size() != 0) {
            view.gameView();
            job = scan.nextLine();
            if (job.equals("1")) {
                model.setJob("Fighter");
            } else if (job.equals("2")) {
                model.setJob("Rogue");
            }
            propertyViolations = validator.validateProperty(model, "job");
            if (propertyViolations.size() != 0) {
                for (ConstraintViolation<GameModel> violation : propertyViolations) {
                    System.out.println(violation.getMessage());
                }
            }
        }

        model.createHero();
        model.createMap();
        //Arrays.deepToString(); && Arrays.toString()
        view.setFooter("WASD for movement. E(x)it.");
        while (!input.equals("x")) {
            updateView();
            input = scan.nextLine();
            model.handleMovement(input);
        }

        scan.close(); // must be at the ends
    }

    // public void setName(String name) {
    // model.setName(name);
    // }

    // public void setJob(String job) {
    // model.setJob(job);
    // }

    // public void createHero() {
    // model.createHero();
    // }

    public void updateView() {
        view.setStatus(model.getStatus());
        view.setBody(model.getMap());
        // view.setFooter("options");
        view.gameView();
    }
}
