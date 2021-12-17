package neo.vn.test365children.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class CauhoiDetail extends RealmObject implements Parcelable, Serializable {
    @SerializedName("ERROR")
    String sERROR;
    @SerializedName("MESSAGE")
    String sMESSAGE;
    @SerializedName("RESULT")
    String sRESULT;
    @PrimaryKey
    @SerializedName("ID")
    String sID;
    @SerializedName("PART_ID")
    String sPART_ID;
    @SerializedName("QUESTION")
    String sQUESTION;
    @SerializedName("A")
    String sA;
    @SerializedName("B")
    String sB;
    @SerializedName("C")
    String sC;
    @SerializedName("D")
    String sD;
    @SerializedName("ANSWER")
    String sANSWER;
    @SerializedName("EXPLAIN")
    String sEXPLAIN;
    @SerializedName("UPDATETIME")
    String sUPDATETIME;
    @SerializedName("TYPE")
    String sTYPE;
    @SerializedName("ANSWER_CHILD")
    String sANSWER_CHILD;
    @SerializedName("RESULT_CHILD")
    String sRESULT_CHILD;
    @SerializedName("POINT_CHILD")
    String sPOINT_CHILD;
    @SerializedName("EGG_1")
    String sEGG_1;
    @SerializedName("EGG_2")
    String sEGG_2;
    @SerializedName("EGG_3")
    String sEGG_3;
    @SerializedName("EGG_4")
    String sEGG_4;
    @SerializedName("POINT")
    String sPOINT;
    @SerializedName("EGG_1_RESULT")
    String sEGG_1_RESULT;
    @SerializedName("EGG_2_RESULT")
    String sEGG_2_RESULT;
    @SerializedName("EGG_3_RESULT")
    String sEGG_3_RESULT;
    @SerializedName("EGG_4_RESULT")
    String sEGG_4_RESULT;

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

    String sImagePath;
    String sAudioPath;
    String sCauhoi_huongdan;
    String sNumberDe;
    String sSubNumberCau;
    String sTextDebai;
    boolean mLeft;
    boolean mRight;
    boolean isAnserTrue;
    boolean isDalam;
    String sAnwserChil_Dientu_1;
    String sAnwserChil_Dientu_2;
    String sAnwserChil_Dientu_3;
    String sAnwserChil_Dientu_5;
    String sAnwserChil_Dientu_4;
    String sAnwserChil_Dientu_6;
    String sAnwserChil_Dientu_7;
    String sAnwserChil_Dientu_8;
    String sAnwserChil_Dientu_9;
    String sAnwserChil_Dientu_10;
    String sAnwserChil_Dientu_11;
    String sAnwserChil_Dientu_12;
    String sAnwserChil_Dientu_13;
    String sAnwserChil_Dientu_15;
    String sAnwserChil_Dientu_14;
    String sAnwserChil_Dientu_16;
    String sAnwserChil_Dientu_17;
    String sAnwserChil_Dientu_18;
    String sAnwserChil_Dientu_19;
    String sAnwserChil_Dientu_20;
    String sAnwserChil_Dientu_21;
    String sAnwserChil_Dientu_22;
    String sAnwserChil_Dientu_23;
    String sAnwserChil_Dientu_24;
    String sAnwserChil_Dientu_25;
    float fTempPoint;

    public CauhoiDetail(String sERROR, String sMESSAGE, String sRESULT) {
        this.sERROR = sERROR;
        this.sMESSAGE = sMESSAGE;
        this.sRESULT = sRESULT;
    }

    public CauhoiDetail() {
    }

    protected CauhoiDetail(Parcel in) {
        sERROR = in.readString();
        sMESSAGE = in.readString();
        sRESULT = in.readString();
    }

    public static final Creator<CauhoiDetail> CREATOR = new Creator<CauhoiDetail>() {
        @Override
        public CauhoiDetail createFromParcel(Parcel in) {
            return new CauhoiDetail(in);
        }

        @Override
        public CauhoiDetail[] newArray(int size) {
            return new CauhoiDetail[size];
        }
    };

    private static CauhoiDetail getObject(JSONObject jsonObject) {
        return new Gson().fromJson(jsonObject.toString(), CauhoiDetail.class);
    }

    public static ArrayList<CauhoiDetail> getList(String jsonArray) throws JSONException {
        ArrayList<CauhoiDetail> arrayList = new ArrayList<>();
        Type type = new TypeToken<List<CauhoiDetail>>() {
        }.getType();
        Gson gson = new Gson();
        arrayList = gson.fromJson(jsonArray, type);
        return arrayList;
    }

    public float getfTempPoint() {
        return fTempPoint;
    }

    public void setfTempPoint(float fTempPoint) {
        this.fTempPoint = fTempPoint;
    }

    public String getsAnwserChil_Dientu_1() {
        return sAnwserChil_Dientu_1;
    }

    public void setsAnwserChil_Dientu_1(String sAnwserChil_Dientu_1) {
        this.sAnwserChil_Dientu_1 = sAnwserChil_Dientu_1;
    }

    public String getsAnwserChil_Dientu_2() {
        return sAnwserChil_Dientu_2;
    }

    public void setsAnwserChil_Dientu_2(String sAnwserChil_Dientu_2) {
        this.sAnwserChil_Dientu_2 = sAnwserChil_Dientu_2;
    }

    public String getsAnwserChil_Dientu_3() {
        return sAnwserChil_Dientu_3;
    }

    public void setsAnwserChil_Dientu_3(String sAnwserChil_Dientu_3) {
        this.sAnwserChil_Dientu_3 = sAnwserChil_Dientu_3;
    }

    public String getsAnwserChil_Dientu_5() {
        return sAnwserChil_Dientu_5;
    }

    public void setsAnwserChil_Dientu_5(String sAnwserChil_Dientu_5) {
        this.sAnwserChil_Dientu_5 = sAnwserChil_Dientu_5;
    }

    public String getsAnwserChil_Dientu_4() {
        return sAnwserChil_Dientu_4;
    }

    public void setsAnwserChil_Dientu_4(String sAnwserChil_Dientu_4) {
        this.sAnwserChil_Dientu_4 = sAnwserChil_Dientu_4;
    }

    public String getsAnwserChil_Dientu_6() {
        return sAnwserChil_Dientu_6;
    }

    public void setsAnwserChil_Dientu_6(String sAnwserChil_Dientu_6) {
        this.sAnwserChil_Dientu_6 = sAnwserChil_Dientu_6;
    }

    public String getsAnwserChil_Dientu_7() {
        return sAnwserChil_Dientu_7;
    }

    public void setsAnwserChil_Dientu_7(String sAnwserChil_Dientu_7) {
        this.sAnwserChil_Dientu_7 = sAnwserChil_Dientu_7;
    }

    public String getsAnwserChil_Dientu_8() {
        return sAnwserChil_Dientu_8;
    }

    public void setsAnwserChil_Dientu_8(String sAnwserChil_Dientu_8) {
        this.sAnwserChil_Dientu_8 = sAnwserChil_Dientu_8;
    }

    public String getsAnwserChil_Dientu_9() {
        return sAnwserChil_Dientu_9;
    }

    public void setsAnwserChil_Dientu_9(String sAnwserChil_Dientu_9) {
        this.sAnwserChil_Dientu_9 = sAnwserChil_Dientu_9;
    }

    public String getsAnwserChil_Dientu_10() {
        return sAnwserChil_Dientu_10;
    }

    public void setsAnwserChil_Dientu_10(String sAnwserChil_Dientu_10) {
        this.sAnwserChil_Dientu_10 = sAnwserChil_Dientu_10;
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

    public boolean isAnserTrue() {
        return isAnserTrue;
    }

    public void setAnserTrue(boolean anserTrue) {
        isAnserTrue = anserTrue;
    }

    public boolean isDalam() {
        return isDalam;
    }

    public void setDalam(boolean dalam) {
        isDalam = dalam;
    }

    public String getsImagePath() {
        return sImagePath;
    }

    public void setsImagePath(String sImagePath) {
        this.sImagePath = sImagePath;
    }

    public String getsAudioPath() {
        return sAudioPath;
    }

    public void setsAudioPath(String sAudioPath) {
        this.sAudioPath = sAudioPath;
    }

    public String getsSubNumberCau() {
        return sSubNumberCau;
    }

    public void setsSubNumberCau(String sSubNumberCau) {
        this.sSubNumberCau = sSubNumberCau;
    }

    public String getsTextDebai() {
        return sTextDebai;
    }

    public void setsTextDebai(String sTextDebai) {
        this.sTextDebai = sTextDebai;
    }

    public String getsNumberDe() {
        return sNumberDe;
    }

    public void setsNumberDe(String sNumberDe) {
        this.sNumberDe = sNumberDe;
    }

    public String getsCauhoi_huongdan() {
        return sCauhoi_huongdan;
    }

    public void setsCauhoi_huongdan(String sCauhoi_huongdan) {
        this.sCauhoi_huongdan = sCauhoi_huongdan;
    }

    public String getsEGG_1() {
        return sEGG_1;
    }

    public void setsEGG_1(String sEGG_1) {
        this.sEGG_1 = sEGG_1;
    }

    public String getsEGG_2() {
        return sEGG_2;
    }

    public void setsEGG_2(String sEGG_2) {
        this.sEGG_2 = sEGG_2;
    }

    public String getsEGG_3() {
        return sEGG_3;
    }

    public void setsEGG_3(String sEGG_3) {
        this.sEGG_3 = sEGG_3;
    }

    public String getsEGG_4() {
        return sEGG_4;
    }

    public void setsEGG_4(String sEGG_4) {
        this.sEGG_4 = sEGG_4;
    }

    public String getsPOINT() {
        return sPOINT;
    }

    public void setsPOINT(String sPOINT) {
        this.sPOINT = sPOINT;
    }

    public String getsEGG_1_RESULT() {
        return sEGG_1_RESULT;
    }

    public void setsEGG_1_RESULT(String sEGG_1_RESULT) {
        this.sEGG_1_RESULT = sEGG_1_RESULT;
    }

    public String getsEGG_2_RESULT() {
        return sEGG_2_RESULT;
    }

    public void setsEGG_2_RESULT(String sEGG_2_RESULT) {
        this.sEGG_2_RESULT = sEGG_2_RESULT;
    }

    public String getsEGG_3_RESULT() {
        return sEGG_3_RESULT;
    }

    public void setsEGG_3_RESULT(String sEGG_3_RESULT) {
        this.sEGG_3_RESULT = sEGG_3_RESULT;
    }

    public String getsEGG_4_RESULT() {
        return sEGG_4_RESULT;
    }

    public void setsEGG_4_RESULT(String sEGG_4_RESULT) {
        this.sEGG_4_RESULT = sEGG_4_RESULT;
    }

    public boolean ismLeft() {
        return mLeft;
    }

    public void setmLeft(boolean mLeft) {
        this.mLeft = mLeft;
    }

    public boolean ismRight() {
        return mRight;
    }

    public void setmRight(boolean mRight) {
        this.mRight = mRight;
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

    public String getsA() {
        return sA;
    }

    public void setsA(String sA) {
        this.sA = sA;
    }

    public String getsB() {
        return sB;
    }

    public void setsB(String sB) {
        this.sB = sB;
    }

    public String getsC() {
        return sC;
    }

    public void setsC(String sC) {
        this.sC = sC;
    }

    public String getsD() {
        return sD;
    }

    public void setsD(String sD) {
        this.sD = sD;
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

    public String getsUPDATETIME() {
        return sUPDATETIME;
    }

    public void setsUPDATETIME(String sUPDATETIME) {
        this.sUPDATETIME = sUPDATETIME;
    }

    public String getsTYPE() {
        return sTYPE;
    }

    public void setsTYPE(String sTYPE) {
        this.sTYPE = sTYPE;
    }

    public String getsANSWER_CHILD() {
        return sANSWER_CHILD;
    }

    public void setsANSWER_CHILD(String sANSWER_CHILD) {
        this.sANSWER_CHILD = sANSWER_CHILD;
    }

    public String getsRESULT_CHILD() {
        return sRESULT_CHILD;
    }

    public void setsRESULT_CHILD(String sRESULT_CHILD) {
        this.sRESULT_CHILD = sRESULT_CHILD;
    }

    public String getsPOINT_CHILD() {
        return sPOINT_CHILD;
    }

    public void setsPOINT_CHILD(String sPOINT_CHILD) {
        this.sPOINT_CHILD = sPOINT_CHILD;
    }

    public static Creator<CauhoiDetail> getCREATOR() {
        return CREATOR;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }

    public String getsAnwserChil_Dientu_11() {
        return sAnwserChil_Dientu_11;
    }

    public void setsAnwserChil_Dientu_11(String sAnwserChil_Dientu_11) {
        this.sAnwserChil_Dientu_11 = sAnwserChil_Dientu_11;
    }

    public String getsAnwserChil_Dientu_12() {
        return sAnwserChil_Dientu_12;
    }

    public void setsAnwserChil_Dientu_12(String sAnwserChil_Dientu_12) {
        this.sAnwserChil_Dientu_12 = sAnwserChil_Dientu_12;
    }

    public String getsAnwserChil_Dientu_13() {
        return sAnwserChil_Dientu_13;
    }

    public void setsAnwserChil_Dientu_13(String sAnwserChil_Dientu_13) {
        this.sAnwserChil_Dientu_13 = sAnwserChil_Dientu_13;
    }

    public String getsAnwserChil_Dientu_15() {
        return sAnwserChil_Dientu_15;
    }

    public void setsAnwserChil_Dientu_15(String sAnwserChil_Dientu_15) {
        this.sAnwserChil_Dientu_15 = sAnwserChil_Dientu_15;
    }

    public String getsAnwserChil_Dientu_14() {
        return sAnwserChil_Dientu_14;
    }

    public void setsAnwserChil_Dientu_14(String sAnwserChil_Dientu_14) {
        this.sAnwserChil_Dientu_14 = sAnwserChil_Dientu_14;
    }

    public String getsAnwserChil_Dientu_16() {
        return sAnwserChil_Dientu_16;
    }

    public void setsAnwserChil_Dientu_16(String sAnwserChil_Dientu_16) {
        this.sAnwserChil_Dientu_16 = sAnwserChil_Dientu_16;
    }

    public String getsAnwserChil_Dientu_17() {
        return sAnwserChil_Dientu_17;
    }

    public void setsAnwserChil_Dientu_17(String sAnwserChil_Dientu_17) {
        this.sAnwserChil_Dientu_17 = sAnwserChil_Dientu_17;
    }

    public String getsAnwserChil_Dientu_18() {
        return sAnwserChil_Dientu_18;
    }

    public void setsAnwserChil_Dientu_18(String sAnwserChil_Dientu_18) {
        this.sAnwserChil_Dientu_18 = sAnwserChil_Dientu_18;
    }

    public String getsAnwserChil_Dientu_19() {
        return sAnwserChil_Dientu_19;
    }

    public void setsAnwserChil_Dientu_19(String sAnwserChil_Dientu_19) {
        this.sAnwserChil_Dientu_19 = sAnwserChil_Dientu_19;
    }

    public String getsAnwserChil_Dientu_20() {
        return sAnwserChil_Dientu_20;
    }

    public void setsAnwserChil_Dientu_20(String sAnwserChil_Dientu_20) {
        this.sAnwserChil_Dientu_20 = sAnwserChil_Dientu_20;
    }

    public String getsAnwserChil_Dientu_21() {
        return sAnwserChil_Dientu_21;
    }

    public void setsAnwserChil_Dientu_21(String sAnwserChil_Dientu_21) {
        this.sAnwserChil_Dientu_21 = sAnwserChil_Dientu_21;
    }

    public String getsAnwserChil_Dientu_22() {
        return sAnwserChil_Dientu_22;
    }

    public void setsAnwserChil_Dientu_22(String sAnwserChil_Dientu_22) {
        this.sAnwserChil_Dientu_22 = sAnwserChil_Dientu_22;
    }

    public String getsAnwserChil_Dientu_23() {
        return sAnwserChil_Dientu_23;
    }

    public void setsAnwserChil_Dientu_23(String sAnwserChil_Dientu_23) {
        this.sAnwserChil_Dientu_23 = sAnwserChil_Dientu_23;
    }

    public String getsAnwserChil_Dientu_24() {
        return sAnwserChil_Dientu_24;
    }

    public void setsAnwserChil_Dientu_24(String sAnwserChil_Dientu_24) {
        this.sAnwserChil_Dientu_24 = sAnwserChil_Dientu_24;
    }

    public String getsAnwserChil_Dientu_25() {
        return sAnwserChil_Dientu_25;
    }

    public void setsAnwserChil_Dientu_25(String sAnwserChil_Dientu_25) {
        this.sAnwserChil_Dientu_25 = sAnwserChil_Dientu_25;
    }
}

