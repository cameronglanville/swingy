package com.cglanvil.app.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class GameModel {

    @NotNull(message = "Name cannot be null")
    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 2, message = "Name must have at least 2 character")
    protected String name;

    //@NotNull(message = "Jop cannot be null")
    @NotEmpty(message = "Jop cannot be null")
    @Size(min = 2, message = "Job must have at least 2 characters")
    protected String job;

    @Min(value = 1, message = "Level can not be less than 1")
    @Max(value = 20, message = "Level can not be more than 20")
    protected int level;

    @Min(value = 0, message = "Exp can't be less than 0")
    protected int exp;

    protected int expToLevel;

    @Min(value = 1, message = "Hp can not be less than 1")
    protected int hp;

    // @Min(value = 0, message = "Hp can not be less than 0")
    protected int currentHp;

    @Min(value = 1, message = "Attack can not be less than 1")
    protected int atk;

    @Min(value = 1, message = "Defence can not be less than 1")
    protected int def;

    protected int weapon;

    protected int armour;

    protected int helm;

    protected int creatureLevel;

    protected char[][] map;

    public void setName(String name) {
        this.name = name;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void createHero() {
        this.level = 1;
        this.exp = 0;
        this.expToLevel = (int) (this.level * 1000 + 450 * Math.pow(this.level - 1, 2));
        this.atk = 10;
        this.def = 10;
        this.currentHp = 100;
        this.hp = 100;
    }

    public void battleStart(String name, String job) {

    }

    public void setCreatureLevel(int level) {
        this.creatureLevel = level;
    }

    public String getStatus() {
        return "----------------------------------\n" + this.name + " the " + this.job + "\nlevel " + this.level
                + " " + this.exp + "/" + this.expToLevel + "\nHp: " + this.currentHp + "/" + this.hp + " Atk: "
                + this.atk + " Def: " + this.def + "\n----------------------------------";
    }

}
