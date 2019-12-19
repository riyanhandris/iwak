package com.example.iwak.model;

public class ModelStage {
    private int id;
    private int idIkan;
    private String name;
    private String materi;

    public ModelStage(int id, int idIkan, String name, String materi) {
        this.id = id;
        this.idIkan = idIkan;
        this.name = name;
        this.materi = materi;
    }

    public ModelStage() {
    }

    public int getIdIkan() {
        return idIkan;
    }

    public void setIdIkan(int idIkan) {
        this.idIkan = idIkan;
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

    public String getMateri() {
        return materi;
    }

    public void setMateri(String materi) {
        this.materi = materi;
    }
}
