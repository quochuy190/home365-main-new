package neo.vn.test365children.Models;

import com.google.gson.annotations.SerializedName;

public class Dictionary {
    @SerializedName("ERROR")
    private String sERROR;
    @SerializedName("MESSAGE")
    private String sMESSAGE;
    @SerializedName("RESULT")
    private String sRESULT;
    @SerializedName("ID")
    private String ID;
    @SerializedName("WORD")
    String sNewWord;
    @SerializedName("MEAN")
    String sTranslate;
    String sImage;
    @SerializedName("PRONOUNCE")
    String sAudio;
    @SerializedName("NOTE")
    String sDescription;
    @SerializedName("UPDATETIME")
    String UPDATETIME;
    @SerializedName("CLASS_ID")
    String CLASS_ID;
    @SerializedName("STATE")
    String STATE;

    public Dictionary(String sNewWord, String sTranslate, String sImage, String sAudio, String sDescription) {
        this.sNewWord = sNewWord;
        this.sTranslate = sTranslate;
        this.sImage = sImage;
        this.sAudio = sAudio;
        this.sDescription = sDescription;
    }

    public String getsNewWord() {
        return sNewWord;
    }

    public void setsNewWord(String sNewWord) {
        this.sNewWord = sNewWord;
    }

    public String getsTranslate() {
        return sTranslate;
    }

    public void setsTranslate(String sTranslate) {
        this.sTranslate = sTranslate;
    }

    public String getsImage() {
        return sImage;
    }

    public void setsImage(String sImage) {
        this.sImage = sImage;
    }

    public String getsAudio() {
        return sAudio;
    }

    public void setsAudio(String sAudio) {
        this.sAudio = sAudio;
    }

    public String getsDescription() {
        return sDescription;
    }

    public void setsDescription(String sDescription) {
        this.sDescription = sDescription;
    }

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
