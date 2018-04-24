package com.example.guts.test2;

/**
 * Created by Guts on 12/04/2018.
 */

public class BloodSugar {
    private int bsId;
    private int id;
    private Double BloodSugar;

    public BloodSugar (int bsId, int id, Double BloodSugar){
        this.bsId = bsId;
        this.id = id;
        this.BloodSugar = BloodSugar;
    }

    public BloodSugar (int id, Double BloodSugar){
        this.id = id;
        this.BloodSugar = BloodSugar;
    }

    public BloodSugar (Double BloodSugar){
        this.BloodSugar = BloodSugar;
    }

    public int getId() {
        return id;
    }

    public Double getBloodSugar() {
        return BloodSugar;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBloodSugar(Double bloodSugar) {
        BloodSugar = bloodSugar;
    }
}
