package com.itheima.config;

import com.itheima.bean.MyImportSelector;
import com.itheima.bean.MyRegistrar;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import(MyRegistrar.class)
public class SpringConfig7 {
}
