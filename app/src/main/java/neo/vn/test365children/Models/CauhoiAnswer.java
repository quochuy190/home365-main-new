package neo.vn.test365children.Models;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class CauhoiAnswer extends RealmObject {
    @SerializedName("INFO")
    RealmList<CauhoiDetailAnswer> lisInfo;
    @PrimaryKey
    @SerializedName("ID")
    String sID;
    @SerializedName("EXCERCISE_ID")
    String sEXCERCISE_ID;
    @SerializedName("KIEU")
    String sKIEU;
    @SerializedName("UPDATETIME")
    String sUPDATETIME;
    @SerializedName("QUESTION_NUMBER")
    String QUESTION_NUMBER;
    @SerializedName("TEXT")
    String TEXT;
    @SerializedName("HUONGDAN")
    String HUONGDAN;


    public CauhoiAnswer() {
    }

    public CauhoiAnswer(RealmList<CauhoiDetailAnswer> lisInfo, String sID, String sEXCERCISE_ID, String sKIEU, String sUPDATETIME) {
        this.lisInfo = lisInfo;
        this.sID = sID;
        this.sEXCERCISE_ID = sEXCERCISE_ID;
        this.sKIEU = sKIEU;
        this.sUPDATETIME = sUPDATETIME;
    }

    public RealmList<CauhoiDetailAnswer> getLisInfo() {
        return lisInfo;
    }

    public void setLisInfo(RealmList<CauhoiDetailAnswer> lisInfo) {
        this.lisInfo = lisInfo;
    }

    public String getsID() {
        return sID;
    }

    public void setsID(String sID) {
        this.sID = sID;
    }

    public String getsEXCERCISE_ID() {
        return sEXCERCISE_ID;
    }

    public void setsEXCERCISE_ID(String sEXCERCISE_ID) {
        this.sEXCERCISE_ID = sEXCERCISE_ID;
    }

    public String getsKIEU() {
        return sKIEU;
    }

    public void setsKIEU(String sKIEU) {
        this.sKIEU = sKIEU;
    }

    public String getsUPDATETIME() {
        return sUPDATETIME;
    }

    public void setsUPDATETIME(String sUPDATETIME) {
        this.sUPDATETIME = sUPDATETIME;
    }
}
