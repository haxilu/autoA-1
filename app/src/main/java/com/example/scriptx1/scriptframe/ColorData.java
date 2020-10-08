package com.example.scriptx1.scriptframe;

public class ColorData {
    byte[] colordata;
    int x;
    int y;
    int w;
    int h;
    int pixelStride;
    int rowStride;


    public void setPixelStride(int pixelStride) {
        this.pixelStride = pixelStride;
    }

    public void setRowStride(int rowStride) {
        this.rowStride = rowStride;
    }

    public byte[] getColordata() {
        return colordata;
    }



    int[] getPix(int x, int y){

        return new int[]{1,2};
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setColordata(byte[] colordata) {
        this.colordata = colordata;
    }

    public void setH(int h) {
        this.h = h;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getW() {
        return w;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public int getH() {
        return h;
    }
}
