package com.test.xml;

import com.test.auto.CompactDisc;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by 高保红 on 2017/7/5.
 */
public class CDPlayer implements MediaPlayer {
    private CompactDisc compactDisc;

    //强依赖 构造器注入
    @Autowired
    public CDPlayer(CompactDisc compactDisc){
        this.compactDisc = compactDisc;
    }

//    public CompactDisc getCompactDisc() {
//        return compactDisc;
//    }
//    可选性依赖 属性注入
    @Autowired
    public void setCompactDisc(CompactDisc compactDisc) {
        this.compactDisc = compactDisc;
    }

    @Override
    public void play() {
        compactDisc.play();
    }
}
