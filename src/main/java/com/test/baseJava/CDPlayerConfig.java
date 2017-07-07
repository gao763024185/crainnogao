package com.test.baseJava;

import com.test.auto.CompactDisc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 高保红 on 2017/7/5.
 */
@Configuration
public class CDPlayerConfig {
    @Bean
    public CompactDisc sgtPeppers(){
        return new SgtPeppers();
    }
//    @Bean
//    public CDPlayer cdPlayer(){
//        return new CDPlayer(sgtPeppers());
//    }
    @Bean
    public CDPlayer cdPlayer(CompactDisc compactDisc){
        return new CDPlayer(compactDisc);
    }

//    @Bean(name = "cdPlayer_1")
//    public CDPlayer cdPlayer_1(CompactDisc compactDisc){
//        CDPlayer cdPlayer = new CDPlayer(compactDisc);
//        cdPlayer.setCd(compactDisc);
//        return cdPlayer;
//    }
}
