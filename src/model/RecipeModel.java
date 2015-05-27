package model;

import java.lang.String;
import java.sql.Time;

public class RecipeModel {

    private int idRecipe;
    private String title;
    private String description;
    private int note;
    private String type;
    private Time time;
    private int nbPeople;
    private String image;

    public RecipeModel(String title, String description, String type, Time temps, int nbPeople, String image) {
        this.title = title;
        this.description = description;
        this.type = type;
        this.time = temps;
        this.nbPeople = nbPeople;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getNote() {
        return note;
    }

    public String getType() {
        return type;
    }

    public Time getTime() {
        return time;
    }

    public int getNbPeople() {
        return nbPeople;
    }

    public String getImage() {
        return image;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public void setNbPeople(int nbPeople) {
        this.nbPeople = nbPeople;
    }

    public void setImage(String image) {
        this.image = image;
    }
}