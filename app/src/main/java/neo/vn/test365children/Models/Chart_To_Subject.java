package neo.vn.test365children.Models;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Chart_To_Subject {
    @SerializedName("ERROR")
    String sERROR;
    @SerializedName("MESSAGE")
    String sMESSAGE;
    @SerializedName("RESULT")
    String sRESULT;

    @SerializedName("ID")
    String sID;
    @SerializedName("YEAR_ID")
    String sYEAR_ID;
    @SerializedName("LEVEL_ID")
    String sLEVEL_ID;
    @SerializedName("LEVEL_NAME")
    String sLEVEL_NAME;
    @SerializedName("WEEK_ID")
    String sWEEK_ID;
    @SerializedName("WEEK_NAME")
    String sWEEK_NAME;
    @SerializedName("SUBJECT_ID")
    String sSUBJECT_ID;
    @SerializedName("SUBJECT_NAME")
    String sSUBJECT_NAME;
    @SerializedName("CHILD_ID")
    String sCHILD_ID;
    @SerializedName("START_TAKE_TIME")
    String sSTART_TAKE_TIME;
    @SerializedName("END_TAKE_TIME")
    String sEND_TAKE_TIME;
    @SerializedName("DURATION")
    String sDURATION;
    @SerializedName("POINT")
    String sPOINT;

    public Chart_To_Subject() {
    }

    private static Chart_To_Subject getObject(JSONObject jsonObject) {
        return new Gson().fromJson(jsonObject.toString(), Chart_To_Subject.class);
    }

    public static ArrayList<Chart_To_Subject> getList(String jsonArray) throws JSONException {
        ArrayList<Chart_To_Subject> arrayList = new ArrayList<>();
        Type type = new TypeToken<List<Chart_To_Subject>>() {
        }.getType();
        Gson gson = new Gson();
        arrayList = gson.fromJson(jsonArray, type);
        return arrayList;
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

    public String getsID() {
        return sID;
    }

    public void setsID(String sID) {
        this.sID = sID;
    }

    public String getsYEAR_ID() {
        return sYEAR_ID;
    }

    public void setsYEAR_ID(String sYEAR_ID) {
        this.sYEAR_ID = sYEAR_ID;
    }

    public String getsLEVEL_ID() {
        return sLEVEL_ID;
    }

    public void setsLEVEL_ID(String sLEVEL_ID) {
        this.sLEVEL_ID = sLEVEL_ID;
    }

    public String getsLEVEL_NAME() {
        return sLEVEL_NAME;
    }

    public void setsLEVEL_NAME(String sLEVEL_NAME) {
        this.sLEVEL_NAME = sLEVEL_NAME;
    }

    public String getsWEEK_ID() {
        return sWEEK_ID;
    }

    public void setsWEEK_ID(String sWEEK_ID) {
        this.sWEEK_ID = sWEEK_ID;
    }

    public String getsWEEK_NAME() {
        return sWEEK_NAME;
    }

    public void setsWEEK_NAME(String sWEEK_NAME) {
        this.sWEEK_NAME = sWEEK_NAME;
    }

    public String getsSUBJECT_ID() {
        return sSUBJECT_ID;
    }

    public void setsSUBJECT_ID(String sSUBJECT_ID) {
        this.sSUBJECT_ID = sSUBJECT_ID;
    }

    public String getsSUBJECT_NAME() {
        return sSUBJECT_NAME;
    }

    public void setsSUBJECT_NAME(String sSUBJECT_NAME) {
        this.sSUBJECT_NAME = sSUBJECT_NAME;
    }

    public String getsCHILD_ID() {
        return sCHILD_ID;
    }

    public void setsCHILD_ID(String sCHILD_ID) {
        this.sCHILD_ID = sCHILD_ID;
    }

    public String getsSTART_TAKE_TIME() {
        return sSTART_TAKE_TIME;
    }

    public void setsSTART_TAKE_TIME(String sSTART_TAKE_TIME) {
        this.sSTART_TAKE_TIME = sSTART_TAKE_TIME;
    }

    public String getsEND_TAKE_TIME() {
        return sEND_TAKE_TIME;
    }

    public void setsEND_TAKE_TIME(String sEND_TAKE_TIME) {
        this.sEND_TAKE_TIME = sEND_TAKE_TIME;
    }

    public String getsDURATION() {
        return sDURATION;
    }

    public void setsDURATION(String sDURATION) {
        this.sDURATION = sDURATION;
    }

    public String getsPOINT() {
        return sPOINT;
    }

    public void setsPOINT(String sPOINT) {
        this.sPOINT = sPOINT;
    }
}

