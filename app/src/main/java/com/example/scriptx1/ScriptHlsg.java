package com.example.scriptx1;

import com.example.scriptx1.screendo.ScreenLib;
import com.example.scriptx1.scriptframe.Fb;
import com.example.scriptx1.scriptframe.Fcallback;
import com.example.scriptx1.scriptframe.Page;
import com.example.scriptx1.scriptframe.TsFrame;

import java.util.ArrayList;
import java.util.List;

public class ScriptHlsg extends TsFrame {
    Fb 小矿 = new Fb(0xd09843, "10|13|0xf0b617,13|28|0xe8cd66,30|6|0xf9dd7a", 90, 4, 772, 59, 932).setName("小矿");
    Fb 中矿 = new Fb(0x6907e8, "9|17|0xb214ff,22|17|0x7005df,7|19|0xa31bfb", 90, 4, 772, 59, 932).setName("中矿");
    Fb 大矿 = new Fb(0x36d5eb, "20|2|0x62e0ef,36|7|0x9dffff,18|19|0x1dbddd,16|20|0x16baef", 90, 4, 772, 59, 932).setName("大矿");
    Fb 好友主城右箭头图标 = new Fb(0xd8d054, "-7|-8|0xe4d65b,-10|-11|0xddd157,-10|13|0xcfbb4a,-4|5|0xdacc52", 90, 704, 1057, 718, 1111).setName("好友主城右箭头图标").setPartialX(-40);
    Fb 可占领 = new Fb(0x9dea3a, "6|0|0x98de40,12|0|0x9de63f,13|3|0xa1e748,12|7|0xa0e647,7|7|0xa4e155,0|7|0x9dea3a,0|3|0x94da39", 90, 494, 843, 572, 873).setName("可占领").setPartialY(40);
    Fb 布阵防守按钮_矿 = new Fb(0x76c31f, "82|-1|0x77c420,157|-3|0x77c420,7|25|0x61ad17,10|54|0x43930c", 90, 237, 1047, 300, 1093).setName("布阵防守按钮_矿");
    Fb 退出按钮_矿 = new Fb(0xfbf0d2, "13|10|0xfbeece,19|20|0xfff0d4,5|20|0xfeefd0,23|4|0xfdecce,11|-3|0xde733d,10|26|0xdb642a", 90, 645, 301, 696, 344).setName("退出按钮_矿");
    Fb 退出按钮_布阵防守 = new Fb(0xfef0d3, "10|10|0xfbeccf,18|17|0xfff1d4,5|17|0xfbedd2,21|5|0xfff0d2,13|-8|0xe67c3e,10|23|0xdf662d", 90, 655, 153, 692, 188).setName("退出按钮_布阵防守");
    Fb 布阵按钮 = new Fb(0x68b51b, "0|7|0x5fae17,0|13|0x5fad1b,-6|6|0x62ae18,6|6|0x61ad15,12|-2|0xf6ffec,-10|15|0xf6ffec", 90, 309, 630, 333, 653).setName("布阵按钮");
    Fb 可领取 = new Fb(0xffdb58, "2|0|0xffd760,2|7|0xffc441,0|7|0xffc93a,7|2|0xffcf38,7|4|0xffc72e", 90, 92, 781, 130, 928).setName("可领取按钮");

    Fb 荀彧 = new Fb(0x507ebc, "-6|34|0xc56500,21|18|0x2c3671,22|26|0xefcd61,53|26|0xfffaeb,18|35|0xf7d267,52|36|0xfdedaf,39|50|0xa0463d", 90, 52, 748, 658, 996);
    Fb 蔡文姬 = new Fb(0x547cb9, "49|26|0xffeeae,56|27|0xb47f53,35|30|0xe1b8b4,65|31|0xdeada9,1|33|0xcb9799,19|45|0x312227", 90, 52, 748, 658, 996);
    Fb 贾诩 = new Fb(0xcd9c62, "36|37|0xf1cfb3,32|39|0xf6d2b2,35|39|0xfaddbd,75|2|0xc56500,9|71|0x7e7b98,16|73|0xffffff,7|52|0xfaddbb,70|71|0x696681", 90, 52, 748, 658, 996);


    boolean 小矿有无;
    boolean 中矿有无;
    boolean 大矿有无;
    boolean iscc;
    String 布阵队伍="null";

