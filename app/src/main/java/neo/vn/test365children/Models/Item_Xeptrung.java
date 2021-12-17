package neo.vn.test365children.Models;

public class Item_Xeptrung {
  String sRotrung;
  int img_Trung;
  String sTrung;


  public Item_Xeptrung(String sRotrung, int img_Trung, String sTrung) {
    this.sRotrung = sRotrung;
    this.img_Trung = img_Trung;
    this.sTrung = sTrung;
  }

  public String getsRotrung() {
    return sRotrung;
  }

  public void setsRotrung(String sRotrung) {
    this.sRotrung = sRotrung;
  }

  public int getImg_Trung() {
    return img_Trung;
  }

  public void setImg_Trung(int img_Trung) {
    this.img_Trung = img_Trung;
  }

  public String getsTrung() {
    return sTrung;
  }

  public void setsTrung(String sTrung) {
    this.sTrung = sTrung;
  }
}