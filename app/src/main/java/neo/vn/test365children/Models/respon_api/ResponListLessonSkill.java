package neo.vn.test365children.Models.respon_api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import neo.vn.test365children.Models.ObjLessonSkill;

public class ResponListLessonSkill {
    @SerializedName("ERROR")
    private String sERROR;
    @SerializedName("MESSAGE")
    private String sMESSAGE;
    @SerializedName("RESULT")
    private String sRESULT;
    @SerializedName("INFO")
    private List<ObjLessonSkill> lisLessonSkill;

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

    public List<ObjLessonSkill> getLisLessonSkill() {
        return lisLessonSkill;
    }

    public void setLisLessonSkill(List<ObjLessonSkill> lisLessonSkill) {
        this.lisLessonSkill = lisLessonSkill;
    }
}
