package neo.vn.test365children.Models;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class DesExercises {
    @SerializedName("ERROR")
    String sERROR;
    @SerializedName("MESSAGE")
    String sMESSAGE;
    @SerializedName("RESULT")
    String sRESULT;

    @SerializedName("ID")
    String sID;
    @SerializedName("WEEK_TEST_ID")
    String sWEEK_TEST_ID;
    @SerializedName("NAME")
    String sNAME;
    @SerializedName("UNDER_6_RECOMMENT")
    String sUNDER_6_RECOMMENT;
    @SerializedName("RECOMMENT_7_8")
    String sRECOMMENT_7_8;
    @SerializedName("RECOMMENT_9_10")
    String sRECOMMENT_9_10;

    @SerializedName("YEAR_NAME")
    String sYEAR_NAME;
    @SerializedName("LEVEL_ID")
    String sLEVEL_ID;
    @SerializedName("SUBJECT_ID")
    String sSUBJECT_ID;
    @SerializedName("WEEK_ID")
    String sWEEK_ID;
    @SerializedName("POINT")
    String sPOINT;

    @SerializedName("START_TAKE_TIME")
    String sSTART_TAKE_TIME;
    @SerializedName("END_TAKE_TIME")
    String sEND_TAKE_TIME;
    @SerializedName("DURATION")
    String sDURATION;
    @SerializedName("SUBMIT_TYPE")
    String sSUBMIT_TYPE;
    @SerializedName("RECOMMENT_MOTHER")
    String sRECOMMENT_MOTHER;

    @SerializedName("WORKHARD_POINT")
    String sWORKHARD_POINT;
    @SerializedName("STICKER_ID")
    String sSTICKER_ID;
    @SerializedName("IMPROMENT_POINT")
    String sIMPROMENT_POINT;
    @SerializedName("WEEK_NAME")
    String sWEEK_NAME;

    @SerializedName("cunglam")
    String scunglam;
    @SerializedName("cungtruong")
    String scungtruong;
    @SerializedName("cunglop")
    String scunglop;
    @SerializedName("caonhat")
    String scaonhat;
    @SerializedName("trungbinh")
    String strungbinh;
    @SerializedName("thapnhat")
    String sthapnhat;
    @SerializedName("ADMIN_COMMENT")
    String sADMIN_COMMENT;

    public DesExercises() {
    }

    public DesExercises(String sERROR, String sMESSAGE, String sRESULT, String sID, String sWEEK_TEST_ID, String sNAME, String sUNDER_6_RECOMMENT, String sRECOMMENT_7_8, String sRECOMMENT_9_10, String sYEAR_NAME, String sLEVEL_ID, String sSUBJECT_ID, String sWEEK_ID, String sPOINT, String scunglam, String scungtruong, String scunglop, String scaonhat, String strungbinh, String sthapnhat) {
        this.sERROR = sERROR;
        this.sMESSAGE = sMESSAGE;
        this.sRESULT = sRESULT;
        this.sID = sID;
        this.sWEEK_TEST_ID = sWEEK_TEST_ID;
        this.sNAME = sNAME;
        this.sUNDER_6_RECOMMENT = sUNDER_6_RECOMMENT;
        this.sRECOMMENT_7_8 = sRECOMMENT_7_8;
        this.sRECOMMENT_9_10 = sRECOMMENT_9_10;
        this.sYEAR_NAME = sYEAR_NAME;
        this.sLEVEL_ID = sLEVEL_ID;
        this.sSUBJECT_ID = sSUBJECT_ID;
        this.sWEEK_ID = sWEEK_ID;
        this.sPOINT = sPOINT;
        this.scunglam = scunglam;
        this.scungtruong = scungtruong;
        this.scunglop = scunglop;
        this.scaonhat = scaonhat;
        this.strungbinh = strungbinh;
        this.sthapnhat = sthapnhat;
    }

    private static DesExercises getObject(JSONObject jsonObject) {
        return new Gson().fromJson(jsonObject.toString(), DesExercises.class);
    }

    public static ArrayList<DesExercises> getList(String jsonArray) throws JSONException {
        ArrayList<DesExercises> arrayList = new ArrayList<>();
        Type type = new TypeToken<List<DesExercises>>() {
        }.getType();
        Gson gson = new Gson();
        arrayList = gson.fromJson(jsonArray, type);
        return arrayList;
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

    public String getsSUBMIT_TYPE() {
        return sSUBMIT_TYPE;
    }

    public void setsSUBMIT_TYPE(String sSUBMIT_TYPE) {
        this.sSUBMIT_TYPE = sSUBMIT_TYPE;
    }

    public String getsRECOMMENT_MOTHER() {
        return sRECOMMENT_MOTHER;
    }

    public void setsRECOMMENT_MOTHER(String sRECOMMENT_MOTHER) {
        this.sRECOMMENT_MOTHER = sRECOMMENT_MOTHER;
    }

    public String getsWORKHARD_POINT() {
        return sWORKHARD_POINT;
    }

    public void setsWORKHARD_POINT(String sWORKHARD_POINT) {
        this.sWORKHARD_POINT = sWORKHARD_POINT;
    }

    public String getsSTICKER_ID() {
        return sSTICKER_ID;
    }

    public void setsSTICKER_ID(String sSTICKER_ID) {
        this.sSTICKER_ID = sSTICKER_ID;
    }

    public String getsIMPROMENT_POINT() {
        return sIMPROMENT_POINT;
    }

    public void setsIMPROMENT_POINT(String sIMPROMENT_POINT) {
        this.sIMPROMENT_POINT = sIMPROMENT_POINT;
    }

    public String getsWEEK_NAME() {
        return sWEEK_NAME;
    }

    public void setsWEEK_NAME(String sWEEK_NAME) {
        this.sWEEK_NAME = sWEEK_NAME;
    }

    public String getsADMIN_COMMENT() {
        return sADMIN_COMMENT;
    }

    public void setsADMIN_COMMENT(String sADMIN_COMMENT) {
        this.sADMIN_COMMENT = sADMIN_COMMENT;
    }

    public String getsID() {
        return sID;
    }

    public void setsID(String sID) {
        this.sID = sID;
    }

    public String getsWEEK_TEST_ID() {
        return sWEEK_TEST_ID;
    }

    public void setsWEEK_TEST_ID(String sWEEK_TEST_ID) {
        this.sWEEK_TEST_ID = sWEEK_TEST_ID;
    }

    public String getsNAME() {
        return sNAME;
    }

    public void setsNAME(String sNAME) {
        this.sNAME = sNAME;
    }

    public String getsUNDER_6_RECOMMENT() {
        return sUNDER_6_RECOMMENT;
    }

    public void setsUNDER_6_RECOMMENT(String sUNDER_6_RECOMMENT) {
        this.sUNDER_6_RECOMMENT = sUNDER_6_RECOMMENT;
    }

    public String getsRECOMMENT_7_8() {
        return sRECOMMENT_7_8;
    }

    public void setsRECOMMENT_7_8(String sRECOMMENT_7_8) {
        this.sRECOMMENT_7_8 = sRECOMMENT_7_8;
    }

    public String getsRECOMMENT_9_10() {
        return sRECOMMENT_9_10;
    }

    public void setsRECOMMENT_9_10(String sRECOMMENT_9_10) {
        this.sRECOMMENT_9_10 = sRECOMMENT_9_10;
    }

    public String getsYEAR_NAME() {
        return sYEAR_NAME;
    }

    public void setsYEAR_NAME(String sYEAR_NAME) {
        this.sYEAR_NAME = sYEAR_NAME;
    }

    public String getsLEVEL_ID() {
        return sLEVEL_ID;
    }

    public void setsLEVEL_ID(String sLEVEL_ID) {
        this.sLEVEL_ID = sLEVEL_ID;
    }

    public String getsSUBJECT_ID() {
        return sSUBJECT_ID;
    }

    public void setsSUBJECT_ID(String sSUBJECT_ID) {
        this.sSUBJECT_ID = sSUBJECT_ID;
    }

    public String getsWEEK_ID() {
        return sWEEK_ID;
    }

    public void setsWEEK_ID(String sWEEK_ID) {
        this.sWEEK_ID = sWEEK_ID;
    }

    public String getsPOINT() {
        return sPOINT;
    }

    public void setsPOINT(String sPOINT) {
        this.sPOINT = sPOINT;
    }

    public String getScunglam() {
        return scunglam;
    }

    public void setScunglam(String scunglam) {
        this.scunglam = scunglam;
    }

    public String getScungtruong() {
        return scungtruong;
    }

    public void setScungtruong(String scungtruong) {
        this.scungtruong = scungtruong;
    }

    public String getScunglop() {
        return scunglop;
    }

    public void setScunglop(String scunglop) {
        this.scunglop = scunglop;
    }

    public String getScaonhat() {
        return scaonhat;
    }

    public void setScaonhat(String scaonhat) {
        this.scaonhat = scaonhat;
    }

    public String getStrungbinh() {
        return strungbinh;
    }

    public void setStrungbinh(String strungbinh) {
        this.strungbinh = strungbinh;
    }

    public String getSthapnhat() {
        return sthapnhat;
    }

    public void setSthapnhat(String sthapnhat) {
        this.sthapnhat = sthapnhat;
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
}

