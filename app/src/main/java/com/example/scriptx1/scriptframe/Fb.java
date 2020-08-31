package com.example.scriptx1.scriptframe;


import android.util.Log;

public class Fb extends F<Fb> {

    public Fb(int mainColor, String subColor, double distance, int x1, int y1, int x2, int y2) {
        super(mainColor, subColor, distance, x1, y1, x2, y2);
        isClick=true;
    }

    public Fb(int mainColor, String subColor, double distance, int x1, int y1, int x2, int y2, int t, int r) {
        super(mainColor, subColor, distance, x1, y1, x2, y2, t, r);
        isClick=true;
    }

    public Fb(int mainColor, String subColor, double distance, double x1, double y1, double x2, double y2) {
        super(mainColor, subColor, distance, x1, y1, x2, y2);
        isClick=true;
    }

    public Fb(int mainColor, String subColor, double distance, double x1, double y1, double x2, double y2, int t, int r) {
        super(mainColor, subColor, distance, x1, y1, x2, y2, t, r);
        isClick=true;
    }

    public Fb(int mainColor, String subColor, double distance, double x1, double y1, double x2, double y2, float xx, float yy) {
        super(mainColor, subColor, distance, x1, y1, x2, y2, xx, yy);
        isClick=true;
    }


    //--------------------------------------------------------------------------------------------------------------------------------------------------

    public void action(boolean debug) throws InterruptedException {
        int[] xy = findColorT();
        if (xy!=null && findColorAll() && findColorAny()){ //下面是界面内的操作
            int x = xy[0]+partialX;
            int y = xy[1]+partialY;


            if(debug){
                Log.i("找色log-b",String.format("找到【%s】{x=%s,y=%s,z=%s}",name,xy[0], xy[1],xy[2]));
            }
            //有回调不往下执行
            if (callBack!=null) {
                callBack.fCallback(x, y,t,r);
            }else{

                //点击(默认点击)
                if (isClick){
                    click(x, y,t,r);
                    if(debug){
                        Log.i("点击log-b",String.format("点击【%s】{x=%s,y=%s,z=%s}",name,xy[0], xy[1],xy[2]));
                    }
                }

            }


        }


    }


}
