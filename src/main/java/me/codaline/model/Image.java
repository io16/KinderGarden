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
    private String formatFile;
    @Lob
    @Column(name = "Post_IMAGE", nullable = false, columnDefinition = "mediumblob")
    private byte[] image;

    public String getFormatFile() {
        return formatFile;
    }

    public void setFormatFile(String formatFile) {
        this.formatFile = formatFile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
