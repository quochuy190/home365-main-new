package neo.vn.test365children.Models;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Item_BXH {
    @SerializedName("ERROR")
    String sERROR;
    @SerializedName("MESSAGE")
    String sMESSAGE;
    @SerializedName("RESULT")
    String sRESULT;

    @SerializedName("CHILD_ID")
    String sCHILD_ID;
    @SerializedName("USERNAME")
    String sUSERNAME;
    @SerializedName("FULLNAME")
    String sFULLNAME;
    @SerializedName("CLASS")
    String sCLASS;
    @SerializedName("AVATAR")
    String sAVATAR;
    @SerializedName("LEVEL_ID")
    String sLEVEL_ID;
    @SerializedName("LEVEL_NAME")
    String sLEVEL_NAME;
    @SerializedName("SCHOOL_ID")
    String sSCHOOL_ID;
    @SerializedName("SCHOOL_NAME")
    String sSCHOOL_NAME;

    @SerializedName("WEEK_ID")
    String sWEEK_ID;
    @SerializedName("DTB")
    String sDTB;
    @SerializedName("SPEED")
    String sSPEED;
    @SerializedName("SL")
    String sSL;
    public Item_BXH() {
    }


    private static Item_BXH getObject (JSONObject jsonObject){
        return new Gson().fromJson(jsonObject.toString(),Item_BXH.class);
    }

    public  static ArrayList<Item_BXH> getList(String jsonArray) throws JSONException {
        ArrayList<Item_BXH> arrayList = new ArrayList<>();
        Type type = new TypeToken<List<Item_BXH>>(){}.getType();
        Gson gson= new Gson();
        arrayList = gson.fromJson(jsonArray,type);
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

    public String getsCHILD_ID() {
        return sCHILD_ID;
    }

    public void setsCHILD_ID(String sCHILD_ID) {
        this.sCHILD_ID = sCHILD_ID;
    }

    public String getsUSERNAME() {
        return sUSERNAME;
    }

    public void setsUSERNAME(String sUSERNAME) {
        this.sUSERNAME = sUSERNAME;
    }

    public String getsFULLNAME() {
        return sFULLNAME;
    }

    public void setsFULLNAME(String sFULLNAME) {
        this.sFULLNAME = sFULLNAME;
    }

    public String getsCLASS() {
        return sCLASS;
    }

    public void setsCLASS(String sCLASS) {
        this.sCLASS = sCLASS;
    }

    public String getsAVATAR() {
        return sAVATAR;
    }

    public void setsAVATAR(String sAVATAR) {
        this.sAVATAR = sAVATAR;
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

    public String getsSCHOOL_ID() {
        return sSCHOOL_ID;
    }

    public void setsSCHOOL_ID(String sSCHOOL_ID) {
        this.sSCHOOL_ID = sSCHOOL_ID;
    }

    public String getsSCHOOL_NAME() {
        return sSCHOOL_NAME;
    }

    public void setsSCHOOL_NAME(String sSCHOOL_NAME) {
        this.sSCHOOL_NAME = sSCHOOL_NAME;
    }

    public String getsWEEK_ID() {
        return sWEEK_ID;
    }

    public void setsWEEK_ID(String sWEEK_ID) {
        this.sWEEK_ID = sWEEK_ID;
    }

    public String getsDTB() {
        return sDTB;
    }

    public void setsDTB(String sDTB) {
        this.sDTB = sDTB;
    }

    public String getsSPEED() {
        return sSPEED;
    }

    public void setsSPEED(String sSPEED) {
        this.sSPEED = sSPEED;
    }

    public String getsSL() {
        return sSL;
    }

    public void setsSL(String sSL) {
        this.sSL = sSL;
    }
}