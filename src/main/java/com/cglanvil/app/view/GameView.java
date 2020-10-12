package com.cglanvil.app.view;

public class GameView { // good

    private final String header;
    private String status; // characters status
    private String body;
    private String footer;

    public GameView() {
        this.header = " ___ _ _ _  _ ._ _  ___  _ _ \n" + "<_-<| | | |<_>| ' |/ . || | |\n"
                + "/__/|__/_/ |_||_|_|\\_. |`_. |\n" + "cglanvil           <___'<___'";
        this.status = "";
        this.body = "";
        this.footer = "";
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

    public void displayErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void refreshView() {
        System.out.println("----------------------------------\n" + header + "\n----------------------------------");
        if (!"".equals(status)) {
            System.out.println(status + "\n----------------------------------");
        }
        if (!"".equals(body)) {
            System.out.println(body + "\n----------------------------------");
        }
        if (!"".equals(footer)) {
            System.out.println(footer + "\n----------------------------------");
        }
    }
}
