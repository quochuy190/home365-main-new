
package neo.vn.test365children.Models.vip;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ChildX implements Serializable {
    @SerializedName("FULLNAME")
    private String mFULLNAME;
    @SerializedName("ID")
    private String mID;
    @SerializedName("LEVEL_ID")
    private String mLEVELID;
    @SerializedName("LEVEL_NAME")
    private String mLEVELNAME;
    @SerializedName("PASSWORD")
    private String mPASSWORD;
    @SerializedName("USERNAME")
    private String mUSERNAME;

    public String getFULLNAME() {
        return mFULLNAME;
    }

    public void setFULLNAME(String fULLNAME) {
        mFULLNAME = fULLNAME;
    }

    public String getID() {
        return mID;
    }

    public void setID(String iD) {
        mID = iD;
    }

    public String getLEVELID() {
        return mLEVELID;
    }

    public void setLEVELID(String lEVELID) {
        mLEVELID = lEVELID;
    }

    public String getLEVELNAME() {
        return mLEVELNAME;
    }

    public void setLEVELNAME(String lEVELNAME) {
        mLEVELNAME = lEVELNAME;
    }

    public String getPASSWORD() {
        return mPASSWORD;
    }

    public void setPASSWORD(String pASSWORD) {
        mPASSWORD = pASSWORD;
    }

    public String getUSERNAME() {
        return mUSERNAME;
    }

    public void setUSERNAME(String uSERNAME) {
        mUSERNAME = uSERNAME;
    }

}
