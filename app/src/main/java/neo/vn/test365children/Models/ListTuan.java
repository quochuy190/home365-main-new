package neo.vn.test365children.Models;

import java.util.List;

public class ListTuan {
  private String sName;
  private List<ExerciseAnswer> lisBaitapTuan;

  public ListTuan(String sName, List<ExerciseAnswer> lisBaitapTuan) {
    this.sName = sName;
    this.lisBaitapTuan = lisBaitapTuan;
  }

  public String getsName() {
    return sName;
  }

  public void setsName(String sName) {
    this.sName = sName;
  }

  public List<ExerciseAnswer> getLisBaitapTuan() {
    return lisBaitapTuan;
  }

  public void setLisBaitapTuan(List<ExerciseAnswer> lisBaitapTuan) {
    this.lisBaitapTuan = lisBaitapTuan;
  }
}