package com.example.scriptx1;

import com.example.scriptx1.scriptframe.Page;
import com.example.scriptx1.scriptframe.TsFrame;

import java.util.ArrayList;
import java.util.List;

public class ScriptSs extends TsFrame {

    @Override
    protected List<Page> getPages() {
        debug();
        List<Page> Ppages = new ArrayList<>();
        Ppages.add(new Page(0xf3fbfe, "-46|-9|0x17a3f9,49|-8|0x17a4f9,-42|49|0x09c3fd,45|46|0x09c1fc", 90, 598, 699, 730, 832)
                .setName("虚拟大师")
                .setClick(true)

        );

        return Ppages;
    }
}
