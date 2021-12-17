
package neo.vn.test365children.Models.vip;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class INFOX implements Serializable {

    @SerializedName("CHILDS")
    private List<ChildX> mChildXES;
    @SerializedName("ID")
    private String mID;
    @SerializedName("USERNAME")
    private String mUSERNAME;

    public List<ChildX> getCHILDS() {
        return mChildXES;
    }

    public void setCHILDS(List<ChildX> cHILDREN) {
        mChildXES = cHILDREN;
    }

    public String getID() {
        return mID;
    }

    public void setID(String iD) {
        mID = iD;
    }

    public String getUSERNAME() {
        return mUSERNAME;
    }

    public void setUSERNAME(String uSERNAME) {
        mUSERNAME = uSERNAME;
    }

}
