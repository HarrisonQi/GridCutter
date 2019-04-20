package entity;

/**
 * 用于存储图片的坐标
 */
public class ImgCo {
    private int co1;
    private int co2;
    private int len1;
    private int len2;

    public int getCo1() {
        return co1;
    }

    public void setCo1(int co1) {
        this.co1 = co1;
    }

    public int getCo2() {
        return co2;
    }

    public void setCo2(int co2) {
        this.co2 = co2;
    }

    public int getLen1() {
        return len1;
    }

    public void setLen1(int len1) {
        this.len1 = len1;
    }

    public int getLen2() {
        return len2;
    }

    public void setLen2(int len2) {
        this.len2 = len2;
    }

    @Override
    public String toString() {
        return "ImgCo{" +
                "co1=" + co1 +
                ", co2=" + co2 +
                ", len1=" + len1 +
                ", len2=" + len2 +
                '}';
    }
}
