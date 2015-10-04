package model;

import java.util.ArrayList;
import java.util.List;

public class Producer {

    private int id;
    private String name;
    private String country;
    private List<Souvenir> souvenirs;

    public Producer() {
        id = -1;
        name = "NoName";
        country = "NoCountry";
        souvenirs = new ArrayList<>();
    }

    public Producer(int id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
        souvenirs = new ArrayList<>();
    }

    public Producer(int id, String name, String country, List<Souvenir> souvenirs) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.souvenirs = souvenirs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Souvenir> getSouvenirs() {
        return souvenirs;
    }

    public void setSouvenirs(List<Souvenir> souvenirs) {
        this.souvenirs = souvenirs;
    }

}
