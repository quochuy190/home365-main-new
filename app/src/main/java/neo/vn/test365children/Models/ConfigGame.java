package neo.vn.test365children.Models;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ConfigGame {
    @SerializedName("ERROR")
    String sERROR;
    @SerializedName("MESSAGE")
    String sMESSAGE;
    @SerializedName("MESSGE")
    String MESSGE;
    @SerializedName("RESULT")
    String sRESULT;
    @SerializedName("CHILD_ID")
    String CHILD_ID;
    @SerializedName("CHILD_NAME")
    String CHILD_NAME;
    @SerializedName("GAME_TPTT")
    String GAME_TPTT;
    @SerializedName("GAME_SUDOKU")
    String GAME_SUDOKU;
    @SerializedName("GAME_KOW")
    String GAME_KOW;
    @SerializedName("GAME_TNNL")
    String GAME_TNNL;

    public ConfigGame() {
    }

    private static ConfigGame getObject(JSONObject jsonObject) {
        return new Gson().fromJson(jsonObject.toString(), ConfigGame.class);
    }

    public static ArrayList<ConfigGame> getList(String jsonArray) throws JSONException {
        ArrayList<ConfigGame> arrayList = new ArrayList<>();
        Type type = new TypeToken<List<ConfigGame>>() {
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

    public String getCHILD_ID() {
        return CHILD_ID;
    }

    public void setCHILD_ID(String CHILD_ID) {
        this.CHILD_ID = CHILD_ID;
    }

    public String getCHILD_NAME() {
        return CHILD_NAME;
    }

    public void setCHILD_NAME(String CHILD_NAME) {
        this.CHILD_NAME = CHILD_NAME;
    }

    public String getGAME_TPTT() {
        return GAME_TPTT;
    }

    public void setGAME_TPTT(String GAME_TPTT) {
        this.GAME_TPTT = GAME_TPTT;
    }

    public String getGAME_SUDOKU() {
        return GAME_SUDOKU;
    }

    public void setGAME_SUDOKU(String GAME_SUDOKU) {
        this.GAME_SUDOKU = GAME_SUDOKU;
    }

    public String getGAME_KOW() {
        return GAME_KOW;
    }

    public void setGAME_KOW(String GAME_KOW) {
        this.GAME_KOW = GAME_KOW;
    }

    public String getGAME_TNNL() {
        return GAME_TNNL;
    }

    public void setGAME_TNNL(String GAME_TNNL) {
        this.GAME_TNNL = GAME_TNNL;
    }
}
