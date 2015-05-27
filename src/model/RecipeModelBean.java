package model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.lang.String;
import java.sql.Time;
@ManagedBean
@RequestScoped
public class RecipeModelBean {

    private int idRecette;
    private String titre;
    private String description;
    private int note;
    private String type;
    private Time temps;
    private int personnes;
    private String image;

    public RecipeModelBean(String titre, String description, String type, Time temps, int personnes, String image) {
        this.titre = titre;
        this.description = description;
        this.type = type;
        this.temps = temps;
        this.personnes = personnes;
        this.image = image;
    }

    public String getTitre() {
        return titre;
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

    public Time getTemps() {
        return temps;
    }

    public int getPersonnes() {
        return personnes;
    }

    public String getImage() {
        return image;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTemps(Time temps) {
        this.temps = temps;
    }

    public void setPersonnes(int personnes) {
        this.personnes = personnes;
    }

    public void setImage(String image) {
        this.image = image;
    }
}