package neo.vn.test365children.Models.respon_api;

import com.google.gson.annotations.SerializedName;

import neo.vn.test365children.Models.InfoListLuyenthi;

/**
 * Created by: Neo Company.
 * Developer: HuyNQ2
 * Date: 06-November-2019
 * Time: 13:54
 * Version: 1.0
 */
public class ResponGetListLuyenthi {
    @SerializedName("ERROR")
    private String error;
    @SerializedName("MESSAGE")
    private String message;
    @SerializedName("RESULT")
    private String result;
    @SerializedName("INFO")
    private InfoListLuyenthi info;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public InfoListLuyenthi getInfo() {
        return info;
    }

    public void setInfo(InfoListLuyenthi info) {
        this.info = info;
    }
}
