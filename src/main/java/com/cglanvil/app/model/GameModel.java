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
    private String name;

    // @NotEmpty(message = "Jop cannot be empty")
    @NotNull(message = "No jop selected, job can't be null")
    @Size(min = 2, message = "No job selected")
    private String job;

    @Min(value = 1, message = "Level can't be less than 1")
    @Max(value = 20, message = "Level can't be more than 20")
    private int level;

    @Min(value = 0, message = "Exp can't be less than 0")
    private int exp;

    private int expToLevel;

    @Min(value = 1, message = "Hp can't be less than 1")
    private int hp;

    // @Min(value = 0, message = "Hp can not be less than 0")
    private int currentHp;

    @Min(value = 1, message = "Attack can't be less than 1")
    private int atk;

    @Min(value = 1, message = "Defence can't be less than 1")
    private int def;

    @Min(value = 0, message = "Weapon can't be less than 0")
    private int weapon;

    @Min(value = 0, message = "Armour can't be less than 0")
    private int armour;

    @Min(value = 0, message = "Helm can't be less than 0")
    private int helm;

    @NotNull(message = "Creature level can't be null")
    @Min(value = 0, message = "Creature level can't be less than 0")
    private int creatureLevel;

    @NotNull(message = "Map size can't be null")
    private int mapSize;

    @NotNull(message = "Map can't be null")
    private char[][] map;

    @Min(value = 0, message = "x can't be negative")
    private int x;

    @Min(value = 0, message = "y can't be negative")
    private int y;

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
            this.def = 1;
        } else {
            this.atk = 1;
            this.def = 2;
        }
        this.currentHp = 10;
        this.hp = 10;
    }

    public void createMap() {
        this.mapSize = (this.level - 1) * 5 + 10 - (this.level % 2);
        map = new char[this.mapSize][this.mapSize];
        int x = 0;
        int y = 0;
        while (x < this.mapSize) {
            while (y < this.mapSize) {
                map[x][y] = '_';
                y++;
            }
            y = 0;
            x++;
        }
        this.x = this.mapSize / 2;
        this.y = this.x;
        map[this.x][this.y] = 'H';
    }

    public String getMap() {
        String mapAsString = "";
        int i = 0;
        int j = 0;
        while (i < this.mapSize) {
            if (i != 0) {
                mapAsString += "\n";
            }
            while (j < this.mapSize) {
                if (j == 0) {
                    mapAsString += "|";
                } else {
                    mapAsString += " |";
                }
                mapAsString += map[i][j];
                j++;
            }
            j = 0;
            i++;
        }
        return mapAsString;
    }

    public void handleMovement(String input) {
        if (input.equalsIgnoreCase("w") || input.equalsIgnoreCase("a") || input.equalsIgnoreCase("s") || input.equalsIgnoreCase("d")) {
            this.map[this.x][this.y] = '_';
            if (input.equalsIgnoreCase("w")) {
                if (this.x != 0) {
                    this.x -= 1;
                }
            } else if (input.equalsIgnoreCase("a")) {
                if (this.y != 0) {
                    this.y -= 1;
                }
            } else if (input.equalsIgnoreCase("s")) {
                if (this.x != this.mapSize - 1) {
                    this.x += 1;
                }
            } else if (input.equalsIgnoreCase("d")) {
                if (this.y != this.mapSize - 1) {
                    this.y += 1;
                }
            }
            this.map[this.x][this.y] = 'H';
        }
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
