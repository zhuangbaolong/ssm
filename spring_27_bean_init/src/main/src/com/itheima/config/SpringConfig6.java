package com.itheima.config;

import com.itheima.bean.Dog;
import com.itheima.bean.MyImportSelector;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@ComponentScan
@Configuration
@Import({MyImportSelector.class})
public class SpringConfig6 {
}
