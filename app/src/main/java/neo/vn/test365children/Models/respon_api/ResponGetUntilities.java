package neo.vn.test365children.Models.respon_api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import neo.vn.test365children.Models.ObjUntility;

public class ResponGetUntilities {
    @SerializedName("ERROR")
    private String sERROR;
    @SerializedName("MESSAGE")
    private String sMESSAGE;
    @SerializedName("RESULT")
    private String sRESULT;
    @SerializedName("INFO")
    private List<ObjUntility> lisUntilities;

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

    public List<ObjUntility> getLisUntilities() {
        return lisUntilities;
    }

    public void setLisUntilities(List<ObjUntility> lisUntilities) {
        this.lisUntilities = lisUntilities;
    }
}
