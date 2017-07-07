package com.test.auto;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 高保红 on 2017/7/5.
 */
@Configuration
@ComponentScan   //启用组件扫描,寻找带有@Component注解的类为其创建bean
public class CDPlayerConfig {
}
