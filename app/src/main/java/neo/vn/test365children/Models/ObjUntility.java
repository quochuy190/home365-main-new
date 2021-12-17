package neo.vn.test365children.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ObjUntility implements Serializable {
    @SerializedName("ID")
    String ID;
    @SerializedName("NAME")
    String sName;
    @SerializedName("URL_IMG")
    String sLogo;
    @SerializedName("URL")
    String URL;
    @SerializedName("UNIT")
    String UNIT;
    @SerializedName("ADDRESS")
    String ADDRESS;
    @SerializedName("DESCRIPTION")
    String DESCRIPTION;
    @SerializedName("PHONE")
    String PHONE;
    @SerializedName("PRICE")
    String PRICE;
    @SerializedName("TTIME")
    String TTIME;
    @SerializedName("DES_PHONE")
    String DES_PHONE;
    @SerializedName("OD")
    String OD;
    @SerializedName("IMAGE_URL")
    String sIMAGE_URL_SKILL;


    public ObjUntility(String sName, String sLogo) {
        this.sName = sName;
        this.sLogo = sLogo;
    }

    public ObjUntility() {
    }

    public String getOD() {
        return OD;
    }

    public void setOD(String OD) {
        this.OD = OD;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsLogo() {
        return sLogo;
    }

    public void setsLogo(String sLogo) {
        this.sLogo = sLogo;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getUNIT() {
        return UNIT;
    }

    public void setUNIT(String UNIT) {
        this.UNIT = UNIT;
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public String getPHONE() {
        return PHONE;
    }

    public void setPHONE(String PHONE) {
        this.PHONE = PHONE;
    }

    public String getPRICE() {
        return PRICE;
    }

    public void setPRICE(String PRICE) {
        this.PRICE = PRICE;
    }

    public String getTTIME() {
        return TTIME;
    }

    public void setTTIME(String TTIME) {
        this.TTIME = TTIME;
    }

    public String getDES_PHONE() {
        return DES_PHONE;
    }

    public void setDES_PHONE(String DES_PHONE) {
        this.DES_PHONE = DES_PHONE;
    }

    public String getsIMAGE_URL_SKILL() {
        return sIMAGE_URL_SKILL;
    }

    public void setsIMAGE_URL_SKILL(String sIMAGE_URL_SKILL) {
        this.sIMAGE_URL_SKILL = sIMAGE_URL_SKILL;
    }
}
