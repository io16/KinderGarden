package me.codaline.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by igor on 13.11.16.
 */
@Entity
public class ImagesAndGalleries {
    @Id
    @GeneratedValue
    private int id;
    private int idGallery;
    private int idImage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdGallery() {
        return idGallery;
    }

    public void setIdGallery(int idGallery) {
        this.idGallery = idGallery;
    }

    public int getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }
}
