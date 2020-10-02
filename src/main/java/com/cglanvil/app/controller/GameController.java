package com.cglanvil.app.controller;

import com.cglanvil.app.model.GameModel;
import com.cglanvil.app.view.GameView;

public class GameController {
    private GameModel model;
    private GameView view;

    public GameController(GameModel model, GameView view) {
        this.model = model;
        this.view = view;
    }

    public void setHero(String name, String job) {
        model.createHero(name, job);
    }

    public void updateView() {
        view.setStatus(model.getStatus());
        view.setBody("testing");
        view.setOptions("options");
        view.gameView();
    }
}
