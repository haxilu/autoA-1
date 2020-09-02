package com.example.scriptx1;

import com.example.scriptx1.screendo.ScreenLib;
import com.example.scriptx1.scriptframe.Fb;
import com.example.scriptx1.scriptframe.Fcallback;
import com.example.scriptx1.scriptframe.Page;
import com.example.scriptx1.scriptframe.TsFrame;

import java.util.ArrayList;
import java.util.List;

public class ScriptHlsg2 extends TsFrame {

    Fb 小矿 = new Fb(0xed780d, "6|10|0xe8a730,15|21|0xf4c84b,23|30|0xedac0b,44|20|0xf3c872,51|12|0xfaeaa2", 90, 1, 1145, 36, 1364).setName("小矿");
    Fb 中矿 = new Fb(0x852bdf, "8|15|0x9711f5,23|30|0xb312fe,46|26|0x9f0ff8,49|22|0xba39fc", 90, 1, 1145, 36, 1364).setName("中矿");
    Fb 大矿 = new Fb(0x23c2ee, "5|8|0x24e2f7,15|16|0x1be1f7,31|28|0x14bff0,33|-1|0x58e8f8,53|12|0x86edfa", 90, 1, 1145, 36, 1364).setName("大矿");

    Fb 好友主城右箭头图标 = new Fb(0xd4c74d, "-10|-8|0xdad054,-18|-14|0xd9c853,-7|7|0xd2c94f,-12|13|0xd4c44a,-19|25|0xcdbc50", 90, 1056, 1581, 1078, 1671).setName("好友主城右箭头图标").setPartialX(-70);
    Fb 可占领 = new Fb(0x98f026, "5|0|0x98f026,11|0|0x98f026,18|0|0x98f026,19|4|0x96ed25,19|7|0x96ed25,19|12|0x94ea25,11|12|0x98f026,6|12|0x98f026,0|12|0x98f026", 90, 768, 1281, 821, 1304).setName("可占领").setPartialY(80);

    Fb 布阵防守按钮_矿 = new Fb(0x6bb81c, "3|28|0x58a715,68|-27|0x78c522,204|-24|0x79c623", 90, 388, 1610, 422, 1667).setName("布阵防守按钮_矿");
    Fb 退出按钮_矿 = new Fb( 0xfef0d3, "18|13|0xfceed0,28|24|0xfef1d4,7|28|0xfef1d5,36|-2|0xfdeed1,18|-12|0xe2773c,19|36|0xdc632c,-7|17|0xde6934,50|15|0xdd6c3a", 90, 971, 455, 1032, 513).setName("退出按钮_矿");
    Fb 退出按钮_布阵防守 = new Fb(0xfdeed0, "20|18|0xfef0d3,27|26|0xfef0d4,10|29|0xfcedd0,33|5|0xfcedcf,19|-4|0xdd7340,23|36|0xde652c", 90, 982, 230, 1036, 291).setName("退出按钮_布阵防守");
    Fb 布阵按钮 = new Fb(0x67b51a, "0|9|0x61af18,0|17|0x5caa17,-8|10|0x60ad18,8|9|0x63b019,13|-3|0xf5ffeb,-14|22|0xf5ffeb", 90, 466, 943, 498, 975).setName("布阵按钮");
    Fb 可领取 = new Fb(0xf8e03f, "7|0|0xf8e040,10|2|0xf1da1c,10|9|0xfcd10d,6|10|0xfacd0c,1|10|0xfcd30d,-3|4|0xf4d513", 90, 143, 1177, 173, 1391).setName("可领取按钮");

    Fb 贾诩 = new Fb(0x583c6c, "89|-11|0xc36501,-7|-48|0x9c918f,66|-49|0x978d8b,49|-29|0x8b7e78,-16|11|0x706796,82|-90|0xbf660a,-10|-76|0xd37e2b", 90, 0.06, 0.56, 0.95, 0.92);
    Fb 蔡文姬 = new Fb(0x487ec3, "75|39|0xf7e4be,87|40|0xdfbb86,-2|51|0xcf9299,51|45|0xdebcb9,94|47|0xceafa6,75|109|0xd6a592", 90, 84, 1130, 887, 1385);
    Fb 司马懿 = new Fb(0x3f5ea1, "-29|-49|0xf66246,-55|31|0x795287,36|30|0x700201,-91|29|0x720201,-64|-30|0x3f5d9d,28|41|0x8d5f50", 90, 0.06, 0.56, 0.95, 0.92);


