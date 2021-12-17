package neo.vn.test365children.Models;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GameTNNL {
    @SerializedName("EXCERCISE_ID")
    String sEXCERCISE_ID;
    @SerializedName("ID")
    String sID;
    @SerializedName("PART_ID")
    String sPART_ID;
    @SerializedName("LEVEL_ID")
    String sLEVEL_ID;
    @SerializedName("HTML_A")
    String sHTML_A;
    @SerializedName("HTML_B")
    String sHTML_B;
    @SerializedName("HTML_C")
    String sHTML_C;
    @SerializedName("HTML_D")
    String sHTML_D;


    public GameTNNL() {
    }

    private static GameTNNL getObject(JSONObject jsonObject) {
        return new Gson().fromJson(jsonObject.toString(), GameTNNL.class);
    }

    public static ArrayList<GameTNNL> getList(String jsonArray) throws JSONException {
        ArrayList<GameTNNL> arrayList = new ArrayList<>();
        Type type = new TypeToken<List<GameTNNL>>() {
        }.getType();
        Gson gson = new Gson();
        arrayList = gson.fromJson(jsonArray, type);
        return arrayList;
    }

    public String getsEXCERCISE_ID() {
        return sEXCERCISE_ID;
    }

    public void setsEXCERCISE_ID(String sEXCERCISE_ID) {
        this.sEXCERCISE_ID = sEXCERCISE_ID;
    }

    public String getsID() {
        return sID;
    }

    public void setsID(String sID) {
        this.sID = sID;
    }

    public String getsPART_ID() {
        return sPART_ID;
    }

    public void setsPART_ID(String sPART_ID) {
        this.sPART_ID = sPART_ID;
    }

    public String getsHTML_A() {
        return sHTML_A;
    }

    public void setsHTML_A(String sHTML_A) {
        this.sHTML_A = sHTML_A;
    }

    public String getsHTML_B() {
        return sHTML_B;
    }

    public void setsHTML_B(String sHTML_B) {
        this.sHTML_B = sHTML_B;
    }

    public String getsHTML_C() {
        return sHTML_C;
    }

    public void setsHTML_C(String sHTML_C) {
        this.sHTML_C = sHTML_C;
    }

    public String getsHTML_D() {
        return sHTML_D;
    }

    public void setsHTML_D(String sHTML_D) {
        this.sHTML_D = sHTML_D;
    }

    public String getsLEVEL_ID() {
        return sLEVEL_ID;
    }

    public void setsLEVEL_ID(String sLEVEL_ID) {
        this.sLEVEL_ID = sLEVEL_ID;
    }
}

