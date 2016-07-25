package org.forten.smaple;

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

        Driver lb = ctx.getBean("lb",Driver.class);
        System.out.println(lb);

        Car lh = ctx.getBean("lh",Car.class);
        System.out.println(lh);
    }
}
