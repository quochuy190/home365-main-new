package neo.vn.test365children.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ErrorDetail {
    @SerializedName("command")
    private String command;
    @SerializedName("code")
    private String code;
    @SerializedName("args")
    private List<String> args;

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<String> getArgs() {
        return args;
    }

    public void setArgs(List<String> args) {
        this.args = args;
    }
}
