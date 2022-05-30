package neo.vn.test365children.Models.respon_api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import neo.vn.test365children.Models.ObjLessonSkill;

public class ResponRegister {
    @SerializedName("ERROR")
    private String error;
    @SerializedName("MESSAGE")
    private String message;
    @SerializedName("RESULT")
    private String RESULT;
    @SerializedName("info")
    private ResponInitChil info;

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

    public ResponInitChil getInfo() {
        return info;
    }

    public void setInfo(ResponInitChil info) {
        this.info = info;
    }

    public String getRESULT() {
        return RESULT;
    }

    public void setRESULT(String RESULT) {
        this.RESULT = RESULT;
    }
}
