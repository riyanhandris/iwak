package com.example.iwak.model;

import android.graphics.drawable.Drawable;

public class ModelIwak {
    private int id;
    private String title;
    private Drawable drawable;

    public ModelIwak(int id, String title, Drawable drawable) {
        this.id = id;
        this.title = title;
        this.drawable = drawable;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public Drawable getDrawable() {
        return drawable;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }
}
