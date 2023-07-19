package com.example.mybatisplus_04_generator;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;

public class Generator {
    public static void main(String[] args) {
        //代码生成器
        AutoGenerator autoGenerator = new AutoGenerator();
        DataSourceConfig dataSource = new DataSourceConfig();
        dataSource.setDriverName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test?serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("0214");
        autoGenerator.setDataSource(dataSource);

        //设置包名
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.itheima"); //设置生成的根包名
        packageConfig.setEntity("domain"); //设置实体类包名
        packageConfig.setMapper("dao"); //设置数据层包名
        autoGenerator.setPackageInfo(packageConfig);
        //全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir(System.getProperty("user.dir")+"mybatisplus_04_generated/src/main/java"); //设置文件目录
        globalConfig.setOpen(false);  //设置生成后是否打开文件所在目录
        globalConfig.setAuthor("zhuangbaolong");  //设置作者
        globalConfig.setFileOverride(true);  //是否覆盖原来生成的文件
        globalConfig.setMapperName("%sDao");  //设置数据层接口名，%s占位符
        globalConfig.setIdType(IdType.AUTO);  //设置id生成策略
        autoGenerator.execute();
        //策略设置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setTablePrefix("tbl_"); //数据前缀名
        strategyConfig.setInclude("tbl_user"); //设置生成的表名
        strategyConfig.setRestControllerStyle(true); //是否启用Rest风格
        strategyConfig.setEntityLombokModel(true); //设置启用lombok
        strategyConfig.setLogicDeleteFieldName("deleted"); //设置逻辑删除字段
        strategyConfig.setVersionFieldName("version"); //乐观锁字段名
    }
}