    @Override
    protected List<Page> getPages() {
         List<Page> pages = new ArrayList<>();
            pages.add(new Page(0xed873c, "-2|-25|0x74efff,-1|32|0xeee83a,42|1|0xef883d,43|-22|0x75eeff,44|28|0xede842", 90, 76, 1067, 110, 1094)
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
                            ScreenLib.setKeep(true);
                            中矿有无= 中矿.findColorF() != null;
                            大矿有无= 大矿.findColorF() != null;
                            ScreenLib.setKeep(false);

                        }
                    })
                    .add(
                            new Fb(0xfce98a, "-5|21|0xf3c744,9|17|0xf4c74a,13|9|0x3e2016,23|23|0xf4c340", 90, 645, 1063, 701, 1099)
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

            pages.add(new Page(0x7c422c, "0|13|0x7a432e,14|13|0x7a432e,14|0|0x78442e,21|0|0x7b422e,21|12|0x7b422e,49|15|0x7a432e,49|-2|0x7b422e", 90, 70, 362, 142, 397)
                    .setName("好友界面npc图标")
                    .setClick(true)

            );


            pages.add(new Page(0xc59e4f, "-2|10|0xc79f4a,2|30|0xad7329,18|10|0xa81a0e,53|10|0xb82418,68|3|0xeac00a,10|2|0xe5c210,22|42|0x422a12", 90, 23, 1166, 51, 1258)
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
                            if (xy0!=null && !iscc){

                                ScreenLib.click(xy0[0],xy0[1],t,r);//点击占领
                            }else{
                                int[] xy = 好友主城右箭头图标.findColorF();
                                if (xy==null){//找到最后一个好友则回城
                                    ScreenLib.click(x,y,t,r);//回城
                                }else{
                                    ScreenLib.click(xy[0]-40,xy[1],t,r);//点击进入下一个好友主城
                                    iscc=false;
                                }

                            }

                        }
                    })
            );

            pages.add(new Page(0xf07b11, "20|28|0xe7a91a,40|44|0xf3c744,50|57|0xf3b508,67|67|0xf1c13b,83|90|0xf6d065", 90, 64, 128, 110, 187)
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
                                    ScreenLib.click(xy[0],xy[1],t,r);
                                    iscc=true;
                                }
                            }
                        }
                    })


            );
        pages.add(new Page(0x6807ea, "16|23|0x9013f3,52|53|0xb312fe,71|76|0xb015f7,82|90|0xc35bff,101|56|0x6e03e7,109|46|0xb013ff", 90, 51, 121, 113, 189)
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
                                ScreenLib.click(xy[0],xy[1],t,r);//
                                iscc=true;
                            }
                        }
                    }
                })


        );
        pages.add(new Page(0x1fdbfe, "15|14|0x74eefb,32|32|0x57e9f8,47|43|0x13bfef,67|64|0x27d4f2,84|77|0x46e7f9,122|38|0x6ce6f5", 90, 38, 121, 94, 189)
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
                                ScreenLib.click(xy[0],xy[1],t,r);//
                                iscc=true;
                            }
                        }
                    }
                })


        );

        pages.add(new Page(0xa7714b, "20|29|0xa7714b,2|20|0x925a41,6|31|0x925a3f,378|345|0x552c18,377|371|0x562b1a,175|479|0x68b41e,303|467|0xf0cc40", 90, 206, 147, 277, 205)
                .setName("布阵防守界面")
                .setCallBack(new Fcallback() {
                    @Override
                    public void fCallback(int x, int y, int t, int r) throws InterruptedException {
                        if (getFlag()==0)return;
                        int[] is1=ScreenLib.findColorClick(0x592c17, "17|19|0x512b18,1|16|0x532f19,16|4|0x502918", 90, 594, 385, 628, 418);
                        if (is1==null)ScreenLib.click(579, 380);

                        int[] is2=ScreenLib.findColorClick(0x532a16, "22|20|0x512c1c,1|20|0x54301a,23|-1|0x552d14", 90, 471, 379, 510, 415);
                        if (is2==null)ScreenLib.click(475, 384);

                        int[] is3=ScreenLib.findColorClick(0x562e15, "18|21|0x542e1b,1|23|0x55321f,19|1|0x532d18", 90, 348, 383, 386, 423);
                        if (is3==null)ScreenLib.click(357, 387);

                        int[] is4=ScreenLib.findColorClick(0x542b17, "27|18|0x563222,4|12|0x512b16,25|-1|0x522c17", 90, 206, 378, 246, 411);
                        if (is4==null)ScreenLib.click(208, 381);

                        int[] is5=ScreenLib.findColorClick(0x502918, "26|18|0x532e1b,6|18|0x532f19,24|4|0x562e15", 90, 88, 379, 133, 416);
                        if (is5==null)ScreenLib.click(87, 385);

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
                                    xy = 荀彧.findColorF();
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
        pages.add(new Page(0xfee445, "2|-28|0xf9f757,-16|22|0xf9d536,24|22|0xfcdc3b,-29|62|0xdf6e2c,82|120|0xdd5406", 90, 169, 283, 200, 314)
                .setName("恭喜获得界面")
                .setClick(true)
        );






        return pages;
    }
}
