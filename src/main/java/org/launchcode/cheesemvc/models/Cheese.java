package org.launchcode.cheesemvc.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;


/**
 * Created by ryanneal on 11/16/17.
 */
public class Cheese {

    @NotNull
    @Size(min = 3, max=15)
    private String name;

    private String description;

    private CheeseType type;

    public static int id = 1;

    public final int cheeseId;
    static ArrayList<Cheese> cheeses = new ArrayList<>();

    public Cheese(String name, String description){
        this();
        this.name = name;
        this.description = description;
    }

    public Cheese(){
        this.cheeseId= id;
        id++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Cheese.id = id;
    }

    public int getCheeseId() {
        return cheeseId;
    }

    public CheeseType getType() {
        return type;
    }

    public void setType(CheeseType type) {
        this.type = type;
    }
}
