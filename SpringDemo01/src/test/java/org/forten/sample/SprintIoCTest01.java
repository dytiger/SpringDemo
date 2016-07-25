package org.forten.sample;

import org.forten.sample.bean.Car;
import org.forten.sample.bean.Driver;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2016/7/25.
 */
public class SprintIoCTest01 {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:/spring/app-*.xml");
        Car qq = (Car)ctx.getBean("qq");
        System.out.println(qq);
        Car lh = ctx.getBean("lh",Car.class);
        System.out.println(lh);

        Driver zl = ctx.getBean("zl",Driver.class);
        System.out.println(zl);

        // 以下对象是new出来的，不被Spring容器管理
        // 所以也不可以从ctx中获得到
        Car bc = new Car("奔驰",800000,150);
    }
}
