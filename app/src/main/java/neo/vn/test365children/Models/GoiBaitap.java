package neo.vn.test365children.Models;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GoiBaitap implements Serializable {
    @SerializedName("ERROR")
    String sERROR;
    @SerializedName("MESSAGE")
    String sMESSAGE;
    @SerializedName("MESSGE")
    String MESSGE;
    @SerializedName("RESULT")
    String sRESULT;
    @SerializedName("ID")
    String ID;
    @SerializedName("CODE")
    String CODE;
    @SerializedName("NAME")
    String NAME;
    @SerializedName("DESCRIPTION")
    String DESCRIPTION;
    @SerializedName("SERVICE_NUMBER")
    String SERVICE_NUMBER;
    @SerializedName("SERVICE_CMC")
    String SERVICE_CMC;
    @SerializedName("INSTRUCTION")
    String INSTRUCTION;
    @SerializedName("LEVEL_ID")
    String LEVEL_ID;
    @SerializedName("LEVEL_NAME")
    String LEVEL_NAME;
    @SerializedName("SUBJECT_ID")
    String SUBJECT_ID;
    @SerializedName("SUBJECT_NAME")
    String SUBJECT_NAME;
    @SerializedName("EXCERCISE_LIST")
    String EXCERCISE_LIST;
    @SerializedName("USER_ACTIVE")
    String USER_ACTIVE;
    @SerializedName("ACTIVE_STATE")
    String ACTIVE_STATE; //0 chưa active, 1 đã active


    public GoiBaitap() {
    }

    private static GoiBaitap getObject(JSONObject jsonObject) {
        return new Gson().fromJson(jsonObject.toString(), GoiBaitap.class);
    }

    public static ArrayList<GoiBaitap> getList(String jsonArray) throws JSONException {
        ArrayList<GoiBaitap> arrayList = new ArrayList<>();
        Type type = new TypeToken<List<GoiBaitap>>() {
        }.getType();
        Gson gson = new Gson();
        arrayList = gson.fromJson(jsonArray, type);
        return arrayList;
    }


    public String getMESSGE() {
        return MESSGE;
    }

    public void setMESSGE(String MESSGE) {
        this.MESSGE = MESSGE;
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

    public String getCODE() {
        return CODE;
    }

    public void setCODE(String CODE) {
        this.CODE = CODE;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public String getSERVICE_NUMBER() {
        return SERVICE_NUMBER;
    }

    public void setSERVICE_NUMBER(String SERVICE_NUMBER) {
        this.SERVICE_NUMBER = SERVICE_NUMBER;
    }

    public String getSERVICE_CMC() {
        return SERVICE_CMC;
    }

    public void setSERVICE_CMC(String SERVICE_CMC) {
        this.SERVICE_CMC = SERVICE_CMC;
    }

    public String getINSTRUCTION() {
        return INSTRUCTION;
    }

    public void setINSTRUCTION(String INSTRUCTION) {
        this.INSTRUCTION = INSTRUCTION;
    }

    public String getLEVEL_ID() {
        return LEVEL_ID;
    }

    public void setLEVEL_ID(String LEVEL_ID) {
        this.LEVEL_ID = LEVEL_ID;
    }

    public String getLEVEL_NAME() {
        return LEVEL_NAME;
    }

    public void setLEVEL_NAME(String LEVEL_NAME) {
        this.LEVEL_NAME = LEVEL_NAME;
    }

    public String getSUBJECT_ID() {
        return SUBJECT_ID;
    }

    public void setSUBJECT_ID(String SUBJECT_ID) {
        this.SUBJECT_ID = SUBJECT_ID;
    }

    public String getSUBJECT_NAME() {
        return SUBJECT_NAME;
    }

    public void setSUBJECT_NAME(String SUBJECT_NAME) {
        this.SUBJECT_NAME = SUBJECT_NAME;
    }

    public String getEXCERCISE_LIST() {
        return EXCERCISE_LIST;
    }

    public void setEXCERCISE_LIST(String EXCERCISE_LIST) {
        this.EXCERCISE_LIST = EXCERCISE_LIST;
    }

    public String getUSER_ACTIVE() {
        return USER_ACTIVE;
    }

    public void setUSER_ACTIVE(String USER_ACTIVE) {
        this.USER_ACTIVE = USER_ACTIVE;
    }

    public String getACTIVE_STATE() {
        return ACTIVE_STATE;
    }

    public void setACTIVE_STATE(String ACTIVE_STATE) {
        this.ACTIVE_STATE = ACTIVE_STATE;
    }
}
