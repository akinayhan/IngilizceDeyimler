package com.example.ingilizcedeyimler;

public class Deyimler {
    private int Id;
    private String Ing;
    private String Tr;

    public Deyimler()
    {

    }

    public Deyimler(String ing, String tr) {
        Ing = ing;
        Tr = tr;
    }

    public String getIng() {
        return Ing;
    }

    public void setIng(String ing) {
        Ing = ing;
    }

    public String getTr() {
        return Tr;
    }

    public void setTr(String tr) {
        Tr = tr;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}
