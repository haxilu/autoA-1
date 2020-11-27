package com.example.scriptx1;

import com.example.scriptx1.screendo.ScreenLib;
import com.example.scriptx1.scriptframe.Fcallback;
import com.example.scriptx1.scriptframe.Page;
import com.example.scriptx1.scriptframe.TsFrame;

import java.util.ArrayList;
import java.util.List;

public class ScriptSs extends TsFrame {

    @Override
    protected List<Page> getPages() {
        debug();
        List<Page> Ppages = new ArrayList<>();
        Ppages.add(new Page(0x27b0f0, "-15|2|0x27b0f0,17|2|0x27b0f0", 90, 172, 1798, 186, 1811)
                .setName("首页")
                .setCallBack(new Fcallback() {
                    @Override
                    public void fCallback(int x, int y, int t, int r) throws InterruptedException {
                        ScreenLib.click(541, 1819);//控制台
                    }
                })

        );
        Ppages.add(new Page(0x27b0f0, "-20|0|0x27b0f0,16|0|0x27b0f0", 90, 534, 1781, 547, 1791)
                .setName("控制台")
                .setCallBack(new Fcallback() {
                    @Override
                    public void fCallback(int x, int y, int t, int r) throws InterruptedException {
                        ScreenLib.click(897, 1829);//我的
                    }
                })

        );

        Ppages.add(new Page(0x27b0f0, "-14|-3|0x27b0f0,12|-1|0x27b0f0", 90, 894, 1832, 906, 1840)
                .setName("我的")
                .setCallBack(new Fcallback() {
                    @Override
                    public void fCallback(int x, int y, int t, int r) throws InterruptedException {
                        ScreenLib.click(179, 1804);//首页
                    }
                })

        );

        return Ppages;
    }
}
