package neo.vn.test365children.Models;

public class SudokuCell {
    private int value;
    private boolean modifiable = true;
    private String x;
    private String y;
    private int position;
    private boolean isClick;
    private boolean isHide;
    private int value_click;
    private boolean isAnwser;
    public SudokuCell(int value) {
        this.value = value;
    }

    public SudokuCell(int value, String x, String y) {
        this.value = value;
        this.x = x;
        this.y = y;
    }

    public SudokuCell(int value, String x, String y, boolean isAnwser) {
        this.value = value;
        this.x = x;
        this.y = y;
        this.isAnwser = isAnwser;
    }

    /* public void setNotModifiable() {
        modifiable = false;
    }

    public void setInitValue(int value) {
        this.value = value;
        invalidate();
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }*/

    public boolean isAnwser() {
        return isAnwser;
    }

    public void setAnwser(boolean anwser) {
        isAnwser = anwser;
    }

    public int getValue_click() {
        return value_click;
    }

    public void setValue_click(int value_click) {
        this.value_click = value_click;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isModifiable() {
        return modifiable;
    }

    public void setModifiable(boolean modifiable) {
        this.modifiable = modifiable;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean isClick() {
        return isClick;
    }

    public void setClick(boolean click) {
        isClick = click;
    }

    public boolean isHide() {
        return isHide;
    }

    public void setHide(boolean hide) {
        isHide = hide;
    }
}
