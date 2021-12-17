package neo.vn.test365children.Models.respon_api;

import com.google.gson.annotations.SerializedName;

public class ResponInitChil {
    @SerializedName("ERROR")
    private String sERROR;
    @SerializedName("MESSAGE")
    private String sMESSAGE;
    @SerializedName("RESULT")
    private String sRESULT;
    @SerializedName("USER_MOTHER")
    private String USER_MOTHER;
    @SerializedName("USER_CHILD")
    private String USER_CHILD;
    @SerializedName("PASSWORD")
    private String PASSWORD;

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
