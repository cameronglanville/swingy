package com.cglanvil.app;

import java.util.Scanner;

import com.cglanvil.app.controller.GameController;
import com.cglanvil.app.model.Hero;
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
        String input;
        String name;
        String job;
        //create an empty model
        Hero model = new Hero();
        // create a view
        GameView view = new GameView();
        //create a controller
        GameController controller = new GameController(model, view);

        //capture hero name
        System.out.println("Please input a name:");
        // System.out.println("E(x)it");
        input = scan.nextLine();
        name = input;
        controller.setHeroName(name);
        // if (input.equals("x")) {
        //     scan.close();
        //     return;
        // } else {
        //     name = input;
        // }
        System.out.println("Please input a job:");
        // System.out.println("E(x)it");
        input = scan.nextLine();
        job = input;
        controller.setHeroJob(job);
        // if (input.equals("x")) {
        //     scan.close();
        //     return;
        // } else {
        //     job = input;
        // }
        // System.out.println("Creating your hero: " + name + " the " + job);
        // create a hero
        //Hero model = createHero(name, job);
        // create a view
        // GameView view = new GameView();
        // GameController controller = new GameController(model, view);
        controller.updateView();

        scan.close();
        // System.out.println("Yay, you got to the end!");
    }

    // private static Hero createHero(String name, String job) {
    //     Hero hero = new Hero();
    //     hero.setName(name);
    //     hero.setJob(job);
    //     hero.setLevel(1);
    //     hero.setExp(0);
    //     hero.setHp(100);
    //     hero.setCurrentHp(100);
    //     hero.setAtk(10);
    //     hero.setDef(10);
    //     return hero;
    // }
}
