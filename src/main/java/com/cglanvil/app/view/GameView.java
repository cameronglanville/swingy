package com.cglanvil.app.view;

public class GameView { // good

    private String status; // characters status
    private String body;
    private String options;

    public void setStatus(String status) {
        this.status = status;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public void displayErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void gameView() {
        System.out.println(status);
        System.out.println(body);
        System.out.println(options);
    }
}
