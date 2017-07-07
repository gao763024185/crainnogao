package com.test.baseJava;

import com.test.auto.CompactDisc;

/**
 * Created by 高保红 on 2017/7/5.
 */
public class SgtPeppers implements CompactDisc {
    private String title = "Sgt.Pepper's Lonely Hearts Club Band";
    private String artist = "The Beatles";

    public void play(){
        System.out.println("Playing "+title+" by "+artist);
    }
}
