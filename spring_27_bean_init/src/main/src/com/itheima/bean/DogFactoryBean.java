package com.itheima.bean;

import org.springframework.beans.factory.FactoryBean;

//实现了FactoryBean接口，被加载后对应的是泛型类型
public class DogFactoryBean implements FactoryBean<Dog> {
    @Override
    public Dog getObject() throws Exception {
        return new Dog();
    }

    @Override
    public Class<?> getObjectType() {
        return Dog.class;
    }

    @Override
    public boolean isSingleton() {
        //对象是否是单例的
        return FactoryBean.super.isSingleton();
    }
}
