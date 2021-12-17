package neo.vn.test365children.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ObjMenuSkill implements Serializable, Comparable<ObjMenuSkill> {
    @SerializedName("ERROR")
    private String sERROR;
    @SerializedName("MESSAGE")
    private String sMESSAGE;
    @SerializedName("RESULT")
    private String sRESULT;
    @SerializedName("NAME")
    private String sName;
    @SerializedName("info")
    private List<ObjLessonSkill> lisLessonSkill;
    int iPrioritize;

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

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

  /*  public ObjMenuSkill(String sName, List<ObjLessonSkill> lisLessonSkill) {
        this.sName = sName;
        this.lisLessonSkill = lisLessonSkill;
    }*/

    public int compareTo(ObjMenuSkill employee) {
        if (iPrioritize == employee.iPrioritize)
            return 0;
        else if (iPrioritize > employee.iPrioritize)
            return 1;
        else
            return -1;
    }

    public int getiPrioritize() {
        return iPrioritize;
    }

    public void setiPrioritize(int iPrioritize) {
        this.iPrioritize = iPrioritize;
    }

    public ObjMenuSkill(String sName, List<ObjLessonSkill> lisLessonSkill, int iPrioritize) {
        this.sName = sName;
        this.lisLessonSkill = lisLessonSkill;
        this.iPrioritize = iPrioritize;
    }
}
