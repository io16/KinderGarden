package me.codaline.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by igor on 05.11.16.
 */
@Entity
public class Gallery {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "title",columnDefinition="TEXT")
    private String title;
    @Column(name = "context" ,columnDefinition="TEXT")
    private String context;
    private String date;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}
