package neo.vn.test365children.Models;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Sticker {
    @SerializedName("ERROR")
    String sERROR;
    @SerializedName("MESSAGE")
    String sMESSAGE;
    @SerializedName("RESULT")
    String sRESULT;

    @SerializedName("ID")
    String sID;
    @SerializedName("LEVEL_ID")
    String sLEVEL_ID;
    @SerializedName("IMAGE_ID")
    String sIMAGE_ID;
    @SerializedName("LABEL")
    String sLABEL;
    @SerializedName("FILENAME")
    String sFILENAME;
    @SerializedName("PATH")
    String sPATH;

    public Sticker() {
    }

    private static Sticker getObject(JSONObject jsonObject) {
        return new Gson().fromJson(jsonObject.toString(), Sticker.class);
    }

    public static ArrayList<Sticker> getList(String jsonArray) throws JSONException {
        ArrayList<Sticker> arrayList = new ArrayList<>();
        Type type = new TypeToken<List<Sticker>>() {
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

    public String getsLEVEL_ID() {
        return sLEVEL_ID;
    }

    public void setsLEVEL_ID(String sLEVEL_ID) {
        this.sLEVEL_ID = sLEVEL_ID;
    }

    public String getsIMAGE_ID() {
        return sIMAGE_ID;
    }

    public void setsIMAGE_ID(String sIMAGE_ID) {
        this.sIMAGE_ID = sIMAGE_ID;
    }

    public String getsLABEL() {
        return sLABEL;
    }

    public void setsLABEL(String sLABEL) {
        this.sLABEL = sLABEL;
    }

    public String getsFILENAME() {
        return sFILENAME;
    }

    public void setsFILENAME(String sFILENAME) {
        this.sFILENAME = sFILENAME;
    }

    public String getsPATH() {
        return sPATH;
    }

    public void setsPATH(String sPATH) {
        this.sPATH = sPATH;
    }
}

