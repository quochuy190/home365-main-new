package neo.vn.test365children.Models;

public class DapAnNoicau {
  private String sName;
  private String sContent;
  private String sDapan_Traloi;
  private String sDapan_Dung;
  private boolean isClick;
  private int sBackground;

  public DapAnNoicau(String sName, String sContent, String sDapan_Traloi, String sDapan_Dung, boolean isClick, int sBackground) {
    this.sName = sName;
    this.sContent = sContent;
    this.sDapan_Traloi = sDapan_Traloi;
    this.sDapan_Dung = sDapan_Dung;
    this.isClick = isClick;
    this.sBackground = sBackground;
  }

  public String getsName() {
    return sName;
  }

  public void setsName(String sName) {
    this.sName = sName;
  }

  public String getsContent() {
    return sContent;
  }

  public void setsContent(String sContent) {
    this.sContent = sContent;
  }

  public String getsDapan_Traloi() {
    return sDapan_Traloi;
  }

  public void setsDapan_Traloi(String sDapan_Traloi) {
    this.sDapan_Traloi = sDapan_Traloi;
  }

  public String getsDapan_Dung() {
    return sDapan_Dung;
  }

  public void setsDapan_Dung(String sDapan_Dung) {
    this.sDapan_Dung = sDapan_Dung;
  }

  public boolean isClick() {
    return isClick;
  }

  public void setClick(boolean click) {
    isClick = click;
  }

  public int getsBackground() {
    return sBackground;
  }

  public void setsBackground(int sBackground) {
    this.sBackground = sBackground;
  }
}