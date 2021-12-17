
package neo.vn.test365children.Models.vip;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ObjLoginVip implements Serializable {

    @SerializedName("ERROR")
    private String mERROR;
    @SerializedName("INFO")
    private INFOX mINFOX;
    @SerializedName("MESSAGE")
    private String mMESSAGE;

    public String getERROR() {
        return mERROR;
    }

    public void setERROR(String eRROR) {
        mERROR = eRROR;
    }

    public INFOX getINFO() {
        return mINFOX;
    }

    public void setINFO(INFOX iNFO) {
        mINFOX = iNFO;
    }

    public String getMESSAGE() {
        return mMESSAGE;
    }

    public void setMESSAGE(String mESSAGE) {
        mMESSAGE = mESSAGE;
    }

}
