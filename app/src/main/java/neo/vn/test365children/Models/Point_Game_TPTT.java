package neo.vn.test365children.Models;

public class Point_Game_TPTT {
  private String sPoint;
  private boolean isPlaying;

  public Point_Game_TPTT() {
  }

  public Point_Game_TPTT(String sPoint, boolean isPlaying) {
    this.sPoint = sPoint;
    this.isPlaying = isPlaying;
  }

  public String getsPoint() {
    return sPoint;
  }

  public void setsPoint(String sPoint) {
    this.sPoint = sPoint;
  }

  public boolean isPlaying() {
    return isPlaying;
  }

  public void setPlaying(boolean playing) {
    isPlaying = playing;
  }
}