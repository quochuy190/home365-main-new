package neo.vn.test365children.Models;

import com.google.gson.annotations.SerializedName;

public class ObjKoW {
    @SerializedName("ERROR")
    private String sERROR;
    @SerializedName("MESSAGE")
    private String sMESSAGE;
    @SerializedName("RESULT")
    private String sRESULT;
    @SerializedName("ID")
    private String ID;
    @SerializedName("WORD")
    private String WORD;
    @SerializedName("MEAN")
    private String MEAN;
    @SerializedName("PRONOUNCE")
    private String PRONOUNCE;
    @SerializedName("NOTE")
    private String NOTE;
    @SerializedName("EDITOR")
    private String EDITOR;
    @SerializedName("UPDATETIME")
    private String UPDATETIME;
    @SerializedName("CLASS_ID")
    private String CLASS_ID;
    @SerializedName("STATE")
    private String STATE;


    public String getsERROR() {
        return sERROR;
    }

    public void setsERROR(String sERROR) {
        this.sERROR = sERROR;
    }

    public String getsMESSAGE() {
        return sMESSAGE;
    }

    public void setsMESSAGE(String sMESSAGE) {
        this.sMESSAGE = sMESSAGE;
    }

    public String getsRESULT() {
        return sRESULT;
    }

    public void setsRESULT(String sRESULT) {
        this.sRESULT = sRESULT;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getWORD() {
        return WORD;
    }

    public void setWORD(String WORD) {
        this.WORD = WORD;
    }

    public String getMEAN() {
        return MEAN;
    }

    public void setMEAN(String MEAN) {
        this.MEAN = MEAN;
    }

    public String getPRONOUNCE() {
        return PRONOUNCE;
    }

    public void setPRONOUNCE(String PRONOUNCE) {
        this.PRONOUNCE = PRONOUNCE;
    }

    public String getNOTE() {
        return NOTE;
    }

    public void setNOTE(String NOTE) {
        this.NOTE = NOTE;
    }

    public String getEDITOR() {
        return EDITOR;
    }

    public void setEDITOR(String EDITOR) {
        this.EDITOR = EDITOR;
    }

    public String getUPDATETIME() {
        return UPDATETIME;
    }

    public void setUPDATETIME(String UPDATETIME) {
        this.UPDATETIME = UPDATETIME;
    }

    public String getCLASS_ID() {
        return CLASS_ID;
    }

    public void setCLASS_ID(String CLASS_ID) {
        this.CLASS_ID = CLASS_ID;
    }

    public String getSTATE() {
        return STATE;
    }

    public void setSTATE(String STATE) {
        this.STATE = STATE;
    }
}
