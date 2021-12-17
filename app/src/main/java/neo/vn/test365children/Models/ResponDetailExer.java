package neo.vn.test365children.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponDetailExer {
    @SerializedName("ERROR")
    private String sERROR;
    @SerializedName("MESSAGE")
    private String sMESSAGE;
    @SerializedName("RESULT")
    private String sRESULT;
    @SerializedName("DETAILS")
    private DetailExercise DETAILS;
    @SerializedName("INFO")
    private List<DetailExercise> listExerLuyentap;

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

    public DetailExercise getDETAILS() {
        return DETAILS;
    }

    public void setDETAILS(DetailExercise DETAILS) {
        this.DETAILS = DETAILS;
    }

    public List<DetailExercise> getListExerLuyentap() {
        return listExerLuyentap;
    }

    public void setListExerLuyentap(List<DetailExercise> listExerLuyentap) {
        this.listExerLuyentap = listExerLuyentap;
    }
}
