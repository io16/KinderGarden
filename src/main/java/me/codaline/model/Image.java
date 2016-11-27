package me.codaline.model;

import javax.persistence.*;

/**
 * Created by igor on 04.11.16.
 */
@Entity
public class Image {
    @Id
    @GeneratedValue
    private int id;
    private String date;
    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
