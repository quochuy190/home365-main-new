package neo.vn.test365children.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class InfoKids extends RealmObject implements Serializable {
    @SerializedName("ID")
    private String sID;
    @PrimaryKey
    @SerializedName("USERNAME")
    private String sUSERNAME;
    @SerializedName("PASSWORD")
    private String sPASSWORD;
    @SerializedName("FULLNAME")
    private String sFULLNAME;
    @SerializedName("AVATAR")
    private String sAVATAR;
    @SerializedName("STARTTIME")
    private String sSTARTTIME;
    @SerializedName("APPVERSION")
    private String sAPPVERSION;
    @SerializedName("DEVICEMODEL")
    private String sDEVICEMODEL;
    @SerializedName("API_SERVER")
    private String sAPI_SERVER;
    @SerializedName("MEDIA_SERVER")
    private String sMEDIA_SERVER;

    @SerializedName("STATE")
    private String sSTATE;
    @SerializedName("UPDATETIME")
    private String sUPDATETIME;
    @SerializedName("DEVICETYPE")
    private String sDEVICETYPE;
    @SerializedName("OSVERSION")
    private String sOSVERSION;
    @SerializedName("TOKENKEY")
    private String sTOKENKEY;
    @SerializedName("PARENT_ID")
    private String sPARENT_ID;
    @SerializedName("SCHOOL_ID")
    private String sSCHOOL_ID;
    @SerializedName("LEVEL_ID")
    private String sLEVEL_ID;
    @SerializedName("YEAR_ID")
    private String sYEAR_ID;
    @SerializedName("CLASS")
    private String sCLASS;
    @SerializedName("LEVEL")
    private String sLEVEL;
    @SerializedName("SCHOOL")
    private String sSCHOOL;
    @SerializedName("DISTRICT")
    private String sDISTRICT;
    @SerializedName("PROVINCE_ID")
    private String PROVINCE_ID;
    @SerializedName("PROVINCE")
    private String sPROVINCE;
    @SerializedName("DISTRICT_ID")
    private String DISTRICT_ID;
    @SerializedName("PARENT_USERNAME")
    private String sPARENT_USERNAME;
    @SerializedName("PARENT_FULLNAME")
    private String sPARENT_FULLNAME;
    @SerializedName("LIST_BUY")
    private String sLIST_BUY;
    @SerializedName("LIST_TAKEN")
    private String sLIST_TAKEN;
    @SerializedName("USER_MOTHER")
    private String sUSER_MOTHER;
    @SerializedName("PHONENUMBER")
    private String sPHONENUMBER;
    @SerializedName("EMAIL")
    private String EMAIL;
    @SerializedName("IS_VIP")
    private int IS_VIP;
    @SerializedName("VIP_EXPIRE_DATE")
    private String VIP_EXPIRE_DATE;
    @SerializedName("VIP_NAME")
    private String VIP_NAME;

    public InfoKids() {
    }

    public InfoKids(String sID, String sUSERNAME, String sPASSWORD, String sFULLNAME, String sPARENT_ID, String sLEVEL_ID, String sLEVEL, String sPARENT_USERNAME) {
        this.sID = sID;
        this.sUSERNAME = sUSERNAME;
        this.sPASSWORD = sPASSWORD;
        this.sFULLNAME = sFULLNAME;
        this.sPARENT_ID = sPARENT_ID;
        this.sLEVEL_ID = sLEVEL_ID;
        this.sLEVEL = sLEVEL;
        this.sPARENT_USERNAME = sPARENT_USERNAME;
    }

    public String getVIP_NAME() {
        return VIP_NAME;
    }

    public void setVIP_NAME(String VIP_NAME) {
        this.VIP_NAME = VIP_NAME;
    }

    public int getIS_VIP() {
        return IS_VIP;
    }

    public void setIS_VIP(int IS_VIP) {
        this.IS_VIP = IS_VIP;
    }

    public String getVIP_EXPIRE_DATE() {
        return VIP_EXPIRE_DATE;
    }

    public void setVIP_EXPIRE_DATE(String VIP_EXPIRE_DATE) {
        this.VIP_EXPIRE_DATE = VIP_EXPIRE_DATE;
    }

    public String getsID() {
        return sID;
    }

    public void setsID(String sID) {
        this.sID = sID;
    }

    public String getsUSERNAME() {
        return sUSERNAME;
    }

    public void setsUSERNAME(String sUSERNAME) {
        this.sUSERNAME = sUSERNAME;
    }

    public String getsPASSWORD() {
        return sPASSWORD;
    }

    public void setsPASSWORD(String sPASSWORD) {
        this.sPASSWORD = sPASSWORD;
    }

    public String getsFULLNAME() {
        return sFULLNAME;
    }

    public void setsFULLNAME(String sFULLNAME) {
        this.sFULLNAME = sFULLNAME;
    }

    public String getsAVATAR() {
        return sAVATAR;
    }

    public void setsAVATAR(String sAVATAR) {
        this.sAVATAR = sAVATAR;
    }

    public String getsSTARTTIME() {
        return sSTARTTIME;
    }

    public void setsSTARTTIME(String sSTARTTIME) {
        this.sSTARTTIME = sSTARTTIME;
    }

    public String getsAPPVERSION() {
        return sAPPVERSION;
    }

    public void setsAPPVERSION(String sAPPVERSION) {
        this.sAPPVERSION = sAPPVERSION;
    }

    public String getsDEVICEMODEL() {
        return sDEVICEMODEL;
    }

    public void setsDEVICEMODEL(String sDEVICEMODEL) {
        this.sDEVICEMODEL = sDEVICEMODEL;
    }

    public String getsAPI_SERVER() {
        return sAPI_SERVER;
    }

    public void setsAPI_SERVER(String sAPI_SERVER) {
        this.sAPI_SERVER = sAPI_SERVER;
    }

    public String getsMEDIA_SERVER() {
        return sMEDIA_SERVER;
    }

    public void setsMEDIA_SERVER(String sMEDIA_SERVER) {
        this.sMEDIA_SERVER = sMEDIA_SERVER;
    }

    public String getsSTATE() {
        return sSTATE;
    }

    public void setsSTATE(String sSTATE) {
        this.sSTATE = sSTATE;
    }

    public String getsUPDATETIME() {
        return sUPDATETIME;
    }

    public void setsUPDATETIME(String sUPDATETIME) {
        this.sUPDATETIME = sUPDATETIME;
    }

    public String getsDEVICETYPE() {
        return sDEVICETYPE;
    }

    public void setsDEVICETYPE(String sDEVICETYPE) {
        this.sDEVICETYPE = sDEVICETYPE;
    }

    public String getsOSVERSION() {
        return sOSVERSION;
    }

    public void setsOSVERSION(String sOSVERSION) {
        this.sOSVERSION = sOSVERSION;
    }

    public String getsTOKENKEY() {
        return sTOKENKEY;
    }

    public void setsTOKENKEY(String sTOKENKEY) {
        this.sTOKENKEY = sTOKENKEY;
    }

    public String getsPARENT_ID() {
        return sPARENT_ID;
    }

    public void setsPARENT_ID(String sPARENT_ID) {
        this.sPARENT_ID = sPARENT_ID;
    }

    public String getsSCHOOL_ID() {
        return sSCHOOL_ID;
    }

    public void setsSCHOOL_ID(String sSCHOOL_ID) {
        this.sSCHOOL_ID = sSCHOOL_ID;
    }

    public String getsLEVEL_ID() {
        return sLEVEL_ID;
    }

    public void setsLEVEL_ID(String sLEVEL_ID) {
        this.sLEVEL_ID = sLEVEL_ID;
    }

    public String getsYEAR_ID() {
        return sYEAR_ID;
    }

    public void setsYEAR_ID(String sYEAR_ID) {
        this.sYEAR_ID = sYEAR_ID;
    }

    public String getsCLASS() {
        return sCLASS;
    }

    public void setsCLASS(String sCLASS) {
        this.sCLASS = sCLASS;
    }

    public String getsLEVEL() {
        return sLEVEL;
    }

    public void setsLEVEL(String sLEVEL) {
        this.sLEVEL = sLEVEL;
    }

    public String getsSCHOOL() {
        return sSCHOOL;
    }

    public void setsSCHOOL(String sSCHOOL) {
        this.sSCHOOL = sSCHOOL;
    }

    public String getsDISTRICT() {
        return sDISTRICT;
    }

    public void setsDISTRICT(String sDISTRICT) {
        this.sDISTRICT = sDISTRICT;
    }

    public String getsPROVINCE() {
        return sPROVINCE;
    }

    public void setsPROVINCE(String sPROVINCE) {
        this.sPROVINCE = sPROVINCE;
    }

    public String getsPARENT_USERNAME() {
        return sPARENT_USERNAME;
    }

    public void setsPARENT_USERNAME(String sPARENT_USERNAME) {
        this.sPARENT_USERNAME = sPARENT_USERNAME;
    }

    public String getsPARENT_FULLNAME() {
        return sPARENT_FULLNAME;
    }

    public void setsPARENT_FULLNAME(String sPARENT_FULLNAME) {
        this.sPARENT_FULLNAME = sPARENT_FULLNAME;
    }

    public String getsLIST_BUY() {
        return sLIST_BUY;
    }

    public void setsLIST_BUY(String sLIST_BUY) {
        this.sLIST_BUY = sLIST_BUY;
    }

    public String getsLIST_TAKEN() {
        return sLIST_TAKEN;
    }

    public void setsLIST_TAKEN(String sLIST_TAKEN) {
        this.sLIST_TAKEN = sLIST_TAKEN;
    }

    public String getsUSER_MOTHER() {
        return sUSER_MOTHER;
    }

    public void setsUSER_MOTHER(String sUSER_MOTHER) {
        this.sUSER_MOTHER = sUSER_MOTHER;
    }

    public String getPROVINCE_ID() {
        return PROVINCE_ID;
    }

    public void setPROVINCE_ID(String PROVINCE_ID) {
        this.PROVINCE_ID = PROVINCE_ID;
    }

    public String getDISTRICT_ID() {
        return DISTRICT_ID;
    }

    public void setDISTRICT_ID(String DISTRICT_ID) {
        this.DISTRICT_ID = DISTRICT_ID;
    }

    public String getsPHONENUMBER() {
        return sPHONENUMBER;
    }

    public void setsPHONENUMBER(String sPHONENUMBER) {
        this.sPHONENUMBER = sPHONENUMBER;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }
}
