package org.launchcode.cheesemvc.models;

/**
 * Created by ryanneal on 12/4/17.
 */
public enum CheeseType {

    HARD ("Hard"),
    SOFT ("Soft"),
    FAKE ("Fake");

    private final String name;

    CheeseType(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
