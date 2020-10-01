package com.cglanvil.app.view;

public class GameView {
    public void printHeroDetails(String heroName, String heroJob, int heroLevel, int heroExp, int heroHp,
            int heroCurrentHp, int heroAtk, int heroDef) {
        System.out.println("Hero:");
        System.out.println("Name:\t" + heroName);
        System.out.println("Job:\t" + heroJob);
        System.out.println("Level:\t" + heroLevel);
        System.out.println("Hp:\t" + heroCurrentHp + " / " + heroHp);
        System.out.println("Atk:\t" + heroAtk);
        System.out.println("Def:\t" + heroDef);
    }
}
