package com.example.onepoint_ourtree.api.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class Tree implements Serializable {

    @SerializedName("hauteurenm")
    private int hauteur;
    @SerializedName("libellefrancais")
    private String nom;
    @SerializedName("espece")
    private String espece;
    @SerializedName("circonferenceencm")
    private int circonference;
    @SerializedName("adresse")
    private String adresse;


    public int getHauteur() {
        return hauteur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEspece() {
        return espece;
    }

    public void setEspece(String espece) {
        this.espece = espece;
    }

    public int getCirconference() {
        return circonference;
    }

    public void setCirconference(int circonference) {
        this.circonference = circonference;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
