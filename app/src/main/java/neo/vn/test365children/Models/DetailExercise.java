package neo.vn.test365children.Models;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class DetailExercise implements Comparable<DetailExercise>, Serializable {
    @SerializedName("EXCERCISE_ID")
    String EXCERCISE_ID;
    String EXCERCISE_ID_LUYENTAP;
    @SerializedName("EXCERCISE_NAME")
    String EXCERCISE_NAME;
    @SerializedName("ID")
    String sID;
    @SerializedName("YEAR_ID")
    String sYEAR_ID;
    @SerializedName("YEAR_NAME")
    String sYEAR_NAME;
    @SerializedName("LEVEL_ID")
    String sLEVEL_ID;
    @SerializedName("LEVEL_NAME")
    String sLEVEL_NAME;
    @SerializedName("SUBJECT_ID")
    String sSUBJECT_ID;
    @SerializedName("SUBJECT_NAME")
    String sSUBJECT_NAME;
    @SerializedName("WEEK_ID")
    String sWEEK_ID;
    @SerializedName("WEEK_NAME")
    String sWEEK_NAME;
    @SerializedName("NAME")
    String sNAME;
    @SerializedName("REQUIREMENT")
    String sREQUIREMENT;
    @SerializedName("PRICE")
    String sPRICE;
    @SerializedName("STATUS_TAKEN")
    String sSTATUS_TAKEN;
    @SerializedName("TOTAL_BUY")
    String sTOTAL_BUY;
    @SerializedName("STATE_BUY")
    String sSTATE_BUY;
    @SerializedName("START_TAKE_TIME")
    String sSTART_TAKE_TIME;
    @SerializedName("END_TAKE_TIME")
    String sEND_TAKE_TIME;
    @SerializedName("POINT")
    String sPOINT;
    @SerializedName("STICKER")
    String STICKER;
    @SerializedName("FILE_PDF")
    String FILE_PDF;
    @SerializedName("LINK")
    String LINK;
    @SerializedName("RECOMMENT_MOTHER")
    String RECOMMENT_MOTHER;
    @SerializedName("PARTS")
    List<Cauhoi> lisPARTS;
    @SerializedName("STATISTIC")
    StatisticDetailExer objStatistic;
    @SerializedName("DURATION")
    String DURATION;
    String sTrangthailambai;
    boolean isDalam;

    public String getEXCERCISE_ID_LUYENTAP() {
        return EXCERCISE_ID_LUYENTAP;
    }

    public void setEXCERCISE_ID_LUYENTAP(String EXCERCISE_ID_LUYENTAP) {
        this.EXCERCISE_ID_LUYENTAP = EXCERCISE_ID_LUYENTAP;
    }

    public boolean isDalam() {
        return isDalam;
    }

    public void setDalam(boolean dalam) {
        isDalam = dalam;
    }

    public String getDURATION() {
        return DURATION;
    }

    public void setDURATION(String DURATION) {
        this.DURATION = DURATION;
    }

    public String getsTrangthailambai() {
        return sTrangthailambai;
    }

    public void setsTrangthailambai(String sTrangthailambai) {
        this.sTrangthailambai = sTrangthailambai;
    }

    public String getsSTATE_BUY() {
        return sSTATE_BUY;
    }

    public void setsSTATE_BUY(String sSTATE_BUY) {
        this.sSTATE_BUY = sSTATE_BUY;
    }

    public String getsSTART_TAKE_TIME() {
        return sSTART_TAKE_TIME;
    }

    public void setsSTART_TAKE_TIME(String sSTART_TAKE_TIME) {
        this.sSTART_TAKE_TIME = sSTART_TAKE_TIME;
    }

    public String getsEND_TAKE_TIME() {
        return sEND_TAKE_TIME;
    }

    public void setsEND_TAKE_TIME(String sEND_TAKE_TIME) {
        this.sEND_TAKE_TIME = sEND_TAKE_TIME;
    }

    public String getsPOINT() {
        return sPOINT;
    }

    public void setsPOINT(String sPOINT) {
        this.sPOINT = sPOINT;
    }

    public String getsID() {
        return sID;
    }

    public void setsID(String sID) {
        this.sID = sID;
    }

    public String getsYEAR_ID() {
        return sYEAR_ID;
    }

    public void setsYEAR_ID(String sYEAR_ID) {
        this.sYEAR_ID = sYEAR_ID;
    }

    public String getsYEAR_NAME() {
        return sYEAR_NAME;
    }

    public void setsYEAR_NAME(String sYEAR_NAME) {
        this.sYEAR_NAME = sYEAR_NAME;
    }

    public String getsLEVEL_ID() {
        return sLEVEL_ID;
    }

    public void setsLEVEL_ID(String sLEVEL_ID) {
        this.sLEVEL_ID = sLEVEL_ID;
    }

    public String getsLEVEL_NAME() {
        return sLEVEL_NAME;
    }

    public void setsLEVEL_NAME(String sLEVEL_NAME) {
        this.sLEVEL_NAME = sLEVEL_NAME;
    }

    public String getsSUBJECT_ID() {
        return sSUBJECT_ID;
    }

    public void setsSUBJECT_ID(String sSUBJECT_ID) {
        this.sSUBJECT_ID = sSUBJECT_ID;
    }

    public String getsSUBJECT_NAME() {
        return sSUBJECT_NAME;
    }

    public void setsSUBJECT_NAME(String sSUBJECT_NAME) {
        this.sSUBJECT_NAME = sSUBJECT_NAME;
    }

    public String getsWEEK_ID() {
        return sWEEK_ID;
    }

    public void setsWEEK_ID(String sWEEK_ID) {
        this.sWEEK_ID = sWEEK_ID;
    }

    public String getsWEEK_NAME() {
        return sWEEK_NAME;
    }

    public void setsWEEK_NAME(String sWEEK_NAME) {
        this.sWEEK_NAME = sWEEK_NAME;
    }

    public String getsNAME() {
        return sNAME;
    }

    public void setsNAME(String sNAME) {
        this.sNAME = sNAME;
    }

    public String getsREQUIREMENT() {
        return sREQUIREMENT;
    }

    public void setsREQUIREMENT(String sREQUIREMENT) {
        this.sREQUIREMENT = sREQUIREMENT;
    }

    public String getsPRICE() {
        return sPRICE;
    }

    public void setsPRICE(String sPRICE) {
        this.sPRICE = sPRICE;
    }

    public String getsSTATUS_TAKEN() {
        return sSTATUS_TAKEN;
    }

    public void setsSTATUS_TAKEN(String sSTATUS_TAKEN) {
        this.sSTATUS_TAKEN = sSTATUS_TAKEN;
    }

    public String getsTOTAL_BUY() {
        return sTOTAL_BUY;
    }

    public void setsTOTAL_BUY(String sTOTAL_BUY) {
        this.sTOTAL_BUY = sTOTAL_BUY;
    }

    public List<Cauhoi> getLisPARTS() {
        return lisPARTS;
    }

    public void setLisPARTS(List<Cauhoi> lisPARTS) {
        this.lisPARTS = lisPARTS;
    }

    public StatisticDetailExer getObjStatistic() {
        return objStatistic;
    }

    public void setObjStatistic(StatisticDetailExer objStatistic) {
        this.objStatistic = objStatistic;
    }

    public String getSTICKER() {
        return STICKER;
    }

    public void setSTICKER(String STICKER) {
        this.STICKER = STICKER;
    }

    public String getRECOMMENT_MOTHER() {
        return RECOMMENT_MOTHER;
    }

    public void setRECOMMENT_MOTHER(String RECOMMENT_MOTHER) {
        this.RECOMMENT_MOTHER = RECOMMENT_MOTHER;
    }

    public String getFILE_PDF() {
        return FILE_PDF;
    }

    public void setFILE_PDF(String FILE_PDF) {
        this.FILE_PDF = FILE_PDF;
    }

    public String getLINK() {
        return LINK;
    }

    public void setLINK(String LINK) {
        this.LINK = LINK;
    }

    public String getEXCERCISE_ID() {
        return EXCERCISE_ID;
    }

    public void setEXCERCISE_ID(String EXCERCISE_ID) {
        this.EXCERCISE_ID = EXCERCISE_ID;
    }

    public String getEXCERCISE_NAME() {
        return EXCERCISE_NAME;
    }

    public void setEXCERCISE_NAME(String EXCERCISE_NAME) {
        this.EXCERCISE_NAME = EXCERCISE_NAME;
    }

    @Override
    public int compareTo(@NonNull DetailExercise detailExercise) {
        if (Integer.parseInt(EXCERCISE_ID) == Integer.parseInt(detailExercise.getEXCERCISE_ID()))
            return 0;
        else if (Integer.parseInt(EXCERCISE_ID) > Integer.parseInt(detailExercise.getEXCERCISE_ID()))
            return 1;
        else
            return -1;
    }
}
