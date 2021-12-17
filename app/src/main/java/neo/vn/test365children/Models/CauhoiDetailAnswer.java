package neo.vn.test365children.Models;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class CauhoiDetailAnswer extends RealmObject {

  @PrimaryKey
  @SerializedName("ID")
  String sID;
  @SerializedName("PART_ID")
  String sPART_ID;
  @SerializedName("UPDATETIME")
  String sUPDATETIME;
  @SerializedName("ANSWER_CHILD")
  String sANSWER_CHILD;
  @SerializedName("RESULT_CHILD")
  String sRESULT_CHILD;
  @SerializedName("POINT_CHILD")
  String sPOINT_CHILD;


  public CauhoiDetailAnswer() {
  }

  public CauhoiDetailAnswer(String sID, String sPART_ID, String sUPDATETIME, String sANSWER_CHILD,
                            String sRESULT_CHILD, String sPOINT_CHILD) {
    this.sID = sID;
    this.sPART_ID = sPART_ID;
    this.sUPDATETIME = sUPDATETIME;
    this.sANSWER_CHILD = sANSWER_CHILD;
    this.sRESULT_CHILD = sRESULT_CHILD;
    this.sPOINT_CHILD = sPOINT_CHILD;
  }

  public String getsID() {
    return sID;
  }

  public void setsID(String sID) {
    this.sID = sID;
  }

  public String getsPART_ID() {
    return sPART_ID;
  }

  public void setsPART_ID(String sPART_ID) {
    this.sPART_ID = sPART_ID;
  }

  public String getsUPDATETIME() {
    return sUPDATETIME;
  }

  public void setsUPDATETIME(String sUPDATETIME) {
    this.sUPDATETIME = sUPDATETIME;
  }

  public String getsANSWER_CHILD() {
    return sANSWER_CHILD;
  }

  public void setsANSWER_CHILD(String sANSWER_CHILD) {
    this.sANSWER_CHILD = sANSWER_CHILD;
  }

  public String getsRESULT_CHILD() {
    return sRESULT_CHILD;
  }

  public void setsRESULT_CHILD(String sRESULT_CHILD) {
    this.sRESULT_CHILD = sRESULT_CHILD;
  }

  public String getsPOINT_CHILD() {
    return sPOINT_CHILD;
  }

  public void setsPOINT_CHILD(String sPOINT_CHILD) {
    this.sPOINT_CHILD = sPOINT_CHILD;
  }
}