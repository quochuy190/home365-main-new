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

/**
 * @author Quốc Huy
 * @version 1.0.0
 * @description
 * @desc Developer NEO Company.
 * @created 7/11/2018
 * @updated 7/11/2018
 * @modified by
 * @updated on 7/11/2018
 * @since 1.0
 */
public class City implements Serializable {
    @SerializedName("ERROR")
    String sERROR;
    @SerializedName("MESSAGE")
    String sMESSAGE;
    @SerializedName("RESULT")
    String sRESULT;
    @SerializedName("ID")
    String sID;
    @SerializedName("PROVINCE_NAME")
    String sPROVINCE_NAME;

    public City(String sERROR, String sMESSAGE, String sRESULT, String sID, String sDISTRICT_NAME) {
        this.sERROR = sERROR;
        this.sMESSAGE = sMESSAGE;
        this.sRESULT = sRESULT;
        this.sID = sID;
        this.sPROVINCE_NAME = sDISTRICT_NAME;
    }

    public City(String sID, String sPROVINCE_NAME) {
        this.sID = sID;
        this.sPROVINCE_NAME = sPROVINCE_NAME;
    }

    public City() {
    }
    private static City getObject(JSONObject jsonObject) {
        return new Gson().fromJson(jsonObject.toString(), City.class);
    }

    public static ArrayList<City> getList(String jsonArray) throws JSONException {
        ArrayList<City> arrayList = new ArrayList<>();
        Type type = new TypeToken<List<City>>() {
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

    public String getsPROVINCE_NAME() {
        return sPROVINCE_NAME;
    }

    public void setsPROVINCE_NAME(String sPROVINCE_NAME) {
        this.sPROVINCE_NAME = sPROVINCE_NAME;
    }
}
