package com.example.exercicio_3_new;

public class HumorData {

    private int humorId;
    private String nomeHumor;

    public HumorData(int humorId, String nomeHumor){
        this.humorId = humorId;
        this.nomeHumor = nomeHumor;
    }

    public int getHumorId() {
        return humorId;
    }

    public void setHumorId(int humorId) {
        this.humorId = humorId;
    }

    public String getNomeHumor() {
        return nomeHumor;
    }

    public void setNomeHumor(String nomeHumor) {
        this.nomeHumor = nomeHumor;
    }
}
