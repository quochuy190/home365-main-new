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
 * @created 7/31/2018
 * @updated 7/31/2018
 * @modified by
 * @updated on 7/31/2018
 * @since 1.0
 */
public class ObjLogin implements Serializable {
    @SerializedName("ERROR")
    private String sERROR;
    @SerializedName("MESSAGE")
    private String sMESSAGE;
    @SerializedName("RESULT")
    private String sRESULT;
    @SerializedName("ERR_DETAILS")
    private ErrorDetail sERR_DETAILS;
    @SerializedName("TOKEN")
    private String sTOKEN;
    @SerializedName("INFO")
    private InfoKids sObjInfoKid;

    public ObjLogin() {
    }

    public ObjLogin(String sERROR, String sMESSAGE) {
        this.sERROR = sERROR;
        this.sMESSAGE = sMESSAGE;
    }

    private static ObjLogin getObject(JSONObject jsonObject) {
        return new Gson().fromJson(jsonObject.toString(), ObjLogin.class);
    }

    public static ArrayList<ObjLogin> getList(String jsonArray) throws JSONException {
        ArrayList<ObjLogin> arrayList = new ArrayList<>();
        Type type = new TypeToken<List<ObjLogin>>() {
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

    public String getsTOKEN() {
        return sTOKEN;
    }

    public void setsTOKEN(String sTOKEN) {
        this.sTOKEN = sTOKEN;
    }

    public InfoKids getsObjInfoKid() {
        return sObjInfoKid;
    }

    public void setsObjInfoKid(InfoKids sObjInfoKid) {
        this.sObjInfoKid = sObjInfoKid;
    }

    public ErrorDetail getsERR_DETAILS() {
        return sERR_DETAILS;
    }

    public void setsERR_DETAILS(ErrorDetail sERR_DETAILS) {
        this.sERR_DETAILS = sERR_DETAILS;
    }
}
