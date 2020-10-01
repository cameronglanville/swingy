package com.cglanvil.app.controller;

import com.cglanvil.app.model.Hero;
import com.cglanvil.app.view.GameView;

public class GameController {
    private Hero model;
    private GameView view;

    public GameController(Hero model, GameView view) {
        this.model = model;
        this.view = view;
    }

    public String getHeroName() {
        return model.getName();
    }

    public void setHeroName(String name) {
        model.setName(name);
    }

    public String getHeroJob() {
        return model.getJob();
    }

    public void setHeroJob(String name) {
        model.setJob(name);
    }

    public int getHeroLevel() {
        return model.getLevel();
    }

    public void setHeroLevel(int level) {
        model.setLevel(level);
    }

    public int getHeroExp() {
        return model.getExp();
    }

    public void setHeroExp(int exp) {
        model.setExp(exp);
    }

    public int getHeroHp() {
        return model.getHp();
    }

    public void setHeroHp(int hp) {
        model.setHp(hp);
    }

    public int getHeroCurrentHp() {
        return model.getCurrentHp();
    }

    public void setHeroCurrentHp(int currentHp) {
        model.setCurrentHp(currentHp);
    }

    public int getHeroAtk() {
        return model.getAtk();
    }

    public void setHeroAtk(int atk) {
        model.setAtk(atk);
    }

    public int getHeroDef() {
        return model.getDef();
    }

    public void setHeroDef(int def) {
        model.setDef(def);
    }

    public void updateView() {
        view.printHeroDetails(model.getName(), model.getJob(), model.getLevel(), model.getExp(), model.getHp(),
                model.getCurrentHp(), model.getAtk(), model.getDef());
    }
}
