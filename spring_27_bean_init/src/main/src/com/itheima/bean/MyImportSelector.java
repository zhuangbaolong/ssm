package com.itheima.bean;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

public class MyImportSelector implements ImportSelector {
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        System.out.println("=================");
        System.out.println("提示:"+annotationMetadata.getClassName());
        //检查是否配configuration
        boolean flag = annotationMetadata.hasAnnotation("org.springframework.context.annotation.Configuration");
        System.out.println(flag);
        Map<String, Object> annotationAttributes = annotationMetadata.getAnnotationAttributes("org.springframework.context.annotation.ComponentScan");
        System.out.println(annotationAttributes);
        System.out.println("=================");
        return new String[]{"com.itheima.bean.Dog","com.itheima.bean.Cat"};
    }
}
