package com.example.scriptx1.scriptframe;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class TsFrame {

    private List<Page> mPages;//脚本界面特征列表
    private int flag = 0; //控制脚本执行和退出
    public boolean debug;
    private Page mPage;
    private Fb mFb;
    boolean isd = false;
    private ArrayList<String> upName = new ArrayList<String>() {{
        add(null);
        add(null);
    }};

    public TsFrame() {
        this.mPages = getPages();


    }


    protected void debug() {
        this.debug = true;
    }

    protected abstract List<Page> getPages();

    //启动脚本
    public void start() {
        if (flag == 0) {
            flag = 1;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        body();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

    }

    //结束脚本
    public void finish() {
        flag = 0;
    }

    //获取脚本执行状态
    public int getFlag() {
        return flag;
    }

    //记录上一个界面的name值
    private void saveUpName(String name) {
        if (!name.equals(upName.get(upName.size() - 1))) {
            upName.add(name);
        }
        if (upName.size() > 5) {
            upName.remove(0);
        }

    }

    //脚本逻辑（页面）
    private void body() throws InterruptedException {
        // Log.i("qqqqqqqqqq", "上一个界面是：" + upName.get(upName.size()-2));
        for (Page pag : mPages) {
            if (flag == 0) return;
            mPage = pag.action(debug, true);// 找到界面
            if (mPage.isFind) {//找到界面
                if (pag.fbList != null) {//子页面操作
                    for (Fb fb : pag.fbList) {
                        if (flag == 0) return;
                        fb.action(this);
                    }
                }
            }
        }

        if (flag == 1) {
            body();
        }
    }


}
