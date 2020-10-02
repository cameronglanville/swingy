package com.cglanvil.app.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
// import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class Hero extends Creature{

    //fighter / rogue / wizard
    @NotNull(message = "Jop cannot be null")
    @Size(min = 2, message = "Job must have at least 2 characters")
    private String job;

    @Min(value = 0, message = "Exp can't be less than 0")
    private int exp;

    public String getJob() {
        return this.job;
    }

    public void setJob(String newJob) {
        this.job = newJob;
    }

    public int getExp() {
        return this.exp;
    }

    public void setExp(int newExp) {
        this.exp = newExp;
    }
}
