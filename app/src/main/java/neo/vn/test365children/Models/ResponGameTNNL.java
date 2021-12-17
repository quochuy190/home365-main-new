package neo.vn.test365children.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponGameTNNL {
    @SerializedName("ERROR")
    private String sERROR;
    @SerializedName("MESSAGE")
    private String sMESSAGE;
    @SerializedName("RESULT")
    private String sRESULT;
    @SerializedName("INFO")
    private List<GameTNNL> lisInfo;

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

    public List<GameTNNL> getLisInfo() {
        return lisInfo;
    }

    public void setLisInfo(List<GameTNNL> lisInfo) {
        this.lisInfo = lisInfo;
    }
}
