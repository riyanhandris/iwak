package com.example.iwak.model;

public class ModelResults {
   private boolean hasil[]= new boolean[5];

    public ModelResults() {
        for (int i = 0; i <hasil.length ; i++) {
            hasil[i]=false;
        }
    }

    public boolean[] getHasil() {
        return hasil;
    }

    public void setHasil(int a) {
        this.hasil[a] = true ;
    }
}
