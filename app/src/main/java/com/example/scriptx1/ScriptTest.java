package com.example.scriptx1;

import android.util.Log;

import com.example.scriptx1.screendo.ScreenLib;

import com.example.scriptx1.scriptframe.F;
import com.example.scriptx1.scriptframe.Fb;
import com.example.scriptx1.scriptframe.Fcallback;
import com.example.scriptx1.scriptframe.Page;
import com.example.scriptx1.scriptframe.TsFrame;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ScriptTest extends TsFrame {
    private static ScriptTest instance = null;
    private long 书院时间记录 = 0;
    private long 书院间隔点击时间 = 60000L * 1L;

    private long 关卡时间记录 = 0;
    private long 关卡间隔点击时间 = 60000L * 1L;

    private ScriptTest() {
    }

    public static ScriptTest getInstance() {
        if (instance == null) {
            instance = new ScriptTest();
        }
        return instance;
    }

    @Override
    protected List<Page> getPages() {
        debug();//开启调式
        List<Page> mPage = new ArrayList<>();
        mPage.add(new Page(0xae6c65, "17|-5|0xaf615a,36|8|0x6d1f1b,-3|30|0x541a1d,31|39|0x5b0e14", 90, 84, 1032, 130, 1061)
                .setName("府邸界面")
                .add(
                        new Fb(0xe9301b, "-2|-3|0xf5522e,-2|5|0xdd1109,4|0|0xe9311b", 90, 206, 1153, 483, 1246)
                                .setName("红点"),
                        new Fb(0xf0e5cc, "-30|3|0xf0e5cc,-73|2|0xf0e5cc,-97|-1|0xf0e5cc", 40, 126, 514, 689, 560)
                                .setName("气泡对话框")

                        ,
                        new Fb(0xf2ead4, "0|13|0xf0e5cc,0|24|0xf0e5cc,21|25|0xf0e5cc,19|-3|0xf3ead5", 90, 632, 701, 679, 751)
                                .setName("子嗣气泡对话框"),
                        new Fb(0xf5cd51, "8|-14|0xf6df56,13|-26|0xf3d959,-22|2|0xcf190c,-17|-15|0xe11e0b,-7|-31|0xd21008", 90, 603, 35, 630, 64)
                                .setName("出府按钮")
                                .setCallBack(new Fcallback() {
                                    @Override
                                    public void fCallback(int x, int y, int t, int r) throws InterruptedException {
                                        if (书院时间记录==0){
                                            书院时间记录=System.currentTimeMillis();
                                        }else if (System.currentTimeMillis()-书院时间记录>=书院间隔点击时间){
                                            ScreenLib.click(x,y,t,r);
                                            关卡时间记录=System.currentTimeMillis();
                                            书院时间记录=System.currentTimeMillis();
                                        }
                                    }
                                })



                )
        );

        mPage.add(new Page(0x241a12, "172|4|0x2a1c13,-1|-9|0xb57a3b,139|-9|0xba844b,-112|110|0x4c546a,39|110|0x4d5366,-253|86|0xf2d18c,-252|76|0xfbe89d,-253|71|0xd9955a", 90, 258, 45, 367, 82)
                .setName("成就界面")
                .add(

                        new Fb(0xe52615, "0|3|0xdc1008,-3|3|0xdc1108,-3|0|0xe52715,4|0|0xe62816", 90, 120, 180, 146, 790)
                                .setName("红点1")
                                .setAgain()
                        ,

                        new Fb(0xe52615, "0|3|0xdc1008,-3|3|0xdc1108,-3|0|0xe52715,4|0|0xe62816", 90, 466, 182, 491, 807)
                                .setName("红点2")
                                .setAgain()
                        ,

                        new Fb(0x8e3e2c, "-11|10|0x994531,-18|17|0xa44b35,-19|0|0x8e3e2c,-6|16|0xa64c36,-10|-5|0xf0be5d,-24|8|0xf2d474", 40, 659, 64, 714, 105, 1500, 10)
                                .setName("成就灯笼退出按钮")

                )

        );

        mPage.add(new Page(0xa13a1e, "-14|0|0xa13a1e,-34|19|0xa13a1d,-34|35|0xa13a1d,-15|56|0xa13a1d,10|56|0xa13a1d,4|40|0x25100b,-11|15|0x25100b", 90, 211, 171, 259, 235)
                .setName("成就详情界面")
                .add(

                        new Fb(0xda8832, "0|19|0x6c3717,38|-2|0xe49639,82|1|0xd5802f", 90, 514, 302, 553, 993, 1500, 5)
                                .setName("成就领取按钮")
                                .setAgain()

                        ,
                        new Fb(0xfde9c6, "-10|-9|0xfeefcf,11|-12|0xfef2d6,-12|14|0xfddfaf,15|16|0xfcdeac,-19|3|0x1f293b,28|3|0x1d2738,1|-20|0x385572", 40, 616, 181, 673, 231)
                                .setName("成就详情退出按钮")

                )

        );

        mPage.add(new Page(0xfef2b9, "-8|0|0xfef2b9,-19|6|0xf0d88e,-21|11|0xfedd7c,-13|5|0x321308,-5|4|0x2e0c03,-17|12|0x2e0c03,-429|100|0x7290a7,-430|62|0x7498b4", 90, 351, 60, 441, 95)
                .setName("经营资产界面")
                .add(

                        new Fb(0xeba13f, "2|24|0x804118,57|-1|0xefac45,105|0|0xeba13f", 90, 460, 446, 479, 1193)
                                .setName("经营按钮")
                                .setAgain()
                        ,
                        new Fb(0x8e3e2c, "-11|10|0x994531,-18|17|0xa44b35,-19|0|0x8e3e2c,-6|16|0xa64c36,-10|-5|0xf0be5d,-24|8|0xf2d474", 40, 659, 64, 714, 105)
                                .setName("灯笼退出按钮")


                )

        );

        mPage.add(new Page(0xfeefb0, "-4|5|0xfee594,-6|7|0xfee086,6|4|0xfee799,13|9|0xfede7e,-252|259|0x702421,-252|251|0x702421,-225|251|0x702421,-224|262|0x702421", 90, 270, 59, 340, 99)
                .setName("处理公务界面")
                .all(new Page(0x5c6486, "-5|-21|0x5c6486,25|5|0x5c6486,707|0|0x5c6486,682|4|0x5c6486", 90, 0, 262, 38, 305))
                .add(
                        new Fb(0x8e3e2c, "-11|10|0x994531,-18|17|0xa44b35,-19|0|0x8e3e2c,-6|16|0xa64c36,-10|-5|0xf0be5d,-24|8|0xf2d474", 40, 659, 64, 714, 105)
                                .setName("灯笼退出按钮")
                                .setCallBack(new Fcallback() {
                                    @Override
                                    public void fCallback(int x, int y, int t, int r) throws InterruptedException {
                                        if (getFlag() == 0) return;
                                        //找 使用按钮
                                        int[] xy = ScreenLib.findColor(0xe5973a, "-1|18|0x924a1b,36|-2|0xeda541,76|-2|0xe89b3c", 90, 535, 1045, 592, 1147);
                                        if (xy == null) {
                                            ScreenLib.click(289, 1049, 1000, 25);
                                        } else {
                                            ScreenLib.click(x, y, t, r);
                                        }
                                    }
                                })

                )

        );

        mPage.add(new Page(0xfeefb0, "-7|10|0xfedb79,5|9|0xfede7e,-8|1|0xfeedab,8|0|0xfeefb0,-6|-6|0xfeface,3|-7|0xfefcd1,-2|-16|0x422b1b,-30|-17|0x362214", 90, 303, 73, 428, 89)
                .setName("任务界面")
                .all(
                        new Page(0xb1a19d, "28|0|0xb0a09c,78|8|0xb1a49f,126|4|0xb1a19d", 60, 316, 457, 368, 502),
                        new Page(0xeff20b, "-5|13|0xfef806,2|27|0xfee004,9|14|0xfeac22,-8|-2|0xa42b0a", 90, 63, 245, 100, 297)
                )
                .add(

                        new Fb(0x944b1b, "-2|-16|0xeba240,33|-15|0xea9e3e,66|-15|0xe99c3d", 90, 539, 464, 586, 1228)
                                .setName("领取按钮")
                                .setAgain()
                        ,
                        new Fb(0xb6aa5c, "1|7|0xa49854,8|18|0x9c914f,16|19|0x8c8142", 90, 177, 173, 697, 231)
                                .setName("宝箱按钮")
                                .setAgain()
                        ,


                        new Fb(0x8e3e2c, "-11|10|0x994531,-18|17|0xa44b35,-19|0|0x8e3e2c,-6|16|0xa64c36,-10|-5|0xf0be5d,-24|8|0xf2d474", 40, 659, 64, 714, 105, 1500, 10)
                                .setName("任务界面灯笼退出按钮")

                )

        );
        mPage.add(new Page(0xfef9c7, "-5|1|0xfef7c3,4|1|0xfef7c3,1|11|0xfee28b,-4|13|0xfede80,5|13|0xfede80,11|5|0x3a2516,-297|404|0x9e381c,-297|399|0x9e381c,-293|399|0x9e381c", 90, 287, 65, 426, 93)
                .setName("红颜知己界面")
                .add(

                        new Fb(0xdd8a33, "-4|19|0x8e481a,37|-2|0xe79b3c,71|1|0xe5973a", 90, 483, 1164, 531, 1264)
                                .setName("随机传唤按钮")
                                .setT(6000)
                                .setAgain()
                                .addClick(200,300)
                        ,
                        new Fb(0x8e3e2c, "-11|10|0x994531,-18|17|0xa44b35,-19|0|0x8e3e2c,-6|16|0xa64c36,-10|-5|0xf0be5d,-24|8|0xf2d474", 40, 659, 64, 714, 105, 1500, 10)
                                .setName("红颜知己灯笼退出")


                )

        );

        mPage.add(new Page(0xfefacd, "10|0|0xfefacd,18|0|0xfefacd,25|0|0xfefacd,36|8|0xfeeba5,59|8|0xfeeba5,-312|79|0xf7e9d8,-298|79|0xfff1df,-298|91|0xf9ecda,-313|91|0xfef0de", 90, 338, 60, 416, 98)
                .setName("子嗣界面")
                .add(
                        new Fb(0xeba23f, "0|26|0x6d3718,26|3|0xeda541,64|1|0xeda642", 90, 481, 616, 530, 662)
                                .setName("培养按钮")
                                .setAgain()
                        ,
                        new Fb(0x8e3e2c, "-11|10|0x994531,-18|17|0xa44b35,-19|0|0x8e3e2c,-6|16|0xa64c36,-10|-5|0xf0be5d,-24|8|0xf2d474", 40, 659, 64, 714, 105, 1000, 10)
                                .setName("子嗣灯笼退出按钮")

                )

        );


        mPage.add(new Page(0xbb703e, "20|10|0xe0b563,10|28|0xd09051,-7|26|0xad582d,-8|12|0xa86035,5|16|0x232830", 70, 33, 999, 90, 1059)
                .setName("府邸外界面")
                .add(
                        new Fb(0xfeda82, "0|-2|0xfed97d,0|4|0xfedd89,0|9|0xfadd91,-4|1|0xfeda82,-7|3|0xfedd89", 90, 131, 598, 659, 607)
                                .setName("书院")
                                .setPartialX(55)
                                .setPartialY(20)
                                .setTime(60000L * 10L)

                        ,
                        new Fb(0xfde9ad, "0|10|0xfeebb5,0|24|0xefe1b5,-8|13|0xfeedba,10|10|0xfeedba,0|-8|0x110f0d,0|34|0x1b1714,0|-20|0xfeda81", 90, 151, 961, 662, 970)
                                .setName("关卡")
                                .setPartialX(-30)
                                .setTime(60000L * 10L)
                        ,
                        new Fb(0xf5cd51, "8|-14|0xf6df56,13|-26|0xf3d959,-22|2|0xcf190c,-17|-15|0xe11e0b,-7|-31|0xd21008", 90, 603, 35, 630, 64)
                                .setName("进府按钮")
                                .setCallBack(new Fcallback() {
                                    @Override
                                    public void fCallback(int x, int y, int t, int r) throws InterruptedException {
                                        if (关卡时间记录==0){
                                            关卡时间记录=System.currentTimeMillis();
                                        }else if (System.currentTimeMillis()-关卡时间记录>=关卡间隔点击时间){
                                            ScreenLib.click(x,y,t,r);
                                            关卡时间记录=System.currentTimeMillis();
                                            书院时间记录=System.currentTimeMillis();
                                        }
                                    }
                                })
                )

        );

        mPage.add(new Page(0xfee99e, "7|-2|0xfeeeab,14|-2|0xfeeeab,20|-1|0xdfcc8d,24|-1|0xfeeba5,-14|-4|0x392415,-215|3|0xb66b24,-201|3|0xb66b24,-195|3|0xb66b24", 90, 323, 60, 409, 94)
                .setName("书院界面")
                .add(

                        new Fb(0x6afb00, "5|0|0x67f201,8|0|0x67f201,12|0|0x67f201,13|-4|0x65eb02", 90, 154, 523, 190, 1053)
                                .setName("门客学习完成按钮1")
                                .setAgain()

                        ,
                        new Fb(0x6afb00, "5|0|0x67f201,8|0|0x67f201,12|0|0x67f201,13|-4|0x65eb02", 90, 486, 515, 513, 972)
                                .setName("门客学习完成按钮2")
                                .setAgain()
                        ,

                        new Fb(0xf5f1aa, "0|7|0xfcf9b0,0|12|0xfffcb2,-4|0|0xf4f1aa,-10|0|0xf7f3ac", 90, 279, 506, 302, 948)
                                .setName("门客学习桌1")
                                .setAgain()
                        ,

                        new Fb(0xf5f1aa, "0|7|0xfcf9b0,0|12|0xfffcb2,-4|0|0xf4f1aa,-10|0|0xf7f3ac", 90, 595, 519, 620, 967)
                                .setName("门客学习桌2")
                                .setAgain()
                        ,

                        new Fb(0x8e3e2c, "-11|10|0x994531,-18|17|0xa44b35,-19|0|0x8e3e2c,-6|16|0xa64c36,-10|-5|0xf0be5d,-24|8|0xf2d474", 40, 659, 64, 714, 105)
                                .setName("书院灯笼退出按钮")


                )
        );

        mPage.add(new Page(0xfefed6, "5|1|0xfefcd2,12|1|0xfefcd2,12|11|0xfeeda7,12|16|0xfee48f,12|20|0xfedd7d,-10|1|0xfefcd2,-12|11|0xfeeda7,-12|19|0xfede7f", 90, 253, 161, 419, 186)
                        .setName("门客选择界面")
                        .add(

                                new Fb(0x426d9c, "-1|15|0x142643,29|-1|0x4c7dab,53|-3|0x5186b3,84|-5|0x5790ba", 90, 494, 368, 535, 1008)
                                        .setName("派遣按钮")
                                ,

                                new Fb(0xfde8c5, "-10|-11|0xfef1d5,11|-12|0xfef2d6,-12|13|0xfddfaf,13|13|0xfcdeac,-12|-2|0x1d2738,16|-2|0x1d2738", 90, 633, 153, 687, 205)
                                        .setName("门客选择退出按钮")

                        )
        );

        mPage.add(new Page(0xe1964a, "0|7|0x25150b,118|1|0xe4994f,109|129|0xfef43f,105|133|0xfbe303,87|174|0x702421,79|196|0x6f2421,87|214|0x702421", 90, 267, 39, 327, 66)
                .setName("关卡界面")
                .add(
                        new Fb(0xfef7a4, "14|1|0xfef7a4,-9|1|0xfef7a4,1|5|0x13151a,6|5|0x121317,6|-4|0xc05b1c,-1|-4|0xc76220", 90, 48, 330, 673, 930)
                            .setName("双剑战斗图标")
                            .setPartialY(15)

                )
        );
        mPage.add(new Page(0xfee34b, "13|16|0xfee34b,46|6|0x5081ad,-27|9|0x5082ae,-428|-5|0x99b4c8,-654|105|0x819eb4", 90, 628, 118, 706, 145)
                .setName("开始战斗界面")
                .add(
                        new Fb(0xfef590, "8|0|0xfef032,-1|74|0xf8d833,-8|74|0xf9d013,59|74|0xf9c602,65|69|0xf8d723,59|6|0xfef210,57|11|0xfef254", 90, 290, 618, 360, 689)
                                .setName("开始战斗按钮")
                                .setPartialY(15)
                        ,
                        new Fb(0xf68d13, "5|10|0xec3b27,8|5|0xf1521b,11|2|0xf57d1a,11|6|0xf1521b", 90, 588, 889, 650, 940)
                                .setName("跳过战斗按钮")

                )
        );

        mPage.add(new Page(0xfaf833, "5|-22|0xd9a302,8|-41|0xfeed05,8|-66|0xf42d01,34|-76|0xfa8304,34|-49|0xfdcd04,51|1|0xfaf835,91|-1|0xfbfb7e,75|-49|0xfdc603", 90, 368, 439, 492, 557)
                .setName("决胜按钮")
                .setClick(true)

        );
        mPage.add(new Page(0x73ddf7, "-1|8|0x73ddf7,0|18|0x73ddf7,107|0|0x73ddf7,107|19|0x73ddf7", 90, 560, 1192, 690, 1231)
                .setName("对话框界面")
                .setClick(true)

        );




        return mPage;
    }

}
