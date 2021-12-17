package neo.vn.test365children.Models;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class TuanDamua implements Serializable {
  @SerializedName("ERROR")
  String sERROR;
  @SerializedName("MESSAGE")
  String sMESSAGE;
  @SerializedName("RESULT")
  String sRESULT;
  @SerializedName("ID")
  String sID;
  @SerializedName("CHILD_ID")
  String sCHILD_ID;
  @SerializedName("ID_TO_SIMILAR")
  String sID_TO_SIMILAR;
  @SerializedName("NAME")
  String sNAME;
  @SerializedName("NOTICE")
  String sNOTICE;
  @SerializedName("PARENT_ID")
  String sPARENT_ID;
  @SerializedName("STATE ")
  String sSTATE;
  @SerializedName("TAKEN_NUMBER")
  String sTAKEN_NUMBER;
  @SerializedName("TYPE")
  String sTYPE;
  @SerializedName("TYPETAB")
  String sTYPETAB;
  @SerializedName("WEEK_TEST_ID")
  String sWEEK_TEST_ID;
  @SerializedName("WEEK_NAME")
  String sWEEK_NAME;
  @SerializedName("REQUIREMENT")
  String sREQUIREMENT;
  String sHeaderId;
  String sMonhoc;

  public TuanDamua() {
  }

  private static TuanDamua getObject(JSONObject jsonObject) {
    return new Gson().fromJson(jsonObject.toString(), TuanDamua.class);
  }

  public static ArrayList<TuanDamua> getList(String jsonArray) throws JSONException {
    ArrayList<TuanDamua> arrayList = new ArrayList<>();
    Type type = new TypeToken<List<TuanDamua>>() {
    }.getType();
    Gson gson = new Gson();
    arrayList = gson.fromJson(jsonArray, type);
    return arrayList;
  }

  public String getsMonhoc() {
    return sMonhoc;
  }

  public void setsMonhoc(String sMonhoc) {
    this.sMonhoc = sMonhoc;
  }

  public String getsWEEK_NAME() {
    return sWEEK_NAME;
  }

  public void setsWEEK_NAME(String sWEEK_NAME) {
    this.sWEEK_NAME = sWEEK_NAME;
  }

  public String getsREQUIREMENT() {
    return sREQUIREMENT;
  }

  public void setsREQUIREMENT(String sREQUIREMENT) {
    this.sREQUIREMENT = sREQUIREMENT;
  }

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

  public String getsID() {
    return sID;
  }

  public void setsID(String sID) {
    this.sID = sID;
  }

  public String getsCHILD_ID() {
    return sCHILD_ID;
  }

  public void setsCHILD_ID(String sCHILD_ID) {
    this.sCHILD_ID = sCHILD_ID;
  }

  public String getsID_TO_SIMILAR() {
    return sID_TO_SIMILAR;
  }

  public void setsID_TO_SIMILAR(String sID_TO_SIMILAR) {
    this.sID_TO_SIMILAR = sID_TO_SIMILAR;
  }

  public String getsNAME() {
    return sNAME;
  }

  public void setsNAME(String sNAME) {
    this.sNAME = sNAME;
  }

  public String getsNOTICE() {
    return sNOTICE;
  }

  public void setsNOTICE(String sNOTICE) {
    this.sNOTICE = sNOTICE;
  }

  public String getsPARENT_ID() {
    return sPARENT_ID;
  }

  public void setsPARENT_ID(String sPARENT_ID) {
    this.sPARENT_ID = sPARENT_ID;
  }

  public String getsSTATE() {
    return sSTATE;
  }

  public void setsSTATE(String sSTATE) {
    this.sSTATE = sSTATE;
  }

  public String getsTAKEN_NUMBER() {
    return sTAKEN_NUMBER;
  }

  public void setsTAKEN_NUMBER(String sTAKEN_NUMBER) {
    this.sTAKEN_NUMBER = sTAKEN_NUMBER;
  }

  public String getsTYPE() {
    return sTYPE;
  }

  public void setsTYPE(String sTYPE) {
    this.sTYPE = sTYPE;
  }

  public String getsTYPETAB() {
    return sTYPETAB;
  }

  public void setsTYPETAB(String sTYPETAB) {
    this.sTYPETAB = sTYPETAB;
  }

  public String getsWEEK_TEST_ID() {
    return sWEEK_TEST_ID;
  }

  public void setsWEEK_TEST_ID(String sWEEK_TEST_ID) {
    this.sWEEK_TEST_ID = sWEEK_TEST_ID;
  }

  public String getsHeaderId() {
    return sHeaderId;
  }

  public void setsHeaderId(String sHeaderId) {
    this.sHeaderId = sHeaderId;
  }
}