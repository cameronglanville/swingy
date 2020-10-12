package com.cglanvil.app.controller;

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
    private Scanner scan = new Scanner(System.in);
    private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private Validator validator = factory.getValidator();

    public GameController(GameModel model, GameView view) {
        this.model = model;
        this.view = view;
    }

    public void GameStart() {
        // initiate everything
        String input = "";
        Set<ConstraintViolation<GameModel>> violations = this.validator.validate(model);
        // Main menu
        while (violations.size() != 0) {
            view.setFooter("1. New Game\n2. Load Game");
            view.refreshView();
            input = this.scan.nextLine();
            if ("1".equals(input)) {
                newGame();
            } else if ("2".equals(input)) {
                loadGame();
            }
            model.createHero();
            violations = this.validator.validate(model);
            for (ConstraintViolation<GameModel> violation : violations) {
                System.out.println(violation.getMessage());
            }
        }
        model.createMap();
        // Arrays.deepToString(); && Arrays.toString()
        view.setFooter("Get to the edge of the Map\nWASD for movement. E(x)it.");
        input = "";
        // playing the game
        while (!input.equals("x")) {
            if (model.getCurrentHp() <= 0) {
                System.out.println("You Died");
                break;
            }
            mapView();
            input = this.scan.nextLine();
            if ("w".equalsIgnoreCase(input) || "a".equalsIgnoreCase(input) || "s".equalsIgnoreCase(input)
                    || "d".equalsIgnoreCase(input)) {
                int random_int = (int) (Math.random() * 10);
                if (random_int == 0) {
                    battle(input);
                } else {
                    model.handleMovement(input);
                }
            }
        }
        this.scan.close(); // must be at the ends
    }

    private void battle(String input) {
        String command = "";
        model.battleStart();
        while (!"run".equalsIgnoreCase(command) && !"fight".equalsIgnoreCase(command)) {
            battleView();
            command = this.scan.nextLine().trim();
            if ("run".equalsIgnoreCase(command)) {
                int random_int = (int) (Math.random() * 100);
                if (random_int < 50) {
                    System.out.println("succesfully ran away");
                } else {
                    System.out.println("unable to run, you fight");
                    model.fight(input);
                }
            } else if ("fight".equalsIgnoreCase(command)) {
                System.out.println("you fight");
                model.fight(input);
            }
        }
    }

    private void newGame() {
        model.setName("");
        model.setJob("");
        String input = "";
        // validate name
        Set<ConstraintViolation<GameModel>> propertyViolations = this.validator.validateProperty(model, "name");
        // capture hero name
        view.setFooter("Please input your name.\nb: Back to main menu");
        while (propertyViolations.size() != 0) {
            view.refreshView();
            input = this.scan.nextLine().trim();
            if ("b".equals(input)) {
                System.out.println("returning to main menu");
                return;
            }
            model.setName(input);
            propertyViolations = this.validator.validateProperty(model, "name");
            if (propertyViolations.size() != 0) {
                for (ConstraintViolation<GameModel> violation : propertyViolations) {
                    System.out.println(violation.getMessage());
                }
            }
        }
        // validate job
        propertyViolations = this.validator.validateProperty(model, "job");
        // capture job
        input = "";
        view.setFooter("Please input your job.\nFighter or Rogue are recommended.\nb: Back to main menu");
        while (propertyViolations.size() != 0) {
            view.refreshView();
            input = this.scan.nextLine().trim();
            if ("b".equals(input)) {
                System.out.println("returning to main menu");
                return;
            }
            model.setJob(input);
            propertyViolations = this.validator.validateProperty(model, "job");
            if (propertyViolations.size() != 0) {
                for (ConstraintViolation<GameModel> violation : propertyViolations) {
                    System.out.println(violation.getMessage());
                }
            }
        }
    }

    private void loadGame() {
        System.out.println("load game doesn't work yet");
    }

    private void mapView() {
        view.setStatus(model.getStatus());
        view.setBody(model.getMap2());
        view.setFooter("Get to the edge of the map to complete the mission\nWASD for movement. E(x)it.");
        view.refreshView();
    }

    private void battleView() {
        view.setStatus(model.getStatus());
        view.setBody(model.getEncounter());
        view.setFooter("Input fight or run.");
        view.refreshView();
    }
}
