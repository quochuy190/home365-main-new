package neo.vn.test365children.Models;

public class Chucai {
    String sChucai;
    int sPosition;
    String sContent;
    int iImage;

    public Chucai(String sChucai, int sPosition, String sContent, int iImage) {
        this.sChucai = sChucai;
        this.sPosition = sPosition;
        this.sContent = sContent;
        this.iImage = iImage;
    }

    public String getsChucai() {
        return sChucai;
    }

    public void setsChucai(String sChucai) {
        this.sChucai = sChucai;
    }

    public int getsPosition() {
        return sPosition;
    }

    public void setsPosition(int sPosition) {
        this.sPosition = sPosition;
    }

    public String getsContent() {
        return sContent;
    }

    public void setsContent(String sContent) {
        this.sContent = sContent;
    }

    public int getiImage() {
        return iImage;
    }

    public void setiImage(int iImage) {
        this.iImage = iImage;
    }
}
