package neo.vn.test365children.Models;

import java.io.Serializable;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class ExerciseAnswer extends RealmObject implements Serializable {
    @PrimaryKey
    private String sId_exercise;
    private String sId_userMe;
    private String sId_userCon;
    private String sPoint;
    private String sMonhoc;
    private String isTrangthailambai;
    private RealmList<Cauhoi> mLisCauhoi;
    private String sTimebatdaulambai;
    private String sTimequydinh;
    private String sTimeketthuclambai;
    private String sThoiluonglambai;
    private String sKieunopbai;
    private String sIdTuan;
    private String sTrangthainopbai;
    private String sDetailExercise;
    private String sStatus_Play;//1 đang làm , 0 đã làm xong nộp bài
    private boolean isLuyenthi;
    private String EXCERCISE_ID_LUYENTAP;
    public ExerciseAnswer(String sId_exercise, String sId_userMe, String sId_userCon, String sPoint, String sMonhoc,
                          String isTrangthailambai, RealmList<Cauhoi> mLisCauhoi) {
        this.sId_exercise = sId_exercise;
        this.sId_userMe = sId_userMe;
        this.sId_userCon = sId_userCon;
        this.sPoint = sPoint;
        this.sMonhoc = sMonhoc;
        this.isTrangthailambai = isTrangthailambai;
        this.mLisCauhoi = mLisCauhoi;
    }

    public ExerciseAnswer() {
    }

    public String getEXCERCISE_ID_LUYENTAP() {
        return EXCERCISE_ID_LUYENTAP;
    }

    public void setEXCERCISE_ID_LUYENTAP(String EXCERCISE_ID_LUYENTAP) {
        this.EXCERCISE_ID_LUYENTAP = EXCERCISE_ID_LUYENTAP;
    }

    public boolean isLuyenthi() {
        return isLuyenthi;
    }

    public void setLuyenthi(boolean luyenthi) {
        isLuyenthi = luyenthi;
    }

    public String getsStatus_Play() {
        return sStatus_Play;
    }

    public void setsStatus_Play(String sStatus_Play) {
        this.sStatus_Play = sStatus_Play;
    }

    public String getsTrangthainopbai() {
        return sTrangthainopbai;
    }

    public void setsTrangthainopbai(String sTrangthainopbai) {
        this.sTrangthainopbai = sTrangthainopbai;
    }

    public String getsDetailExercise() {
        return sDetailExercise;
    }

    public void setsDetailExercise(String sDetailExercise) {
        this.sDetailExercise = sDetailExercise;
    }

    public String getsIdTuan() {
        return sIdTuan;
    }

    public void setsIdTuan(String sIdTuan) {
        this.sIdTuan = sIdTuan;
    }

    public String getsTimebatdaulambai() {
        return sTimebatdaulambai;
    }

    public void setsTimebatdaulambai(String sTimebatdaulambai) {
        this.sTimebatdaulambai = sTimebatdaulambai;
    }

    public String getsTimequydinh() {
        return sTimequydinh;
    }

    public void setsTimequydinh(String sTimequydinh) {
        this.sTimequydinh = sTimequydinh;
    }

    public String getsTimeketthuclambai() {
        return sTimeketthuclambai;
    }

    public void setsTimeketthuclambai(String sTimeketthuclambai) {
        this.sTimeketthuclambai = sTimeketthuclambai;
    }

    public String getsThoiluonglambai() {
        return sThoiluonglambai;
    }

    public void setsThoiluonglambai(String sThoiluonglambai) {
        this.sThoiluonglambai = sThoiluonglambai;
    }

    public String getsKieunopbai() {
        return sKieunopbai;
    }

    public void setsKieunopbai(String sKieunopbai) {
        this.sKieunopbai = sKieunopbai;
    }

    public String getsMonhoc() {
        return sMonhoc;
    }

    public void setsMonhoc(String sMonhoc) {
        this.sMonhoc = sMonhoc;
    }

    public String getsId_exercise() {
        return sId_exercise;
    }

    public void setsId_exercise(String sId_exercise) {
        this.sId_exercise = sId_exercise;
    }

    public String getsId_userMe() {
        return sId_userMe;
    }

    public void setsId_userMe(String sId_userMe) {
        this.sId_userMe = sId_userMe;
    }

    public String getsId_userCon() {
        return sId_userCon;
    }

    public void setsId_userCon(String sId_userCon) {
        this.sId_userCon = sId_userCon;
    }

    public String getsPoint() {
        return sPoint;
    }

    public void setsPoint(String sPoint) {
        this.sPoint = sPoint;
    }

    public String getIsTrangthailambai() {
        return isTrangthailambai;
    }

    public void setIsTrangthailambai(String isTrangthailambai) {
        this.isTrangthailambai = isTrangthailambai;
    }

    public RealmList<Cauhoi> getmLisCauhoi() {
        return mLisCauhoi;
    }

    public void setmLisCauhoi(RealmList<Cauhoi> mLisCauhoi) {
        this.mLisCauhoi = mLisCauhoi;
    }
}
