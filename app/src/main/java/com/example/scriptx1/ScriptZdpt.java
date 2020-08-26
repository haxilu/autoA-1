package com.example.scriptx1;

import com.example.scriptx1.scriptframe.Fa;
import com.example.scriptx1.scriptframe.Fb;
import com.example.scriptx1.scriptframe.TsFrame;

import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScriptZdpt extends TsFrame {
    private static ScriptZdpt instance= null;
    private ScriptZdpt(){}
    public static ScriptZdpt getInstance() {
        if (instance == null){
            instance = new ScriptZdpt();
        }
        return instance;
    }

    @Override
    protected List<Fa> getFa() {
        List<Fa> fa = new ArrayList<Fa>();
        fa.add(new Fa("主城界面",0xee873b, "-3|-40|0x74efff,-1|42|0xeee83b,65|-42|0x74efff,66|1|0xee873b,64|37|0xeee83b", 90, 95, 1512, 240, 1713));
        fa.add(new Fa("试炼界面",0x938c86, "-62|-5|0x950c12,-134|73|0xfedc37,117|79|0xfedb37,-59|69|0xc52717,45|70|0xc52815", 90, 478, 1723, 583, 1896));
        //点击开战
        fa.add(new Fa(0xff8c1c, "-62|0|0xff941f,69|-1|0xff941f,-133|-40|0xffc33d,118|-44|0xffc43e", 90, 484, 1265, 588, 1322));

        //点击确认
        fa.add(new Fa(0x60ad18, "-123|-8|0x64b219,125|3|0x60ad18,-252|-909|0x3c72c0,-205|-912|0x376fc2,204|-896|0x336cc2,293|-877|0x4274c0", 90, 504, 1439, 588, 1540));


    return fa;
    }

    @Override
    public Map<String, List<Fb>> getFb() {
        Map<String, List<Fb>> map = new HashMap<String, List<Fb>>();
        List<Fb> 主城界面 = new ArrayList<Fb>();
        主城界面.add(new Fb("点击试炼",0x98908c, "-93|-10|0xc2a780,-63|1|0x920913,33|5|0x880514,-61|61|0xdc371f,41|62|0xc52815", 90, 587, 1775, 653, 1916));

        List<Fb> 试炼界面 = new ArrayList<Fb>();
        试炼界面.add(new Fb("点击开战",0x5aab19, "-49|-30|0x79c625,-53|25|0x41900e,-161|-11|0x68b61c", 90, 947, 377, 986, 1050));


        map.put("试炼界面",试炼界面);
        map.put("主城界面",主城界面);
        return map;
    }
}
