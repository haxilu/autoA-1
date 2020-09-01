package com.example.scriptx1.scriptframe;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Page extends F<Page> {
    protected List<Fb> fbList;
    protected boolean isFind;

    public Page(int mainColor, String subColor, double distance, int x1, int y1, int x2, int y2) {
        super(mainColor, subColor, distance, x1, y1, x2, y2);
    }

    public Page(int mainColor, String subColor, double distance, int x1, int y1, int x2, int y2, int t, int r) {
        super(mainColor, subColor, distance, x1, y1, x2, y2, t, r);
    }

    public Page(int mainColor, String subColor, double distance, double x1, double y1, double x2, double y2) {
        super(mainColor, subColor, distance, x1, y1, x2, y2);
    }

    public Page(int mainColor, String subColor, double distance, double x1, double y1, double x2, double y2, int t, int r) {
        super(mainColor, subColor, distance, x1, y1, x2, y2, t, r);
    }

    public Page(int mainColor, String subColor, double distance, double x1, double y1, double x2, double y2, float xx, float yy) {
        super(mainColor, subColor, distance, x1, y1, x2, y2, xx, yy);
    }


    //--------------------------------------------------------------------------------------------------------------------------------------------------

    public Page add(Fb... fb) {
        if (this.fbList == null) {
            this.fbList = new ArrayList<>();
        }
        Collections.addAll(this.fbList, fb);

        return this;
    }



    public Page action(boolean debug, boolean b) throws InterruptedException {
        this.isFind = false;//没有找到颜色
        int[] xy = findColorT();
        if (xy != null && findColorAll() && findColorAny()) { //下面是界面内的操作(回调 或 点击)
            int x = xy[0] + partialX;
            int y = xy[1] + partialY;
            this.isFind = true;


            if (debug) {
                Log.i("找色log-a", String.format("找到【%s】{x=%s,y=%s,z=%s}", name, xy[0], xy[1], xy[2]));
            }
            //有回调不往下执行
            if (callBack != null) {
                callBack.fCallback(x, y, t, r);
            } else {

                //点击(默认不点击)
                if (isClick) {
                    click(x, y, t, r);
                    if (debug) {
                        Log.i("点击log-a", String.format("点击【%s】{x=%s,y=%s,z=%s}", name, xy[0], xy[1], xy[2]));
                    }
                }

            }
            _addClick();//附加点击

        }
        return this;

    }


}
