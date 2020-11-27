package com.example.scriptx1.scriptframe;

import android.content.SharedPreferences;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.scriptx1.MainActivity;
import com.example.scriptx1.screendo.GBData;
import com.example.scriptx1.screendo.ScreenLib;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.example.scriptx1.screendo.GBData.color16To10_int;


public abstract class F<T extends F<T>> extends ScreenLib {
    private int mainColor; //主颜色
    private String subColor; //子颜色
    private double distance; //相似度
    private int x1, y1, x2, y2; //找色范围
    private double x1d, y1d, x2d, y2d; //找色范围
    protected int t = 1000; //默认延迟
    protected int r = 4; //默认随机范围
    private int argsFlag;//0为浮点参数构造，1为整数参数构造
    private float xx, yy;
    private ArrayList<Integer[]> analysisSubColor;
    private int[] analysisMainColor;

    protected String name;//唯一标志 不要设置一样的name
    protected int partialX;//x的偏移
    protected int partialY;//y的偏移
    protected List<T> anyList;//fList任意一个为true 返回 true
    protected List<T> allList;//fList全部为true 返回 true
    protected boolean isClick;//默认点击
    protected Fcallback callBack=null;//回调
    protected UnFcallback UncallBack=null;//回调
    String is;
    protected long time;
    protected long tu;
    protected int[] aClick;
    protected int[] bClick;
    private boolean tus=true;

    private  boolean mCheckBox = true;
    public T setCheckBox(String is){
        this.is = is;
        return (T)this;
    }

    public boolean getCheckBox(){
//        if (is!=null){
//            Log.i("999999999", String.format("%s：%s", is,MainActivity.sp.getBoolean(is,true)));
//        }

        if(MainActivity.sp==null)return true;
       return  MainActivity.sp.getBoolean(is,true);
    }

    public T addClick(int x, int y){
        if (aClick==null){
            aClick = new int[]{x,y};
        }
        return (T)this;
    }

    public T addUnClick(int x, int y){
        if (bClick==null){
            bClick = new int[]{x,y};
        }
        return (T)this;
    }

    protected void  _addClick(){
        if (aClick!=null){
            click(aClick[0],aClick[1]);
        }

    }

    protected void  _addUnClick(){
        if (bClick!=null){
            click(bClick[0],bClick[1]);
        }

    }

    public T setTime(long time,boolean ... tus) {
        this.time = time;
        if (tus.length>0){
            this.tus=tus[0];
        }

        return (T)this;
    }

    public T any(T... anyList) {
        if (this.anyList == null) {
            this.anyList = new ArrayList<>();
        }
        Collections.addAll(this.anyList, anyList);
        return (T) this;
    }

    public T all(T... allList) {
        if (this.allList == null) {
            this.allList = new ArrayList<>();
        }
        Collections.addAll(this.allList, allList);
        return (T) this;
    }


    public T setName(String name) {
        this.name = name;
        return (T) this;
    }


    public T setClick(boolean b) {
        this.isClick = b;
        return (T) this;
    }

    public T setCallBack(Fcallback callBack) {
        this.callBack = callBack;
        return (T) this;
    }
    public T setUnCallBack(UnFcallback UncallBack) {
        this.UncallBack = UncallBack;
        return (T) this;
    }

    public T setPartialX(int partialX) {
        this.partialX = partialX;
        return (T) this;
    }

    public T setPartialY(int partialY) {
        this.partialY = partialY;
        return (T) this;
    }


    public T setT(int t) {
        this.t = t;
        return (T) this;
    }

    public T setR(int r) {
        this.r = r;
        return (T) this;
    }

    public F(int mainColor, String subColor, double distance, int x1, int y1, int x2, int y2) {
        this.mainColor = mainColor;
        this.subColor = subColor;
        this.distance = distance;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.argsFlag = 1;
        analysis();
    }

    public F(int mainColor, String subColor, double distance, int x1, int y1, int x2, int y2, int t, int r) {
        this.mainColor = mainColor;
        this.subColor = subColor;
        this.distance = distance;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.t = t;
        this.r = r;
        this.argsFlag = 1;
        analysis();
    }

    public F(int mainColor, String subColor, double distance, double x1, double y1, double x2, double y2) {
        this.mainColor = mainColor;
        this.subColor = subColor;
        this.distance = distance;
        this.x1d = x1;
        this.y1d = y1;
        this.x2d = x2;
        this.y2d = y2;
        this.argsFlag = 0;
        analysis();
    }

    public F(int mainColor, String subColor, double distance, double x1, double y1, double x2, double y2, int t, int r) {
        this.mainColor = mainColor;
        this.subColor = subColor;
        this.distance = distance;
        this.x1d = x1;
        this.y1d = y1;
        this.x2d = x2;
        this.y2d = y2;
        this.t = t;
        this.r = r;
        this.argsFlag = 0;
        analysis();
    }

    public F(int mainColor, String subColor, double distance, double x1, double y1, double x2, double y2, float xx, float yy) {
        this.mainColor = mainColor;
        this.subColor = subColor;
        this.distance = distance;
        this.x1d = x1;
        this.y1d = y1;
        this.x2d = x2;
        this.y2d = y2;
        this.xx = xx;
        this.yy = yy;
        this.argsFlag = 0;
        analysis();
    }


    //解析文本参数
    private void analysis() {
        analysisSubColor = GBData.getColorListSub(subColor);//16进制文本颜色转成10进制颜色数组（子颜色列表）
        analysisMainColor = color16To10_int(mainColor);//文本转10进制颜色（主颜色）
    }




    protected int[] findColor() {
        if (argsFlag == 1) {
            return GBData.MultiPointFindColor(analysisMainColor, analysisSubColor, distance, x1, y1, x2, y2);
        } else if (argsFlag == 0) {
            return GBData.MultiPointFindColor(analysisMainColor, analysisSubColor, distance, (int) (x1d * MainActivity.w), (int) (y1d * MainActivity.h), (int) (x2d * MainActivity.w), (int) (y2d * MainActivity.h));
        }
        return null;
    }


    protected boolean findColorAll() { //全部为true 返回true
        if (allList == null) return true;
        for (T page : allList) {
            if (page.findColor() == null) return false;
        }
        return true;
    }

    protected boolean findColorAny() { //一个为true 返回true
        if (anyList == null) return true;
        for (T page : anyList) {
            if (page.findColor() != null) return true;
        }
        return false;
    }

    //间隔指定时间找色
    protected int[] findColorT() throws InterruptedException {
        int[] xy;
        if (time > 0L) {
            if (tu == 0L) {//第一次进入
                if (tus){//第一次进入 是否找色
                    xy = findColorF();
                    if (xy!=null){
                        tu = System.currentTimeMillis();
                        return xy;
                    }
                }else{
                    tu = System.currentTimeMillis();
                    return null;
                }
            }
            //再次进入
            if (System.currentTimeMillis() - tu >= time) {
                xy = findColorF();
                if (xy!=null){
                    tu = System.currentTimeMillis();
                }

            }else{
                return null;
            }
        }else{
            xy = findColorF();
        }
        return xy;
    }
    //找色
    public int[] findColorF() throws InterruptedException {
        if (argsFlag == 1) {
            return findColor(analysisMainColor, analysisSubColor, distance, x1, y1, x2, y2);
        } else if (argsFlag == 0) {
            return findColor(analysisMainColor, analysisSubColor, distance, x1d, y1d, x2d, y2d);
        }
        return null;
    }


}