    boolean 小矿有无;
    boolean 中矿有无;
    boolean 大矿有无;
    String 布阵队伍="null";
    @Override
    protected List<Page> getPages() {
        debug();
        List<Page> pages = new ArrayList<>();
        pages.add(new Page(0xee873b, "0|-39|0x74efff,66|-47|0x74efff,63|-5|0xee873b,64|44|0xeee83b,-1|45|0xeee83b", 90, 116, 1583, 149, 1656)
                .setName("主城界面")
                .setCallBack(new Fcallback() {
                    @Override
                    public void fCallback(int x, int y, int t, int r) throws InterruptedException {
                        if (getFlag()==0)return;
                        int[] xy = 可领取.findColorF();
                        if (xy!=null){
                            ScreenLib.click(xy[0],xy[1],1000,4);
                            fCallback(x,y,t,r);
                        }

                        小矿有无= 小矿.findColorF() != null;
                        中矿有无= 中矿.findColorF() != null;
                        大矿有无= 大矿.findColorF() != null;

                    }
                })
                .add(
                        new Fb( 0xfce88e, "-16|37|0xf2c23f,34|37|0xf2bd35,16|15|0x3e2018,26|15|0xf7d666,19|-1|0x3e2018,27|-1|0x3e2018", 90, 959, 1586, 1051, 1659)
                                .setName("好友图标按钮")
                                .setCallBack(new Fcallback() {
                                    @Override
                                    public void fCallback(int x, int y, int t, int r) throws InterruptedException {
                                        if (!小矿有无 || !中矿有无 || !大矿有无){
                                            ScreenLib.click(x,y,t,r);
                                        }
                                    }
                                })
                )
        );

        pages.add(new Page(0x7d422b, "0|21|0x7d422b,20|23|0x7d422b,20|2|0x7d422b,31|0|0x7d422b,32|22|0x7d422b,69|-4|0x8f5c46,68|8|0xf3eada,70|25|0x7d422b", 90, 114, 548, 168, 586)
                .setName("好友界面npc图标")
                .setClick(true)

        );


        pages.add(new Page(0xc4a04a, "-1|29|0xb98836,15|-1|0xf2dc1c,100|-1|0xf2dd24,32|10|0xb42611,84|11|0xbc2a13", 90, 26, 1768, 64, 1854)
                .setName("好友主城界面(回城按钮)")
                .setPartialX(20)
                .setCallBack(new Fcallback() {
                    @Override
                    public void fCallback(int x, int y, int t, int r) throws InterruptedException {
                        if(小矿有无 && 中矿有无 && 大矿有无){ //三矿都有则回城
                            ScreenLib.click(x,y,t,r);//回城
                            return;
                        }

                        int[] xy0 = 可占领.findColorF();
                        if (xy0!=null){
                            ScreenLib.click(xy0[0],xy0[1],t,r);//点击占领
                        }else{
                            int[] xy = 好友主城右箭头图标.findColorF();
                            if (xy==null){//找到最后一个好友则回城
                                ScreenLib.click(x,y,t,r);//回城
                            }else{
                                ScreenLib.click(xy[0]-70,xy[1],t,r);//点击进入下一个好友主城
                            }

                        }

                    }
                })
        );

        pages.add(new Page(0xef7c0c, "15|21|0xf4d798,25|45|0xf0b31c,51|65|0xf6d162,75|88|0xf3b608,97|107|0xf3c644,142|59|0xf7cb4d,167|19|0xf4cd74", 90, 94, 203, 168, 300)
                .setName("小矿界面")
                .setCallBack(new Fcallback() {
                    @Override
                    public void fCallback(int x, int y, int t, int r) throws InterruptedException {
                        if(!小矿有无){
                            int[] xy=布阵防守按钮_矿.setName("小矿布阵防守").findColorF();
                            if (xy!=null){
                                布阵队伍="小矿队伍";
                                ScreenLib.click(xy[0],xy[1],t,r);//点击布阵
                            }
                        }else{
                            int[] xy=退出按钮_矿.setName("小矿退出按钮").findColorF();
                            if (xy!=null){
                                ScreenLib.click(xy[0],xy[1],t,r);//点击布阵
                            }
                        }
                    }
                })


        );
        pages.add(new Page( 0x6a08e9, "23|31|0xad42f2,44|67|0x7208ec,80|98|0xb312fe,100|113|0xd36ff1,147|94|0x6907ea,194|58|0xdbb3f0", 90, 94, 204, 148, 267)
                .setName("中矿界面")
                .setCallBack(new Fcallback() {
                    @Override
                    public void fCallback(int x, int y, int t, int r) throws InterruptedException {
                        if(!中矿有无){
                            int[] xy=布阵防守按钮_矿.setName("中矿布阵防守").findColorF();
                            if (xy!=null){
                                布阵队伍="中矿队伍";
                                ScreenLib.click(xy[0],xy[1],t,r);//点击布阵
                            }
                        }else{
                            int[] xy=退出按钮_矿.setName("中矿退出按钮").findColorF();
                            if (xy!=null){
                                ScreenLib.click(xy[0],xy[1],t,r);//点击布阵
                            }
                        }
                    }
                })


        );
        pages.add(new Page(0x18e0f7, "24|30|0x21e2f7,59|57|0x18e1f7,81|74|0x1199e4,102|91|0x25ddf4,125|108|0x58e9f8,177|69|0x74ebf9,196|37|0x4fe7f8", 90, 66, 196, 144, 280)
                .setName("大矿界面")
                .setCallBack(new Fcallback() {
                    @Override
                    public void fCallback(int x, int y, int t, int r) throws InterruptedException {
                        if(!大矿有无){
                            int[] xy=布阵防守按钮_矿.setName("大矿布阵防守").findColorF();
                            if (xy!=null){
                                布阵队伍="大矿队伍";
                                ScreenLib.click(xy[0],xy[1],t,r);//点击布阵
                            }
                        }else{
                            int[] xy=退出按钮_矿.setName("大矿退出按钮").findColorF();
                            if (xy!=null){
                                ScreenLib.click(xy[0],xy[1],t,r);//点击布阵
                            }
                        }
                    }
                })


        );

        pages.add(new Page(0xa7714b, "4|14|0x925a40,85|670|0x79c623,176|668|0x79c622,450|688|0xeecb3f,484|687|0xf0ce40", 90, 343, 238, 401, 283)
                .setName("布阵防守界面")
                .setCallBack(new Fcallback() {
                    @Override
                    public void fCallback(int x, int y, int t, int r) throws InterruptedException {
                        if (getFlag()==0)return;
                        int[] is1=ScreenLib.findColor(0x542e19, "2|17|0x54311f,24|1|0x512a19,24|16|0x542c16", 90, 889, 576, 939, 621);
                        if (is1==null)ScreenLib.click(889, 576);

                        int[] is2=ScreenLib.findColor(0x562b17, "1|23|0x522a16,21|1|0x5a2c19,22|23|0x522c19", 90, 711, 574, 768, 626);
                        if (is2==null)ScreenLib.click(711, 574);

                        int[] is3=ScreenLib.findColor(0x542d14, "0|20|0x532c16,19|0|0x522b18,20|19|0x562e12", 90, 524, 582, 578, 634);
                        if (is3==null)ScreenLib.click(524, 582);

                        int[] is4=ScreenLib.findColor(0x50281a, "0|17|0x542d17,27|-1|0x5a2c18,25|22|0x4f281c", 90, 323, 573, 380, 630);
                        if (is4==null)ScreenLib.click(323, 573);

                        int[] is5=ScreenLib.findColor(0x582720, "3|23|0x522a17,27|5|0x5a2b19,30|26|0x542c15", 90, 141, 574, 196, 627);
                        if (is5==null)ScreenLib.click(141, 574);


                        if (is1!=null && is2!=null && is3!=null && is4!=null && is5!=null){

                            switch (布阵队伍){
                                case "null":
                                    int[] xy = 退出按钮_布阵防守.findColorF();
                                    if (xy!=null){
                                        ScreenLib.click(xy[0],xy[1],1000,4);
                                    }


                                    break;
                                case "小矿队伍":
                                    xy = 蔡文姬.findColorF();
                                    if (xy!=null){
                                        ScreenLib.click(xy[0],xy[1],1000,4);
                                    }


                                    xy=布阵按钮.findColorF();
                                    if (xy!=null){
                                        ScreenLib.click(xy[0],xy[1],1000,4);
                                        小矿有无=true;
                                    }
                                    break;
                                case "中矿队伍":
                                    xy = 贾诩.findColorF();
                                    if (xy!=null){
                                        ScreenLib.click(xy[0],xy[1],1000,4);
                                    }


                                    xy=布阵按钮.findColorF();
                                    if (xy!=null){
                                        ScreenLib.click(xy[0],xy[1],1000,4);
                                        中矿有无=true;

                                    }
                                    break;
                                case "大矿队伍":
                                    xy = 司马懿.findColorF();
                                    if (xy!=null){
                                        ScreenLib.click(xy[0],xy[1],1000,4);
                                    }


                                    xy=布阵按钮.findColorF();
                                    if (xy!=null){
                                        ScreenLib.click(xy[0],xy[1],1000,4);
                                        大矿有无=true;
                                    }

                            }

                            //开始布阵

                        }else{
                            fCallback(x,y,t,r);
                        }
                    }
                })



        );






        return pages;
    }
}
