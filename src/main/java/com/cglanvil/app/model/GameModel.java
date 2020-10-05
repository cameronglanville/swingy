package com.cglanvil.app.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
// import javax.validation.constraints.NotEmpty;

public class GameModel {

    // @NotEmpty(message = "Name cannot be empty")
    @NotNull(message = "Name can't be null")
    @Size(min = 2, max = 15, message = "Name must have between 2 and 15 characters")
    // @Size(max = 15, message = "Name can't have more than 15 characters")
    protected String name;

    // @NotEmpty(message = "Jop cannot be empty")
    @NotNull(message = "No jop selected, job can't be null")
    @Size(min = 2, message = "No job selected")
    protected String job;

    @Min(value = 1, message = "Level can't be less than 1")
    @Max(value = 20, message = "Level can't be more than 20")
    protected int level;

    @Min(value = 0, message = "Exp can't be less than 0")
    protected int exp;

    protected int expToLevel;

    @Min(value = 1, message = "Hp can't be less than 1")
    protected int hp;

    // @Min(value = 0, message = "Hp can not be less than 0")
    protected int currentHp;

    @Min(value = 1, message = "Attack can't be less than 1")
    protected int atk;

    @Min(value = 1, message = "Defence can't be less than 1")
    protected int def;

    protected int weapon;

    protected int armour;

    protected int helm;

    protected int creatureLevel;

    protected char[][] map;

    @Min(value = 0, message = "x can't be negative")
    protected int x;

    @Min(value = 0, message = "y can't be negative")
    protected int y;

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
        if (this.job.equals("Rogue")) {
            this.atk = 2;
        } else {
            this.atk = 1;
        }
        if (this.job.equals("Fighter")) {
            this.atk = 2;
        } else {
            this.atk = 1;
        }
        this.def = 1;
        this.currentHp = 10;
        this.hp = 10;
    }

    public void createMap() {
        int mapSize = this.level * 10;
        map = new char[mapSize + 1][mapSize + 1];
        int x = 0;
        int y = 0;
        while (x < mapSize) {
            while (y < mapSize) {
                map[x][y] = 'a';
            }
            map[x][y] = '\0';
            y = 0;
            x++;
        }
        map[x][y] = '\0';
        // for (int i = 0; i < mapSize; i++ ) {
        //     for (int j = 0; j < mapSize; j++) {
        //         map[i][j] = 'a';
        //     }
        // }
    }

    public char[][] getMap() {
        return map;
    }

    public void battleStart(String name, String job) {

    }

    public void setCreatureLevel(int level) {
        this.creatureLevel = level;
    }

    public String getStatus() {
        return this.name + " the " + this.job + "\nlevel " + this.level + " " + this.exp + "/" + this.expToLevel
                + "\nHp: " + this.currentHp + "/" + this.hp + " Atk: " + this.atk + " Def: " + this.def;
    }

}
