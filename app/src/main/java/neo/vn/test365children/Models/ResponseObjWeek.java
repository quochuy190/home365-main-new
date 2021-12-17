package neo.vn.test365children.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseObjWeek {
    @SerializedName("ERROR")
    String sERROR;
    @SerializedName("MESSAGE")
    String sMESSAGE;
    @SerializedName("RESULT")
    String sRESULT;
    @SerializedName("INFO")
    List<Baitap_Tuan> sINFO;

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

    public List<Baitap_Tuan> getsINFO() {
        return sINFO;
    }

    public void setsINFO(List<Baitap_Tuan> sINFO) {
        this.sINFO = sINFO;
    }
}
