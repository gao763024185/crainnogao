package com.test.auto;

import org.springframework.stereotype.Component;

/**
 * Created by 高保红 on 2017/7/5.
 */
@Component
public class SgtPeppers implements CompactDisc {
    private String title = "Sgt.Pepper's Lonely Hearts Club Band";
    private String artist = "The Beatles";

    public void play(){
        System.out.println("Playing "+title+" by "+artist);
    }
}
