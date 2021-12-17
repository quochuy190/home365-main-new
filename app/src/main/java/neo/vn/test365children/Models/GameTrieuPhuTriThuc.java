package neo.vn.test365children.Models;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GameTrieuPhuTriThuc {
    @SerializedName("ID")
    String sID;
    @SerializedName("PART_ID")
    String sPART_ID;
    @SerializedName("QUESTION")
    String sQUESTION;
    @SerializedName("OPTION_A")
    String sOPTION_A;
    @SerializedName("OPTION_B")
    String sOPTION_B;
    @SerializedName("OPTION_C")
    String sOPTION_C;
    @SerializedName("OPTION_D")
    String sOPTION_D;
    @SerializedName("ANSWER")
    String sANSWER;
    @SerializedName("EXPLAIN")
    String sEXPLAIN;
    @SerializedName("HTML_CONTENT")
    String sHTML_CONTENT;
    @SerializedName("HTML_A")
    String sHTML_A;
    @SerializedName("HTML_B")
    String sHTML_B;
    @SerializedName("HTML_C")
    String sHTML_C;
    @SerializedName("HTML_D")
    String sHTML_D;
    @SerializedName("POINT")
    String sPOINT;
    @SerializedName("UPDATETIME")
    String sUPDATETIME;
    @SerializedName("CHILD_ID")
    String sCHILD_ID;
    @SerializedName("TAKEN")
    String sTAKEN;

    public GameTrieuPhuTriThuc() {
    }

    private static GameTrieuPhuTriThuc getObject(JSONObject jsonObject) {
        return new Gson().fromJson(jsonObject.toString(), GameTrieuPhuTriThuc.class);
    }

    public static ArrayList<GameTrieuPhuTriThuc> getList(String jsonArray) throws JSONException {
        ArrayList<GameTrieuPhuTriThuc> arrayList = new ArrayList<>();
        Type type = new TypeToken<List<GameTrieuPhuTriThuc>>() {
        }.getType();
        Gson gson = new Gson();
        arrayList = gson.fromJson(jsonArray, type);
        return arrayList;
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

    public String getsQUESTION() {
        return sQUESTION;
    }

    public void setsQUESTION(String sQUESTION) {
        this.sQUESTION = sQUESTION;
    }

    public String getsOPTION_A() {
        return sOPTION_A;
    }

    public void setsOPTION_A(String sOPTION_A) {
        this.sOPTION_A = sOPTION_A;
    }

    public String getsOPTION_B() {
        return sOPTION_B;
    }

    public void setsOPTION_B(String sOPTION_B) {
        this.sOPTION_B = sOPTION_B;
    }

    public String getsOPTION_C() {
        return sOPTION_C;
    }

    public void setsOPTION_C(String sOPTION_C) {
        this.sOPTION_C = sOPTION_C;
    }

    public String getsOPTION_D() {
        return sOPTION_D;
    }

    public void setsOPTION_D(String sOPTION_D) {
        this.sOPTION_D = sOPTION_D;
    }

    public String getsANSWER() {
        return sANSWER;
    }

    public void setsANSWER(String sANSWER) {
        this.sANSWER = sANSWER;
    }

    public String getsEXPLAIN() {
        return sEXPLAIN;
    }

    public void setsEXPLAIN(String sEXPLAIN) {
        this.sEXPLAIN = sEXPLAIN;
    }

    public String getsHTML_CONTENT() {
        return sHTML_CONTENT;
    }

    public void setsHTML_CONTENT(String sHTML_CONTENT) {
        this.sHTML_CONTENT = sHTML_CONTENT;
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

    public String getsPOINT() {
        return sPOINT;
    }

    public void setsPOINT(String sPOINT) {
        this.sPOINT = sPOINT;
    }

    public String getsUPDATETIME() {
        return sUPDATETIME;
    }

    public void setsUPDATETIME(String sUPDATETIME) {
        this.sUPDATETIME = sUPDATETIME;
    }

    public String getsCHILD_ID() {
        return sCHILD_ID;
    }

    public void setsCHILD_ID(String sCHILD_ID) {
        this.sCHILD_ID = sCHILD_ID;
    }

    public String getsTAKEN() {
        return sTAKEN;
    }

    public void setsTAKEN(String sTAKEN) {
        this.sTAKEN = sTAKEN;
    }
}
