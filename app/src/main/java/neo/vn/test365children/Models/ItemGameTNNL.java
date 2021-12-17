package neo.vn.test365children.Models;

public class ItemGameTNNL {
    boolean isFlipped;
    boolean isClickFlip;
    boolean isFliping;
    int sResoureImage;
    String sContent;
    String sId;

    public ItemGameTNNL(boolean isFlipped, int sResoureImage, String sContent, String sId) {
        this.isFlipped = isFlipped;
        this.sResoureImage = sResoureImage;
        this.sContent = sContent;
        this.sId = sId;
    }

    public int getsResoureImage() {
        return sResoureImage;
    }

    public void setsResoureImage(int sResoureImage) {
        this.sResoureImage = sResoureImage;
    }

    public String getsContent() {
        return sContent;
    }

    public void setsContent(String sContent) {
        this.sContent = sContent;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public ItemGameTNNL(boolean isFlipped) {
        this.isFlipped = isFlipped;
    }

    public boolean isFlipped() {
        return isFlipped;
    }

    public void setFlipped(boolean flipped) {
        isFlipped = flipped;
    }

    public boolean isClickFlip() {
        return isClickFlip;
    }

    public void setClickFlip(boolean clickFlip) {
        isClickFlip = clickFlip;
    }

    public boolean isFliping() {
        return isFliping;
    }

    public void setFliping(boolean fliping) {
        isFliping = fliping;
    }
}
