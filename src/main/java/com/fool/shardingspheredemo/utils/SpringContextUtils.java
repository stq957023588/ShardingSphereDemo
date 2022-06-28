package com.fool.shardingspheredemo.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Random;

/**
 * @author fool
 * @date 2022/4/21 17:10
 */
@Component
public class SpringContextUtils implements ApplicationContextAware {
    public static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtils.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static <T> T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }

    public static <T> T getBean(Class<T> clazz, String name) {
        return applicationContext.getBean(name, clazz);
    }


    public static void main(String[] args) {
        System.out.println(randomString(-229985452) + " " + randomString(-147909649));
    }

    public static String randomString(int i)
    {
        Random ran = new Random(i);
        StringBuilder sb = new StringBuilder();
        while (true)
        {
            int k = ran.nextInt(27);
            if (k == 0) {
                break;
            }

            sb.append((char)('`' + k));
        }

        return sb.toString();
    }

}
