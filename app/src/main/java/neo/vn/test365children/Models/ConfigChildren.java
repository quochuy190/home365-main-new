package neo.vn.test365children.Models;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ConfigChildren {
    @SerializedName("ERROR")
    String sERROR;
    @SerializedName("MESSAGE")
    String sMESSAGE;
    @SerializedName("RESULT")
    String sRESULT;
    @SerializedName("ID")
    String sID;
    @SerializedName("CHILD_ID")
    String sCHILD_ID;
    @SerializedName("MATH_TAKEN_TIME")
    String sMATH_TAKEN_TIME;
    @SerializedName("MATH_DY")
    String sMATH_DY;
    @SerializedName("MATH_NOTIFY")
    String sMATH_NOTIFY;
    @SerializedName("MATH_TAKEN_DURATION")
    String sMATH_TAKEN_DURATION;
    @SerializedName("VIETNAMESE_TAKEN_TIME")
    String sVIETNAMESE_TAKEN_TIME;
    @SerializedName("VIETNAMESE_DY")
    String sVIETNAMESE_DY;
    @SerializedName("VIETNAMESE_NOTIFY")
    String sVIETNAMESE_NOTIFY;

    @SerializedName("VIETNAMESE_TAKEN_DURATION")
    String sVIETNAMESE_TAKEN_DURATION;
    @SerializedName("ENGLISH_TAKEN_TIME")
    String sENGLISH_TAKEN_TIME;
    @SerializedName("ENGLISH_DY")
    String sENGLISH_DY;
    @SerializedName("ENGLISH_NOTIFY")
    String sENGLISH_NOTIFY;
    @SerializedName("ENGLISH_TAKEN_DURATION")
    String sENGLISH_TAKEN_DURATION;
    @SerializedName("GAME_TO_OPEN")
    String sGAME_TO_OPEN;

    public ConfigChildren() {
    }

    private static ConfigChildren getObject(JSONObject jsonObject) {
        return new Gson().fromJson(jsonObject.toString(), ConfigChildren.class);
    }

    public static ArrayList<ConfigChildren> getList(String jsonArray) throws JSONException {
        ArrayList<ConfigChildren> arrayList = new ArrayList<>();
        Type type = new TypeToken<List<ConfigChildren>>() {
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

    public String getsCHILD_ID() {
        return sCHILD_ID;
    }

    public void setsCHILD_ID(String sCHILD_ID) {
        this.sCHILD_ID = sCHILD_ID;
    }

    public String getsMATH_TAKEN_TIME() {
        return sMATH_TAKEN_TIME;
    }

    public void setsMATH_TAKEN_TIME(String sMATH_TAKEN_TIME) {
        this.sMATH_TAKEN_TIME = sMATH_TAKEN_TIME;
    }

    public String getsMATH_DY() {
        return sMATH_DY;
    }

    public void setsMATH_DY(String sMATH_DY) {
        this.sMATH_DY = sMATH_DY;
    }

    public String getsMATH_NOTIFY() {
        return sMATH_NOTIFY;
    }

    public void setsMATH_NOTIFY(String sMATH_NOTIFY) {
        this.sMATH_NOTIFY = sMATH_NOTIFY;
    }

    public String getsMATH_TAKEN_DURATION() {
        return sMATH_TAKEN_DURATION;
    }

    public void setsMATH_TAKEN_DURATION(String sMATH_TAKEN_DURATION) {
        this.sMATH_TAKEN_DURATION = sMATH_TAKEN_DURATION;
    }

    public String getsVIETNAMESE_TAKEN_TIME() {
        return sVIETNAMESE_TAKEN_TIME;
    }

    public void setsVIETNAMESE_TAKEN_TIME(String sVIETNAMESE_TAKEN_TIME) {
        this.sVIETNAMESE_TAKEN_TIME = sVIETNAMESE_TAKEN_TIME;
    }

    public String getsVIETNAMESE_DY() {
        return sVIETNAMESE_DY;
    }

    public void setsVIETNAMESE_DY(String sVIETNAMESE_DY) {
        this.sVIETNAMESE_DY = sVIETNAMESE_DY;
    }

    public String getsVIETNAMESE_NOTIFY() {
        return sVIETNAMESE_NOTIFY;
    }

    public void setsVIETNAMESE_NOTIFY(String sVIETNAMESE_NOTIFY) {
        this.sVIETNAMESE_NOTIFY = sVIETNAMESE_NOTIFY;
    }

    public String getsVIETNAMESE_TAKEN_DURATION() {
        return sVIETNAMESE_TAKEN_DURATION;
    }

    public void setsVIETNAMESE_TAKEN_DURATION(String sVIETNAMESE_TAKEN_DURATION) {
        this.sVIETNAMESE_TAKEN_DURATION = sVIETNAMESE_TAKEN_DURATION;
    }

    public String getsENGLISH_TAKEN_TIME() {
        return sENGLISH_TAKEN_TIME;
    }

    public void setsENGLISH_TAKEN_TIME(String sENGLISH_TAKEN_TIME) {
        this.sENGLISH_TAKEN_TIME = sENGLISH_TAKEN_TIME;
    }

    public String getsENGLISH_DY() {
        return sENGLISH_DY;
    }

    public void setsENGLISH_DY(String sENGLISH_DY) {
        this.sENGLISH_DY = sENGLISH_DY;
    }

    public String getsENGLISH_NOTIFY() {
        return sENGLISH_NOTIFY;
    }

    public void setsENGLISH_NOTIFY(String sENGLISH_NOTIFY) {
        this.sENGLISH_NOTIFY = sENGLISH_NOTIFY;
    }

    public String getsENGLISH_TAKEN_DURATION() {
        return sENGLISH_TAKEN_DURATION;
    }

    public void setsENGLISH_TAKEN_DURATION(String sENGLISH_TAKEN_DURATION) {
        this.sENGLISH_TAKEN_DURATION = sENGLISH_TAKEN_DURATION;
    }

    public String getsGAME_TO_OPEN() {
        return sGAME_TO_OPEN;
    }

    public void setsGAME_TO_OPEN(String sGAME_TO_OPEN) {
        this.sGAME_TO_OPEN = sGAME_TO_OPEN;
    }
}

