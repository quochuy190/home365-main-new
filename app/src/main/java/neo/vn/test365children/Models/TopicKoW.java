package neo.vn.test365children.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class TopicKoW implements Serializable {
    @SerializedName("ERROR")
    private String sERROR;
    @SerializedName("MESSAGE")
    private String sMESSAGE;
    @SerializedName("RESULT")
    private String sRESULT;
    @SerializedName("ID")
    private String ID;
    @SerializedName("NAME")
    private String NAME;
    @SerializedName("EDITOR")
    private String EDITOR;
    @SerializedName("UPDATETIME")
    private String UPDATETIME;
    @SerializedName("NAMEENGLISH")
    private String NAMEENGLISH;

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

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
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

    public String getNAMEENGLISH() {
        return NAMEENGLISH;
    }

    public void setNAMEENGLISH(String NAMEENGLISH) {
        this.NAMEENGLISH = NAMEENGLISH;
    }
}
