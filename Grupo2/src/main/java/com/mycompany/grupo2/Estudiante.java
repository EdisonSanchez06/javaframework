/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grupo2;

/**
 *
 * @author Edison
 */
class Estudiante {
    private String EST_CED;
    private String EST_NOM;
    private String EST_APE;
    private String EST_DIR;
    private String EST_TEL;

    public Estudiante(String EST_CED, String EST_NOM, String EST_APE, String EST_DIR, String EST_TEL) {
        this.EST_CED = EST_CED;
        this.EST_NOM = EST_NOM;
        this.EST_APE = EST_APE;
        this.EST_DIR = EST_DIR;
        this.EST_TEL = EST_TEL;
    }

    public String getEST_CED() {
        return EST_CED;
    }

    public String getEST_NOM() {
        return EST_NOM;
    }

    public void setEST_NOM(String EST_NOM) {
        this.EST_NOM = EST_NOM;
    }

    public String getEST_APE() {
        return EST_APE;
    }

    public void setEST_APE(String EST_APE) {
        this.EST_APE = EST_APE;
    }

    public String getEST_DIR() {
        return EST_DIR;
    }

    public void setEST_DIR(String EST_DIR) {
        this.EST_DIR = EST_DIR;
    }

    public String getEST_TEL() {
        return EST_TEL;
    }

    public void setEST_TEL(String EST_TEL) {
        this.EST_TEL = EST_TEL;
    }
    
    
}
