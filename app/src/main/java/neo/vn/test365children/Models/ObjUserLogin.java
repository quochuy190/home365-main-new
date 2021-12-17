package neo.vn.test365children.Models;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ObjUserLogin {
    @SerializedName("ERROR")
    String sERROR;
    @SerializedName("MESSAGE")
    String sMESSAGE;
    @SerializedName("MESSGE")
    String MESSGE;
    @SerializedName("RESULT")
    String sRESULT;
    @SerializedName("USER_MOTHER")
    String USER_MOTHER;
    @SerializedName("USER_CHILD")
    String USER_CHILD;
    @SerializedName("PASSWORD")
    String PASSWORD;

    public ObjUserLogin() {
    }

    private static ObjUserLogin getObject(JSONObject jsonObject) {
        return new Gson().fromJson(jsonObject.toString(), ObjUserLogin.class);
    }

    public static ArrayList<ObjUserLogin> getList(String jsonArray) throws JSONException {
        ArrayList<ObjUserLogin> arrayList = new ArrayList<>();
        Type type = new TypeToken<List<ObjUserLogin>>() {
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

    public String getUSER_MOTHER() {
        return USER_MOTHER;
    }

    public void setUSER_MOTHER(String USER_MOTHER) {
        this.USER_MOTHER = USER_MOTHER;
    }

    public String getUSER_CHILD() {
        return USER_CHILD;
    }

    public void setUSER_CHILD(String USER_CHILD) {
        this.USER_CHILD = USER_CHILD;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }
}
