package com.example.scriptx1;

import android.content.Context;
import android.content.SharedPreferences;
import android.renderscript.Script;
import android.util.Log;
import android.widget.Toast;

import com.example.scriptx1.screendo.ScreenLib;
import com.example.scriptx1.scriptframe.Fb;
import com.example.scriptx1.scriptframe.Fcallback;
import com.example.scriptx1.scriptframe.Page;
import com.example.scriptx1.scriptframe.TsFrame;
import com.example.scriptx1.scriptframe.UnFcallback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScriptPaoMianSanGuo extends TsFrame {
    SharedPreferences sp;
    boolean 灵符挑战记录 = true;
    boolean 群雄涿鹿挑战记录 = true;
    String 挑战次数界面判断="null";
    @Override
    protected List<Page> getPages() {


       // Toast.makeText(MainActivity.CONTEXT, String.format("sp = %s", sp.getBoolean("checkBox3 ",true)), Toast.LENGTH_SHORT).show();
        List<Page> mPage = new ArrayList<>();
        mPage.add(new Page(0x604415, "12|-1|0xfcecd2,23|3|0x604415,35|4|0xfdefd4", 90, 24, 1925, 31, 1931)
                .setName("主界面")
                .add(
                        new Fb(0xffc61c, "-8|-19|0xfffdf1,-31|-26|0xffcf1a,14|-26|0xffd70d", 90, 154, 1482, 162, 1491)
                        .setName("讨伐吕布按钮").setCheckBox("自动讨伐吕布"),

                        new Fb(0xe10028, "16|3|0xd80029,6|8|0xce0027", 90, 831, 2004, 866, 2035)
                        .setName("内政红点")
                        .setTime(15*60000).setCheckBox("自动内政征收"),

                        new Fb(0xdb0028, "-8|-8|0xf1002b,7|9|0xc30023", 90, 1017, 2016, 1024, 2025)
                        .setName("联盟红点")
                        .all(new Fb(0x604415, "12|-1|0xfcecd2,23|3|0x604415,35|4|0xfdefd4", 90, 24, 1925, 32, 1931))
                        .setTime(60000*10).setCheckBox("自动联盟巡查"),

                        new Fb(0xeb002b, "4|4|0xdd0029,10|10|0xc80025", 90, 76, 925, 104, 955)
                        .setName("玩法红点").setTime(10000),

                        new Fb(0xf1002b, "9|0|0xef002c", 90, 554, 955, 574, 977)
                        .setName("群雄涿鹿红点").setCheckBox("自动群雄涿鹿"),

                        new Fb(0xf6012c, "8|8|0xd80029,16|12|0xc80025", 90, 700, 951, 726, 978)
                                .setName("灵符争夺红点").setCheckBox("自动灵符争夺"),
                        new Fb(0xf1002b, "3|5|0xde0029,8|9|0xce0026", 90, 251, 956, 270, 976)
                            .setName("征战红点"),
                        new Fb(0xe9002b, "5|6|0xd7002a,12|9|0xc90025", 90, 403, 1261, 413, 1269)
                            .setName("好友红点 ").setTime(6000*10).setCheckBox("自动领取好友名望"),
                        new Fb(0xffe773, "-7|-15|0xeab75b,-8|11|0xf4c963,8|0|0xfce170", 90, 113, 1006, 120, 1016)
                            .setName("收起三角形")
                            .setPartialX(-60)
                )
                .setCallBack(new Fcallback() {
                    @Override
                    public void fCallback(int x, int y, int t, int r) throws InterruptedException {
                        灵符挑战记录=true;
                        群雄涿鹿挑战记录 = true;
                        挑战次数界面判断="null";
                    }
                })
        );

        mPage.add(new Page(0xb41f07, "224|9|0xb51f07,447|2|0xb41f07,662|-3|0xb41f07", 90, 130, 879, 153, 901)
                .setName("内政界面")
                .add(
                        new Fb(0xcf0025, "9|-6|0xe1002a,18|-12|0xf1002d", 90, 484, 715, 520, 750)
                                .setName("征收红点"),
                        new Fb(0xede5c0, "13|-14|0xc43c08,-20|-8|0xc73f05", 90, 1006, 476, 1026, 491)
                                .setName("退出_内政界面按钮").all(new Fb(0xb41f07, "224|9|0xb51f07,447|2|0xb41f07,662|-3|0xb41f07", 90, 130, 879, 153, 901))

                )
        );

        mPage.add(new Page(0x03bfc8, "29|-4|0x01bdc6,443|-4|0x8ba800,468|-3|0x8ba800", 90, 220, 1566, 245, 1592)
                .setName("征收界面")
                .add(
                        new Fb(0x01bdc6, "0|46|0x019ead,38|50|0x019ead", 90, 217, 1568, 241, 1590)
                                .setName("一键征收按钮")
                                .all(
                                        new Fb(0xf2012c, "10|7|0xde0029,15|15|0xc70125", 90, 869, 1525, 904, 1555)
                                        .setName("征收按钮红点")
                                )

                        ,
                        new Fb(0xefe6bf, "-26|0|0xcb3e08,1|-22|0xc93d02,19|-15|0xc93e05", 90, 1006, 469, 1027, 490)
                                .setName("退出_征收界面按钮")
                )
        );

        mPage.add(new Page(0xb41f07, "6|59|0x8e0b01,94|-12|0xb41f07,180|16|0xb41c04", 90, 434, 1927, 453, 1948)
                .setName("战斗动画界面")
                .setClick(true)


        );


        mPage.add(new Page(0x008bb9, "-2|3|0x17b7eb,-12|-11|0xfffdd2,50|23|0x0593c1", 90, 128, 1019, 145, 1036)
                .setName("灵符争夺界面")
                .setCallBack(new Fcallback() {
                    @Override
                    public void fCallback(int x, int y, int t, int r) throws InterruptedException {
                        挑战次数界面判断="挑战次数界面_灵符争夺";
                        if(灵符挑战记录){
                            //灵符挑战按钮
                            ScreenLib.findColorClick(0x89a900, "-1|18|0x8da600,-5|40|0x648200", 90, 164, 1570, 848, 1584);
                        }
                    }
                })
                .add(
                        new Fb(0xde0029, "0|-10|0xfb0b38,10|-4|0xe5002b", 90, 181, 1005, 190, 1014)
                        .setName("灵符密藏"),
                        new Fb(0xede5c0, "-18|-7|0xc93d08,6|-24|0xd03e03,18|-13|0xca3e03", 90, 1008, 472, 1026, 487)
                        .setName("退出_灵符挑战")

                )



        );
        mPage.add(new Page(0x4e4130, "14|5|0xfffffb,10|13|0xfcf8f5,6|18|0xf3ece4,22|11|0xdad0c6,32|13|0xfffffd,30|17|0xfefdf9,7|34|0xfffffd,18|37|0x514131,40|39|0xfffffb", 90, 546, 818, 597, 840)
                .setName("挑战次数界面")
                .setCallBack(new Fcallback() {
                    @Override
                    public void fCallback(int x, int y, int t, int r) throws InterruptedException {
                        switch(挑战次数界面判断){
                            case "挑战次数界面_灵符争夺":
                                灵符挑战记录=false;
                                Log.i("log-","挑战次数界面_灵符争夺");
                                ScreenLib.click(1025,  830);//退出挑战次数界面

                                break;
                            case "挑战次数界面_群雄涿鹿":
                                群雄涿鹿挑战记录 = false;
                                Log.i("log-","挑战次数界面_群雄涿鹿");
                                ScreenLib.click(1025,  830);//退出挑战次数界面
                                break;
                            case "null":
                                Log.i("log-","没有前置界面");                        }

                    }
                })

        );


        mPage.add(new Page(0x68000b, "100|-5|0x68000b,231|-4|0x68000b,442|-4|0x68000b,598|-3|0x68000b,725|-2|0x68000b,813|1|0x68000b", 90, 132, 1564, 147, 1573)
                .setName("灵符进攻胜利界面")
                .add(new Fb(0xe8b51e, "159|243|0xf2c222,410|-2|0xe2b71d,662|246|0xe2b423", 90, 194, 1190, 219, 1220)
                        .setName("翻卡"),
                        new Fb(0xf1cb20, "-1|6|0xeec619,-9|7|0xf4cc1d,10|8|0xe7c420,-1|15|0xe3c12a,-7|15|0xe6c327", 90, 474, 1706, 508, 1739)
                        .setName("点击关闭按钮")

                )


        );

        mPage.add(new Page(0xe1b41d, "846|-2|0xe2b31f,846|321|0xcaa72f,2|321|0xcba92d,446|1|0x8b220f", 90, 110, 619, 118, 627)
                .setName("征战界面")
                .add(new Fb(0xdc0028, "-14|-13|0xf7002d,9|13|0xc40024", 90, 971, 1324, 980, 1332)
                        .setPartialX(-50)
                        .setPartialY(50)
                        .setName("平叛剿匪红点").setUnCallBack(new UnFcallback() {
                            @Override
                            public void unfCallback() throws InterruptedException {
                                //滚动
                                ScreenLib.screenSlide(685, 1579,694,  705);
                                //讨伐吕布红点
                                if(ScreenLib.findColorClick(0xdc0028, "-14|-13|0xf7002d,9|13|0xc40024", 90, 971, 1324+100, 980, 1332)==null){
                                   //退出  征战界面
                                    ScreenLib.click( 1030,  501);
                                }
                            }
                        }).setCheckBox("自动平叛剿匪")


                )
        );
        mPage.add(new Page(0xd78b02, "-452|-108|0xb41e05,-319|-109|0x8ca700,-52|-264|0xed381b", 90, 934, 1083, 941, 1090)
                .setName("平叛剿匪界面 ")
                .add(new Fb(0x8ba800, "2|29|0x648200,67|-1|0x8ba800", 90, 610, 968, 618, 977)
                        .setName("剿匪5次按钮"),
                        new Fb(0xde0029, "-8|-6|0xef002c,9|10|0xc30022", 90, 932, 908, 940, 915)
                        .setName("奖励红点"),
                        new Fb(0xf0e7be, "-31|-23|0xc83d06,24|29|0xae3602,-160|431|0xffdb10,-139|447|0xfffd5a", 90, 1026, 494, 1036, 503)
                        .setName("退出_平叛剿匪界面按钮")

                )
        );


        mPage.add(
                new Page(0xe69375, "-17|13|0xe89575,15|11|0xec9778,-54|160|0x533336,190|119|0xfffccf", 90, 533, 750, 541, 758)
                        .setName("恭喜获得界面")
                        .setClick(true)
        );

        mPage.add(new Page(0xe79476, "-92|35|0xfdb48b,89|27|0xf7a782,0|211|0xbd7b63,-196|97|0xfffed2,215|117|0xfefbce", 90, 531, 753, 542, 759)
                .setName("挑战结束界面")
                .setClick(true)
        );


        mPage.add(
                new Page(0x8ba800, "232|-2|0xb42006,461|2|0x01bdc6,689|4|0x8ba800", 90, 122, 1631, 133, 1640)
                .setName("好友界面")
                .add(
                        new Fb(0xe6012a, "10|11|0xc70125,11|-1|0xe8002a", 90, 735, 1616, 968, 1624)
                        .setName("一键赠送按钮，一键领取按钮-红点")
                        .setAgain(),
                        new Fb(0xd90128, "2|-12|0xfe0432,1|9|0xc40024", 90, 458, 609, 465, 617)
                        .setName("申请红点"),
                        new Fb(0x8ca700, "2|36|0x648200", 90, 682, 1634, 689, 1641)
                        .setName("一键同意"),
                        new Fb(0xf0e8c1, "-25|-29|0xca3e03,26|25|0xac3402", 90, 1024, 498, 1033, 505)
                        .setName("退出_好友界面按钮")



                )


        );

        mPage.add(new Page(0xf82419, "1|31|0xfde732,-4|61|0xe5bb11,-13|99|0xfedf0b,-27|69|0xef1b0f,73|-2|0xd80e0c", 90, 92, 617, 101, 624)
                .setName("联盟界面")
                .add(
                        new Fb(0xf5002c, "10|1|0xf4032d", 90, 291, 1160, 310, 1176)
                        .setName("联盟巡查红点")
                        .setUnCallBack(new UnFcallback() {
                            @Override
                            public void unfCallback() throws InterruptedException {
                                ScreenLib.click( 1027,  496);
                            }
                        })

                )
        );

        mPage.add(new Page(0xd4730a, "96|284|0xd4730a,1|283|0xd4730a,92|3|0xd4730a,-1|357|0xd4730a", 90, 183, 791, 192, 801)
                .setName("联盟巡查界面")
                .add(
                        new Fb(0x8ca700, "207|-43|0xef002a,207|-28|0xc60024", 90, 711, 1060, 717, 1066)
                        .setName("巡查红点按钮")
                        .setUnCallBack(new UnFcallback() {
                            @Override
                            public void unfCallback() throws InterruptedException {
                                ScreenLib.click( 1034,  498);
                            }
                        })
                )

        );

        mPage.add(new Page(0xffd757, "-1|-41|0x8ba800,257|-652|0xf88c10,267|-497|0xffffff,322|-489|0xfdd708", 90, 451, 1535, 460, 1543)
                .setName("联盟巡查_购买事件")
                .setCallBack(new Fcallback() {
                    @Override
                    public void fCallback(int x, int y, int t, int r) throws InterruptedException {
                        ScreenLib.click( 1030,  742);
                    }
                })
        );

        mPage.add(new Page(0x8ba800, "5|-195|0xc47b74,169|-196|0xc57c75,-52|-195|0x492318,240|-179|0x48231b,77|-317|0xfcd740", 90, 446, 1379, 457, 1389)
                .setName("联盟巡查_司隶")
                .setClick(true)
        );

        mPage.add(new Page(0x8ba800, "-142|27|0xfede65,-164|6|0x8a684c,-177|-8|0x31200e,-329|29|0xfede65,-345|8|0x7e6044,-362|-16|0x352211", 90, 723, 1291, 732, 1302)
                .setName("联盟巡查_组队战斗事件")
                .setClick(true)
                .addClick( 1023,  738)
        );

        mPage.add(new Page(0xe80f17, "9|-24|0xfb1313,15|-37|0xfae649,25|-33|0xd78227,-59|-6|0xc6ad74,-125|8|0x353688", 90, 306, 819, 312, 825)
                .setName("奖励日志_排名奖励界面")
                .add(
                        new Fb(0xdb002a, "0|-14|0xfc0b38,1|12|0xc20023", 90, 551, 609, 558, 616)
                        .setName("累计伤害红点").addUnClick(1029,  501)
                )
        );

        mPage.add(new Page(0xad1105, "0|249|0xae1206,48|249|0xae1408,187|-110|0xc28006,366|-112|0xf7a513", 90, 184, 754, 191, 767)
                .setName("奖励日志_累计伤害界面")
                .add(new Fb(0x8ba800, "-1|35|0x648200,86|-7|0x89a900", 90, 431, 1752, 440, 1759)
                        .setName("一键领取按钮")
                        .addClick( 1029,  501)
                )
        );

        mPage.add(new Page(0x3ff548, "114|20|0x2bef11,112|35|0xfceab8,39|348|0xb51f06,-584|354|0xfffa00", 90, 790, 594, 802, 602)
                .setName("群雄涿鹿界面").setCallBack(new Fcallback() {
                    @Override
                    public void fCallback(int x, int y, int t, int r) throws InterruptedException {
                        挑战次数界面判断="挑战次数界面_群雄涿鹿";
                        //退出群雄涿鹿界面
                        if(!群雄涿鹿挑战记录) {
                           ScreenLib.click(1032,  453);
                        }
                    }
                })
                .add(
                        new Fb(0xeb002d, "1|16|0xc30023", 90, 429, 713, 958, 724)
                        .setName("宝箱红点").setAgain(),
                        new Fb(0x89a900, "-1|13|0x8ea401", 90, 285, 1286, 825, 1294)
                        .setName("挑战按钮1").setAgain(),
                        new Fb(0x89a900, "1|16|0x8da600", 90, 288, 1644, 805, 1651)
                        .setName("挑战按钮2").setAgain(),
                        new Fb(0xfbfbfb, "-1|11|0xfbfbfb,-79|47|0xfbfbfb", 90, 925, 727, 934, 735)
                        .setName("灰色宝箱").addClick(853,  952).setClick(false)

                )


        );
        mPage.add(new Page(0xe49577, "-117|102|0xc68066,116|98|0xdd9273,-21|50|0xffff83", 90, 530, 568, 544, 577)
                .setName("群雄涿鹿胜利界面")
                .setClick(true)

        );

        mPage.add(new Page(0x8ba800, "-230|-5|0xb41f07,149|-214|0x513007,148|-226|0xbfa87c,148|-231|0xd3be91,148|-235|0xd1bc8f,148|-239|0x61441a", 90, 645, 1365, 658, 1376)
                .setName("群雄涿鹿_刷新提示框界面")
                .setClick(true)

        );

        mPage.add(new Page(0xfe2e2e, "-1|18|0x8c1c1b,0|36|0xec282a,14|-1|0xfffdcb,8|-141|0xfff112", 90, 861, 1097, 871, 1111)
                .setName("讨伐吕布界面")
                .add(
                        new Fb(0x8ca901, "48|49|0xfefee4,69|50|0xfefde8,83|49|0xfefee4", 90, 448, 1101, 458, 1110)
                        .setName("挑战冷却中按钮").addUnClick(553, 1124),
                        new Fb(0x919191, "3|47|0x6e6e6e,58|6|0xfafafa,58|11|0x919191", 90, 459, 1101, 468, 1110)
                        .setName("已领取按钮").addClick(1028,  501).setClick(false),
                        new Fb(0x292929, "-126|52|0xdcdcdc,53|-71|0x292929", 90, 646, 843, 657, 854)
                        .setName("灰色吕布图片").addClick(1028,  501).setClick(false)
                )

        );

        return mPage;
    }
}
