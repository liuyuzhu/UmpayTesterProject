package com.umpaytester.utils;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;

/**
 *作者：刘玉柱
 *日期：2017年11月21日
 *时间：上午11:01:36
 *该类的功能:
**/
public class Config {

    private static PropertiesConfiguration propConfig;

    private static final Config CONFIG = new Config();

    /**
     * 自动保存
     */
    private static boolean autoSave = true;

    private Config() {
    }

    public static Config getInstance(String propertiesFile) {
        //执行初始化 
        init(propertiesFile);
        return CONFIG;
    }

    /**
     * 初始化
     *
     * @param propertiesFile
     * @see
     */
    private static void init(String propertiesFile) {
        try {
            propConfig = new PropertiesConfiguration(propertiesFile);
            //自动重新加载 
            propConfig.setReloadingStrategy(new FileChangedReloadingStrategy());
            //自动保存 
            propConfig.setAutoSave(autoSave);
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据Key获得对应的value
     *
     * @param key
     * @return
     * @see
     */
    public Object getValue(String key) {
        return propConfig.getProperty(key);
    }

    /**
     * 设置属性
     *
     * @param key
     * @param value
     * @see
     */
    public void setProperty(String key, String value) {
        propConfig.setProperty(key, value);
    }

}

