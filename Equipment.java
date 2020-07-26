/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Zeynep
 */
public class Equipment {
    private String name;
    private int id;
    private String mpcm;
    private String magtech;
    private String uvli;
    private String dol;
    private String pd;

    public Equipment(String name, int id, String mpcm, String magtech, String uvli, String dol, String pd) {
        this.name = name;
        this.id = id;
        this.mpcm = mpcm;
        this.magtech = magtech;
        this.uvli = uvli;
        this.dol = dol;
        this.pd = pd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMpcm() {
        return mpcm;
    }

    public void setMpcm(String mpcm) {
        this.mpcm = mpcm;
    }

    public String getMagtech() {
        return magtech;
    }

    public void setMagtech(String magtech) {
        this.magtech = magtech;
    }

    public String getUvli() {
        return uvli;
    }

    public void setUvli(String uvli) {
        this.uvli = uvli;
    }

    public String getDol() {
        return dol;
    }

    public void setDol(String dol) {
        this.dol = dol;
    }

    public String getPd() {
        return pd;
    }

    public void setPd(String pd) {
        this.pd = pd;
    }
    
}
