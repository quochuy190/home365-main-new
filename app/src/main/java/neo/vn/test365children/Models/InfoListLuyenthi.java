package neo.vn.test365children.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by: Neo Company.
 * Developer: HuyNQ2
 * Date: 06-November-2019
 * Time: 14:00
 * Version: 1.0
 */
public class InfoListLuyenthi {
    @SerializedName("MATHS")
    private List<GoiBaitap> listMATHS;
    @SerializedName("VIETNAMESE")
    private List<GoiBaitap> listVIETNAMESE;
    @SerializedName("ENGLISH")
    private List<GoiBaitap> listENGLISH;

    public List<GoiBaitap> getListMATHS() {
        return listMATHS;
    }

    public void setListMATHS(List<GoiBaitap> listMATHS) {
        this.listMATHS = listMATHS;
    }

    public List<GoiBaitap> getListVIETNAMESE() {
        return listVIETNAMESE;
    }

    public void setListVIETNAMESE(List<GoiBaitap> listVIETNAMESE) {
        this.listVIETNAMESE = listVIETNAMESE;
    }

    public List<GoiBaitap> getListENGLISH() {
        return listENGLISH;
    }

    public void setListENGLISH(List<GoiBaitap> listENGLISH) {
        this.listENGLISH = listENGLISH;
    }
}
