package com.example.kolokwium_2.dto;

import java.util.Arrays;

public class PlanszaDto {
    private String[][] plansza;

    public PlanszaDto(String[][] plansza) {
        this.plansza = plansza;
    }

    public String[][] getPlansza() {
        return plansza;
    }

    public void setPlansza(String[][] plansza) {
        this.plansza = plansza;
    }

    @Override
    public String toString() {
        String s = "";
        for(String[] tmp : plansza){
            s += "\n" + Arrays.toString(tmp);
        }
        return s;
    }
}
