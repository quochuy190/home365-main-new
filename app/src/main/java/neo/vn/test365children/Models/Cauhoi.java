package neo.vn.test365children.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Cauhoi extends RealmObject implements Parcelable, Serializable {
    @SerializedName("ERROR")
    String sERROR;
    @SerializedName("MESSAGE")
    String sMESSAGE;
    @SerializedName("RESULT")
    String sRESULT;
    @SerializedName("INFO")
    RealmList<CauhoiDetail> lisInfo;
    @PrimaryKey
    @SerializedName("ID")
    String sID;
    @SerializedName("EXCERCISE_ID")
    String sEXCERCISE_ID;
    @SerializedName("QUESTION_NUMBER")
    String sQUESTION_NUMBER;
    @SerializedName("KIEU")
    String sKIEU;
    @SerializedName("HUONGDAN")
    String sHUONGDAN;
    @SerializedName("TEXT")
    String sTEXT;
    @SerializedName("IMAGE_ID")
    String sIMAGE_ID;
    @SerializedName("AUDIO_ID")
    String sAUDIO_ID;
    @SerializedName("PATH_IMAGE")
    String sPATH_IMAGE;
    @SerializedName("PATH_AUDIO")
    String sPATH_AUDIO;
    @SerializedName("UPDATETIME")
    String sUPDATETIME;
    String mOption;
    String mNumber;
    int iCount_Princess;
    boolean isDalam;
    boolean isResul_chil;
    boolean isEndGame;

    public Cauhoi(String sERROR, String sMESSAGE, String sRESULT, String mOption) {
        this.sERROR = sERROR;
        this.sMESSAGE = sMESSAGE;
        this.sRESULT = sRESULT;
        this.mOption = mOption;
    }

    public Cauhoi() {
    }

    public Cauhoi(String sERROR, String sMESSAGE, String sRESULT, RealmList<CauhoiDetail> lisInfo, String sID, String sEXCERCISE_ID, String sQUESTION_NUMBER, String sKIEU, String sHUONGDAN, String sTEXT, String sIMAGE_ID, String sAUDIO_ID, String sPATH_IMAGE, String sPATH_AUDIO, String sUPDATETIME, String mOption) {
        this.sERROR = sERROR;
        this.sMESSAGE = sMESSAGE;
        this.sRESULT = sRESULT;
        this.lisInfo = lisInfo;
        this.sID = sID;
        this.sEXCERCISE_ID = sEXCERCISE_ID;
        this.sQUESTION_NUMBER = sQUESTION_NUMBER;
        this.sKIEU = sKIEU;
        this.sHUONGDAN = sHUONGDAN;
        this.sTEXT = sTEXT;
        this.sIMAGE_ID = sIMAGE_ID;
        this.sAUDIO_ID = sAUDIO_ID;
        this.sPATH_IMAGE = sPATH_IMAGE;
        this.sPATH_AUDIO = sPATH_AUDIO;
        this.sUPDATETIME = sUPDATETIME;
        this.mOption = mOption;
    }

    protected Cauhoi(Parcel in) {
        sERROR = in.readString();
        sMESSAGE = in.readString();
        sRESULT = in.readString();
        // lisInfo = in.createTypedArrayList(CauhoiDetail.CREATOR);
        sID = in.readString();
        sEXCERCISE_ID = in.readString();
        sQUESTION_NUMBER = in.readString();
        sKIEU = in.readString();
        sHUONGDAN = in.readString();
        sTEXT = in.readString();
        sIMAGE_ID = in.readString();
        sAUDIO_ID = in.readString();
        sPATH_IMAGE = in.readString();
        sPATH_AUDIO = in.readString();
        sUPDATETIME = in.readString();
        mOption = in.readString();
    }

    public static final Creator<Cauhoi> CREATOR = new Creator<Cauhoi>() {
        @Override
        public Cauhoi createFromParcel(Parcel in) {
            return new Cauhoi(in);
        }

        @Override
        public Cauhoi[] newArray(int size) {
            return new Cauhoi[size];
        }
    };

    private static Cauhoi getObject(JSONObject jsonObject) {
        return new Gson().fromJson(jsonObject.toString(), Cauhoi.class);
    }

    public static ArrayList<Cauhoi> getList(String jsonArray) throws JSONException {
        ArrayList<Cauhoi> arrayList = new ArrayList<>();
        Type type = new TypeToken<List<Cauhoi>>() {
        }.getType();
        Gson gson = new Gson();
        arrayList = gson.fromJson(jsonArray, type);
        return arrayList;
    }

    public boolean isEndGame() {
        return isEndGame;
    }

    public void setEndGame(boolean endGame) {
        isEndGame = endGame;
    }

    public int getiCount_Princess() {
        return iCount_Princess;
    }

    public void setiCount_Princess(int iCount_Princess) {
        this.iCount_Princess = iCount_Princess;
    }

    public boolean isDalam() {
        return isDalam;
    }

    public void setDalam(boolean dalam) {
        isDalam = dalam;
    }

    public boolean isResul_chil() {
        return isResul_chil;
    }

    public void setResul_chil(boolean resul_chil) {
        isResul_chil = resul_chil;
    }

    public String getmNumber() {
        return mNumber;
    }

    public void setmNumber(String mNumber) {
        this.mNumber = mNumber;
    }

    public String getsPATH_IMAGE() {
        return sPATH_IMAGE;
    }

    public void setsPATH_IMAGE(String sPATH_IMAGE) {
        this.sPATH_IMAGE = sPATH_IMAGE;
    }

    public String getsPATH_AUDIO() {
        return sPATH_AUDIO;
    }

    public void setsPATH_AUDIO(String sPATH_AUDIO) {
        this.sPATH_AUDIO = sPATH_AUDIO;
    }

    public String getmOption() {
        return mOption;
    }

    public void setmOption(String mOption) {
        this.mOption = mOption;
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

    public RealmList<CauhoiDetail> getLisInfo() {
        return lisInfo;
    }

    public void setLisInfo(RealmList<CauhoiDetail> lisInfo) {
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

    public String getsQUESTION_NUMBER() {
        return sQUESTION_NUMBER;
    }

    public void setsQUESTION_NUMBER(String sQUESTION_NUMBER) {
        this.sQUESTION_NUMBER = sQUESTION_NUMBER;
    }

    public String getsKIEU() {
        return sKIEU;
    }

    public void setsKIEU(String sKIEU) {
        this.sKIEU = sKIEU;
    }

    public String getsHUONGDAN() {
        return sHUONGDAN;
    }

    public void setsHUONGDAN(String sHUONGDAN) {
        this.sHUONGDAN = sHUONGDAN;
    }

    public String getsTEXT() {
        return sTEXT;
    }

    public void setsTEXT(String sTEXT) {
        this.sTEXT = sTEXT;
    }

    public String getsIMAGE_ID() {
        return sIMAGE_ID;
    }

    public void setsIMAGE_ID(String sIMAGE_ID) {
        this.sIMAGE_ID = sIMAGE_ID;
    }

    public String getsAUDIO_ID() {
        return sAUDIO_ID;
    }

    public void setsAUDIO_ID(String sAUDIO_ID) {
        this.sAUDIO_ID = sAUDIO_ID;
    }

    public String getsUPDATETIME() {
        return sUPDATETIME;
    }

    public void setsUPDATETIME(String sUPDATETIME) {
        this.sUPDATETIME = sUPDATETIME;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(sERROR);
        dest.writeString(sMESSAGE);
        dest.writeString(sRESULT);
        dest.writeTypedList(lisInfo);
        dest.writeString(sID);
        dest.writeString(sEXCERCISE_ID);
        dest.writeString(sQUESTION_NUMBER);
        dest.writeString(sKIEU);
        dest.writeString(sHUONGDAN);
        dest.writeString(sTEXT);
        dest.writeString(sIMAGE_ID);
        dest.writeString(sAUDIO_ID);
        dest.writeString(sPATH_IMAGE);
        dest.writeString(sPATH_AUDIO);
        dest.writeString(sUPDATETIME);
        dest.writeString(mOption);
    }
}

