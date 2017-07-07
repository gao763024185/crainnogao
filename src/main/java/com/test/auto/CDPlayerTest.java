package com.test.auto;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.TestCase.assertNotNull;

/**
 * Created by 高保红 on 2017/7/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
public class CDPlayerTest {

    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();


//    在CDPlayerConfig配置类中通过注解@ComponentScan扫描到同包下带有@Component注解的类,在spring中为其创建一个bean
//    此时@Autowired注解注入bean则会生效
    @Autowired
    private  MediaPlayer player;

    @Autowired
    private  CompactDisc cd;

    @Test
    public void cdShouldNotBeNull(){
        assertNotNull(cd);
    }

    @Test
    public void play(){
        player.play();
//        assertEquals("Playing Sgt.Pepper's Lonely Hearts Club Band by The Beatles\n",log.getLog());
    }
}
