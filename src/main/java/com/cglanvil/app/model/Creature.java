package com.cglanvil.app.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public abstract class Creature {

    @NotNull(message = "Name cannot be null")
    @Size(min = 2, message = "Name must have at least 2 character")
    protected String name;

    @Min(value = 1, message = "Level can not be less than 1")
    @Max(value = 1, message = "Level can not be more than 20")
    protected int level;

    @Min(value = 1, message = "Hp can not be less than 1")
    protected int hp;

    // @Min(value = 0, message = "Hp can not be less than 0")
    protected int currentHp;

    @Min(value = 1, message = "Attack can not be less than 1")
    protected int atk;

    @Min(value = 1, message = "Defence can not be less than 1")
    protected int def;

    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int newLevel) {
        this.level = newLevel;
    }

    public int getHp() {
        return this.hp;
    }

    public void setHp(int newHp) {
        this.hp = newHp;
    }

    public int getCurrentHp() {
        return this.currentHp;
    }

    public void setCurrentHp(int newCurrentHp) {
        this.currentHp = newCurrentHp;
    }

    public int getAtk() {
        return this.atk;
    }

    public void setAtk(int newAtk) {
        this.atk = newAtk;
    }

    public int getDef() {
        return this.def;
    }

    public void setDef(int def) {
        this.def = def;
    }
}
